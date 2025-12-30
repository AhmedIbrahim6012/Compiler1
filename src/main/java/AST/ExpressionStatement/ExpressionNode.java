package AST.ExpressionStatement;

import AST.ASTNode;

public abstract class ExpressionNode extends ASTNode {
    public ExpressionNode(int line, String name) {
        super(line, name);
    }

    @Override
    public void printTree(int indent) {
        super.printTree(indent);
    }
}
