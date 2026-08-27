package Front.AST.CSS.Property;

import Front.AST.ASTNode;

public class NamePropertyNode extends ASTNode {
    public final String value;
    public NamePropertyNode(int line, String value) {
        super("Name", line);
        this.value = value;
    }

    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name + " (line " + line + ") :");
        System.out.println(super.indent(indent+2)+value);
    }
}
