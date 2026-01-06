package SymbolTable;

import Back.AST.*;
import Back.AST.ExpressionStatement.AssignmentStatement;
import Back.AST.ExpressionStatement.Atoms.NameAtomNode;
import Back.AST.ExpressionStatement.CallExpressionNode;
import Back.AST.ExpressionStatement.ExpressionNode;
import Back.AST.ExpressionStatement.ExpressionStatementNode;
import Back.AST.FlowStatement.RaiseStatementNode;
import Back.AST.FlowStatement.ReturnStatementNode;

public class SymbolTableVisitor {
    private final SymbolTable symbolTable;
    public  SymbolTableVisitor() {
        this.symbolTable = new SymbolTable();
    }
    public void analyze(Program node) {
        if (node == null){
            return;
        }

        for(ASTNode statement: node.statements){
            visit(statement,false);
        }
    }

    private void visit(ASTNode node,boolean check){
        if (node == null){
            return;
        }
//        System.out.println(node instanceof  NameAtomNode);
        if (node instanceof NameAtomNode){
            visitNameAtom((NameAtomNode)node,check);
        } else if (node instanceof SimpleStatementsNode) {
            visitSimpleStatements((SimpleStatementsNode)node,check);
        } else if (node instanceof FunctionDefNode){
            visitFunction((FunctionDefNode)node,check);
        } else if (node instanceof BlockNode) {
            visitBlock((BlockNode)node,check);
        } else if (node instanceof AssignmentStatement) {
            visitAssignment((AssignmentStatement)node,check);
        } else if (node instanceof CallExpressionNode) {
            visitCallFunction((CallExpressionNode)node,check);
        } else if (node instanceof ReturnStatementNode) {
            visitReturnStatement((ReturnStatementNode) node,check);
        }else if (node instanceof ExpressionStatementNode){
            visitExpressionStatement((ExpressionStatementNode)node,check);
        }else if (node instanceof IfStatementNode){
            visitIfStatement((IfStatementNode)node,check);
        } else if (node instanceof ForStatementNode) {
            visitForStatement((ForStatementNode)node,check);
        } else if (node instanceof TryStatementNode) {
            visitTryStatement((TryStatementNode)node,check);
        } else if (node instanceof RaiseStatementNode) {
            visitRaiseStatement((RaiseStatementNode) node,check);
        }
    }

    private void visitReturnStatement(ReturnStatementNode node,boolean check){
        visit(node.expression,true);
    }

    private void visitRaiseStatement(RaiseStatementNode node, boolean check){
        visit(node.expressionBeforeFrom,true);
        visit(node.expressionAfterFrom,true);
    }

    private void visitSimpleStatements(SimpleStatementsNode node,boolean check){
        for (ASTNode statement: node.statements){
            visit(statement,check);
        }
    }

    private void visitExpressionStatement(ExpressionStatementNode node,boolean check){
        visit(node.expression,check);
    }

    private void visitFunction(FunctionDefNode node,boolean check){
        visit(node.name,false);
        symbolTable.enterScope();
        for (NameAtomNode params:node.parameters){
            symbolTable.addSymbol(params.value,Type.Variable,node.line);
        }
        visit(node.body,check);
        symbolTable.exitScope();
    }
    private void visitCallFunction(CallExpressionNode node,boolean check){
        visit(node.function,true);
    }
    private void visitBlock(BlockNode node,boolean check){
        if (node ==null){
            return;
        }
        for (ASTNode statement: node.statements){
            visit(statement,check);
        }
    }
    private void visitAssignment(AssignmentStatement node,boolean check){
        if (node == null){
            return;
        }
        for (ExpressionNode expr : node.right) {
            visit(expr,true);
        }
        visit(node.left,check);
    }


    private void visitNameAtom(NameAtomNode node,boolean check){
        if (node ==null){
            return;
        }
        String name = node.value;
        if (check){
            symbolTable.lookup(node.value,node.line);
        }else {
            symbolTable.addSymbol(name,Type.Variable,node.line);
        }

    }

    private void visitIfStatement(IfStatementNode node,boolean check){
        if (node ==null){
            return;
        }
        visit(node.condition,true);
        symbolTable.enterScope();
        visit(node.body,check);
        symbolTable.exitScope();
        for (IfStatementNode.ElseIf elif : node.elseIf) {
            visit(elif.condition,true);
            symbolTable.enterScope();
            visit(elif.body,check);
            symbolTable.exitScope();
        }
        if (node.elseBody!=null){
            symbolTable.enterScope();
            visit(node.elseBody.body,check);
            symbolTable.exitScope();
        }
    }
    private void visitForStatement(ForStatementNode node,boolean check){
        if (node ==null){
            return;
        }
        visit(node.expression,true);

        for (ExpressionNode param : node.params){
            visit(param,check);
        }
        symbolTable.enterScope();
        visit(node.body,check);
        if (node.elseBody!=null){
            visit(node.elseBody.body,check);
        }
        symbolTable.exitScope();
    }

    private void visitTryStatement(TryStatementNode node,boolean check){
        if (node == null){
            return;
        }
        visit(node.body,check);
        for (TryStatementNode.Except except : node.excepts) {
            visit(except.expression,check);
            visit(except.body,check);
        }
    }
}
