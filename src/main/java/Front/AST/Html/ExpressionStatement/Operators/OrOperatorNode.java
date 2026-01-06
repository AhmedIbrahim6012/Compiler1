package Front.AST.Html.ExpressionStatement.Operators;

public class OrOperatorNode extends OperatorNode {

    public OrOperatorNode(int line) {
        super(line, "or");
    }

    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name + " (line " + line + ")");
    }
}
