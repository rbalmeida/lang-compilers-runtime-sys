// Generated from /home/ralmeida/git/langcompilersruntimesys/antlrexperiments/property-file/src/main/antlr/PropertyFileEmbedded.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

/**
 * This class provides an empty implementation of {@link PropertyFileEmbeddedVisitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public class PropertyFileEmbeddedBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements PropertyFileEmbeddedVisitor<T> {
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitFile(PropertyFileEmbeddedParser.FileContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitProp(PropertyFileEmbeddedParser.PropContext ctx) { return visitChildren(ctx); }
}