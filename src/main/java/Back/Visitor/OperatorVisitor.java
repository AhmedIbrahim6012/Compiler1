package Back.Visitor;

import Back.AST.ExpressionStatement.Operators.*;
import BackLang.*;
public class OperatorVisitor extends BackParserBaseVisitor<OperatorNode> {
    @Override
    public OperatorNode visitLessThan(BackParser.LessThanContext ctx) {
        return new LessThanOperatorNode(ctx.start.getLine());
    }

    @Override
    public OperatorNode visitGreaterThan(BackParser.GreaterThanContext ctx) {
        return  new GreaterThanOperatorNode(ctx.start.getLine());
    }
    @Override
    public OperatorNode visitEqual(BackParser.EqualContext ctx) {
        return new EqualOperatorNode(ctx.start.getLine());
    }
    @Override
    public OperatorNode visitGreaterThanOrEqual(BackParser.GreaterThanOrEqualContext ctx) {
        return new GreaterThanOrEqualOperatorNode(ctx.start.getLine());
    }
    @Override
    public OperatorNode visitLessThanOrEqual(BackParser.LessThanOrEqualContext ctx) {
        return new LessThanOrEqualOperatorNode(ctx.start.getLine());
    }
    @Override
    public OperatorNode visitNotEqual(BackParser.NotEqualContext ctx) {
        return new NotEqualOperatorNode(ctx.start.getLine());
    }
    @Override
    public OperatorNode visitIn(BackParser.InContext ctx) {
        return new InOperatorNode(ctx.start.getLine());
    }
    @Override
    public OperatorNode visitNotIn(BackParser.NotInContext ctx) {
        return new NotInOperatorNode(ctx.start.getLine());
    }
    @Override
    public OperatorNode visitIs(BackParser.IsContext ctx) {
        return new IsOperatorNode(ctx.start.getLine());
    }
    @Override
    public OperatorNode visitIsNot(BackParser.IsNotContext ctx) {
        return new IsNotOperatorNode(ctx.start.getLine());
    }
}
