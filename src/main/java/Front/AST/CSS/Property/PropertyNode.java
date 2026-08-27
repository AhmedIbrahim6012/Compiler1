package Front.AST.CSS.Property;

import Front.AST.ASTNode;

public class PropertyNode extends ASTNode {
    public final ASTNode property;
    public PropertyNode(int line,ASTNode property) {
        super("Property", line);
        this.property = property;
    }

    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name + " (line " + line + ") :");
        property.printTree(indent+2);
    }
}
