package AST.ExpressionStatement;
import AST.ExpressionStatement.Operators.OperatorNode;
import java.util.List;

public class CompareExpressionNode extends ExpressionNode{
    public final ExpressionNode left;
    public final List<OperatorNode> ops;
    public final List<ExpressionNode> comparators;
    public CompareExpressionNode(int line, ExpressionNode left, List<OperatorNode> ops, List<ExpressionNode> comparators) {
        super(line, "Comparesion");
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
