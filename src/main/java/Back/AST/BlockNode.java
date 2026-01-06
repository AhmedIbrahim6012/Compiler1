package Back.AST;

import java.util.List;

public class BlockNode extends  ASTNode {
    public List<ASTNode> statements;
    public  BlockNode(int line,List<ASTNode> statements)
    {
        super(line,"Block");
        this.statements = statements;
    }

    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name + " (line " + line + ") :");
        for (ASTNode statement:statements) {
            statement.printTree(indent+2);
        }
    }
}
