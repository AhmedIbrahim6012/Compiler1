package Front.AST.CSS.Property;

public class VariablePropertyNode extends  PropertyNode {
    public final String value;
    public VariablePropertyNode(int line, String value) {
        super("Variable", line);
        this.value = value;
    }

    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name + " (line " + line + ") :");
        System.out.println(super.indent(indent+2)+value);
    }
}
