package Front.AST.Html.ExpressionStatement.Atoms;

public class IntNumberAtomNode extends AtomNode {
    public final int value;
    public IntNumberAtomNode(int line,int value) {
        super(line, "Integer");
        this.value = value;
    }

    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name +" : "+value+" (line " + line + ")");
    }
}
