package AST;

import AST.ExpressionStatement.ExpressionNode;

import java.util.List;

public class TryStatementNode extends CompoundStatementNode {
    public final BlockNode body;
    public final List<Except>excepts;
    public TryStatementNode(int line, BlockNode body, List<Except> excepts)
    {
        super(line,"Try");
        this.body = body;
        this.excepts = excepts;
    }

    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name + " (line " + line + ") :");
        body.printTree(indent+2);
        for (Except except : excepts) {
            except.printTree(indent);
        }
    }

    public static class Except extends  CompoundStatementNode{
        public  final ExpressionNode expression;
        public  final BlockNode body;

        public Except(int line, ExpressionNode expression, BlockNode body) {
            super(line, "Else");
            this.expression = expression;
            this.body = body;
        }
        @Override
        public void printTree(int indent) {
            System.out.println(super.indent(indent) + super.name + " (line " + line + ") :");
            if (expression != null) {
                System.out.println(super.indent(indent+2)+"Expression :");
                expression.printTree(indent+4);
            }
            body.printTree(indent+2);
        }
    }
}
