package Front.AST.CSS;

import Front.AST.ASTNode;
import Front.AST.CSS.Selector.SelectorNode;

import java.util.List;

public class CombineSelectorsNode extends ASTNode {
    public final List<CombineSelectorNode> Combineselectors;
    public CombineSelectorsNode( int line, List<CombineSelectorNode> Combineselectors) {
        super("Combine Selectors", line);
        this.Combineselectors = Combineselectors;
    }

    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name + " (line " + line + ") :");
        for (CombineSelectorNode selector : Combineselectors) {
            selector.printTree(indent+2);
        }
    }
}
