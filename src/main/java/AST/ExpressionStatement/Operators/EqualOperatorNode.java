package AST.ExpressionStatement.Operators;

public class EqualOperatorNode extends  OperatorNode {
    public EqualOperatorNode(int line) {
        super(line, "Equal");
    }
    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name + " (line " + line + ")");
    }
}
