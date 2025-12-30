package Visitor;

import AST.ExpressionStatement.Atoms.*;
import MyLang.MyParser;
import MyLang.MyParserBaseVisitor;

public class AtomVisitor extends MyParserBaseVisitor<AtomNode> {
    @Override
    public AtomNode visitNumber(MyParser.NumberContext ctx) {
        if (ctx.NUMBER().getText().contains(".")){
            return new DoubleNumberAtomNode(ctx.start.getLine(),Double.parseDouble(ctx.NUMBER().getText()));
        }else {
            return new IntNumberAtomNode(ctx.start.getLine(),Integer.parseInt(ctx.NUMBER().getText()));
        }
    }

    @Override
    public AtomNode visitBool(MyParser.BoolContext ctx) {
         return new BoolAtomNode(ctx.start.getLine(),Boolean.parseBoolean(ctx.getChild(0).getText()));
    }

    @Override
    public AtomNode visitNone(MyParser.NoneContext ctx) {
        return new NoneAtomNode(ctx.start.getLine());
    }

    @Override
    public AtomNode visitName(MyParser.NameContext ctx) {
        return new NameAtomNode(ctx.start.getLine(),ctx.NAME().getText());
    }

    @Override
    public AtomNode visitString(MyParser.StringContext ctx) {
        return new StringAtomNode(ctx.start.getLine(),ctx.STRING().getText());
    }
}
