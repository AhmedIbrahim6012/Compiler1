package Back.AST.ExpressionStatement;
import Back.AST.SimpleStatementNode;

public class ExpressionStatementNode extends SimpleStatementNode {
    public final ExpressionNode expression;
    public ExpressionStatementNode(int line,ExpressionNode expression) {
        super(line,"Expression");
        this.expression = expression;
    }

    @Override
    public  void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name + " (line " + line + ")");
        expression.printTree(indent+2);
    }
}
