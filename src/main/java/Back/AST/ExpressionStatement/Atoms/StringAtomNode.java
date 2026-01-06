package Back.AST.ExpressionStatement.Atoms;

public class StringAtomNode extends AtomNode{
    public final String value;

    public StringAtomNode(int line, String value) {
        super(line, "String");
        this.value = value;
    }

    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name +" : "+value+" (line " + line + ")");
    }
}
