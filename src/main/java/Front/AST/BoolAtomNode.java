package Front.AST;

public class BoolAtomNode extends ASTNode {
    public final boolean value;
    public BoolAtomNode(int line,  boolean value) {
        super( "Bool",line);
        this.value = value;
    }

    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name +" : "+value+" (line " + line + ")");
    }
}
