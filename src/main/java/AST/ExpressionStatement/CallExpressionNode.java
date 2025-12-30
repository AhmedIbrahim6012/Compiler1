package AST.ExpressionStatement;

import java.util.List;

public class CallExpressionNode extends ExpressionNode {
    public final ExpressionNode function;
    public final ExpressionNode arguments;

    public CallExpressionNode(int line,ExpressionNode function, ExpressionNode arguments) {
        super(line,"Call");
        this.function = function;
        this.arguments = arguments;
    }

    @Override
    public void printTree(int indent){
        System.out.println(super.indent(indent) + super.name + " (line " + line + ") :");
        function.printTree(indent + 2);
        if (arguments != null)
            arguments.printTree(indent + 2);
    }
}
