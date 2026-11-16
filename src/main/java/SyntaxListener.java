import generated.Splc.SplcBaseListener;
import generated.Splc.SplcParser;
import impl.Scope;
import impl.SplcSemanticError;
import impl.type.PrimitiveType;
import impl.type.Type;
import impl.type.ArrayType;

import java.util.ArrayList;
import java.util.List;

import java.util.HashMap;
import impl.symbol.VariableSymbol;
import impl.symbol.FunctionSymbol;

import org.antlr.v4.runtime.tree.TerminalNode;

public class SyntaxListener extends SplcBaseListener {
    private Scope globalScope = new Scope(null);
    private Scope currentScope = globalScope;

    private final List<SplcSemanticError> errors = new ArrayList<>();

    public Scope getGlobalScope() {
        return globalScope;
    }

    public Scope getCurrentScope() {
        return currentScope;
    }

    public List<SplcSemanticError> getErrors() {
        return errors;
    }

    @Override
    public void enterGlobalDef(SplcParser.GlobalDefContext ctx) {
        if (ctx.LBRACE() != null && ctx.RBRACE() != null) {
            visitFuncDef(ctx);
        } else {
            visitVariableDec(ctx);
        }
    }

    @Override
    public void exitGlobalDef(SplcParser.GlobalDefContext ctx) {
        if (ctx.LBRACE() != null && ctx.RBRACE() != null) {
            currentScope = globalScope; // Exit function scope
        }
    }

    @Override
    public void enterLocalVariableStmt(SplcParser.LocalVariableStmtContext ctx) {
        Type baseType = resolveType(ctx.specifier());
        SplcParser.VarDecContext varDec = ctx.varDec();

        TerminalNode varIdentifier = getVarIdentifier(varDec);
        String name = varIdentifier.getText();
        Type type = getVarType(baseType, varDec);
        // defineVariable(name, type)，if redeclaration of name, return null
        VariableSymbol result = this.currentScope.defineVariable(name, type);

        if (result == null) {
            errors.add(SplcSemanticError.redeclaration(varIdentifier));
            return;
        }
        if (ctx.expression() != null) {
            Type actual = expressionType(ctx.expression());
            if (type instanceof ArrayType && !(actual instanceof ArrayType)) {
                errors.add(SplcSemanticError.incompatibleType(varIdentifier, type, actual));
            }
        }
    }

    @Override
    public void enterCombineStmt(SplcParser.CombineStmtContext ctx) {
        currentScope = new Scope(currentScope);
    }

    @Override
    public void exitCombineStmt(SplcParser.CombineStmtContext ctx) {
        currentScope = currentScope.getParent();
    }

    @Override
    public void enterExpressionStmt(SplcParser.ExpressionStmtContext ctx) {
        checkExpression(ctx.expression());
    }

    private void checkExpression(SplcParser.ExpressionContext expression) {
        if (expression.ASSIGN() == null) {
            return;
        }
        SplcParser.ExpressionContext left = expression.expression(0);
        Type expected = expressionType(left);
        Type actual = expressionType(expression.expression(1));
        if (expected instanceof ArrayType && !(actual instanceof ArrayType)) {
            TerminalNode identifier = getExpressionIdentifier(left);
            if (identifier != null) {
                errors.add(SplcSemanticError.incompatibleType(identifier, expected, actual));
            }
        }
    }

    private Type expressionType(SplcParser.ExpressionContext ctx) {
        if (ctx.Identifier() != null) {
            VariableSymbol variable = currentScope.lookupVariable(ctx.Identifier().getText());
            if (variable == null) {
                errors.add(SplcSemanticError.undeclaredUse(ctx.Identifier()));
                return PrimitiveType.INT;
            }
            return variable.getType();
        }
        if (ctx.NUMBER() != null) {
            return PrimitiveType.INT;
        }
        if (ctx.CHAR_VALUE() != null) {
            return PrimitiveType.CHAR;
        }
        if (ctx.expression().size() == 1) {
            return expressionType(ctx.expression(0));
        }
        if (ctx.LBRACK() != null) {
            Type array = expressionType(ctx.expression(0));
            return array instanceof ArrayType ? ((ArrayType) array).getElementType() : PrimitiveType.INT;
        }
        if (ctx.ASSIGN() != null) {
            return expressionType(ctx.expression(0));
        }
        return PrimitiveType.INT;
    }

