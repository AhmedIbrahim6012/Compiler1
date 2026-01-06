package Back.Visitor;

import Back.AST.ExpressionStatement.ExpressionNode;
import Back.AST.FlowStatement.FlowStatementNode;
import Back.AST.FlowStatement.RaiseStatementNode;
import Back.AST.FlowStatement.ReturnStatementNode;
import BackLang.*;


public class FlowStatementVisitor extends BackParserBaseVisitor<FlowStatementNode> {
    @Override
    public FlowStatementNode visitReturn_statement(BackParser.Return_statementContext ctx) {
        ExpressionNode expression = (new ExpressionNodeVisitor()).visit(ctx.expression());
        return new ReturnStatementNode(ctx.start.getLine(),expression);
    }

    @Override
    public FlowStatementNode visitRaise_statement(BackParser.Raise_statementContext ctx) {
        ExpressionNode before = null,after = null;
        if (ctx.test() != null) {
            before = (new ExpressionNodeVisitor()).visit(ctx.test(0));
            if (ctx.test().size()==2){
                after = (new ExpressionNodeVisitor()).visit(ctx.test(1));
            }
        }
        return new RaiseStatementNode(ctx.start.getLine(),before,after);
    }
}
