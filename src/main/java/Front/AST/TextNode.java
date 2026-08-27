package Front.AST;

public class TextNode extends ASTNode {
    public final String text;
    public TextNode(int line, String text) {
        super("Text", line);
        this.text = text;
    }

    @Override
    public void printTree(int indent) {
        System.out.println(indent(indent) + name + " (line " + line + ") : ");
        System.out.println(indent(indent+2)+text);
    }
}
