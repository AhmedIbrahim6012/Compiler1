package Back.AST.ExpressionStatement;

public class IndexExpressionNode extends ExpressionNode {
    public final ExpressionNode object;
    public final ExpressionNode index;

    public IndexExpressionNode(int line,ExpressionNode object, ExpressionNode index) {
        super(line,"Index Access");
        this.object = object;
        this.index = index;
    }
    @Override
    public  void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name + " (line " + line + ") :");
        System.out.println(super.indent(indent+2)+"Object :");
        object.printTree(indent+4);
        System.out.println(super.indent(indent+2)+"Index :");
        index.printTree(indent + 4);
    }
}
