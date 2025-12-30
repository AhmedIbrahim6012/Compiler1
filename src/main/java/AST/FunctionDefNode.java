package AST;

import AST.ExpressionStatement.Atoms.AtomNode;
import AST.ExpressionStatement.Atoms.NameAtomNode;

import java.util.List;

public class FunctionDefNode extends CompoundStatementNode {
    public NameAtomNode name;
    public List<NameAtomNode> parameters;
    public BlockNode body;
    public FunctionDefNode(int line,NameAtomNode name, List<NameAtomNode> parameters, BlockNode body) {
        super(line,"Function");
        this.name=name;
        this.parameters=parameters;
        this.body=body;
    }

    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name + " (line " + line + ") :");
        name.printTree(indent+2);
        if (!parameters.isEmpty()){
            System.out.println(super.indent(indent+2)+"Params :");
            for (AtomNode param : parameters) {
                param.printTree(indent+4);
            }
        }

        body.printTree(indent+2);
    }
}
