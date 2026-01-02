package AST.ExpressionStatement.Atoms;

public class NoneAtomNode extends AtomNode{
    public NoneAtomNode( int line) {
        super(line, "None");
    }

    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name +" (line " + line + ")");
    }
}
