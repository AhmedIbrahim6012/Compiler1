package Visitor;

import AST.ExpressionStatement.Operators.OperatorNode;
import MyLang.MyParser;
import MyLang.MyParserBaseVisitor;
import AST.ExpressionStatement.Operators.*;
public class OperatorVisitor extends MyParserBaseVisitor<OperatorNode> {
    @Override
    public OperatorNode visitLessThan(MyParser.LessThanContext ctx) {
        return new LessThanOperatorNode(ctx.start.getLine());
    }

    @Override
    public OperatorNode visitGreaterThan(MyParser.GreaterThanContext ctx) {
        return  new GreaterThanOperatorNode(ctx.start.getLine());
    }
    @Override
    public OperatorNode visitEqual(MyParser.EqualContext ctx) {
        return new EqualOperatorNode(ctx.start.getLine());
    }
    @Override
    public OperatorNode visitGreaterThanOrEqual(MyParser.GreaterThanOrEqualContext ctx) {
        return new GreaterThanOrEqualOperatorNode(ctx.start.getLine());
    }
    @Override
    public OperatorNode visitLessThanOrEqual(MyParser.LessThanOrEqualContext ctx) {
        return new LessThanOrEqualOperatorNode(ctx.start.getLine());
    }
    @Override
    public OperatorNode visitNotEqual(MyParser.NotEqualContext ctx) {
        return new NotEqualOperatorNode(ctx.start.getLine());
    }
    @Override
    public OperatorNode visitIn(MyParser.InContext ctx) {
        return new InOperatorNode(ctx.start.getLine());
    }
    @Override
    public OperatorNode visitNotIn(MyParser.NotInContext ctx) {
        return new NotInOperatorNode(ctx.start.getLine());
    }
    @Override
    public OperatorNode visitIs(MyParser.IsContext ctx) {
        return new IsOperatorNode(ctx.start.getLine());
    }
    @Override
    public OperatorNode visitIsNot(MyParser.IsNotContext ctx) {
        return new IsNotOperatorNode(ctx.start.getLine());
    }
}
