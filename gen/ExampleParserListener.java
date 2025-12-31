// Generated from C:/Users/Lenovo/IdeaProjects/Antlr/src/main/antlr4/ExampleParser.g4 by ANTLR 4.13.2


package antlr;      
import org.antlr.v4.runtime.tree.ParseTreeListener;
import antlr.ExampleParser;
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
	 * Enter a parse tree produced by {@link ExampleParser#cssFile}.
	 * @param ctx the parse tree
	 */
	void enterCssFile(ExampleParser.CssFileContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExampleParser#cssFile}.
	 * @param ctx the parse tree
	 */
	void exitCssFile(ExampleParser.CssFileContext ctx);
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
	 * Enter a parse tree produced by {@link ExampleParser#htmlElement}.
	 * @param ctx the parse tree
	 */
	void enterHtmlElement(ExampleParser.HtmlElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExampleParser#htmlElement}.
	 * @param ctx the parse tree
	 */
	void exitHtmlElement(ExampleParser.HtmlElementContext ctx);
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
	/**
	 * Enter a parse tree produced by {@link ExampleParser#jinja2Rule}.
	 * @param ctx the parse tree
	 */
	void enterJinja2Rule(ExampleParser.Jinja2RuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExampleParser#jinja2Rule}.
	 * @param ctx the parse tree
	 */
	void exitJinja2Rule(ExampleParser.Jinja2RuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExampleParser#styleElement}.
	 * @param ctx the parse tree
	 */
	void enterStyleElement(ExampleParser.StyleElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExampleParser#styleElement}.
	 * @param ctx the parse tree
	 */
	void exitStyleElement(ExampleParser.StyleElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExampleParser#cssStatement}.
	 * @param ctx the parse tree
	 */
	void enterCssStatement(ExampleParser.CssStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExampleParser#cssStatement}.
	 * @param ctx the parse tree
	 */
	void exitCssStatement(ExampleParser.CssStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExampleParser#atRule}.
	 * @param ctx the parse tree
	 */
	void enterAtRule(ExampleParser.AtRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExampleParser#atRule}.
	 * @param ctx the parse tree
	 */
	void exitAtRule(ExampleParser.AtRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExampleParser#cssInnerBlock}.
	 * @param ctx the parse tree
	 */
	void enterCssInnerBlock(ExampleParser.CssInnerBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExampleParser#cssInnerBlock}.
	 * @param ctx the parse tree
	 */
	void exitCssInnerBlock(ExampleParser.CssInnerBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExampleParser#cssDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterCssDeclaration(ExampleParser.CssDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExampleParser#cssDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitCssDeclaration(ExampleParser.CssDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExampleParser#cssValue}.
	 * @param ctx the parse tree
	 */
	void enterCssValue(ExampleParser.CssValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExampleParser#cssValue}.
	 * @param ctx the parse tree
	 */
	void exitCssValue(ExampleParser.CssValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExampleParser#cssRule}.
	 * @param ctx the parse tree
	 */
	void enterCssRule(ExampleParser.CssRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExampleParser#cssRule}.
	 * @param ctx the parse tree
	 */
	void exitCssRule(ExampleParser.CssRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExampleParser#selectorList}.
	 * @param ctx the parse tree
	 */
	void enterSelectorList(ExampleParser.SelectorListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExampleParser#selectorList}.
	 * @param ctx the parse tree
	 */
	void exitSelectorList(ExampleParser.SelectorListContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExampleParser#selector}.
	 * @param ctx the parse tree
	 */
	void enterSelector(ExampleParser.SelectorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExampleParser#selector}.
	 * @param ctx the parse tree
	 */
	void exitSelector(ExampleParser.SelectorContext ctx);
}