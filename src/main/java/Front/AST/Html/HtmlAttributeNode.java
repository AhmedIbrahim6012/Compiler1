package Front.AST.Html;

import Front.AST.ASTNode;
import Front.AST.CSS.Value.NameNode;
public class HtmlAttributeNode extends ASTNode {
    public final NameNode key;
    public final ASTNode value;
    public HtmlAttributeNode( int line,NameNode key,ASTNode value) {
        super("Attribute", line);
        this.key = key;
        this.value = value;
    }

    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name + " (line " + line + ") :");
        if (key != null){
            System.out.println(super.indent(indent+2)+"Assign :");
            System.out.println(super.indent(indent+4)+"Key : ");
            this.key.printTree(indent+6);
            if (value != null){
                System.out.println(super.indent(indent+4)+"Value : ");
                this.value.printTree(indent+6);
            }

        }else  {
            value.printTree(indent+2);
        }
    }
}
