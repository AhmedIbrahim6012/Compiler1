package AST;

public class CssValueNode extends ASTNode{
    private String value;

    public CssValueNode(String value, int line) {
        super("CssValue", line);
        this.value = value;
    }

    public String getValue() {
        return value;

    }

    @Override
    public <R> R accept(AstVisitor<R> visitor) {
        return visitor.visitCssValue(this);
    }
}
