package Front.AST.Html.ExpressionStatement.Atoms;

public class BoolAtomNode extends AtomNode {
    public final boolean value;
    public BoolAtomNode(int line,  boolean value) {
        super(line, "Bool");
        this.value = value;
    }

    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name +" : "+value+" (line " + line + ")");
    }
}
