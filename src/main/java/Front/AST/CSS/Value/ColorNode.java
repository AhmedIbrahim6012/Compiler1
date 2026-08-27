package Front.AST.CSS.Value;

import Front.AST.ASTNode;

public class ColorNode extends ASTNode {
    public final String color;
    public ColorNode(int line, String color) {
        super("Color", line);
        this.color = color;
    }

    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name + " (line " + line + ") :");
        System.out.println(super.indent(indent+2)+color);
    }
}
