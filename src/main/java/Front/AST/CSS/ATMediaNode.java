package Front.AST.CSS;

import Front.AST.ASTNode;
import Front.AST.NameNode;

import java.util.List;

public class ATMediaNode extends ASTNode {
    public final MediaQueryNode mediaQuery;
    public final List<CSSRuleNode> cssRules;
    public ATMediaNode(int line, MediaQueryNode mediaQuery, List<CSSRuleNode> cssRules) {
        super("At Media", line);
        this.mediaQuery = mediaQuery;
        this.cssRules = cssRules;
    }

    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name + " (line " + line + ") :");
        mediaQuery.printTree(indent+2);
        for (CSSRuleNode cssRule : cssRules) {
            cssRule.printTree(indent+2);
        }
    }
}
