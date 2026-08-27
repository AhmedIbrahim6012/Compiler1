package Front.AST.JInja2.ExpressionStatement;

import Front.AST.ASTNode;

public class ExpressionNode extends ASTNode {
    public final ASTNode expression;
    public ExpressionNode(int line, ASTNode expression) {
        super("Expression",line);
        this.expression = expression;
    }

    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name + " (line " + line + ")");
        expression.printTree(indent+2);
    }
}
