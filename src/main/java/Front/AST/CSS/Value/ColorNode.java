package Front.AST.CSS.Value;

public class ColorNode extends ValueNode{
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
