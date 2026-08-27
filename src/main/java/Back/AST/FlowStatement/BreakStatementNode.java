package Back.AST.FlowStatement;

public class BreakStatementNode extends FlowStatementNode{
    public BreakStatementNode(int line){
        super(line,"Break");
    }

    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name + " (line " + line + ")");
    }
}
