package Front.AST.CSS.Selector;

import Front.AST.ASTNode;

public class NameSelectorNode extends ASTNode {
	public final String value;

    public NameSelectorNode(int line,String value) {
        super("value",line);
        this.value = value;
    }

    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name + " (line " + line + ") :");
        System.out.println(super.indent(indent+2)+value);
    }
}
