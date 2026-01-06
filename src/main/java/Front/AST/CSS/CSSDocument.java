package Front.AST.CSS;

import Front.AST.ASTNode;

import java.util.List;

public class CSSDocument extends ASTNode {
    public final List<ASTNode>statements;
    public CSSDocument(int line, List<ASTNode> statements) {
        super("CSS Document", line);
        this.statements = statements;
    }

    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name + " (line " + line + ") :");
        for (ASTNode statement : statements){
            statement.printTree(indent+2);
        }
    }
}
