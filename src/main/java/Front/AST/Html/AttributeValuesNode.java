package Front.AST.Html;
import Front.AST.ASTNode;

import java.util.ArrayList;
import java.util.List;

public class AttributeValuesNode extends ASTNode {
    public List<ASTNode>values ;
    public  AttributeValuesNode(int line,List<ASTNode> values)
    {
        super("Attribute value",line);
        this.values = values;
    }

    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name + " (line " + line + ") :");
        for (ASTNode value : values){
            value.printTree(indent+2);
        }
    }
}
