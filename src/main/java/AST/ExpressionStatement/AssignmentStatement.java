package AST.ExpressionStatement;

import java.util.List;

public class AssignmentStatement extends ExpressionNode {
    public final List<ExpressionNode> right;
    public final ExpressionNode left;
    public AssignmentStatement(int line, List<ExpressionNode> right, ExpressionNode left) {
        super(line,"Assignment");
        this.right = right;
        this.left = left;
    }

    @Override
    public void printTree(int indent){
        System.out.println(super.indent(indent) + super.name + " (line " + line + ")");
        System.out.println(super.indent(indent+2)+"Left:");
        left.printTree(indent+4);
        System.out.println(super.indent(indent+2)+"Right:");
        for (ExpressionNode expr : right) {
            expr.printTree(indent + 4);
        }

    }
}
