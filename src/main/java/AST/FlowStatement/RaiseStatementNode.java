package AST.FlowStatement;

import AST.ExpressionStatement.ExpressionNode;

public class RaiseStatementNode extends FlowStatementNode{
    public final ExpressionNode expressionBeforeFrom;
    public  final ExpressionNode expressionAfterFrom;
    public RaiseStatementNode(int line, ExpressionNode expressionBeforeFrom, ExpressionNode expressionAfterFrom) {
        super(line, "Raise");
        this.expressionBeforeFrom = expressionBeforeFrom;
        this.expressionAfterFrom = expressionAfterFrom;
    }

    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name + " (line " + line + ") : ");
        if (expressionBeforeFrom != null) {
            expressionBeforeFrom.printTree(indent+2);
        }
        if (expressionAfterFrom != null) {
            expressionAfterFrom.printTree(indent+2);
        }

    }
}
