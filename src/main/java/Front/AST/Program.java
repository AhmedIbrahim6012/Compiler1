package Front.AST;

import java.util.List;

public class Program extends  ASTNode {
    public List<ASTNode> statements;
    public Program(List<ASTNode>statements){
        super("",1);
        this.statements = statements;
    }

    public void printTree() {
        System.out.println("Program : ");
        for (ASTNode stmt : statements) {
            stmt.printTree(2);
        }
    }
}