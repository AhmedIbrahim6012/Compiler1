package Front.AST.CSS.Selector;

import Front.AST.ASTNode;

public class PseudoClassSelectorNode extends ASTNode {
    public final  String className;
    public PseudoClassSelectorNode(int line, String className) {
        super("Pseudo", line);
        this.className = className;
    }

    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name + " (line " + line + ") :");
        System.out.println(super.indent(indent+2)+className);
    }
}
