import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStreamRewriter;

import java.util.List;

public class CommentShifter extends CymbolParserBaseListener {
    BufferedTokenStream tokens;
    TokenStreamRewriter rewriter;

    public CommentShifter(BufferedTokenStream tokens){
        this.tokens = tokens;
        rewriter = new TokenStreamRewriter(tokens);
    }

    @Override
    public void exitVarDecl(CymbolParser.VarDeclContext ctx) {
        Token semi = ctx.getStop();
        int i = semi.getTokenIndex();
        List<Token> cmtChannel =
                tokens.getHiddenTokensToRight(i, CymbolLexer.COMMENTS);
        if(cmtChannel!=null){
            Token cmt = cmtChannel.get(0);
            if(cmt!=null){
                String txt = cmt.getText().substring(2);
                String newCmt = "/* " + txt.trim() + " */\n";
                rewriter.insertBefore(ctx.start, newCmt);
                rewriter.replace(cmt, "\n");
            }
        }
    }
}
