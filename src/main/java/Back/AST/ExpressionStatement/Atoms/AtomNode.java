package Back.AST.ExpressionStatement.Atoms;

import Back.AST.ExpressionStatement.ExpressionNode;

public abstract class AtomNode extends ExpressionNode {
    public AtomNode(int line, String name) {
        super(line, name);
    }
    @Override
    public void printTree(int indent){
        super.printTree(indent);
    }
}
