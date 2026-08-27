package Back.AST.FlowStatement;

public class ContinueStatementNode extends FlowStatementNode{
    public  ContinueStatementNode(int line) {
        super(line,"Continue");
    }

    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name + " (line " + line + ")");
    }
}
