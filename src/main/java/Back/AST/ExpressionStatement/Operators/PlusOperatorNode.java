package Back.AST.ExpressionStatement.Operators;

public class PlusOperatorNode extends OperatorNode{
    public PlusOperatorNode(int line) {
        super(line, "Plus");
    }

    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name + " (line " + line + ")");
    }
}
