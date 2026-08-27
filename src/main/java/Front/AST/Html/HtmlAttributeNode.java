package Front.AST.Html;

import Front.AST.ASTNode;
import Front.AST.NameNode;

public class HtmlAttributeNode extends ASTNode {
    public final NameNode key;
    public final AttributeValuesNode value;
    public HtmlAttributeNode( int line,NameNode key,AttributeValuesNode value) {
        super("Attribute", line);
        this.key = key;
        this.value = value;
    }

    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name + " (line " + line + ") :");
        if (value != null){
            System.out.println(super.indent(indent+2)+"Key : ");
            this.key.printTree(indent+4);
            value.printTree(indent+2);
        }else  {
            this.key.printTree(indent+2);
        }
    }
}
