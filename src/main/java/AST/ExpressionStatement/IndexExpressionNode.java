package AST.ExpressionStatement;

public class IndexExpressionNode extends ExpressionNode {
    public final ExpressionNode object;
    public final ExpressionNode index;

    public IndexExpressionNode(int line,ExpressionNode object, ExpressionNode index) {
        super(line,"Index");
        this.object = object;
        this.index = index;
    }
    @Override
    public  void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name + " (line " + line + ") :");
        object.printTree(indent+2);
        index.printTree(indent + 2);
    }
}
