package AST;

public class AstPrinter implements AstVisitor<Void> {

    private int indent = 0;

    private void print(ASTNode node) {
        System.out.println("  ".repeat(indent)
                + node.getName()
                + " (line " + node.getLine() + ")");
    }

    private void visitChildren(ASTNode node) {
        indent++;
        for (ASTNode child : node.getChildren()) {
            child.accept(this);
        }
        indent--;
    }

    @Override
    public Void visitHtmlElement(HtmlElementNode node) {
        print(node);
        visitChildren(node);
        return null;
    }

    @Override
    public Void visitAttribute(HtmlAttributeNode node) {
        return null;
    }

    @Override
    public Void visitTextNode(TextNode node) {
        print(node);
        return null;
    }

    @Override
    public Void visitEntity(EntityNode node) {
        print(node);
        return null;
    }

    @Override
    public Void visitDoctype(DoctypeNode node) {
        print(node);
        return null;
    }

    @Override
    public Void visitCssStylesheet(StyleElementNode node) {
        return null;
    }

    @Override
    public Void visitCssRule(CssRuleNode node) {
        return null;
    }

    @Override
    public Void visitCssSelector(CssSelectorNode node) {
        return null;
    }

    @Override
    public Void visitCssDeclaration(CssDeclarationNode node) {
        return null;
    }

    @Override
    public Void visitCssValue(CssValueNode node) {
        return null;
    }

    @Override
    public Void visitCssAtRule(CssAtRuleNode node) {
        print(node);
        visitChildren(node);
        return null;
    }

    @Override
    public Void visitCssInnerBlock(CssInnerBlockNode node) {
        return null;
    }

    @Override
    public Void visitJinja2ForStatement(JinjaStatementNode node) {
        return null;
    }

    @Override
    public Void visitJinja2Expression(JinjaExpressionNode node) {
        return null;
    }

    // باقي التوابع نفس المبدأ
}
