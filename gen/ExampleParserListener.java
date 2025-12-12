// Generated from C:/Users/Lenovo/IdeaProjects/Antlr/src/main/antlr4/ExampleParser.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExampleParser}.
 */
public interface ExampleParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ExampleParser#htmlDocument}.
	 * @param ctx the parse tree
	 */
	void enterHtmlDocument(ExampleParser.HtmlDocumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExampleParser#htmlDocument}.
	 * @param ctx the parse tree
	 */
	void exitHtmlDocument(ExampleParser.HtmlDocumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExampleParser#doctype}.
	 * @param ctx the parse tree
	 */
	void enterDoctype(ExampleParser.DoctypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExampleParser#doctype}.
	 * @param ctx the parse tree
	 */
	void exitDoctype(ExampleParser.DoctypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExampleParser#element}.
	 * @param ctx the parse tree
	 */
	void enterElement(ExampleParser.ElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExampleParser#element}.
	 * @param ctx the parse tree
	 */
	void exitElement(ExampleParser.ElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExampleParser#content}.
	 * @param ctx the parse tree
	 */
	void enterContent(ExampleParser.ContentContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExampleParser#content}.
	 * @param ctx the parse tree
	 */
	void exitContent(ExampleParser.ContentContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExampleParser#attribute}.
	 * @param ctx the parse tree
	 */
	void enterAttribute(ExampleParser.AttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExampleParser#attribute}.
	 * @param ctx the parse tree
	 */
	void exitAttribute(ExampleParser.AttributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExampleParser#attributeValue}.
	 * @param ctx the parse tree
	 */
	void enterAttributeValue(ExampleParser.AttributeValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExampleParser#attributeValue}.
	 * @param ctx the parse tree
	 */
	void exitAttributeValue(ExampleParser.AttributeValueContext ctx);
}