// Generated from C:/Users/Lenovo/IdeaProjects/Antlr/src/main/antlr4/ExampleParser.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ExampleParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ExampleParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ExampleParser#htmlDocument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlDocument(ExampleParser.HtmlDocumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExampleParser#doctype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoctype(ExampleParser.DoctypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExampleParser#element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElement(ExampleParser.ElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExampleParser#content}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContent(ExampleParser.ContentContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExampleParser#attribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttribute(ExampleParser.AttributeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExampleParser#attributeValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributeValue(ExampleParser.AttributeValueContext ctx);
}