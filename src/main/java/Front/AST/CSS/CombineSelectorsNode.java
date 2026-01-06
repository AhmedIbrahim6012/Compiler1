package Front.AST.CSS;

import Front.AST.ASTNode;
import Front.AST.CSS.Selector.SelectorNode;

import java.util.List;

public class CombineSelectorsNode extends ASTNode {
    public final List<SelectorNode> selectors;
    public CombineSelectorsNode( int line, List<SelectorNode> selectors) {
        super("Combine", line);
        this.selectors = selectors;
    }

    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name + " (line " + line + ") :");
        for (SelectorNode selector : selectors) {
            selector.printTree(indent+2);
        }
    }
}
