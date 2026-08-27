package Front.AST.JInja2.ExpressionStatement;

import Front.AST.ASTNode;
import Front.AST.NameNode;

public class PropertyAccessExpressionNode extends ASTNode {
    public final ASTNode value;
    public final NameNode property;

    public PropertyAccessExpressionNode(int line, ASTNode value, NameNode property) {
        super("Property Access",line);
        this.value = value;
        this.property = property;
    }

    @Override
    public void printTree(int indent){
        System.out.println(super.indent(indent) + super.name + " (line " + line + ") :");
        value.printTree(indent+2);
        System.out.println(super.indent(indent+2) + "Property" + " (line " + line + ") :");
        property.printTree(indent+4);
    }
}
