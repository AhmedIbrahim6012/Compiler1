package AST;

import Example.ExampleParser;
import Example.ExampleParserBaseVisitor;

public class ASTBuilder extends ExampleParserBaseVisitor<ASTNode> {

    @Override
    public ASTNode visitDoctype(ExampleParser.HtmlDocumentContext ctx) {
        DoctypeNode doc = new DoctypeNode(ctx.getStart().getLine());

        if (ctx.doctype() != null) {
            doc.addChild(visit(ctx.doctype()));
        }

        for (ExampleParser.ElementContext el : ctx.element()) {
            ASTNode node = visit(el);
            if (node != null)
                doc.addChild(node);
        }

        return doc;
    }
    @Override
    public ASTNode visitHtmlElement(ExampleParser.HtmlElementContext ctx) {
        HtmlElementNode node =
                new HtmlElementNode(ctx.TAG_NAME(0).getText(),
                        ctx.getStart().getLine());

        // attributes
        for (ExampleParser.AttributeContext a : ctx.attribute()) {
            node.addChild(visit(a));
        }

        // children elements
        for (ExampleParser.ElementContext e : ctx.element()) {
            node.addChild(visit(e));
        }

        return node;
    }

    @Override
    public ASTNode visitAttribute(ExampleParser.AttributeContext ctx) {
        return new HtmlAttributeNode(ctx.getText(), ctx.getStart().getLine());
    }

    @Override
    public ASTNode visitText(ExampleParser.TextContext ctx) {
        return new TextNode(ctx.getText(), ctx.getStart().getLine());
    }

    @Override
    public ASTNode visitEntity(ExampleParser.EntityContext ctx) {
        return new EntityNode(ctx.getText(), ctx.getStart().getLine());
    }

    // CSS
    @Override
    public ASTNode visitStyleElement(ExampleParser.StyleElementContext ctx) {
        StyleElementNode style =
                new StyleElementNode(ctx.getStart().getLine());

        for (ExampleParser.CssStatementContext st : ctx.cssStatement()) {
            style.addChild(visit(st));
        }
        return style;
    }

    @Override
    public ASTNode visitCssRule(ExampleParser.CssRuleContext ctx) {
        return new CssRuleNode(ctx.getStart().getLine());
    }

    @Override
    public ASTNode visitAtRule(ExampleParser.AtRuleContext ctx) {
        return new CssAtRuleNode(ctx.IDENT().getText(),
                ctx.getStart().getLine());
    }
}
