package Front.AST.JInja2.ExpressionStatement;


import Front.AST.ASTNode;

import java.util.List;

public class BinaryExpressionNode extends ASTNode {
    public ASTNode left;
    public List<ASTNode> right;
    public List<ASTNode> operator;
    public BinaryExpressionNode(int line, ASTNode left, List<ASTNode> right, List<ASTNode> operator) {
        super("Binary",line);
        this.left = left;
        this.right = right;
        this.operator = operator;
    }

    @Override
    public void printTree(int indent){
        System.out.println(super.indent(indent) + super.name + " (line " + line + ")");
        left.printTree(indent + 2);
        for (int i = 0; i < operator.size(); i++) {
            System.out.print(super.indent(indent+2)+"Operator: ");
            operator.get(i).printTree(indent-10);
            right.get(i).printTree(indent + 2);
        }
    }
}
