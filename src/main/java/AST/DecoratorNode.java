package AST;

import AST.ExpressionStatement.ArgumentsExpressionNode;
import AST.ImporStatement.DottedNameNode;

import java.util.List;

public class DecoratorNode extends  ASTNode {
    public final List<Decorate>decorates;
    public final FunctionDefNode function;
    public DecoratorNode(int line, List<Decorate> decorates, FunctionDefNode function)
    {
        super(line,"Decorator");
        this.decorates = decorates;
        this.function = function;
    }

    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name + " (line " + line + ") :");
        for (Decorate decorate : decorates){
            decorate.printTree(indent+2);
        }
        function.printTree(indent+2);
    }

   public static class Decorate extends  ASTNode{
    public final DottedNameNode dottedName;
    public final ArgumentsExpressionNode argumentsExpression;
        public Decorate(int line, DottedNameNode dottedName, ArgumentsExpressionNode argumentsExpression) {
            super(line,"Decorate");
            this.dottedName = dottedName;
            this.argumentsExpression = argumentsExpression;
        }

        @Override
        public void printTree(int indent) {
            System.out.println(super.indent(indent) + super.name + " (line " + line + ") :");
            dottedName.printTree(indent+2);
            argumentsExpression.printTree(indent+2);
        }
    }
}
