package Front.AST.CSS.Selector;

public class StarSelectorNode extends SelectorNode{
    public StarSelectorNode( int line) {
        super("Star", line);
    }

    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name + " (line " + line + ")");
    }
}
