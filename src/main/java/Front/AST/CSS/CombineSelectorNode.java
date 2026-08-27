package Front.AST.CSS;

import Front.AST.ASTNode;
import Front.AST.CSS.Selector.SelectorNode;
import Front.AST.CSS.combinators.Combinator;

public class CombineSelectorNode extends ASTNode {
    public final SelectorNode selector;
    public final Combinator combinator;
    public  CombineSelectorNode(int line,SelectorNode selector,Combinator combinator) {
        super("Combine Selector",line);
        this.selector = selector;
        this.combinator = combinator;
    }

    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name + " (line " + line + ")");
        selector.printTree(indent+2);
        if (combinator != null) {
            combinator.printTree(indent+2);

        }
    }
}
