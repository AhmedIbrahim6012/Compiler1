package Front.Visitor;
import Front.AST.*;
import Front.AST.CSS.*;
import Front.AST.CSS.Property.NamePropertyNode;
import Front.AST.CSS.Property.PropertyNode;
import Front.AST.CSS.Property.VariablePropertyNode;
import Front.AST.CSS.Selector.*;
import Front.AST.CSS.Value.*;
import Front.AST.CSS.combinators.Combinator;
import Front.AST.CSS.combinators.GTCombinator;
import Front.AST.CSS.combinators.PlusCombinator;
import Front.AST.Html.*;
import Front.AST.JInja2.ExpressionStatement.*;
import Front.AST.JInja2.BlockNode;
import Front.AST.JInja2.ExpressionStatement.Operators.*;
import Front.AST.JInja2.ForStatementNode;
import Front.AST.JInja2.IfStatementNode;
import Front.AST.StringNode;
import FrontLang.FrontParser;
import FrontLang.FrontParserBaseVisitor;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ASTVisitor extends FrontParserBaseVisitor<ASTNode> {

    @Override
    public ASTNode visitDoctype(FrontParser.DoctypeContext ctx) {
        return new DoctypeNode(ctx.start.getLine(),ctx.DOCTYPE().getText());
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
    public ASTNode visitHtmlElementNode(FrontParser.HtmlElementNodeContext ctx) {
        return visit(ctx.htmlElement());
    }
    @Override
    public ASTNode visitHtmlElement(FrontParser.HtmlElementContext ctx) {
        String open = ctx.TAG_NAME(0).getText();
        if (ctx.TAG_NAME().size() == 2){
            String close = ctx.TAG_NAME(1).getText();
            if (!open.equals(close)){
                throw new RuntimeException(
                        "HTML tag mismatch: expected </" + open +
                                "> but found </" + close +
                                "> at line " + ctx.start.getLine()
                );
            }
        }
        NameNode tagName = new NameNode(ctx.start.getLine(),ctx.TAG_NAME(0).getText());
        List<HtmlAttributeNode> attributes = new ArrayList<>();
        for (int i = 0; i < ctx.attribute().size(); i++) {
            attributes.add((HtmlAttributeNode)visit(ctx.attribute(i)));
        }
        List<ASTNode> children = new ArrayList<>();
        boolean isSelfClose = true;
        if (ctx.SELF_CLOSE() == null) {
            isSelfClose = false;
            for (int i = 0; i < ctx.element().size(); i++) {
                children.add(visit(ctx.element(i)));
            }
        }
        return new HtmlElementNode(ctx.start.getLine(),tagName,isSelfClose,attributes,children);
    }
    @Override
    public ASTNode visitAttribute(FrontParser.AttributeContext ctx) {
        NameNode name = new NameNode(ctx.start.getLine(),ctx.TAG_NAME().getText());
        if (ctx.EQUALS() != null) {
            ASTNode value = visit(ctx.attributeValue());
            return new HtmlAttributeNode(ctx.start.getLine(),name,(AttributeValuesNode) value);
        }
        return new HtmlAttributeNode(ctx.start.getLine(),name,null);
    }
    @Override
    public ASTNode visitDoubleQuotedAttributeNode(FrontParser.DoubleQuotedAttributeNodeContext ctx) {
        return visit(ctx.doubleQuotedAttribute());
    }
    @Override
    public ASTNode visitDoubleQuotedAttribute(FrontParser.DoubleQuotedAttributeContext ctx) {
        List<ASTNode> children = new ArrayList<>();
        for (int i = 0; i < ctx.doubleAttrContent().size(); i++) {
            children.add(visit(ctx.doubleAttrContent(i)));
        }
        return new AttributeValuesNode(ctx.start.getLine(),children);
    }
    @Override
    public ASTNode visitDoubleAttrText(FrontParser.DoubleAttrTextContext ctx) {
        return new StringNode(ctx.start.getLine(),ctx.TAG_ATTR_TEXT_D().getText());
    }
    @Override
    public ASTNode visitDoubleAttrJinjaExpr(FrontParser.DoubleAttrJinjaExprContext ctx) {
        return new ExpressionNode(ctx.start.getLine(),visit(ctx.expression()));
    }
    @Override
    public ASTNode visitDoubleAttrJinjaStmt(FrontParser.DoubleAttrJinjaStmtContext ctx) {
        return visit(ctx.jinjaStatement());
    }
    @Override
    public ASTNode visitSingleQuotedAttributeNode(FrontParser.SingleQuotedAttributeNodeContext ctx) {
        return visit(ctx.singleQuotedAttribute());
    }
    @Override
    public ASTNode visitSingleQuotedAttribute(FrontParser.SingleQuotedAttributeContext ctx) {
        List<ASTNode> children = new ArrayList<>();
        for (int i = 0; i < ctx.singleAttrContent().size(); i++) {
            children.add(visit(ctx.singleAttrContent(i)));
        }
        return new AttributeValuesNode(ctx.start.getLine(),children);
    }
    @Override
    public ASTNode visitSingleAttrText(FrontParser.SingleAttrTextContext ctx) {
        return new StringNode(ctx.start.getLine(),ctx.TAG_ATTR_TEXT_S().getText());
    }
    @Override
    public ASTNode visitSingleAttrJinjaExpr(FrontParser.SingleAttrJinjaExprContext ctx) {
        return new ExpressionNode(ctx.start.getLine(),visit(ctx.expression()));
    }
    @Override
    public ASTNode visitSingleAttrJinjaStmt(FrontParser.SingleAttrJinjaStmtContext ctx) {
        return visit(ctx.jinjaStatement());
    }
    @Override
    public ASTNode visitUnquotedValueNode(FrontParser.UnquotedValueNodeContext ctx) {
        TextNode text = new TextNode(ctx.start.getLine(),ctx.UNQUOTED_VALUE().getText());
        List<ASTNode> children = new ArrayList<>();
        children.add(text);
        return new AttributeValuesNode(ctx.start.getLine(),children);
    }

    @Override
    public ASTNode visitHtmlTextNode(FrontParser.HtmlTextNodeContext ctx) {
        return new TextNode(ctx.start.getLine(),ctx.HTML_TEXT().getText());
    }

    @Override
    public ASTNode visitStyleElementNode(FrontParser.StyleElementNodeContext ctx) {
        return visit(ctx.styleElement());
    }

    @Override
    public ASTNode visitStyleElement(FrontParser.StyleElementContext ctx) {
        List<ASTNode> children = new ArrayList<>();
        for (int i = 0; i < ctx.cssStatement().size(); i++) {
            children.add(visit(ctx.cssStatement(i)));
        }
        return new CSSStatements(ctx.start.getLine(),children);
    }
    @Override
    public ASTNode visitCSSRuleNode(FrontParser.CSSRuleNodeContext ctx) {
        return visit(ctx.cssRule());
    }
    @Override
    public ASTNode visitATRuleNode(FrontParser.ATRuleNodeContext ctx) {
        return visit(ctx.atRule());
    }

    @Override
    public ASTNode visitATMediaNode(FrontParser.ATMediaNodeContext ctx) {
        return visit(ctx.atMedia());
    }

    @Override
    public ASTNode visitAtMedia(FrontParser.AtMediaContext ctx) {
        MediaQueryNode mediaQuery =(MediaQueryNode) visit(ctx.mediaQuery());
        List<CSSRuleNode> cssRuleNodes = new ArrayList<>();
        for (int i = 0; i < ctx.cssRule().size(); i++) {
            cssRuleNodes.add((CSSRuleNode) visit(ctx.cssRule(i)));
        }
        return new ATMediaNode(ctx.start.getLine(),mediaQuery,cssRuleNodes);
    }

    @Override
    public ASTNode visitMediaQuery(FrontParser.MediaQueryContext ctx) {
        NameNode name = new NameNode(ctx.start.getLine(),ctx.getText());
        MediaValueNode mediaValue = new MediaValueNode(ctx.start.getLine(),visit(ctx.mediaValue()));
        return new MediaQueryNode(ctx.start.getLine(),name,mediaValue);
    }

    @Override
    public ASTNode visitMediaNameNode(FrontParser.MediaNameNodeContext ctx) {
        return new NameNode(ctx.start.getLine(),ctx.CSS_IDENT().getText());
    }

    @Override
    public ASTNode visitMediaNumberNode(FrontParser.MediaNumberNodeContext ctx) {
        if (ctx.CSS_NUMBER().getText().contains(".")){
            if (ctx.UNIT() != null){
                return new DoubleValueNode(ctx.start.getLine(),Double.parseDouble(ctx.CSS_NUMBER().getText()),ctx.UNIT().getText());
            }
            return new DoubleValueNode(ctx.start.getLine(),Double.parseDouble(ctx.CSS_NUMBER().getText()),null);
        }else {
            if (ctx.UNIT() != null){
                return new IntValueNode(ctx.start.getLine(),Integer.parseInt(ctx.CSS_NUMBER().getText()),ctx.UNIT().getText());
            }
            return new IntValueNode(ctx.start.getLine(),Integer.parseInt(ctx.CSS_NUMBER().getText()),null);

        }
    }

    @Override
    public ASTNode visitCssRule(FrontParser.CssRuleContext ctx) {
        ASTNode selectorGroup = visit(ctx.selectorGroup());
        ASTNode cssBlock = visit(ctx.cssInnerBlock());
        return new CSSRuleNode(ctx.start.getLine(),(SelectorGroupNode) selectorGroup,(CSSBlockNode) cssBlock);
    }
    @Override
    public ASTNode visitSelectorGroup(FrontParser.SelectorGroupContext ctx) {
        List<CombineSelectorsNode> combineSelectors = new ArrayList<>();
        for (int i = 0; i < ctx.combineSelector().size(); i++) {
            combineSelectors.add((CombineSelectorsNode) visit(ctx.combineSelector(i)));
        }
        return new SelectorGroupNode(ctx.start.getLine(),combineSelectors);
    }

    @Override
    public ASTNode visitCssInnerBlock(FrontParser.CssInnerBlockContext ctx) {
        List<DeclarationNode>declarations = new ArrayList<>();
        for (int i = 0; i < ctx.cssDeclaration().size(); i++) {
            declarations.add((DeclarationNode) visit(ctx.cssDeclaration(i)));
        }
        return new CSSBlockNode(ctx.start.getLine(),declarations);
    }

    @Override
    public ASTNode visitCssDeclaration(FrontParser.CssDeclarationContext ctx) {
        PropertyNode property = new PropertyNode(ctx.start.getLine(),visit(ctx.property()));
        List<ValueNode> values = new ArrayList<>();
        for (int i = 0; i < ctx.cssValue().size(); i++) {
            values.add(new ValueNode(ctx.start.getLine(),visit(ctx.cssValue(i))));
        }
        return new DeclarationNode(ctx.start.getLine(),property,values);
    }

    @Override
    public ASTNode visitNumberCSSNode(FrontParser.NumberCSSNodeContext ctx) {
        if (ctx.CSS_NUMBER().getText().contains(".")){
            if (ctx.UNIT() != null){
                return new DoubleValueNode(ctx.start.getLine(),Double.parseDouble(ctx.CSS_NUMBER().getText()),ctx.UNIT().getText());
            }
            return new DoubleValueNode(ctx.start.getLine(),Double.parseDouble(ctx.CSS_NUMBER().getText()),null);
        }else {
            if (ctx.UNIT() != null){
                return new IntValueNode(ctx.start.getLine(),Integer.parseInt(ctx.CSS_NUMBER().getText()),ctx.UNIT().getText());
            }
            return new IntValueNode(ctx.start.getLine(),Integer.parseInt(ctx.CSS_NUMBER().getText()),null);

        }
    }
    @Override
    public ASTNode visitStringCSSNode(FrontParser.StringCSSNodeContext ctx) {
        return new StringNode(ctx.start.getLine(),ctx.CSS_STRING().getText());
    }

    @Override
    public ASTNode visitKeywordCSSNode(FrontParser.KeywordCSSNodeContext ctx) {
        return new KeyboardNode(ctx.start.getLine(),ctx.getText());
    }
    @Override
    public ASTNode visitVariableDeffNode(FrontParser.VariableDeffNodeContext ctx) {
        return visit(ctx.variableDeff());
    }
    @Override
    public ASTNode visitCallFunctionCSSNode(FrontParser.CallFunctionCSSNodeContext ctx) {
        NameNode name = new NameNode(ctx.start.getLine(),ctx.function().CSS_IDENT().getText());
        List<ASTNode>params = new ArrayList<>();
        for (int i = 0; i < ctx.function().cssValue().size(); i++) {
            params.add(visit(ctx.function().cssValue().get(i)));
        }
        return new FunctionNode(ctx.start.getLine(),name,params);
    }
    @Override
    public ASTNode visitNameCSSNode(FrontParser.NameCSSNodeContext ctx) {
        return new NameNode(ctx.start.getLine(),ctx.CSS_IDENT().getText());
    }

    @Override
    public ASTNode visitColorCSSNode(FrontParser.ColorCSSNodeContext ctx) {
        return new ColorNode(ctx.start.getLine(),ctx.getText());
    }

    @Override
    public ASTNode visitPropertyNameNode(FrontParser.PropertyNameNodeContext ctx) {
        return new NamePropertyNode(ctx.start.getLine(),ctx.CSS_IDENT().getText());
    }
    @Override
    public ASTNode visitVariableCSSNode(FrontParser.VariableCSSNodeContext ctx) {
        return visit(ctx.variableDeff());
    }
    @Override
    public ASTNode visitVariableDeff(FrontParser.VariableDeffContext ctx) {
        return new VariablePropertyNode(ctx.start.getLine(),ctx.CSS_IDENT().getText());
    }

    @Override
    public ASTNode visitCombineSelector(FrontParser.CombineSelectorContext ctx) {
        List<CombineSelectorNode> combineSelectors = new ArrayList<>();
        SelectorNode selector = new SelectorNode(ctx.start.getLine(),visit(ctx.selector()));
        if(!ctx.selectorPart().isEmpty() && ctx.selectorPart(0).combinator() != null){
            ASTNode c =  visit(ctx.selectorPart(0).combinator());
            Combinator combinator = new Combinator(ctx.start.getLine(),c);
            combineSelectors.add(new CombineSelectorNode(ctx.start.getLine(),selector,combinator));
        }else{
            combineSelectors.add(new CombineSelectorNode(ctx.start.getLine(),selector,null));
        }
        for (int i = 0; i < ctx.selectorPart().size() - 1; i++) {
            selector = new SelectorNode(ctx.start.getLine(),visit(ctx.selectorPart(i).selector()));
            if(ctx.selectorPart(i+1).combinator() != null){
                ASTNode c =  visit(ctx.selectorPart(i+1).combinator());
                Combinator combinator = new Combinator(ctx.start.getLine(),c);
                combineSelectors.add(new CombineSelectorNode(ctx.start.getLine(),selector,combinator));
            }else{
                combineSelectors.add(new CombineSelectorNode(ctx.start.getLine(),selector,null));
            }
        }
        if(ctx.selectorPart().size() > 1){
            selector = new SelectorNode(ctx.start.getLine(),visit(ctx.selectorPart(ctx.selectorPart().size()-1).selector()));
            combineSelectors.add(new CombineSelectorNode(ctx.start.getLine(),selector,null));
        }
        return  new CombineSelectorsNode(ctx.start.getLine(),combineSelectors);
    }

    @Override
    public ASTNode visitClassSelector(FrontParser.ClassSelectorContext ctx) {
        return new ClassSelectorNode(ctx.start.getLine(),ctx.CLASS_SELECTOR().getText());
    }
    @Override
    public ASTNode visitIDSelector(FrontParser.IDSelectorContext ctx) {
        return new IDSelectorNode(ctx.start.getLine(),ctx.ID_SELECTOR().getText());
    }
    @Override
    public ASTNode visitPseudoSelector(FrontParser.PseudoSelectorContext ctx) {
        return new PseudoClassSelectorNode(ctx.start.getLine(),ctx.PSEUDO_SELECTOR().getText());
    }
    @Override
    public ASTNode visitElementSelector(FrontParser.ElementSelectorContext ctx) {
        return new NameSelectorNode(ctx.start.getLine(),ctx.CSS_IDENT().getText());
    }
    @Override
    public ASTNode visitStarSelector(FrontParser.StarSelectorContext ctx) {
        return new StarSelectorNode(ctx.start.getLine());
    }
    @Override
    public ASTNode visitGTCSSNode(FrontParser.GTCSSNodeContext ctx) {
        return new GTCombinator(ctx.start.getLine());
    }
    @Override
    public ASTNode visitPlusCSSNode(FrontParser.PlusCSSNodeContext ctx) {
        return new PlusCombinator(ctx.start.getLine());
    }
    @Override
    public ASTNode visitJinja2Node(FrontParser.Jinja2NodeContext ctx) {
        return visit(ctx.jinja2Rule());
    }
    @Override
    public ASTNode visitJinjaExpressionNode(FrontParser.JinjaExpressionNodeContext ctx) {
        return  visit(ctx.jinjaExpression());
    }
    @Override
    public ASTNode visitJinjaStatementNode(FrontParser.JinjaStatementNodeContext ctx) {
        return  visit(ctx.jinjaStatement());
    }
    @Override
    public ASTNode visitJinjaExpression(FrontParser.JinjaExpressionContext ctx) {
        return new ExpressionNode(ctx.start.getLine(),visit(ctx.expression()));
    }
    @Override
    public ASTNode visitExpression(FrontParser.ExpressionContext ctx) {
        ASTNode left = visit(ctx.andExpression(0));
        if (ctx.OR().isEmpty()){
            return left;
        }
        List<ASTNode>ops = new ArrayList<>();
        List<ASTNode>list = new ArrayList<>();
        for (int i = 0; i < ctx.OR().size(); i++) {
            ops.add(new OrOperatorNode(ctx.start.getLine()));
            list.add( visit(ctx.andExpression(i+1)));
        }
        return new BinaryExpressionNode(ctx.start.getLine(),left,list,ops);
    }
    @Override
    public ASTNode visitAndExpression(FrontParser.AndExpressionContext ctx) {
        ASTNode left = visit(ctx.notExpression(0));
        if (ctx.AND().isEmpty()){
            return left;
        }
        List<ASTNode>ops = new ArrayList<>();
        List<ASTNode>list = new ArrayList<>();
        for (int i = 0; i < ctx.AND().size(); i++) {
            ops.add(new AndOperatorNode(ctx.start.getLine()));
            list.add( visit(ctx.notExpression(i+1)));
        }
        return new BinaryExpressionNode(ctx.start.getLine(),left,list,ops);
    }
    @Override
    public ASTNode visitNotExpression(FrontParser.NotExpressionContext ctx) {
        if (ctx.NOT()==null){
            return visit(ctx.comparison());
        }
        ASTNode node = visit(ctx.notExpression());
        return new UnaryExpressionNode(ctx.start.getLine(),new NotOperatorNode(ctx.start.getLine()),node);
    }
    @Override
    public ASTNode visitComparison(FrontParser.ComparisonContext ctx) {
        ASTNode left = visit(ctx.expr(0));
        if (ctx.comp_op().isEmpty()){
            return left;
        }
        List<ASTNode>ops = new ArrayList<>();
        List<ASTNode>list = new ArrayList<>();
        for (int i = 0; i < ctx.comp_op().size(); i++) {
            ops.add(visit(ctx.comp_op(i)));
            list.add(visit(ctx.expr(i+1)));
        }
        return new CompareExpressionNode(ctx.start.getLine(),left,ops,list);
    }
    @Override
    public ASTNode visitExpr(FrontParser.ExprContext ctx) {
        ASTNode atom = visit(ctx.atom());
        for (int i = 0; i < ctx.trailer().size(); i++) {
            atom = handleTrailer(atom,ctx.trailer(i));
        }
        return  atom;
    }
    private ASTNode handleTrailer(ASTNode currentAtom,FrontParser.TrailerContext trailer) {
        int line = trailer.start.getLine();
        if (trailer instanceof FrontParser.FunctionCallTrailerContext){
            ASTNode arguments = visit(trailer);
            return new CallExpressionNode(line,currentAtom,(ArgumentListNode) arguments);
        }else if(trailer instanceof FrontParser.PropertyAccessTrailerContext){
            NameNode name = new NameNode(trailer.start.getLine(),((FrontParser.PropertyAccessTrailerContext) trailer).JINJA_IDENT().getText());
            return new PropertyAccessExpressionNode(line,currentAtom,name);
        }else{
            ASTNode index = visit(trailer);
            return new IndexAccessExpressionNode(line,currentAtom,index);
        }
    }
    @Override
    public ASTNode visitFunctionCallTrailer(FrontParser.FunctionCallTrailerContext ctx) {
        return visit(ctx.argumentList());
    }
    @Override
    public ASTNode visitPropertyAccessTrailer(FrontParser.PropertyAccessTrailerContext ctx) {
        return new NameNode(ctx.start.getLine(),ctx.JINJA_IDENT().getText());
    }
    @Override
    public ASTNode visitIndexAccessTrailer(FrontParser.IndexAccessTrailerContext ctx) {
        return visit(ctx.expression());
    }
    @Override
    public ASTNode visitArgumentList(FrontParser.ArgumentListContext ctx) {
        List<ASTNode>list = new ArrayList<>();
        for (int i = 0; i < ctx.argument().size(); i++) {
            list.add( visit(ctx.argument(i)));
        }
        return new ArgumentListNode(ctx.start.getLine(),list);
    }
    @Override
    public ASTNode visitIfStatement(FrontParser.IfStatementContext ctx) {

        ExpressionNode ifExpression = new ExpressionNode(ctx.start.getLine(),visit(ctx.ifShape().expression()));
        List<ASTNode>ifElements = new ArrayList<>();
        for (int i = 0; i < ctx.ifShape().element().size(); i++) {
            ifElements.add(visit(ctx.ifShape().element(i)));
        }
        List<IfStatementNode.ElseIf>elseIfs = new ArrayList<>();
            for (int i = 0; i < ctx.elifShape().size(); i++) {
                ExpressionNode elseIfCondition = new ExpressionNode(ctx.start.getLine(),visit(ctx.elifShape(i).expression()));
                List<ASTNode>elIfElements = new ArrayList<>();
                for (int j = 0; j < ctx.elifShape(i).element().size(); j++) {
                    elIfElements.add(visit(ctx.elifShape(i).element(j)));
                }
                elseIfs.add(new IfStatementNode.ElseIf(ctx.start.getLine(),elseIfCondition,elIfElements));
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
        NameNode nameNode =new NameNode(ctx.start.getLine(),ctx.JINJA_IDENT().getText());
        ExpressionNode expression = new ExpressionNode(ctx.start.getLine(),visit(ctx.expression()));
        return new ForStatementNode(ctx.start.getLine(),nameNode,expression,elements);
    }
    @Override
    public ASTNode visitBlockStatement(FrontParser.BlockStatementContext ctx) {
        List<ASTNode>elements= new ArrayList<>();
        for (int i = 0; i < ctx.element().size(); i++) {
            elements.add(visit(ctx.element(i)));
        }
        return new BlockNode(ctx.start.getLine(),ctx.JINJA_IDENT().getText(),elements);
    }
    @Override
    public ASTNode visitNumberNode(FrontParser.NumberNodeContext ctx) {
        if (ctx.JINJA_NUMBER().getText().contains(".")){
            return new DoubleNumberAtomNode(ctx.start.getLine(),Double.parseDouble(ctx.JINJA_NUMBER().getText()));
        }else {
            return new IntNumberAtomNode(ctx.start.getLine(),Integer.parseInt(ctx.JINJA_NUMBER().getText()));
        }
    }
    @Override
    public ASTNode visitBoolNode(FrontParser.BoolNodeContext ctx) {
        return new BoolAtomNode(ctx.start.getLine(),Boolean.parseBoolean(ctx.getChild(0).getText()));
    }
    @Override
    public ASTNode visitNameNode(FrontParser.NameNodeContext ctx) {
        return new NameNode(ctx.start.getLine(), ctx.JINJA_IDENT().getText());
    }
    @Override
    public ASTNode visitStringNode(FrontParser.StringNodeContext ctx) {
        return new StringNode(ctx.start.getLine(),ctx.JINJA_STRING().getText());
    }
    @Override
    public ASTNode visitLessThan(FrontParser.LessThanContext ctx) {
        return new LessThanOperatorNode(ctx.start.getLine());
    }
    @Override
    public ASTNode visitLessThanOrEqual(FrontParser.LessThanOrEqualContext ctx) {
        return new LessThanOrEqualOperatorNode(ctx.start.getLine());
    }
    @Override
    public ASTNode visitGreaterThan(FrontParser.GreaterThanContext ctx) {
        return new GreaterThanOperatorNode(ctx.start.getLine());
    }
    @Override
    public ASTNode visitGreaterThanOrEqual(FrontParser.GreaterThanOrEqualContext ctx) {
        return new GreaterThanOrEqualOperatorNode(ctx.start.getLine());
    }
    @Override
    public ASTNode visitEqual(FrontParser.EqualContext ctx) {
        return new EqualOperatorNode(ctx.start.getLine());
    }
    @Override
    public ASTNode visitNotEqual(FrontParser.NotEqualContext ctx) {
        return new NotEqualOperatorNode(ctx.start.getLine());
    }
}
