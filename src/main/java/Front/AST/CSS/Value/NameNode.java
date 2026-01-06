package Front.AST.CSS.Value;


public class NameNode extends ValueNode {
    public final String name;
    public NameNode(int line,String name) {
        super("Name", line);
        this.name = name;
    }
    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name +" : "+name+" (line " + line + ")");
    }

}
