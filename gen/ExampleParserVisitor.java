// Generated from C:/Users/Lenovo/IdeaProjects/Antlr/src/main/antlr4/ExampleParser.g4 by ANTLR 4.13.2


package antlr;  
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import antlr.ExampleParser;
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
	 * Visit a parse tree produced by {@link ExampleParser#htmlElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlElement(ExampleParser.HtmlElementContext ctx);
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
	/**
	 * Visit a parse tree produced by {@link ExampleParser#jinja2Rule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinja2Rule(ExampleParser.Jinja2RuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExampleParser#cssFile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssFile(ExampleParser.CssFileContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExampleParser#cssRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssRule(ExampleParser.CssRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExampleParser#cssBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssBlock(ExampleParser.CssBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExampleParser#cssDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssDeclaration(ExampleParser.CssDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExampleParser#cssValueList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssValueList(ExampleParser.CssValueListContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExampleParser#cssValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssValue(ExampleParser.CssValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExampleParser#selectorList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectorList(ExampleParser.SelectorListContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExampleParser#selector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelector(ExampleParser.SelectorContext ctx);
}