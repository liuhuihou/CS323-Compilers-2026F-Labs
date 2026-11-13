import generated.Splc.SplcBaseVisitor;
import generated.Splc.SplcParser;
import llvm.Addr;
import llvm.Builder;
import llvm.Val;

import java.util.HashMap;
import java.util.Map;

public class LLVMVisitor extends SplcBaseVisitor<Val> {
    private final Builder builder = new Builder();
    private final Map<String, Addr> vars = new HashMap<>();

    public String getLLVM() {
        return builder.print();
    }

    @Override
    public Val visitFunction(SplcParser.FunctionContext ctx) {
        ctx.block().stmt().forEach(this::visit);
        return null;
    }

    @Override
    public Val visitVarDecl(SplcParser.VarDeclContext ctx) {
        //todo:  invoke builder.store and builder.newVar
        return null;
    }

    @Override
    public Val visitAssign(SplcParser.AssignContext ctx) {
        //todo: invoke builder.store
        return null;
    }

    @Override
    public Val visitRetStmt(SplcParser.RetStmtContext ctx) {
        //todo: invoke builder.ret
        return null;
    }

    @Override
    public Val visitMulDiv(SplcParser.MulDivContext ctx) {
        //todo: finish mul and div
        return null;
    }

    @Override
    public Val visitAddSub(SplcParser.AddSubContext ctx) {
        //todo: finish add and sub
        return null;
    }

    @Override
    public Val visitVar(SplcParser.VarContext ctx) {
        //todo: invoke builder.load
        return null;
    }

    @Override
    public Val visitNum(SplcParser.NumContext ctx) {
        int value = Integer.parseInt(ctx.NUMBER().getText());
        return Val.of(value);
    }

    @Override
    public Val visitCompare(SplcParser.CompareContext ctx) {
       //todo: finish compare
        return null;
    }

    @Override
    public Val visitParen(SplcParser.ParenContext ctx) {
        return visit(ctx.expr());
    }
}
