package AST.ExpressionStatement.Operators;

public class LessThanOperatorNode extends  OperatorNode {
    public LessThanOperatorNode(int line) {
        super(line, "LessThan");
    }

    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name +" (line " + line + ")");
    }
}
