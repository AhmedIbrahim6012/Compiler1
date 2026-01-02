package AST.ExpressionStatement;

import java.util.List;

public class ArgumentsExpressionNode extends  ExpressionNode{
    public final List<ExpressionNode>arguments;
    public ArgumentsExpressionNode(int line, List<ExpressionNode> arguments) {
        super(line, "Arguments");
        this.arguments = arguments;
    }

    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name + " (line " + line + ") :");
        for (ExpressionNode argument:arguments){
            argument.printTree(indent+2);
        }
    }
}
