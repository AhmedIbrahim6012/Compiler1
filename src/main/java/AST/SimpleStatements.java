package AST;

import java.util.List;

public class SimpleStatements extends  ASTNode {
   public final List<SimpleStatementNode> statements;
    public SimpleStatements(List<SimpleStatementNode> statements) {
        super(1,"");
        this.statements = statements;
    }

    @Override
    public void printTree(int indent) {
        for (SimpleStatementNode stmt : statements) {
            stmt.printTree(indent);
        }
    }
}
