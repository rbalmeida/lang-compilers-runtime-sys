import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class TestEnum {

    public static void main(String[] args) throws Exception {

        EnumParser.java5 = false;
        if (args.length > 0 && args[0].equals("-java5")) {
            EnumParser.java5 = true;
        }

        CharStream input = CharStreams.fromStream(System.in);
        EnumLexer lexer = new EnumLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        EnumParser parser = new EnumParser(tokens);

        parser.setBuildParseTree(false);
        parser.prog();

    }
}
