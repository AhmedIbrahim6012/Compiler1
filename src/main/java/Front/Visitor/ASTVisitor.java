package Front.Visitor;
import Front.AST.ASTNode;
import Front.AST.CSS.*;
import Front.AST.CSS.Property.NamePropertyNode;
import Front.AST.CSS.Property.PropertyNode;
import Front.AST.CSS.Property.VariablePropertyNode;
import Front.AST.CSS.Selector.SelectorNode;
import Front.AST.CSS.Value.StringNode;
import Front.AST.CSS.Value.ValueNode;
import Front.AST.Html.EntityNode;
import Front.AST.Html.*;
import Front.AST.Html.ExpressionStatement.ExpressionNode;
import Front.AST.Html.JInja2.*;
import Front.AST.Program;
import FrontLang.FrontParser;
import FrontLang.FrontParserBaseVisitor;

import java.util.ArrayList;
import java.util.List;
import Front.AST.CSS.Value.NameNode;

public class ASTVisitor extends FrontParserBaseVisitor<ASTNode> {
    @Override
    public ASTNode visitProgram(FrontParser.ProgramContext ctx) {
        List<ASTNode>statement = new ArrayList<>();
        if (ctx.cssFile() != null) {
            statement.add(visit(ctx.cssFile()));
        }else {
          statement.add(visit(ctx.htmlDocument()));
        }
        return new Program(statement);
    }

    @Override
    public ASTNode visitHtmlDocument(FrontParser.HtmlDocumentContext ctx) {
        DoctypeNode root = null;
        if (ctx.doctype() != null) {
            root =  new DoctypeNode(ctx.getStart().getLine(),ctx.doctype().getText());
        }
        List<ASTNode>elements = new ArrayList<>();
        for (int i = 0; i < ctx.element().size(); i++) {
            elements.add(visit(ctx.element(i)));
        }
        return new HtmlDocument(ctx.start.getLine(),root,elements);
    }

    @Override
    public ASTNode visitCssFile(FrontParser.CssFileContext ctx) {
        List<ASTNode>statements =new ArrayList<>();
        for (int i = 0 ; i<ctx.cssStatement().size();i++){
            statements.add(visit(ctx.cssStatement(i)));
        }
        return new CSSDocument(ctx.start.getLine(),statements);
    }


    @Override
    public ASTNode visitCssRule(FrontParser.CssRuleContext ctx) {
        SelectorGroupNode selectorGroup =(SelectorGroupNode) visit(ctx.selectorGroup());
        CSSBlockNode block = (CSSBlockNode)visit(ctx.cssInnerBlock());
        return new BaseBlockNode(ctx.start.getLine(),selectorGroup,block);
    }

    @Override
    public ASTNode visitAtRule(FrontParser.AtRuleContext ctx) {
        NameNode name = new NameNode(ctx.start.getLine(),ctx.IDENT().getText());
        List<KeyFrameBlockNode>blocks = new ArrayList<>();
        for (int i = 0; i < ctx.keyframeBlock().size(); i++) {
            blocks.add((KeyFrameBlockNode)visit((ctx.keyframeBlock(i))));
        }
        return new AtKeyFramesNode(ctx.start.getLine(),name,blocks);
    }

    @Override
    public ASTNode visitKeyframeBlock(FrontParser.KeyframeBlockContext ctx) {
        List<DeclarationNode> declarations = new ArrayList<>();
        for (int i = 0; i < ctx.cssDeclaration().size(); i++) {
            declarations.add((DeclarationNode)visit(ctx.cssDeclaration(i)));
        }
        KeyFrameSelector selector = KeyFrameSelector.valueOf(ctx.keyframeSelector().getText());
        return new KeyFrameBlockNode(ctx.start.getLine(),selector,declarations);
    }

    @Override
    public ASTNode visitDoctype(FrontParser.DoctypeContext ctx) {
        return new DoctypeNode(ctx.start.getLine(),ctx.DOCTYPE().getText());
    }

