package AST.ImporStatement;
import AST.SimpleStatementNode;

public abstract class ImportStatementNode extends SimpleStatementNode {
    public ImportStatementNode(int line, String name) {
        super(line, name);
    }
    @Override
    public void printTree(int indent){
        super.printTree(indent);
    }
}
