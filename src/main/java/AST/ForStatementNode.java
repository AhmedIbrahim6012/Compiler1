package AST;

import AST.ExpressionStatement.ExpressionNode;
import java.util.List;

public class ForStatementNode extends CompoundStatementNode {
    public final ExpressionNode expression;
    public final List<ExpressionNode>params;
    public final BlockNode body;
    public final Else elseBody;
	public ForStatementNode(int line, ExpressionNode expression, List<ExpressionNode> params, BlockNode body, Else elseBody) {
        super(line,"For");
        this.expression = expression;
        this.params = params;
        this.body = body;
        this.elseBody = elseBody;
    }

    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name + " (line " + line + ") :");
        System.out.println(super.indent(indent+2)+"Params :");
        for (ExpressionNode param : params) {
            param.printTree(indent+4);
        }
        expression.printTree(indent+2);
        body.printTree(indent+2);

        if (elseBody != null) {
            elseBody.printTree(indent);
        }

    }

    public static class Else extends  CompoundStatementNode{
        public  final BlockNode body;

        public Else(int line,BlockNode body) {
            super(line, "Else");
            this.body = body;
        }
        @Override
        public void printTree(int indent) {
            System.out.println(super.indent(indent) + super.name + " (line " + line + ") :");
            body.printTree(indent+2);
        }
    }
}
