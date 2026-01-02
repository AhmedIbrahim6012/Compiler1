package AST.FlowStatement;

import AST.ExpressionStatement.ExpressionNode;

public class ReturnStatementNode extends FlowStatementNode{
    public final ExpressionNode expression;
    public ReturnStatementNode(int line, ExpressionNode expression) {
        super(line, "Return");
        this.expression = expression;
    }

    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name + " (line " + line + ") :");
        if (expression != null) {
            expression.printTree(indent+2);
        }
    }
}
