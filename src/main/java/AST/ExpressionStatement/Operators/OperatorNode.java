package AST.ExpressionStatement.Operators;

import AST.ASTNode;

public abstract class OperatorNode extends ASTNode {
    public OperatorNode(int line, String name) {
        super(line, name);
    }
    @Override
    public void printTree(int indent){
        super.printTree(indent);
    }
}
