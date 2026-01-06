package Front.AST.Html.ExpressionStatement.Operators;

public class NotOperatorNode extends OperatorNode {
	public NotOperatorNode(int line) {
        super(line, "not");
    }

    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name + " (line " + line + ")");
    }
}
