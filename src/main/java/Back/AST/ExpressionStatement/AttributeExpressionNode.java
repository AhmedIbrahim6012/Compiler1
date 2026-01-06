package Back.AST.ExpressionStatement;

public class AttributeExpressionNode extends ExpressionNode {
    public final ExpressionNode value;
    public final String attribute;

    public AttributeExpressionNode(int line, ExpressionNode value, String attribute) {
        super(line,"Attribute");
        this.value = value;
        this.attribute = attribute;
    }

    @Override
    public void printTree(int indent){
        System.out.println(super.indent(indent) + super.name + " (line " + line + ") :");
        value.printTree(indent);
        System.out.println(super.indent(indent+4)+attribute);
    }
}