    @Override
    public ASTNode visitElement(FrontParser.ElementContext ctx) {
        if (ctx.ENTITY() != null) {
            return new EntityNode(ctx.ENTITY().getText(), ctx.getStart().getLine());
        }else if (ctx.htmlElement() != null) {
            return visit(ctx.htmlElement());
        } else if (ctx.styleElement() != null) {
            return visit(ctx.styleElement());
        }else if (ctx.jinja2Rule() != null) {
            return visit(ctx.jinja2Rule());
        }else if (ctx.TEXT() != null) {
            return new TextNode(ctx.start.getLine(),ctx.TEXT().getText());
        }else if (ctx.IDENT() != null) {
            return new NameNode(ctx.start.getLine(),ctx.IDENT().getText());
        }else {
            return new NameNode(ctx.start.getLine(),ctx.getText());
        }
    }

    @Override
    public ASTNode visitStyleElement(FrontParser.StyleElementContext ctx) {
        List<ASTNode>statements = new ArrayList<>();
        for (int i = 0; i < ctx.cssStatement().size(); i++) {
            statements.add(visit(ctx.cssStatement(i)));
        }
        return super.visitStyleElement(ctx);
    }

    @Override
    public ASTNode visitCssStatement(FrontParser.CssStatementContext ctx) {
        if (ctx.atRule() != null) {
            return visit(ctx.atRule());
        }else  {
            return visit(ctx.cssRule());
        }
    }

    @Override
    public ASTNode visitHtmlElement(FrontParser.HtmlElementContext ctx) {
        NameNode tagName = new NameNode(ctx.start.getLine(),ctx.TAG_NAME(0).getText());
        List<HtmlAttributeNode> attributes = new ArrayList<>();
        for (int i = 0; i < ctx.attribute().size(); i++) {
            attributes.add((HtmlAttributeNode)visit(ctx.attribute(i)));
        }
        List<ASTNode> children = new ArrayList<>();
        if (ctx.element() != null) {
            for (int i = 0; i < ctx.element().size(); i++) {
                children.add(visit(ctx.element(i)));
            }
        }
        return new HtmlElementNode(ctx.start.getLine(),tagName,attributes,children);
    }

    @Override
    public ASTNode visitAttribute(FrontParser.AttributeContext ctx) {
        NameNode name = new NameNode(ctx.start.getLine(),ctx.TAG_NAME().getText());
        if (ctx.EQUALS() != null) {
            ASTNode value = visit(ctx.attributeValue());
            return new HtmlAttributeNode(ctx.start.getLine(),name,value);
        }

        return new HtmlAttributeNode(ctx.start.getLine(),name,null);
    }

    @Override
    public ASTNode visitAttributeValue(FrontParser.AttributeValueContext ctx) {
        if (ctx.TAG_STRING() != null) {
            return new StringNode(ctx.start.getLine(),ctx.TAG_STRING().getText());
        }else {
            return new NameNode(ctx.start.getLine(),ctx.UNQUOTED_VALUE().getText());
        }
    }

    @Override
    public ASTNode visitCssInnerBlock(FrontParser.CssInnerBlockContext ctx) {
        List<DeclarationNode> declarations = new ArrayList<>();
        for (int i = 0; i < ctx.cssDeclaration().size(); i++) {
            declarations.add((DeclarationNode)visit(ctx.cssDeclaration(i)));
        }
        return new CSSBlockNode(ctx.start.getLine(),declarations);
    }

    @Override
    public ASTNode visitCssDeclaration(FrontParser.CssDeclarationContext ctx) {
        PropertyNode value = (PropertyNode)visit(ctx.property());
        List<ValueNode>values = new ArrayList<>();
        for (int i = 0; i < ctx.cssValue().size(); i++) {
            values.add((new ValueVisitor().visit(ctx.cssValue(i))));
        }
        return new DeclarationNode(ctx.start.getLine(),value,values);
    }

