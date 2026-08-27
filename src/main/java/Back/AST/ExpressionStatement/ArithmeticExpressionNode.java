package Back.AST.ExpressionStatement;

import Back.AST.ExpressionStatement.Operators.OperatorNode;

public class ArithmeticExpressionNode extends ExpressionNode {
    public ExpressionNode  left;
    public ExpressionNode  right;
    public OperatorNode operator;
    public ArithmeticExpressionNode(int line,ExpressionNode left,OperatorNode operator,ExpressionNode right){
        super(line,"Arithmetic");
        this.left = left;
        this.right = right;
        this.operator = operator;
    }

    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name + " (line " + line + ")");
        System.out.println(indent(indent + 2) + "Left:");
        left.printTree(indent + 4);
        System.out.println(indent(indent + 2) + "Operator:");
        operator.printTree(indent + 4);
        System.out.println(indent(indent + 2) + "Right:");
        right.printTree(indent + 4);
    }
}
