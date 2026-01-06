package Back.AST.ExpressionStatement;

import java.util.List;

public class TupleExpressionNode extends ExpressionNode {
    public final List<ExpressionNode> elements;

    public TupleExpressionNode(int line,List<ExpressionNode> elements) {
        super(line,"Tuple");
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