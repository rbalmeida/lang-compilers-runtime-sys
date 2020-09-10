package propertyfile.embedded;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.Tree;

import java.io.FileInputStream;
import java.io.InputStream;

public class PropertyFileEmbeddedProcessor {

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
        PropertyFileEmbeddedLexer lexer = new PropertyFileEmbeddedLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        PropertyFileEmbeddedParser parser = new PropertyFileEmbeddedParser(tokens);
        ParseTree tree = parser.file();

        ParseTreeWalker walker = new ParseTreeWalker();
        PropertyFileLoader loader = new PropertyFileLoader();
        walker.walk(loader, tree);

        System.out.println(loader.props.toString());

    }

}
