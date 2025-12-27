package AST;

public class JinjaStatementNode extends ASTNode{


private String code;

public JinjaStatementNode(String code, int line) {
    super("JinjaStatement", line);
    this.code = code;
}

public String getCode() {
    return code;
}
    @Override
    public <R> R accept(AstVisitor<R> visitor) {
        return visitor.visitJinja2ForStatement(this);
    }
}