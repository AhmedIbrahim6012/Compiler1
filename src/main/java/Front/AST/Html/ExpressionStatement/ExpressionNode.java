package Front.AST.Html.ExpressionStatement;

import Front.AST.ASTNode;

public abstract class ExpressionNode extends ASTNode {
    public ExpressionNode(int line, String name) {
        super(name,line);
    }

    @Override
    public void printTree(int indent) {
        super.printTree(indent);
    }
}