    private TerminalNode getExpressionIdentifier(SplcParser.ExpressionContext ctx) {
        if (ctx.Identifier() != null) {
            return ctx.Identifier();
        }
        if (ctx.expression().size() == 1) {
            return getExpressionIdentifier(ctx.expression(0));
        }
        return null;
    }

    // Variable Declare:
    private void visitVariableDec(SplcParser.GlobalDefContext ctx) {
        Type baseType = resolveType(ctx.specifier());
        SplcParser.VarDecContext varDec = ctx.varDec();
        TerminalNode identifierNode = getVarIdentifier(varDec);
        String name = identifierNode.getText();
        Type type = getVarType(baseType, varDec);
        if (this.globalScope.lookupCurrentVariable(name) != null) {
            errors.add(SplcSemanticError.redefinition(identifierNode));
        }else{
            this.globalScope.defineVariable(name, type);
        }
    }


    private void visitFuncDef(SplcParser.GlobalDefContext ctx) {
        Type returnType = resolveType(ctx.specifier());
        String name = ctx.Identifier().getText();
        if (globalScope.lookupFunction(name) == null) {
            globalScope.defineFunction(name, returnType, new ArrayList<>());
            currentScope = globalScope.lookupFunction(name);//renew current scope
        } else {
            errors.add(SplcSemanticError.redeclaration(ctx.Identifier()));
            return;
        }
        //todo: to do check function parameters:
        HashMap<String, VariableSymbol> paramMap = new HashMap<>();
        for (int i = 0; i < ctx.funcArgs().Identifier().size();i++){
            String paramName = ctx.funcArgs().Identifier(i).getText();
            Type paramType = resolveType(ctx.funcArgs().specifier(i));
            VariableSymbol paramSymbol = new VariableSymbol(paramName, paramType);
            if (currentScope.lookupCurrentVariable(paramName) == null && !paramMap.containsKey(paramName)) {
                ((FunctionSymbol) currentScope).addParameter(paramSymbol);
                paramMap.put(paramName, paramSymbol);
            } else {
                errors.add(SplcSemanticError.redefinition(ctx.funcArgs().Identifier(i)));
            }

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

    private TerminalNode getVarIdentifier(SplcParser.VarDecContext ctx) {
        if (ctx.Identifier() != null) {
            return ctx.Identifier();
        } else {
            // varDec LBRACK NUMBER RBRACK
            return getVarIdentifier(ctx.varDec());

        }

    }

    private String getVarName(SplcParser.VarDecContext ctx) {
        if (ctx.Identifier() != null) {
            return ctx.Identifier().getText();
        } else {
            // varDec LBRACK NUMBER RBRACK
            return getVarName(ctx.varDec());
        }
    }

    // varDec: int a[1][2][3] -> type: int[3][2][1]
    private Type getVarType(Type baseType, SplcParser.VarDecContext ctx) {
        // If it is not an array type：return the baseType.
        if (ctx.Identifier() != null) {
            return baseType;
        }

        // 1. Collect dimensions downward from the root node of the syntax tree:
        List<Integer> dims = new ArrayList<>();
        SplcParser.VarDecContext p = ctx;
        // The elements in dims are [3, 2, 1]
        while (p.Identifier() == null) {
            dims.add(Integer.parseInt(p.NUMBER().getText()));
            p = p.varDec();
        }

        // 2. Wrap sequentially
        // Origninal: t = int
        // After first loop: t = array(int, 3)
        // After second loop: t = array(array(int, 3), 2)
        // After third loop: t = array(array(array(int, 3), 2), 1) (toString
        // int[3][2][1])
        Type t = baseType;
        for (int d : dims) {
            t = new ArrayType(t, d);
        }
        return t;
    }
}
