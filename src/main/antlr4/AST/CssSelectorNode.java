package AST;

public class CssSelectorNode extends ASTNode{
    private String value;

    public CssSelectorNode(String value, int line) {
        super("CssSelector", line);
        this.value = value;
    }



    public String getValue() {
        return value;
    }
    @Override
    public <R> R accept(AstVisitor<R> visitor) {
        return visitor.visitCssSelector(this);
    }
}
