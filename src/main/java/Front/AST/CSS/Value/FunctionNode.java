package Front.AST.CSS.Value;

import Front.AST.ASTNode;
import Front.AST.NameNode;

import java.util.List;

public class FunctionNode extends ASTNode {
    public final NameNode name;
    public final List<ASTNode> arguments;
    public FunctionNode(int line, NameNode name, List<ASTNode> arguments) {
        super("Function", line);
        this.name = name;
        this.arguments = arguments;
    }

    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name + " (line " + line + ") :");
        name.printTree(indent+2);
        if (!arguments.isEmpty()){
            System.out.println(super.indent(indent+2)+"Params :");
        }
        for (ASTNode argument : arguments) {
            argument.printTree(indent+4);
        }
    }
}
