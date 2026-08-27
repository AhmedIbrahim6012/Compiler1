package Front.AST.JInja2.ExpressionStatement;
import Front.AST.ASTNode;

import java.util.List;

public class CompareExpressionNode extends ASTNode {
    public final ASTNode left;
    public final List<ASTNode> ops;
    public final List<ASTNode> comparators;
    public CompareExpressionNode(int line, ASTNode left, List<ASTNode> ops, List<ASTNode> comparators) {
        super( "Comparesion",line);
        this.left = left;
        this.ops = ops;
        this.comparators = comparators;
    }
    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name + " (line " + line + ")");
        left.printTree(indent + 2);
        for (int i = 0; i < ops.size(); i++) {
            System.out.print(super.indent(indent+2)+"Operator: ");
            ops.get(i).printTree(indent-4);
            comparators.get(i).printTree(indent + 2);
        }
    }
}
