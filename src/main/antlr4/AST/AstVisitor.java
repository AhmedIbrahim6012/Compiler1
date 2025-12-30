package AST;

public interface AstVisitor<R> {
        //html
    R visitHtmlElement(HtmlElementNode node);
    R visitAttribute(HtmlAttributeNode node);
    R visitTextNode(TextNode node);
    R visitEntity(EntityNode node);
    R visitDoctype(DoctypeNode node);

    //css
    R visitCssStylesheet(StyleElementNode node);
    R visitCssRule(CssRuleNode node);
    R visitCssSelector(CssSelectorNode node);
    R visitCssDeclaration(CssDeclarationNode node);
    R visitCssValue(CssValueNode node);
    R visitCssAtRule(CssAtRuleNode node);
    R visitCssInnerBlock(CssInnerBlockNode node);
//jinja2

    R visitJinja2ForStatement(JinjaStatementNode node);
    R visitJinja2Expression(JinjaExpressionNode node);


}
