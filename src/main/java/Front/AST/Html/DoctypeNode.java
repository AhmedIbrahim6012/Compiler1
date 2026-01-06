package Front.AST.Html;

import Front.AST.ASTNode;

public class DoctypeNode extends ASTNode {
    public final String value;

    public DoctypeNode( int line,String value) {
        super("Doctype", line);
        this.value = value;
    }

    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name + " (line " + line + ") :");
        System.out.println(super.indent(indent+2)+value);
    }
}
