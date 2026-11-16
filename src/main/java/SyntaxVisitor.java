import generated.Splc.SplcBaseVisitor;
import generated.Splc.SplcParser;
import impl.Scope;
import impl.SplcSemanticError;
import impl.type.ArrayType;
import impl.type.PrimitiveType;
import impl.type.Type;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.tree.TerminalNode;

public class SyntaxVisitor extends SplcBaseVisitor<Void> {
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
    public Void visitGlobalDef(SplcParser.GlobalDefContext ctx) {
        if (ctx.LBRACE() != null && ctx.RBRACE() != null) {
            visitFuncDef(ctx);
        } else {
            visitVariableDec(ctx);
        }
        return null;
    }

    //Variable Declare:
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
        for (int i = 0; i < ctx.funcArgs().Identifier().size(); i++) {
            TerminalNode parameter = ctx.funcArgs().Identifier(i);
            Type parameterType = resolveType(ctx.funcArgs().specifier(i));
            if (currentScope.lookupCurrentVariable(parameter.getText()) != null) {
                errors.add(SplcSemanticError.redefinition(parameter));
            } else {
                ((impl.symbol.FunctionSymbol) currentScope).addParameter(
                        new impl.symbol.VariableSymbol(parameter.getText(), parameterType));
            }
        }
        for (SplcParser.StatementContext statement : ctx.statement()) {
            visit(statement);
        }
        currentScope = globalScope;
    }

    @Override
    public Void visitLocalVariableStmt(SplcParser.LocalVariableStmtContext ctx) {
        Type type = getVarType(resolveType(ctx.specifier()), ctx.varDec());
        TerminalNode identifier = getVarIdentifier(ctx.varDec());
        if (currentScope.defineVariable(identifier.getText(), type) == null) {
            errors.add(SplcSemanticError.redeclaration(identifier));
        } else if (ctx.expression() != null) {
            Type actual = expressionType(ctx.expression());
            if (type instanceof ArrayType && !(actual instanceof ArrayType)) {
                errors.add(SplcSemanticError.incompatibleType(identifier, type, actual));
            }
        }
        return null;
    }

    @Override
    public Void visitCombineStmt(SplcParser.CombineStmtContext ctx) {
        currentScope = new Scope(currentScope);
        for (SplcParser.StatementContext statement : ctx.statement()) {
            visit(statement);
        }
        currentScope = currentScope.getParent();
        return null;
    }

    @Override
    public Void visitExpressionStmt(SplcParser.ExpressionStmtContext ctx) {
        checkExpression(ctx.expression());
        return null;
    }

    private void checkExpression(SplcParser.ExpressionContext expression) {
        if (expression.ASSIGN() == null) {
            return;
        }
        Type expected = expressionType(expression.expression(0));
        Type actual = expressionType(expression.expression(1));
        if (expected instanceof ArrayType && !(actual instanceof ArrayType)) {
            TerminalNode identifier = getExpressionIdentifier(expression.expression(0));
            if (identifier != null) {
                errors.add(SplcSemanticError.incompatibleType(identifier, expected, actual));
            }
        }
    }

    private Type expressionType(SplcParser.ExpressionContext ctx) {
        if (ctx.Identifier() != null) {
            impl.symbol.VariableSymbol variable = currentScope.lookupVariable(ctx.Identifier().getText());
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

    private TerminalNode getVarIdentifier(SplcParser.VarDecContext ctx) {
        return ctx.Identifier() != null ? ctx.Identifier() : getVarIdentifier(ctx.varDec());
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

    private String getVarName(SplcParser.VarDecContext ctx) {
    if (ctx.Identifier() != null) {
        return ctx.Identifier().getText();
    } else {
        // varDec LBRACK NUMBER RBRACK
        return getVarName(ctx.varDec());
    }
    }

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
    // After first loop:  t = array(int, 3)
    // After second loop: t = array(array(int, 3), 2)
    // After third loop:  t = array(array(array(int, 3), 2), 1) (toString int[3][2][1])
    Type t = baseType;
    for (int d : dims) {
        t = new ArrayType(t, d);
    }
    return t;
    }



}
