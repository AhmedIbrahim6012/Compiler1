package AST ;

public class TextNode extends ASTNode {

    private String text;

    public TextNode(String text, int line) {
        super("TextNode", line);
        this.text = text;
    }

    public String getText() {
        return text;
    }
    @Override
    public <R> R accept(AstVisitor<R> visitor) {

        return visitor.visitTextNode(this);
    }

}
