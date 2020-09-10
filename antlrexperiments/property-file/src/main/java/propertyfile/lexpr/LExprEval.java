package propertyfile.lexpr;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.Tree;

import java.io.FileInputStream;
import java.io.InputStream;

public class LExprEval {

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
        LExprLexer lexer = new LExprLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LExprParser parser = new LExprParser(tokens);
        ParseTree tree = parser.s();

        ParseTreeWalker walker = new ParseTreeWalker();
        EvaluatorWithProps eval = new EvaluatorWithProps();
        walker.walk(eval, tree);

        System.out.println(eval.getValue(tree));

    }

}
