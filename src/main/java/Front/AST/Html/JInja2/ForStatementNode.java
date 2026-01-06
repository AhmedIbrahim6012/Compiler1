package Front.AST.Html.JInja2;

import Front.AST.ASTNode;
import Front.AST.Html.ExpressionStatement.ExpressionNode;

import java.util.List;

public class ForStatementNode extends ASTNode {
    public final String itrator;
    public final ExpressionNode expression;
    public final List<ASTNode>elements;
    public ForStatementNode(int line, String itrator, ExpressionNode expression, List<ASTNode> elements) {
        super("For Statement", line);
        this.itrator = itrator;
        this.expression = expression;
        this.elements = elements;
    }
    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name + " (line " + line + ") : ");
        System.out.println(super.indent(indent+2) + "Iterator: " + itrator);
        expression.printTree(indent+2);
        for (ASTNode element : elements) {
            element.printTree(indent+2);
        }
        System.out.println(super.indent(indent)+"EndFor");
    }
}
