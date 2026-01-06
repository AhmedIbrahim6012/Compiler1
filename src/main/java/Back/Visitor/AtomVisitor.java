package Back.Visitor;

import Back.AST.ExpressionStatement.Atoms.*;
import BackLang.*;

public class AtomVisitor extends BackParserBaseVisitor<AtomNode> {
    @Override
    public AtomNode visitNumber(BackParser.NumberContext ctx) {
        if (ctx.NUMBER().getText().contains(".")){
            return new DoubleNumberAtomNode(ctx.start.getLine(),Double.parseDouble(ctx.NUMBER().getText()));
        }else {
            return new IntNumberAtomNode(ctx.start.getLine(),Integer.parseInt(ctx.NUMBER().getText()));
        }
    }

    @Override
    public AtomNode visitBool(BackParser.BoolContext ctx) {
         return new BoolAtomNode(ctx.start.getLine(),Boolean.parseBoolean(ctx.getChild(0).getText()));
    }

    @Override
    public AtomNode visitNone(BackParser.NoneContext ctx) {
        return new NoneAtomNode(ctx.start.getLine());
    }

    @Override
    public AtomNode visitName(BackParser.NameContext ctx) {
        return new NameAtomNode(ctx.start.getLine(),ctx.NAME().getText());
    }

    @Override
    public AtomNode visitString(BackParser.StringContext ctx) {
        return new StringAtomNode(ctx.start.getLine(),ctx.STRING().getText());
    }
}
