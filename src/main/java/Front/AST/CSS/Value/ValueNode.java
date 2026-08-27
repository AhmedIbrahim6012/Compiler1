package Front.AST.CSS.Value;

import Front.AST.ASTNode;

public class ValueNode extends ASTNode {
    public final ASTNode value ;
    public ValueNode(int line,ASTNode value) {
        super("Value", line);
        this.value = value;
    }

    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name + " (line " + line + ") :");
        value.printTree(indent+2);
    }
}
