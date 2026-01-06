package Back.AST.ExpressionStatement.Operators;

public class IsNotOperatorNode extends OperatorNode {
	public IsNotOperatorNode(int line) {
        super(line, "is not");
    }

    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name + " (line " + line + ")");
    }
}
