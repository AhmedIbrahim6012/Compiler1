package AST.ExpressionStatement;

import AST.ExpressionStatement.Operators.OperatorNode;

public class UnaryExpressionNode extends ExpressionNode {
    public final OperatorNode operator;
    public final ExpressionNode operand;
    public UnaryExpressionNode(int line,OperatorNode operator, ExpressionNode operand) {
        super(line,"Unary");
        this.operator = operator;
        this.operand = operand;
    }

    @Override
    public void printTree(int indent){
        System.out.println(super.indent(indent) + super.name + " (line " + line + ")");
        operator.printTree(indent+2);
        operand.printTree(indent+2);
    }
}
