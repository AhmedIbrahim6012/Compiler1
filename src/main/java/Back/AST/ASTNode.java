package Back.AST;
public abstract class ASTNode{
    public int line;
    public String name;
    public ASTNode(int line, String name) {
        this.line = line;
        this.name = name;
    }

    public void printTree(int indent) {
        System.out.println(indent(indent) + name + " (line " + line + ")");
    }

   public String indent(int indent){
        StringBuilder result= new StringBuilder();
        for (int i = 0; i < indent; i++) {
            result.append(" ");
        }
        return result.toString();
    }
}