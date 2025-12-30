package AST.ExpressionStatement.Atoms;

public class DoubleNumberAtomNode extends AtomNode {
    public final double value;
    public DoubleNumberAtomNode(int line, double value) {
        super(line,"Double");
        this.value = value;
    }

    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name +" : "+value+" (line " + line + ")");
    }
}
