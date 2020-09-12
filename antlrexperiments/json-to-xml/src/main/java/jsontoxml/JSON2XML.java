package jsontoxml;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.FileInputStream;
import java.io.InputStream;

public class JSON2XML {

    public static void main(String [] args) throws Exception {
        String inputFile = null;

        if (args.length > 0) {
            inputFile = args[0];
        }
        InputStream is = System.in;
        if (inputFile != null) {
            is = new FileInputStream(inputFile);
        }

        CharStream input = CharStreams.fromStream(is);
        JSONLexer lexer = new JSONLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        JSONParser parser = new JSONParser(tokens);
        ParseTree tree = parser.json();

        ParseTreeWalker walker = new ParseTreeWalker();
        XMLEmitter eval = new XMLEmitter();
        walker.walk(eval, tree);

        System.out.println(eval.getXML(tree));

    }

}
