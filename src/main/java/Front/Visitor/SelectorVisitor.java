package Front.Visitor;

import Front.AST.ASTNode;
import Front.AST.CSS.Selector.*;
import FrontLang.FrontParser;
import FrontLang.FrontParserBaseVisitor;

public class SelectorVisitor extends FrontParserBaseVisitor<SelectorNode> {
    @Override
    public SelectorNode visitClassSelector(FrontParser.ClassSelectorContext ctx) {
        return new ClassSelectorNode(ctx.start.getLine(),ctx.CLASS_SELECTOR().getText());
    }

    @Override
    public SelectorNode visitIDSelector(FrontParser.IDSelectorContext ctx) {
        return new IDSelectorNode(ctx.start.getLine(),ctx.ID_SELECTOR().getText());
    }

    @Override
    public SelectorNode visitNameSelector(FrontParser.NameSelectorContext ctx) {
        return new NameSelectorNode(ctx.start.getLine(),ctx.IDENT().getText());
    }

    @Override
    public SelectorNode visitPseudoSelector(FrontParser.PseudoSelectorContext ctx) {
        return new PseudoClassSelectorNode(ctx.start.getLine(),ctx.IDENT().getText());
    }

    @Override
    public SelectorNode visitStarSelector(FrontParser.StarSelectorContext ctx) {
        return new StarSelectorNode(ctx.start.getLine());
    }
}
