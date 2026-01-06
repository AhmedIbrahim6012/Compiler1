package Front.AST.Html.ExpressionStatement.Atoms;

public class NameAtomNode extends AtomNode {
    public final String value;
    public NameAtomNode(int line, String value) {
        super(line, "Name");
        this.value = value;
    }
    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name +" : "+value+" (line " + line + ")");
    }
}
