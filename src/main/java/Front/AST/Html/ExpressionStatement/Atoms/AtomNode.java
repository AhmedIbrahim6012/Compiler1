package Front.AST.Html.ExpressionStatement.Atoms;

import Front.AST.Html.ExpressionStatement.ExpressionNode;

public abstract class AtomNode extends ExpressionNode {
    public AtomNode(int line, String name) {

        super(line, name);
    }
    @Override
    public void printTree(int indent){
        super.printTree(indent);
    }
}
