package AST.ExpressionStatement.Operators;

public class IsOperatorNode extends OperatorNode {
	public IsOperatorNode(int line) {
        super(line,"is");
    }

    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name + " (line " + line + ")");
    }
}
