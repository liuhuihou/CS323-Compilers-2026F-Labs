import generated.Splc.SplcBaseVisitor;
import generated.Splc.SplcParser;
import impl.Scope;
import impl.SplcSemanticError;
import impl.symbol.FunctionSymbol;
import impl.symbol.VariableSymbol;
import impl.type.PrimitiveType;
import impl.type.Type;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Lab6Visitor extends SplcBaseVisitor<Void> {
    /**
     * 全局（根）作用域。
     */
    private final Scope globalScope = new Scope();

    /**
     * 遍历过程中当前所处的作用域。
     */
    private Scope currentScope = globalScope;

    /**
     * 收集到的语义错误。
     */
    private final List<SplcSemanticError> errors = new ArrayList<>();

    public Scope getGlobalScope() {
        return globalScope;
    }

    public List<SplcSemanticError> getErrors() {
        return errors;
    }

    @Override
    public Void visitProgram(SplcParser.ProgramContext ctx) {
        for (int i = 0; i < ctx.globalDef().size(); i++) {
            SplcParser.GlobalDefContext globalDefCtx = ctx.globalDef(i);
           // System.out.printf("Def %d: %s\n", i + 1, globalDefCtx.getText());
            visit(globalDefCtx);
        }
        return null;
    }

    @Override
    public Void visitGlobalDef(SplcParser.GlobalDefContext ctx) {
        if (ctx.LBRACE() != null && ctx.RBRACE() != null) {
            visitFuncDef(ctx);
        } else {
            visitVariableDec(ctx);
        }
        return null;
    }

    //Function Define:
    private void visitFuncDef(SplcParser.GlobalDefContext ctx) {
        //TODO: Finish Base2 here: Redeclaration Error
        
        if (currentScope.getFunctions().containsKey(ctx.Identifier().getText())) {
            SplcSemanticError error = SplcSemanticError.redeclaration(ctx.Identifier());
            errors.add(error);
            return;
        } else {
            ArrayList<VariableSymbol> params = new ArrayList<>();
            Scope enclosingScope = currentScope;
            for (int i = 0; i < ctx.funcArgs().Identifier().size(); i++) {
                String paramName = ctx.funcArgs().Identifier(i).getText();
                VariableSymbol paramSymbol =
                        new VariableSymbol(paramName, resolveType(ctx.funcArgs().specifier(i)));
                if (params.stream().anyMatch(param -> param.getName().equals(paramName))) {
                    SplcSemanticError error =
                            SplcSemanticError.redefinition(ctx.funcArgs().Identifier(i));
                    errors.add(error);
                }
                params.add(paramSymbol);
            }
            FunctionSymbol functionSymbol  = currentScope.defineFunction(ctx.Identifier().getText(), resolveType(ctx.specifier()),params);
            currentScope = functionSymbol;

            for (int i = 0; i < ctx.statement().size(); i++) {
                visit(ctx.statement(i));
            }

            currentScope = enclosingScope;
            return;
        }
    }

    @Override
    public Void visitLocalVariableStmt(SplcParser.LocalVariableStmtContext ctx) {
        if (currentScope.getVariables().containsKey(ctx.Identifier().getText())) {
            errors.add(SplcSemanticError.redefinition(ctx.Identifier()));
        } else {
            currentScope.defineVariable(
                    ctx.Identifier().getText(), resolveType(ctx.specifier()));
        }
        return visitChildren(ctx);
    }

    //Variable Declare:
    private void visitVariableDec(SplcParser.GlobalDefContext ctx) {
        //TODO: Finish Base1: Redefinition Error
        if(currentScope.getVariables().containsKey(ctx.Identifier().getText())) {
            SplcSemanticError error = SplcSemanticError.redefinition(ctx.Identifier());
            errors.add(error);
            return;
        } else {
            currentScope.defineVariable(ctx.Identifier().getText(), resolveType(ctx.specifier()));
        }

        
            
    }

    private Type resolveType(SplcParser.SpecifierContext ctx) {
        if (ctx.INT() != null) {
            return PrimitiveType.INT;
        } else if (ctx.CHAR() != null) {
            return PrimitiveType.CHAR;
        } else {
            return PrimitiveType.VOID;
        }
    }

    

}
