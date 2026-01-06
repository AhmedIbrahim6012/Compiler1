package Back.AST.ExpressionStatement.Operators;

public class InOperatorNode extends  OperatorNode {
    public InOperatorNode(int line) {
        super(line,"in");
    }

    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name + " (line " + line + ")");
    }
}
