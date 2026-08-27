package Front.AST.CSS;

import Front.AST.ASTNode;

public class CSSRuleNode extends ASTNode {
    public final SelectorGroupNode selectorGroup;
    public final CSSBlockNode block;
    public CSSRuleNode(int line, SelectorGroupNode selectorGroup, CSSBlockNode block) {
        super("Rule",line);
        this.selectorGroup = selectorGroup;
        this.block = block;
    }

    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name + " (line " + line + ") :");
        selectorGroup.printTree(indent+2);
        block.printTree(indent+2);
    }
}
