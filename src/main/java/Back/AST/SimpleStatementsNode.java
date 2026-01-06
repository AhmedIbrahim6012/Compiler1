package Back.AST;

import java.util.List;

public class SimpleStatementsNode extends  ASTNode {
   public final List<SimpleStatementNode> statements;
    public SimpleStatementsNode(List<SimpleStatementNode> statements) {
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
