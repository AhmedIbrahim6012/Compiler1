package Back.AST.ExpressionStatement;

import java.util.List;

public class AssignmentStatement extends ExpressionNode {
    public final List<ExpressionNode> targets;
    public final ExpressionNode value;
    public AssignmentStatement(int line, List<ExpressionNode> targets, ExpressionNode value) {
        super(line,"Assignment");
        this.targets = targets;
        this.value = value;
    }

    @Override
    public void printTree(int indent){
        System.out.println(super.indent(indent) + super.name + " (line " + line + ")");

        System.out.println(super.indent(indent+2)+"Targets:");
        for (ExpressionNode expr : targets) {
            expr.printTree(indent + 4);
        }
        System.out.println(super.indent(indent+2)+"Value:");
        value.printTree(indent+4);
    }
}
