package Front.AST.CSS.Selector;

import Front.AST.ASTNode;

public class ClassSelectorNode extends ASTNode {
    public final String className;
    public ClassSelectorNode(int line, String className) {
        super("Class", line);
        this.className = className;
    }

    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name + " (line " + line + ") :");
        System.out.println(super.indent(indent+2)+className);
    }
}
