package AST;

import java.util.ArrayList;
import java.util.List;

public class CssInnerBlockNode extends ASTNode{
    private List<ASTNode> statements = new ArrayList<>();

    public CssInnerBlockNode(int line) {
        super("CssInnerBlock", line);
    }

    public void addStatement(ASTNode stmt) {
        statements.add(stmt);
    }

    public List<ASTNode> getStatements() {
        return statements;
    }



    @Override
    public <R> R accept(AstVisitor<R> visitor) {
        return visitor.visitCssInnerBlock(this);
    }

}
