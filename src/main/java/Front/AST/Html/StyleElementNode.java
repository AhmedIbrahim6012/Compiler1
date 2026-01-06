package Front.AST.Html;

import Front.AST.ASTNode;
import Front.AST.CSS.CSSDocument;


public class StyleElementNode extends ASTNode {
    public final CSSDocument css;
    public StyleElementNode( int line, CSSDocument css) {
        super("CSS", line);
        this.css = css;
    }

    @Override
    public void printTree(int indent) {
        System.out.println(indent(indent) + name + " (line " + line + ") : ");
        css.printTree(indent+2);
    }
}
