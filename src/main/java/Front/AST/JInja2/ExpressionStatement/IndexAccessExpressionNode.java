package Front.AST.JInja2.ExpressionStatement;

import Front.AST.ASTNode;

public class IndexAccessExpressionNode extends ASTNode {
    public final ASTNode object;
    public final ASTNode index;

    public IndexAccessExpressionNode(int line, ASTNode object, ASTNode index) {
        super("Index",line);
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
