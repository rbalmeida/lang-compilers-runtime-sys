// Generated from /home/ralmeida/IdeaProjects/antlrtst01/src/main/antlr/grammar01.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

/**
 * This class provides an empty implementation of {@link grammar01Visitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public class grammar01BaseVisitor<T> extends AbstractParseTreeVisitor<T> implements grammar01Visitor<T> {
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitR(grammar01Parser.RContext ctx) { return visitChildren(ctx); }
}