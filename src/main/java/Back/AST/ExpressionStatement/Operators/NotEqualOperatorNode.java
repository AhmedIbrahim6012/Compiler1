package Back.AST.ExpressionStatement.Operators;

public class NotEqualOperatorNode extends OperatorNode {
    public NotEqualOperatorNode(int line) {
        super(line,"NotEqual");
    }

    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name + " (line " + line + ")");
    }
}
