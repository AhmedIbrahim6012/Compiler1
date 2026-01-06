package Back.AST;

public abstract class SimpleStatementNode extends  ASTNode{
    public SimpleStatementNode(int line, String name){
        super(line,name);
    }
    @Override
    public void printTree(int indent)
    {
        super.printTree(indent);
    }
}
