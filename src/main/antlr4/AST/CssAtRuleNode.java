package AST;

import java.util.ArrayList;
import java.util.List;

public class CssAtRuleNode extends ASTNode{
    private String name;
    private List<CssSelectorNode> selectors = new ArrayList<>();
    private CssInnerBlockNode innerBlock;

    public CssAtRuleNode(String name, int line) {
        super("CssAtRule", line);
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public void addSelector(CssSelectorNode selector) {
        selectors.add(selector);
    }

    public void setInnerBlock(CssInnerBlockNode block) {
        this.innerBlock = block;
    }

    public CssInnerBlockNode getInnerBlock() {
        return innerBlock;
    }
    @Override
    public <R> R accept(AstVisitor<R> visitor) {
        return visitor.visitCssAtRule(this);
    }

}
