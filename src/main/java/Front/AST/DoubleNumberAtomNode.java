package Front.AST;

public class DoubleNumberAtomNode extends ASTNode {
    public final double value;
    public DoubleNumberAtomNode(int line, double value) {
        super("Double",line);
        this.value = value;
    }

    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name +" : "+value+" (line " + line + ")");
    }
}
