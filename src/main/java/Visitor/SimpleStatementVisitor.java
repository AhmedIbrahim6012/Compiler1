package Visitor;
import AST.ExpressionStatement.ExpressionNode;
import AST.ExpressionStatement.ExpressionStatementNode;
import MyLang.MyParser;
import MyLang.MyParserBaseVisitor;
import AST.*;

public class SimpleStatementVisitor extends  MyParserBaseVisitor<SimpleStatementNode> {
    @Override
    public SimpleStatementNode visitImport_statement(MyParser.Import_statementContext ctx) {
        return (new ImportStatementVisitor()).visit(ctx);
    }

    @Override
    public SimpleStatementNode visitExpression_statement(MyParser.Expression_statementContext ctx) {
        ExpressionNode expression = (new ExpressionNodeVisitor()).visit(ctx);
        return new ExpressionStatementNode(ctx.start.getLine(), expression);

    }

    @Override
    public SimpleStatementNode visitFlow_statement(MyParser.Flow_statementContext ctx) {
        return (new FlowStatementVisitor()).visit(ctx);
    }
}
