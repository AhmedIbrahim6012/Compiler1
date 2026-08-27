package Front.AST;

public class NameNode extends ASTNode {
    public final String value;
    public NameNode(int line,String value) {
        super("Name", line);
        this.value = value;
    }
    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name +" : "+value+" (line " + line + ")");
    }

}
