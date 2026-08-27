package Front.AST.JInja2;

import Front.AST.ASTNode;
import Front.AST.JInja2.ExpressionStatement.ExpressionNode;
import Front.AST.NameNode;

import java.util.List;

public class ForStatementNode extends ASTNode {
    public final NameNode itrator;
    public final ExpressionNode expression;
    public final List<ASTNode>elements;
    public ForStatementNode(int line, NameNode itrator, ExpressionNode expression, List<ASTNode> elements) {
        super("For Statement", line);
        this.itrator = itrator;
        this.expression = expression;
        this.elements = elements;
    }
    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name + " (line " + line + ") : ");
        itrator.printTree(indent+2);
        expression.printTree(indent+2);
        for (ASTNode element : elements) {
            element.printTree(indent+2);
        }
        System.out.println(super.indent(indent)+"EndFor");
    }
}
