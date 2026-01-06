package Front.AST.CSS.Value;

import java.util.List;

public class FunctionNode extends ValueNode {
    public final NameNode value;
    public final List<ValueNode> arguments;
    public FunctionNode(int line, NameNode value, List<ValueNode> arguments) {
        super("Function", line);
        this.value = value;
        this.arguments = arguments;
    }

    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name + " (line " + line + ") :");
        value.printTree(indent+2);
        if (!arguments.isEmpty()){
            System.out.println(super.indent(indent+2)+"Params :");
        }
        for (ValueNode argument : arguments) {
            argument.printTree(indent+4);
        }
    }
}
