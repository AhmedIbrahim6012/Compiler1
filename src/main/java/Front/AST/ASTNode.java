package Front.AST;


   public abstract class ASTNode {
    protected String name;
    protected int line;
    public ASTNode(String name, int line) {
        this.name = name;
        this.line = line;
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
