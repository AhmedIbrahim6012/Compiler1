package AST;

import java.util.ArrayList;
import java.util.List;

public class CssRuleNode extends ASTNode{
    private List<CssSelectorNode> selectors = new ArrayList<>();
    private List<CssDeclarationNode> declarations = new ArrayList<>();

    public CssRuleNode(int line) {
        super("CssRule", line);
    }

    public void addSelector(CssSelectorNode selector) {
        selectors.add(selector);
    }

    public void addDeclaration(CssDeclarationNode decl) {
        declarations.add(decl);
    }

    public List<CssSelectorNode> getSelectors() {
        return selectors;
    }

    public List<CssDeclarationNode> getDeclarations() {
        return declarations;
    }

    @Override
    public <R> R accept(AstVisitor<R> visitor) {
        return visitor.visitCssRule(this);
    }
}
