package Front.AST.CSS.Property;

import Front.AST.ASTNode;

public class VariablePropertyNode extends ASTNode {
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
