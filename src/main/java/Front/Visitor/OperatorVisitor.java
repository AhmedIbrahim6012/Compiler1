package Front.Visitor;

import Front.AST.Html.ExpressionStatement.Operators.*;
import FrontLang.FrontParser;
import FrontLang.FrontParserBaseVisitor;

public class OperatorVisitor extends FrontParserBaseVisitor<OperatorNode> {
    @Override
    public OperatorNode visitLessThan(FrontParser.LessThanContext ctx) {
        return new LessThanOperatorNode(ctx.start.getLine());
    }

    @Override
    public OperatorNode visitGreaterThan(FrontParser.GreaterThanContext ctx) {
        return  new GreaterThanOperatorNode(ctx.start.getLine());
    }
    @Override
    public OperatorNode visitEqual(FrontParser.EqualContext ctx) {

        return new EqualOperatorNode(ctx.start.getLine());
    }
    @Override
    public OperatorNode visitGreaterThanOrEqual(FrontParser.GreaterThanOrEqualContext ctx) {
        return new GreaterThanOrEqualOperatorNode(ctx.start.getLine());
    }
    @Override
    public OperatorNode visitLessThanOrEqual(FrontParser.LessThanOrEqualContext ctx) {
        return new LessThanOrEqualOperatorNode(ctx.start.getLine());
    }
    @Override
    public OperatorNode visitNotEqual(FrontParser.NotEqualContext ctx) {
        return new NotEqualOperatorNode(ctx.start.getLine());
    }
}
