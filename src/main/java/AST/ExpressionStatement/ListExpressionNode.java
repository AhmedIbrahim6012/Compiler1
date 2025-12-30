package AST.ExpressionStatement;

import java.util.List;

public class ListExpressionNode extends ExpressionNode {
    public final List<ExpressionNode> elements;

    public ListExpressionNode(int line,List<ExpressionNode> elements) {
        super(line,"List");
        this.elements = elements;
    }
    @Override
    public  void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name + " (line " + line + ")");
        if (elements.isEmpty()){
            System.out.println(super.indent(indent+2)+"Empty");
        }
        for (ExpressionNode element : elements) {
            element.printTree(indent + 2);
        }
    }
}
