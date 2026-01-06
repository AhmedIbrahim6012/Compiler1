package Front.AST.CSS.Selector;

public class ClassSelectorNode extends SelectorNode{
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
