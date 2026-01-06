package Front.AST.CSS.Value;

public  class StringNode extends ValueNode {
    public final  String value;
    public StringNode( int line,String value) {
        super("String", line);
        this.value = value;
    }

    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name +" : "+value+" (line " + line + ")");
    }
}

