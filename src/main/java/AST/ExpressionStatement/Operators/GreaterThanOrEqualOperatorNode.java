package AST.ExpressionStatement.Operators;

public class GreaterThanOrEqualOperatorNode extends  OperatorNode {
    public GreaterThanOrEqualOperatorNode(int line) {
        super(line,"GreaterThanOrEqual" );
    }

    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name + " (line " + line + ")");
    }
}
