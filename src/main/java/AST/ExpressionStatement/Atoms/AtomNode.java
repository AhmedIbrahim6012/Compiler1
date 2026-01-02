package AST.ExpressionStatement.Atoms;

import AST.ASTNode;

public abstract class AtomNode extends ASTNode {
    public AtomNode(int line, String name) {
        super(line, name);
    }
    @Override
    public void printTree(int indent){
        super.printTree(indent);
    }
}
