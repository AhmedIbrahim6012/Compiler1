package AST;

public class DoctypeNode extends ASTNode {
    private String value;

    public DoctypeNode(String value, int line) {
        super("Doctype", line);
        this.value = value;
    }

    public String getValue() {
        return value;
    }
    @Override
    public <R> R accept(AstVisitor<R> visitor) {
        return visitor.visitDoctype(this);
    }
}
