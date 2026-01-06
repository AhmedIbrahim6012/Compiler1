package Front.AST.Html.ExpressionStatement.Operators;

import Back.AST.ASTNode;

public abstract class OperatorNode extends ASTNode {
    public OperatorNode(int line, String name) {
        super(line, name);
    }
    @Override
    public void printTree(int indent){
        super.printTree(indent);
    }
}
