package propertyfile.lexpr;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

public class EvaluatorWithProps extends LExprBaseListener {
    ParseTreeProperty<Integer> values = new ParseTreeProperty<>();

    public void setValue(ParseTree node, int value) {
        values.put(node, value);
    }

    public int getValue(ParseTree node) {
        return values.get(node);
    }

    @Override
    public void exitS(LExprParser.SContext ctx) {
        setValue(ctx, getValue(ctx.e()));
    }

    @Override
    public void exitAdd(LExprParser.AddContext ctx) {
        int left = getValue(ctx.e(0));
        int right = getValue(ctx.e(1));
        setValue(ctx, (left + right));
    }

    @Override
    public void exitMult(LExprParser.MultContext ctx) {
        int left = getValue(ctx.e(0));
        int right = getValue(ctx.e(1));
        setValue(ctx, (left * right));
    }

    @Override
    public void exitInt(LExprParser.IntContext ctx) {
        String intText = ctx.INT().getText();
        setValue(ctx, Integer.valueOf(intText));
    }
}
