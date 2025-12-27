package AST;

public class HtmlAttributeNode extends ASTNode {

    private String key;
    private String value;

    public HtmlAttributeNode(String key, String value, int line) {
        super("HtmlAttribute", line);
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    @Override
    public <R> R accept(AstVisitor<R> visitor) {
        return visitor.visitAttribute(this);
    }
}
