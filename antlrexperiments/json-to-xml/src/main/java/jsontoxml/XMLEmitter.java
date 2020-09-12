package jsontoxml;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

public class XMLEmitter extends JSONBaseListener {
    ParseTreeProperty<String> xml = new ParseTreeProperty<>();

    String getXML(ParseTree ctx){
        return xml.get(ctx);
    }

    void setXml(ParseTree ctx, String s){
        xml.put(ctx, s);
    }


    @Override
    public void exitJson(JSONParser.JsonContext ctx) {
        setXml(ctx, getXML(ctx.getChild(0)));
    }

    @Override
    public void exitAnObject(JSONParser.AnObjectContext ctx) {
        StringBuilder buf = new StringBuilder();
        buf.append("\n");
        for(JSONParser.PairContext pctx : ctx.pair()) {
            buf.append(getXML(pctx));
        }
        setXml(ctx, buf.toString());
    }

    @Override
    public void exitEmptyObject(JSONParser.EmptyObjectContext ctx) {
        setXml(ctx, "");
    }

    @Override
    public void exitPair(JSONParser.PairContext ctx) {
        String tag = removeQuotes(ctx.STRING().getText());
        JSONParser.ValueContext vctx = ctx.value();
        String x = String.format("<%s>%s</%s>\n", tag, getXML(vctx), tag);
        setXml(ctx, x);
    }

    @Override
    public void exitArrayOfValues(JSONParser.ArrayOfValuesContext ctx) {
        StringBuilder buf = new StringBuilder();
        buf.append("\n");
        for(JSONParser.ValueContext vctx : ctx.value()){
            buf.append("<element>");
            buf.append(getXML(vctx));
            buf.append("</element>");
            buf.append("\n");
        }
        setXml(ctx, buf.toString());
    }

    @Override
    public void exitEmptyArray(JSONParser.EmptyArrayContext ctx) {
        setXml(ctx, "");
    }

    @Override
    public void exitString(JSONParser.StringContext ctx) {
        setXml(ctx, removeQuotes(ctx.getText()));
    }

    @Override
    public void exitAtom(JSONParser.AtomContext ctx) {
        setXml(ctx, ctx.getText());
    }

    @Override
    public void exitObjectValue(JSONParser.ObjectValueContext ctx) {
        setXml(ctx, getXML(ctx.object()));
    }

    @Override
    public void exitArrayValue(JSONParser.ArrayValueContext ctx) {
        setXml(ctx, getXML(ctx.array()));
    }

    protected String removeQuotes(String s){
        return s.replaceAll("\"", "");
    }
}
