package Back.AST;

import Back.AST.ExpressionStatement.ArgumentsExpressionNode;
import Back.AST.ImporStatement.DottedNameNode;
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

   public static class Decorate extends ASTNode{
    public final DottedNameNode dottedName;
    public final ArgumentsExpressionNode argumentsExpression;
    public final List<String>pathParameters;
        public Decorate(int line, DottedNameNode dottedName,List<String>pathParameters, ArgumentsExpressionNode argumentsExpression) {
            super(line,"Decorate");
            this.dottedName = dottedName;
            this.argumentsExpression = argumentsExpression;
            this.pathParameters = pathParameters;
        }

        @Override
        public void printTree(int indent) {
            System.out.println(super.indent(indent) + super.name + " (line " + line + ") :");
            dottedName.printTree(indent+2);
            System.out.println(super.indent(indent+2) + "Arguments" + " (line " + line + ") :");
            argumentsExpression.printTree(indent+2);
        }
    }
}
