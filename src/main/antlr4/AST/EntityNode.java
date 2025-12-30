package AST;

public class EntityNode extends ASTNode{
    private String value;

    public EntityNode(String value, int line) {
        super("Entity", line);
        this.value = value;
    }

    public String getValue() {
        return value;
    }
    @Override
    public <R> R accept(AstVisitor<R> visitor) {
        return visitor.visitEntity(this);
    }
}
