package Visitor;

import AST.*;
import AST.ExpressionStatement.Atoms.AtomNode;
import AST.ExpressionStatement.Atoms.NameAtomNode;
import AST.ExpressionStatement.ExpressionNode;
import MyLang.MyParser;
import MyLang.MyParserBaseVisitor;

import java.util.ArrayList;
import java.util.List;

public class CompoundStatementVisitor extends MyParserBaseVisitor<CompoundStatementNode> {
    @Override
    public CompoundStatementNode visitIf_statement(MyParser.If_statementContext ctx) {
        ExpressionNode ifCondition = (new ExpressionNodeVisitor()).visit(ctx.test(0));
        BlockNode ifBlock =(BlockNode) (new ASTVisitor()).visit(ctx.block(0));
        List<IfStatementNode.ElseIf>elseIfs = new ArrayList<>();

            for (int i = 0; i < ctx.ELIF().size(); i++) {
             ExpressionNode elseIfCondition = (new ExpressionNodeVisitor()).visit(ctx.test(i+1));
             BlockNode elseIfBlock =(BlockNode) (new ASTVisitor()).visit(ctx.block(i+1));
             elseIfs.add(new IfStatementNode.ElseIf(ctx.test(i+1).start.getLine(),elseIfCondition,elseIfBlock));
            }
        IfStatementNode.Else elseBody=null;
        if (ctx.ELSE() != null) {
            elseBody = new IfStatementNode.Else(ctx.block(ctx.block().size() - 1).start.getLine(),(BlockNode) (new ASTVisitor()).visit(ctx.block(ctx.block().size() - 1)));
        }
        return new IfStatementNode(ctx.start.getLine(),ifCondition,ifBlock,elseIfs,elseBody);
    }

    @Override
    public CompoundStatementNode visitFor_statement(MyParser.For_statementContext ctx) {
        List<ExpressionNode>params = new ArrayList<>();
        for (int i = 0; i < ctx.exprlist().expr().size(); i++) {
            params.add(new ExpressionNodeVisitor().visit((ctx.exprlist().expr(i))));
        }
        ExpressionNode expression = new ExpressionNodeVisitor().visit(ctx.expression());
        BlockNode body =(BlockNode) new ASTVisitor().visit(ctx.block(0));
        ForStatementNode.Else elseBody = null;
        if (ctx.ELSE() != null) {
            elseBody = new ForStatementNode.Else(ctx.block(1).start.getLine(),(BlockNode) new ASTVisitor().visit(ctx.block(1)));
        }
        return new ForStatementNode(ctx.start.getLine(),expression,params,body,elseBody);
    }

    @Override
    public CompoundStatementNode visitTry_statement(MyParser.Try_statementContext ctx) {
        BlockNode body = (BlockNode)  new ASTVisitor().visit(ctx.block(0));
        List<TryStatementNode.Except>excepts = new ArrayList<>();
        for (int i = 1; i < ctx.block().size(); i++) {
            BlockNode exceptBody = (BlockNode) (new ASTVisitor()).visit(ctx.block(i));
            ExpressionNode expression = null;
            if ((i < ctx.block().size()-1) || (i == ctx.block().size()-1 && ctx.test(i-1) != null)) {
               expression = new ExpressionNodeVisitor().visit(ctx.test(i-1));
            }
            excepts.add(new TryStatementNode.Except(ctx.start.getLine(),expression,exceptBody));
        }
        return new TryStatementNode(ctx.start.getLine(),body,excepts);
    }

    @Override
    public CompoundStatementNode visitFuncdef(MyParser.FuncdefContext ctx) {
        NameAtomNode name = new NameAtomNode(ctx.start.getLine(),ctx.NAME().getText());
        List<NameAtomNode>params=new ArrayList<>();
        if (ctx.parameters().paramlist() != null){
            for (int i = 0; i < ctx.parameters().paramlist().NAME().size(); i++) {
                params.add(new NameAtomNode(ctx.start.getLine(),ctx.parameters().paramlist().NAME(i).getText()));
            }
        }
        BlockNode body =(BlockNode) new ASTVisitor().visit(ctx.block());

        return new FunctionDefNode(ctx.start.getLine(),name,params,body);
    }
}
