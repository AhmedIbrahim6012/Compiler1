package AST;
import java.util.ArrayList;
import java.util.List;

   public abstract class ASTNode {
    protected String name;
    protected int line;
    protected List<ASTNode> children = new ArrayList<>();

    public ASTNode(String name, int line) {
        this.name = name;
        this.line = line;
    }

    public void addChild(ASTNode child) {
        children.add(child);
    }

    public List<ASTNode> getChildren() {
        return children;
    }

    public String getName() {
        return name;
    }

    public int getLine() {
        return line;
    }
       public abstract <R> R accept(AstVisitor<R> visitor);

   }