    @Override
    public ASTNode visitProperty(FrontParser.PropertyContext ctx) {
        if (ctx.IDENT() != null) {
            return new NamePropertyNode(ctx.start.getLine(),ctx.IDENT().getText());
        }else {
            return new VariablePropertyNode(ctx.start.getLine(),ctx.variableDeff().IDENT().getText());
        }
    }

    @Override
    public ASTNode visitCombineSelector(FrontParser.CombineSelectorContext ctx) {
        List<SelectorNode>selectors = new ArrayList<>();
        for (int i = 0; i < ctx.selector().size(); i++) {
            selectors.add(new SelectorVisitor().visit(ctx.selector(i)));
        }
        return new CombineSelectorsNode(ctx.start.getLine(),selectors);
    }

    @Override
    public ASTNode visitSelectorGroup(FrontParser.SelectorGroupContext ctx) {
        List<CombineSelectorsNode>combineSelectors = new ArrayList<>();
        for (int i = 0; i < ctx.combineSelector().size(); i++) {
            combineSelectors.add((CombineSelectorsNode) visit(ctx.combineSelector(i)));
        }
        return new SelectorGroupNode(ctx.start.getLine(),combineSelectors);
    }

    @Override
    public ASTNode visitJinja2Rule(FrontParser.Jinja2RuleContext ctx) {
        if (ctx.jinjaExpression() != null) {
            return new ExpressionNodeVisitor().visit(ctx.jinjaExpression().expression());
        }else if (ctx.jinjaStatement() != null) {
            return visit(ctx.jinjaStatement());
        }

        return super.visitJinja2Rule(ctx);
    }

    @Override
    public ASTNode visitIfStatement(FrontParser.IfStatementContext ctx) {
        ExpressionNode ifExpression = new ExpressionNodeVisitor().visit(ctx.ifShape().expression());
        List<ASTNode>ifElements = new ArrayList<>();
        for (int i = 0; i < ctx.ifShape().element().size(); i++) {
            System.out.println(visit(ctx.ifShape().element(i)));
            ifElements.add(visit(ctx.ifShape().element(i)));
        }
        List<IfStatementNode.ElseIf>elseIfs = new ArrayList<>();
        if (ctx.elifShape()!=null){
            for (int i = 0; i < ctx.elifShape().size(); i++) {
                ExpressionNode elseIfCondition = (new ExpressionNodeVisitor()).visit(ctx.elifShape(i).expression());
                List<ASTNode>elIfElements = new ArrayList<>();
                for (int j = 0; j < ctx.elifShape(i).element().size(); j++) {
                    elIfElements.add(visit(ctx.elifShape(i).element(j)));
                }
                elseIfs.add(new IfStatementNode.ElseIf(ctx.start.getLine(),elseIfCondition,elIfElements));
            }
        }
        List<ASTNode>elseIfElements = new ArrayList<>();
        if (ctx.elseShape()!=null){
            for (int i = 0; i < ctx.elseShape().element().size(); i++) {
                elseIfElements.add(visit(ctx.elseShape().element(i)));
            }
        }
        return new IfStatementNode(ctx.start.getLine(),ifExpression,ifElements,elseIfs,new IfStatementNode.Else(ctx.start.getLine(),elseIfElements));
    }


    @Override
    public ASTNode visitForStatement(FrontParser.ForStatementContext ctx) {
        List<ASTNode>elements= new ArrayList<>();
        for (int i = 0; i < ctx.element().size(); i++) {
            elements.add(visit(ctx.element(i)));
        }
        return new ForStatementNode(ctx.start.getLine(),ctx.JINJA_IDENT().getText(),new ExpressionNodeVisitor().visit(ctx.expression()),elements);
    }

    @Override
    public ASTNode visitBlockStatement(FrontParser.BlockStatementContext ctx) {
        List<ASTNode>elements= new ArrayList<>();
        for (int i = 0; i < ctx.element().size(); i++) {
            elements.add(visit(ctx.element(i)));
        }
        return new BlockNode(ctx.start.getLine(),ctx.JINJA_IDENT().getText(),elements);
    }

}
