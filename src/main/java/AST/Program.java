package AST;

import java.util.List;

public class Program {
public List<ASTNode> statements;
public Program(List<ASTNode>statements){
    this.statements = statements;
}

    public void printTree() {
        System.out.println("Program : ");
        for (ASTNode stmt : statements) {
            stmt.printTree(2);
        }
    }
}