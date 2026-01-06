package Front.Visitor;

import Front.AST.ASTNode;
import Front.AST.CSS.Value.*;
import FrontLang.FrontParser;
import FrontLang.FrontParserBaseVisitor;

import java.util.ArrayList;
import java.util.List;

public class ValueVisitor extends FrontParserBaseVisitor<ValueNode> {


    @Override
    public ValueNode visitNumberUnit(FrontParser.NumberUnitContext ctx) {
        if (ctx.NUMBER().getText().contains(".")){
            if (ctx.UNIT() != null){
                return new DoubleValueNode(ctx.start.getLine(),Double.parseDouble(ctx.NUMBER().getText()),ctx.UNIT().getText());
            }
            return new DoubleValueNode(ctx.start.getLine(),Double.parseDouble(ctx.NUMBER().getText()),null);
        }else {
            if (ctx.UNIT() != null){
                return new IntValueNode(ctx.start.getLine(),Integer.parseInt(ctx.NUMBER().getText()),ctx.UNIT().getText());
            }
            return new IntValueNode(ctx.start.getLine(),Integer.parseInt(ctx.NUMBER().getText()),null);

        }
    }

    @Override
    public ValueNode visitName(FrontParser.NameContext ctx) {
        return new NameNode(ctx.start.getLine(),ctx.IDENT().getText());
    }

    @Override
    public ValueNode visitString(FrontParser.StringContext ctx) {
        return new StringNode(ctx.start.getLine(),ctx.STRING().getText());
    }

    @Override
    public ValueNode visitVariable(FrontParser.VariableContext ctx) {
        return new VariableNode(ctx.start.getLine(),ctx.variableDeff().IDENT().getText());
    }

    @Override
    public ValueNode visitCallFunction(FrontParser.CallFunctionContext ctx) {
        NameNode name = new NameNode(ctx.start.getLine(),ctx.function().IDENT().getText());
        List<ValueNode>params = new ArrayList<>();
        for (int i = 0; i < ctx.function().cssValue().size(); i++) {
            params.add(visit(ctx.function().cssValue().get(i)));
        }
        return new FunctionNode(ctx.start.getLine(),name,params);
    }

    @Override
    public ValueNode visitColor(FrontParser.ColorContext ctx) {
        return new ColorNode(ctx.start.getLine(),ctx.getText());
    }
    @Override
    public ValueNode visitKeyword(FrontParser.KeywordContext ctx) {
        return new KeyboardNode(ctx.start.getLine(),ctx.getText());
    }
}
