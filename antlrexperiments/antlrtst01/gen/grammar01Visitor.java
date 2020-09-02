// Generated from /home/ralmeida/IdeaProjects/antlrtst01/src/main/antlr/grammar01.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link grammar01Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface grammar01Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link grammar01Parser#r}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitR(grammar01Parser.RContext ctx);
}