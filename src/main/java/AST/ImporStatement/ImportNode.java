package AST.ImporStatement;
import AST.ASTNode;

public abstract class ImportNode extends ASTNode {
    public ImportNode(int line, String name) {
        super(line, name);
    }
    @Override
    public void printTree(int indent){
        super.printTree(indent);
    }
}
