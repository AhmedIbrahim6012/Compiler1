package Back.AST.ExpressionStatement;

public class CallExpressionNode extends ExpressionNode {
    public final ExpressionNode function;
    public final ArgumentsExpressionNode arguments;

    public CallExpressionNode(int line,ExpressionNode function, ArgumentsExpressionNode arguments) {
        super(line,"Call");
        this.function = function;
        this.arguments = arguments;
    }
    @Override
    public void printTree(int indent){
        System.out.println(super.indent(indent) + super.name + " (line " + line + ") :");
        function.printTree(indent + 2);
        if (arguments != null){
            System.out.println(super.indent(indent+2) + "Arguments" + " (line " + line + ") :");
            arguments.printTree(indent + 2);
        }

    }
}
