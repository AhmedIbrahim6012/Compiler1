package Front.AST.JInja2.ExpressionStatement;

import Front.AST.ASTNode;

public class UnaryExpressionNode extends ASTNode {
    public final ASTNode operator;
    public final ASTNode operand;
    public UnaryExpressionNode(int line, ASTNode operator, ASTNode operand) {
        super("Unary",line);
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
