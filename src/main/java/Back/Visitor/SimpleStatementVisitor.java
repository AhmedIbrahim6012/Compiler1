package Back.Visitor;
import Back.AST.ExpressionStatement.ExpressionNode;
import Back.AST.ExpressionStatement.ExpressionStatementNode;
import Back.AST.SimpleStatementNode;
import BackLang.*;

public class SimpleStatementVisitor extends  BackParserBaseVisitor<SimpleStatementNode> {
    @Override
    public SimpleStatementNode visitImport_statement(BackParser.Import_statementContext ctx) {
        return (new ImportStatementVisitor()).visit(ctx);
    }

    @Override
    public SimpleStatementNode visitExpression_statement(BackParser.Expression_statementContext ctx) {
        ExpressionNode expression = (new ExpressionNodeVisitor()).visit(ctx);
        return new ExpressionStatementNode(ctx.start.getLine(), expression);

    }

    @Override
    public SimpleStatementNode visitFlow_statement(BackParser.Flow_statementContext ctx) {
        return (new FlowStatementVisitor()).visit(ctx);
    }
}
