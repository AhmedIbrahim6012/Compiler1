package Front.AST.Html;

import Front.AST.ASTNode;

public class EntityNode extends ASTNode {
   public final String value;

    public EntityNode(String value, int line) {
        super("Entity", line);
        this.value = value;
    }

    @Override
    public void printTree(int indent) {
        System.out.println(indent(indent) + name + " (line " + line + ") : ");
        System.out.println(indent(indent+2)+value);
    }
}
