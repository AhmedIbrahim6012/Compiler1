package AST;

import AST.ExpressionStatement.ExpressionNode;

import java.util.List;

public class IfStatementNode extends CompoundStatementNode {
    public final ExpressionNode condition;
    public final BlockNode body;
    public final List<ElseIf> elseIf;
    public final  Else elseBody;
    public IfStatementNode(int line, ExpressionNode condition, BlockNode body, List<ElseIf> ElseIf, Else elseBody) {
        super(line, "If");
        this.condition = condition;
        this.body = body;
        this.elseIf = ElseIf;
        this.elseBody = elseBody;
    }

    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name + " (line " + line + ") :");
        System.out.println(super.indent(indent+2)+"Condition : ");
        condition.printTree(indent+4);
        body.printTree(indent+2);

        for (ElseIf el : elseIf) {
            el.printTree(indent);
        }
        if (elseBody != null) {
            elseBody.printTree(indent);
        }
    }

    public static class ElseIf extends CompoundStatementNode{
        public final ExpressionNode condition;
        public  final BlockNode body;
        public ElseIf(int line,ExpressionNode condition, BlockNode body) {
            super(line, "Elif");
            this.condition = condition;
            this.body = body;
        }

        @Override
        public void printTree(int indent) {
            System.out.println(super.indent(indent) + super.name + " (line " + line + ") :");
            System.out.println(super.indent(indent+2)+"Condition : ");
            condition.printTree(indent+4);
            body.printTree(indent+2);
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
