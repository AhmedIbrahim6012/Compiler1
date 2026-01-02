package AST;

abstract public class CompoundStatementNode extends  ASTNode {
    public CompoundStatementNode(int line, String name) {

        super(line, name);
    }
    public void printTree(int indent){
        super.printTree(indent);
    }


}
