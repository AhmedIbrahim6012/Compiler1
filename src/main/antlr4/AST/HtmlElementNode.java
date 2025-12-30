
package AST;

import java.util.ArrayList;
import java.util.List;

public class HtmlElementNode extends ASTNode {

    private String tagName;
    private boolean selfClosing;
    private List<HtmlAttributeNode> attributes = new ArrayList<>();

    public HtmlElementNode(String tagName, int line) {
        super("HtmlElement", line);
        this.tagName = tagName;
    }

    public void addAttribute(HtmlAttributeNode attribute) {
        attributes.add(attribute);
    }

    public List<HtmlAttributeNode> getAttributes() {
        return attributes;
    }

    public String getTagName() {
        return tagName;
    }

    public boolean isSelfClosing() {
        return selfClosing;
    }

    public void setSelfClosing(boolean selfClosing) {
        this.selfClosing = selfClosing;
    }
    @Override
    public <R> R accept(AstVisitor<R> visitor) {
        return visitor.visitHtmlElement(this);
    }
}
