package Front.Visitor;
import Front.AST.Html.ExpressionStatement.Atoms.*;
import FrontLang.FrontParser;
import FrontLang.FrontParserBaseVisitor;

public class AtomVisitor extends FrontParserBaseVisitor<AtomNode> {
    @Override
    public AtomNode visitNumber(FrontParser.NumberContext ctx) {
        if (ctx.JINJA_NUMBER().getText().contains(".")){
            return new DoubleNumberAtomNode(ctx.start.getLine(),Double.parseDouble(ctx.JINJA_NUMBER().getText()));
        }else {
            return new IntNumberAtomNode(ctx.start.getLine(),Integer.parseInt(ctx.JINJA_NUMBER().getText()));
        }
    }

    @Override
    public AtomNode visitBool(FrontParser.BoolContext ctx) {
         return new BoolAtomNode(ctx.start.getLine(),Boolean.parseBoolean(ctx.getChild(0).getText()));
    }

    @Override
    public AtomNode visitAtomName(FrontParser.AtomNameContext ctx) {
        return new NameAtomNode(ctx.start.getLine(),ctx.JINJA_IDENT().getText());
    }

    @Override
    public AtomNode visitString(FrontParser.StringContext ctx) {
        return new StringAtomNode(ctx.start.getLine(),ctx.STRING().getText());
    }
}
