package Back.AST.ExpressionStatement.Operators;

public class LessThanOrEqualOperatorNode extends  OperatorNode {
    public LessThanOrEqualOperatorNode(int line) {
        super(line,"LessThanOrEqual" );
    }

    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name + " (line " + line + ")");
    }
}
