import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.FileInputStream;
import java.io.InputStream;

public class TestChannels {

    public static void main(String[] args) throws Exception {

        String inputFile = null;

        if (args.length > 0) {
            inputFile = args[0];
        }
        InputStream is = System.in;
        if (inputFile != null) {
            is = new FileInputStream(inputFile);
        }

        CharStream input = CharStreams.fromStream(is);
        CymbolLexer lexer = new CymbolLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CymbolParser parser = new CymbolParser(tokens);
        RuleContext tree =  parser.file();

        ParseTreeWalker walker = new ParseTreeWalker();
        CommentShifter shifter = new CommentShifter(tokens);
        walker.walk(shifter, tree);

        System.out.print(shifter.rewriter.getText());


    }

}
