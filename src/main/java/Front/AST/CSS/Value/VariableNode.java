package Front.AST.CSS.Value;

public class VariableNode extends ValueNode{
    public final String variable;
    public VariableNode(int line, String variable) {
        super("Variable", line);
        this.variable = variable;
    }

    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name + " (line " + line + ") :");
        System.out.println(super.indent(indent+2)+variable);
    }
}
