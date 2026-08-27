package Front.AST.CSS.Value;

import Front.AST.ASTNode;

public class VariableNode extends ASTNode {
    public final String variable;
    public VariableNode(int line, String variable) {
        super("Variable", line);
        this.variable = variable;
    }

    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name + " (line " + line + ") :");
        System.out.println(super.indent(indent+2)+variable);
    }
}
