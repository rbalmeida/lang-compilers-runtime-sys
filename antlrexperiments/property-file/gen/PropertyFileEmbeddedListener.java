// Generated from /home/ralmeida/git/langcompilersruntimesys/antlrexperiments/property-file/src/main/antlr/PropertyFileEmbedded.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PropertyFileEmbeddedParser}.
 */
public interface PropertyFileEmbeddedListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PropertyFileEmbeddedParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(PropertyFileEmbeddedParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link PropertyFileEmbeddedParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(PropertyFileEmbeddedParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by {@link PropertyFileEmbeddedParser#prop}.
	 * @param ctx the parse tree
	 */
	void enterProp(PropertyFileEmbeddedParser.PropContext ctx);
	/**
	 * Exit a parse tree produced by {@link PropertyFileEmbeddedParser#prop}.
	 * @param ctx the parse tree
	 */
	void exitProp(PropertyFileEmbeddedParser.PropContext ctx);
}