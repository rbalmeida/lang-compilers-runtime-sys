package loadcsv;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Loader extends CSVBaseListener {
    public static final String EMPTY = "";

    List<Map<String, String >> rows = new ArrayList<Map<String,String>>();
    List<String> header;
    List<String> currentRowFieldValues;

    @Override
    public void exitText(CSVParser.TextContext ctx) {
        currentRowFieldValues.add(ctx.TEXT().getText());
    }

    @Override
    public void exitString(CSVParser.StringContext ctx) {
        currentRowFieldValues.add(ctx.STRING().getText());
    }

    @Override
    public void exitEmpty(CSVParser.EmptyContext ctx) {
        currentRowFieldValues.add(EMPTY);
    }

    @Override
    public void exitHdr(CSVParser.HdrContext ctx) {
        header = new ArrayList<>();
        header.addAll(currentRowFieldValues);
    }

    @Override
    public void enterRow(CSVParser.RowContext ctx) {
        currentRowFieldValues = new ArrayList<>();
    }

    @Override
    public void exitRow(CSVParser.RowContext ctx) {
        if(ctx.getParent().getRuleIndex() == CSVParser.RULE_hdr) return;
        Map<String, String> m = new LinkedHashMap<>();
        int i = 0;
        for(String v : currentRowFieldValues){
            m.put(header.get(i), v);
            i++;
        }
        rows.add(m);
    }
}
