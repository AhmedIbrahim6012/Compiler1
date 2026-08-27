package Front.AST.JInja2.ExpressionStatement;

import Front.AST.ASTNode;

import java.util.ArrayList;
import java.util.List;

public class ArgumentListNode extends ASTNode
{
    public  List<ASTNode> arguments =new ArrayList<>();
    public ArgumentListNode(int line,List<ASTNode> arguments){
        super("Arguments",line);
        this.arguments = arguments;
    }

    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name + " (line " + line + ") :");
        for (ASTNode argument : arguments){
            argument.printTree(indent + 2);
        }
    }
}
