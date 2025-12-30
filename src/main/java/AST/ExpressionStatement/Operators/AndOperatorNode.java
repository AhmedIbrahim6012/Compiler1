package AST.ExpressionStatement.Operators;

public class AndOperatorNode extends  OperatorNode {

    public AndOperatorNode(int line) {
        super(line, "and");
    }

    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name + " (line " + line + ")");
    }
}
