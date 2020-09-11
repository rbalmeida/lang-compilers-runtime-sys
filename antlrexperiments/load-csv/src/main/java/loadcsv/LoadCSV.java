package loadcsv;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.FileInputStream;
import java.io.InputStream;

public class LoadCSV {

    public static void main(String args[]) throws Exception{

        String inputFile = null;

        if (args.length > 0) {
            inputFile = args[0];
        }
        InputStream is = System.in;
        if (inputFile != null) {
            is = new FileInputStream(inputFile);
        }

        CharStream input = CharStreams.fromStream(is);
        CSVLexer lexer = new CSVLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CSVParser parser = new CSVParser(tokens);
        ParseTree tree = parser.file();

        ParseTreeWalker walker = new ParseTreeWalker();
        Loader loader = new Loader();
        walker.walk(loader, tree);

        System.out.println(loader.rows);


    }

}
