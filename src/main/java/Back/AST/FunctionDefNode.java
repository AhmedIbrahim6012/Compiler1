package Back.AST;

import Back.AST.ExpressionStatement.ArgumentsExpressionNode;
import Back.AST.ExpressionStatement.Atoms.AtomNode;
import Back.AST.ExpressionStatement.Atoms.NameAtomNode;

import java.util.List;

public class FunctionDefNode extends CompoundStatementNode {
    public NameAtomNode name;
    public ArgumentsExpressionNode parameters;
    public BlockNode body;
    public FunctionDefNode(int line,NameAtomNode name, ArgumentsExpressionNode parameters, BlockNode body) {
        super(line,"Function");
        this.name=name;
        this.parameters=parameters;
        this.body=body;
    }

    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name + " (line " + line + ") :");
        name.printTree(indent+2);
        if (parameters!=null){
            System.out.println(super.indent(indent+2) + "Parameters" + " (line " + line + ") :");
            parameters.printTree(indent+2);
        }
        body.printTree(indent+2);
    }
}
