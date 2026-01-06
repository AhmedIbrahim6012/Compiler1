package Front.AST.Html.ExpressionStatement;

import java.util.List;

public class CallExpressionNode extends ExpressionNode {
    public final ExpressionNode function;
    public final List<ExpressionNode> arguments;

    public CallExpressionNode(int line, ExpressionNode function, List<ExpressionNode> arguments) {
        super(line,"Call");
        this.function = function;
        this.arguments = arguments;
    }

    @Override
    public void printTree(int indent){
        System.out.println(super.indent(indent) + super.name + " (line " + line + ") :");
        function.printTree(indent + 2);
        System.out.println(super.indent(indent+2)+"Arguments : ");
        for (ExpressionNode argument : arguments){
            argument.printTree(indent + 4);
        }

    }
}
