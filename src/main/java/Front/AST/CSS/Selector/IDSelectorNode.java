package Front.AST.CSS.Selector;

public class IDSelectorNode extends SelectorNode{
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
