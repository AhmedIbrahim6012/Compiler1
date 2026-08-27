package Front.AST;

public class StringNode extends ASTNode {
    public final String value;

    public StringNode(int line, String value) {
        super( "String",line);
        this.value = value;
    }

    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name +" : "+value+" (line " + line + ")");
    }
}
