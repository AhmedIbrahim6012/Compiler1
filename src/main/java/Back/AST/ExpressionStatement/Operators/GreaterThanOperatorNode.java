package Back.AST.ExpressionStatement.Operators;

public class GreaterThanOperatorNode extends  OperatorNode {
    public GreaterThanOperatorNode(int line) {
        super(line, "GreaterThan");
    }
    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name +" (line " + line + ")");
    }
}
