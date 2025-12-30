package Visitor;

import AST.ExpressionStatement.ExpressionNode;
import AST.FlowStatement.FlowStatementNode;
import AST.FlowStatement.RaiseStatementNode;
import AST.FlowStatement.ReturnStatementNode;
import MyLang.MyParser;
import MyLang.MyParserBaseVisitor;

public class FlowStatementVisitor extends MyParserBaseVisitor<FlowStatementNode> {
    @Override
    public FlowStatementNode visitReturn_statement(MyParser.Return_statementContext ctx) {
        ExpressionNode expression = (new ExpressionNodeVisitor()).visit(ctx.expression());
        return new ReturnStatementNode(ctx.start.getLine(),expression);
    }

    @Override
    public FlowStatementNode visitRaise_statement(MyParser.Raise_statementContext ctx) {
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
