package Front.AST;

public class IntNumberAtomNode extends ASTNode {
    public final int value;
    public IntNumberAtomNode(int line,int value) {
        super("Integer",line);
        this.value = value;
    }

    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name +" : "+value+" (line " + line + ")");
    }
}
