package Front.AST.CSS.Selector;

import Front.AST.ASTNode;

public class IDSelectorNode extends ASTNode {
    public final String id;
    public IDSelectorNode(int line, String id) {
        super("ID", line);
        this.id = id;
    }

    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name + " (line " + line + ") :");
        System.out.println(super.indent(indent+2)+id);
    }
}
