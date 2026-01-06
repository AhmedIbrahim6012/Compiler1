
package Front.AST.Html;

import Front.AST.ASTNode;
import java.util.List;
import Front.AST.CSS.Value.NameNode;
public class HtmlElementNode extends ASTNode {
    public final NameNode tagName;
    public  final List<HtmlAttributeNode> attributes;
    public final List<ASTNode> children;
    public HtmlElementNode( int line,NameNode tagName, List<HtmlAttributeNode> attributes, List<ASTNode> children) {
        super("Element", line);
        this.tagName = tagName;
        this.attributes = attributes;
        this.children = children;
    }

    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name + " (line " + line + ") :");
        tagName.printTree(indent + 2);
        if (!attributes.isEmpty()){
            System.out.println(super.indent(indent+2)+"Attributes :");
            for (HtmlAttributeNode attribute : attributes) {
                attribute.printTree(indent+4);
            }
        }

        if (!children.isEmpty()){
            System.out.println(super.indent(indent+2)+"Elements :");
            for (ASTNode child:children){
                child.printTree(indent+4);
            }
        }


    }
}
