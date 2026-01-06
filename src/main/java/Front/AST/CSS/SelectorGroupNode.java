package Front.AST.CSS;

import Front.AST.ASTNode;

import java.util.List;

public class SelectorGroupNode extends ASTNode {
    public final List<CombineSelectorsNode> selectors;
    public SelectorGroupNode(int line, List<CombineSelectorsNode> selectors) {
        super("Selector group", line);
        this.selectors = selectors;
    }

    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name + " (line " + line + ") :");
        for (CombineSelectorsNode selector : selectors) {
            selector.printTree(indent+2);
        }
    }
}
