package Back.AST.ExpressionStatement.Operators;

public class NotInOperatorNode extends OperatorNode{
    public NotInOperatorNode(int line) {
        super(line,"not in");
    }

    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name + " (line " + line + ")");
    }
}
