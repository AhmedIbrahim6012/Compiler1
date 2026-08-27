package Front.AST.CSS;

import Front.AST.ASTNode;

public class MediaValueNode extends ASTNode {
    public final ASTNode value;
    public  MediaValueNode(int line,ASTNode value) {
        super("Value",line);
        this.value = value;
    }

    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name + " (line " + line + ")");
        value.printTree(indent);
    }
}
