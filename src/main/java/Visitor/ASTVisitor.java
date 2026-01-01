package Visitor;

import AST.*;
import AST.ExpressionStatement.ArgumentsExpressionNode;
import AST.ImporStatement.DottedNameNode;
import MyLang.MyParser;
import MyLang.MyParserBaseVisitor;

import java.util.ArrayList;
import java.util.List;

public class ASTVisitor extends MyParserBaseVisitor<ASTNode> {
    @Override
    public ASTNode visitSimple_statement(MyParser.Simple_statementContext ctx) {
        return new SimpleStatementVisitor().visit(ctx);
    }

    @Override
    public ASTNode visitSimple_statements(MyParser.Simple_statementsContext ctx) {
        List<SimpleStatementNode>statements = new ArrayList<>();
        for (int i = 0; i < ctx.simple_statement().size(); i++) {
            statements.add(new SimpleStatementVisitor().visit(ctx.simple_statement(i)));
        }
        return new SimpleStatementsNode(statements);
    }

    @Override
    public ASTNode visitCompound_statements(MyParser.Compound_statementsContext ctx) {
        return new CompoundStatementVisitor().visit(ctx);
    }

    @Override
    public ASTNode visitBlock(MyParser.BlockContext ctx) {
        List<ASTNode> statements=new ArrayList<>();
        if (ctx.simple_statements()!=null){
            statements.add(visit(ctx.simple_statements()));
        }
        for (int i = 0; i < ctx.statements().size(); i++) {
            if (ctx.statements(i).simple_statements()!=null){
                statements.add(visit(ctx.statements(i).simple_statements()));
            }else {
                statements.add(visit(ctx.statements(i).compound_statements()));
            }
        }
        return new BlockNode(ctx.start.getLine(),statements);
    }

    @Override
    public ASTNode visitDecorated(MyParser.DecoratedContext ctx) {
        List<DecoratorNode.Decorate>decorators = new ArrayList<>();
        for (int i = 0; i < ctx.decorator().size(); i++) {
            decorators.add((DecoratorNode.Decorate) visit(ctx.decorator(i)));
        }
        FunctionDefNode function =(FunctionDefNode) new CompoundStatementVisitor().visit(ctx.funcdef());
        return new DecoratorNode(ctx.start.getLine(),decorators,function);
    }

    @Override
    public ASTNode visitDecorator(MyParser.DecoratorContext ctx) {
        DottedNameNode dottedName =(DottedNameNode) new ImportNodeVisitor().visit(ctx.dotted_name());
        ArgumentsExpressionNode arguments = null;
        if (ctx.arglist() != null){
            arguments =(ArgumentsExpressionNode) new ExpressionNodeVisitor().visit(ctx.arglist());
        }
        return new DecoratorNode.Decorate(ctx.start.getLine(),dottedName,arguments);
    }
}
