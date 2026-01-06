package Front.AST.CSS.Value;


public class KeyboardNode extends ValueNode{
    public final String keyboard;
    public KeyboardNode(int line, String keyboard) {
        super("Keyboard", line);
        this.keyboard = keyboard;
    }

    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name + " (line " + line + ") :");
        System.out.println(super.indent(indent+2)+keyboard);
    }
}
