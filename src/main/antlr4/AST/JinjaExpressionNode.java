package AST;

public class JinjaExpressionNode extends ASTNode{

    private String code;

    public JinjaExpressionNode(String code, int line) {
        super("JinjaExpression", line);
        this.code = code;
    }



    public String getCode() {
        return code;
    }
    @Override
    public <R> R accept(AstVisitor<R> visitor) {
        return visitor.visitJinja2Expression(this);
    }

}
