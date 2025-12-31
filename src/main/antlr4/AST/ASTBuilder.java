package AST;
import antlr.ExampleParser;



public class ASTBuilder extends antlr.ExampleParserBaseVisitor<ASTNode> {

    @Override
    public ASTNode visitHtmlDocument(ExampleParser.HtmlDocumentContext ctx) {

        // إذا في doctype → خليه root
        DoctypeNode root;

        if (ctx.doctype() != null) {
            root = new DoctypeNode(
                    ctx.doctype().getText(),
                    ctx.getStart().getLine()
            );
        } else {
            // في حال ما في doctype
            root = new DoctypeNode("NO_DOCTYPE", ctx.getStart().getLine());
        }

        // كل العناصر (html, body, text, style...)
        for (ExampleParser.ElementContext el : ctx.element()) {
            ASTNode child = visit(el);
            if (child != null) {
                root.addChild(child);
            }
        }

        return root;
    }



    @Override
    public ASTNode visitDoctype(ExampleParser.DoctypeContext ctx) {
        DoctypeNode doc = new DoctypeNode(ctx.DOCTYPE().getText(),ctx.getStart().getLine());
        if (ctx.DOCTYPE() != null) { doc.addChild(visit(ctx.DOCTYPE())); }
        for (ExampleParser.ElementContext el : ctx.element())
            { ASTNode node = visit(el); if (node != null) doc.addChild(node); }
        return doc;
    }

    @Override
    public ASTNode visitElement(ExampleParser.ElementContext ctx) {

        // TEXT token
        if (ctx.TEXT() != null) {
            return new TextNode(ctx.TEXT().getText(), ctx.getStart().getLine());
        }

        // ENTITY token
        if (ctx.ENTITY() != null) {
            return new EntityNode(ctx.ENTITY().getText(), ctx.getStart().getLine());
        }

        // HTML element
        if (ctx.htmlElement() != null) {
            return visit(ctx.htmlElement());
        }

        // STYLE element
//        if (ctx.styleElement() != null) {
//            return visit(ctx.styleElement());
//        }

        // EXPRESSION, STATEMENT, LBRACE_HTML… (إذا بدك تعالجهم لاحقاً)
        return null;
    }

    // -----------------------------
    // HTML ELEMENT
    // -----------------------------
    @Override
    public ASTNode visitHtmlElement(ExampleParser.HtmlElementContext ctx) {
        HtmlElementNode node =
                new HtmlElementNode(ctx.TAG_NAME(0).getText(),
                        ctx.getStart().getLine());

        // attributes
        for (ExampleParser.AttributeContext a : ctx.attribute()) {
            node.addChild(visit(a));
        }

        // children
        for (ExampleParser.ElementContext e : ctx.element()) {
            node.addChild(visit(e));
        }

        return node;
    }

    @Override
    public ASTNode visitAttribute(ExampleParser.AttributeContext ctx) {
        return new HtmlAttributeNode(ctx.getText(), ctx.getStart().getLine());
    }

    // -----------------------------
    // CSS
    // -----------------------------
//    @Override
//    public ASTNode visitStyleElement(ExampleParser.StyleElementContext ctx) {
//        StyleElementNode style =
//                new StyleElementNode(ctx.getStart().getLine());
//
//        for (ExampleParser.CssStatementContext st : ctx.cssStatement()) {
//            style.addChild(visit(st));
//        }
//        return style;
//    }

    @Override
    public ASTNode visitCssRule(ExampleParser.CssRuleContext ctx) {
        return new CssRuleNode(ctx.getStart().getLine());
    }

//    @Override
//    public ASTNode visitAtRule(ExampleParser.AtRuleContext ctx) {
//        return new CssAtRuleNode(ctx.IDENT().getText(),
//                ctx.getStart().getLine());
//    }
}
