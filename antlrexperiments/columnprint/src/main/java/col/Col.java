package col;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.FileInputStream;
import java.io.InputStream;

public class Col {

    public static void main(String[] args) throws Exception {

        String inputFile = null;
        int col = Integer.valueOf(args[0]);

        if (args.length > 0) {
            inputFile = args[1];
        }
        InputStream is = System.in;
        if (inputFile != null) {
            is = new FileInputStream(inputFile);
        }

        CharStream input = CharStreams.fromStream(is);
        RowsLexer lexer = new RowsLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        RowsParser parser = new RowsParser(tokens, col);

        parser.setBuildParseTree(false);
        parser.file();


    }

}
