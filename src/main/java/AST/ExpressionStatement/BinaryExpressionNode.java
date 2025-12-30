package AST.ExpressionStatement;

import AST.ExpressionStatement.Operators.OperatorNode;

import java.util.List;

public class BinaryExpressionNode extends ExpressionNode {
    public ExpressionNode left;
    public List<ExpressionNode> right;
    public List<OperatorNode> operator;
    public BinaryExpressionNode(int line,ExpressionNode left, List<ExpressionNode> right, List<OperatorNode> operator) {
        super(line,"Binary");
        this.left = left;
        this.right = right;
        this.operator = operator;
    }

    @Override
    public void printTree(int indent){
        System.out.println(super.indent(indent) + super.name + " (line " + line + ")");
        left.printTree(indent + 2);
        for (int i = 0; i < operator.size(); i++) {
            System.out.print(super.indent(indent+2)+"Operator: ");
            operator.get(i).printTree(indent-4);
            right.get(i).printTree(indent + 2);
        }
    }
}
