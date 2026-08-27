package Front.AST.JInja2.ExpressionStatement;

import Front.AST.ASTNode;

import java.util.List;

public class CallExpressionNode extends ASTNode {
    public final ASTNode function;
    public final ArgumentListNode arguments;

    public CallExpressionNode(int line, ASTNode function,ArgumentListNode arguments) {
        super("Call",line);
        this.function = function;
        this.arguments = arguments;
    }

    @Override
    public void printTree(int indent){
        System.out.println(super.indent(indent) + super.name + " (line " + line + ") :");
        function.printTree(indent + 2);
        arguments.printTree(indent + 2);
    }
}
