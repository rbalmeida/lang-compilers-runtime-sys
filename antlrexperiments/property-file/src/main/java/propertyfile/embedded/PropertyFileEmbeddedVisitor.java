package propertyfile.embedded;// Generated from /home/ralmeida/git/langcompilersruntimesys/antlrexperiments/property-file/src/main/antlr/PropertyFileEmbedded.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PropertyFileEmbeddedParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PropertyFileEmbeddedVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PropertyFileEmbeddedParser#file}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFile(PropertyFileEmbeddedParser.FileContext ctx);
	/**
	 * Visit a parse tree produced by {@link PropertyFileEmbeddedParser#prop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProp(PropertyFileEmbeddedParser.PropContext ctx);
}