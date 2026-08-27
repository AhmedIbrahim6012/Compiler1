package Back.AST.ExpressionStatement.Operators;

public class MinusOperatorNode extends  OperatorNode {
    public  MinusOperatorNode(int line) {
        super(line, "Minus");
    }
    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name + " (line " + line + ")");
    }
}
