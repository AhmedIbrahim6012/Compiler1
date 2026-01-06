package Back.AST.FlowStatement;

import Back.AST.SimpleStatementNode;

public class FlowStatementNode extends SimpleStatementNode {
    public FlowStatementNode(int line, String name) {
        super(line, name);
    }

    @Override
    public void printTree(int indent) {
        super.printTree(indent);
    }
}
