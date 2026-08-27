package Front.AST.JInja2;
import Front.AST.ASTNode;
import java.util.List;
import Front.AST.JInja2.ExpressionStatement.ExpressionNode;
public class IfStatementNode extends ASTNode {
    public final ExpressionNode expression;
    public List<ASTNode>elements;
    public final List<ElseIf> elseIf;
    public final Else elseBody;
    public IfStatementNode(int line, ExpressionNode expression,List<ASTNode>elements, List<IfStatementNode.ElseIf> elseIf, Else elseBody) {
        super("If Statement", line);
        this.expression = expression;
        this.elseIf = elseIf;
        this.elseBody = elseBody;
        this.elements = elements;
    }

    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name + " (line " + line + ") :");
        expression.printTree(indent+2);
        System.out.println(super.indent(indent+2)+"Elements : ");
        for (ASTNode element:elements){
            element.printTree(indent+2);
        }

        for (ElseIf elseIf:elseIf){
            elseIf.printTree(indent);
        }
        if (elseBody != null) {
            if (!elseBody.elements.isEmpty()){
                elseBody.printTree(indent);
            }
        }
        System.out.println(super.indent(indent)+"EndIf");
    }

    public static class ElseIf extends ASTNode{
        public final ExpressionNode expression;
        public List<ASTNode>elements;
        public ElseIf(int line, ExpressionNode expression, List<ASTNode> elements) {
            super("Elif",line);
            this.expression = expression;
            this.elements = elements;
        }

        @Override
        public void printTree(int indent) {
            System.out.println(super.indent(indent) + super.name + " (line " + line + ") :");
            System.out.println(super.indent(indent+2)+"Condition : ");
            expression.printTree(indent+4);
            for (ASTNode element:elements){
                element.printTree(indent+2);
            }
        }
    }

    public static class Else extends ASTNode {
        public List<ASTNode>elements;
        public Else(int line, List<ASTNode> elements) {
            super("Else",line);
            this.elements = elements;
        }
        @Override
        public void printTree(int indent) {
            System.out.println(super.indent(indent) + super.name + " (line " + line + ") :");
            for (ASTNode element:elements){
                element.printTree(indent+2);
            }
        }
    }
}
