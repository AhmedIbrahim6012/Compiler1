package AST.ExpressionStatement;

import AST.ExpressionStatement.Atoms.AtomNode;

public class LiteralExpressionNode extends  ExpressionNode {
    public final AtomNode atom;
    public LiteralExpressionNode(int line, AtomNode atom) {
        super(line, atom.name);
        this.atom = atom;
    }

    @Override
    public void printTree(int indent) {
        atom.printTree(indent);
    }
}
