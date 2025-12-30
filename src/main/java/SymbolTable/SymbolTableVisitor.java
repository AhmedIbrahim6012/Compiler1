package SymbolTable;

import AST.*;
import AST.ExpressionStatement.AssignmentStatement;
import AST.ExpressionStatement.Atoms.NameAtomNode;
import AST.ExpressionStatement.CallExpressionNode;
import AST.ExpressionStatement.ExpressionNode;
import AST.ExpressionStatement.LiteralExpressionNode;

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
            visit(statement);
        }
    }
    private void visit(ASTNode node){
        if (node ==null){
            return;
        }
        System.out.println(node);
        if (node instanceof FunctionDefNode){
            visitFunction((FunctionDefNode)node);
        } else if (node instanceof BlockNode) {
            visitBloc((BlockNode)node);
        } else if (node instanceof AssignmentStatement) {
            visitAssignment((AssignmentStatement)node);
        } else if (node instanceof CallExpressionNode) {
            visitCallFunction((CallExpressionNode)node);
        }
    }

    private void visitFunction(FunctionDefNode node){
        String name = node.name.name;
        symbolTable.addSymbol(name,Type.Function);
        symbolTable.enterScope();
        for (NameAtomNode params:node.parameters){
            symbolTable.addSymbol(params.name,Type.Variable);
        }
        visit(node.body);
        symbolTable.exitScope();
    }
    private void visitCallFunction(CallExpressionNode node){
        if (node.function instanceof LiteralExpressionNode){
            System.out.println("pppppppppppp");
        }
    }
    private void visitBloc(BlockNode node){
        if (node ==null){
            return;
        }
        for (ASTNode statement: node.statements){
            visit(statement);
        }
    }
    private void visitAssignment(AssignmentStatement node){
        if (node ==null){
            return;
        }
        for (ExpressionNode expr : node.right) {
            visit(expr);
        }
        visit(node.left);
    }


    private void visitNameAtom(NameAtomNode node){
        if (node ==null){
            return;
        }
        String name = node.name;
        symbolTable.addSymbol(name,Type.Variable);
    }

    private void visitIfStatement(IfStatementNode node){
        if (node ==null){
            return;
        }
        visit(node.condition);
        visit(node.body);
        for (IfStatementNode.ElseIf elif : node.elseIf) {
            visit(elif.condition);
            visit(elif.body);
        }
        visit(node.elseBody.body);
    }
    private void visitForStatement(ForStatementNode node){
        if (node ==null){
            return;
        }
        visit(node.expression);
        for (ExpressionNode param : node.params){
            visit(param);
        }
    }

    private void visitTryStatement(TryStatementNode node){
        if (node == null){
            return;
        }
        visit(node.body);
        for (TryStatementNode.Except except : node.excepts) {
            visit(except.expression);
            visit(except.body);
        }
    }
}
