package Front.AST.CSS.Selector;

import Front.AST.ASTNode;

public class SelectorNode extends ASTNode {
   public final ASTNode selector;

    public SelectorNode(int line,ASTNode selector) {
        super("Selector",line);
        this.selector = selector;
    }


    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name + " (line " + line + ")");
        selector.printTree(indent+2);
    }
}
