package Back.AST;

import java.util.List;

public class Program extends ASTNode{
public List<ASTNode> statements;
public Program(List<ASTNode>statements){
    super(0,"Program");
    this.statements = statements;
}

    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name + " (line " + line + ") :");
        for(ASTNode statement:statements){
            statement.printTree(indent + 2);
        }
    }
}