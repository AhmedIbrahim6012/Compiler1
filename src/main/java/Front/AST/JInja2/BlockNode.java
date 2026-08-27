package Front.AST.JInja2;

import Front.AST.ASTNode;

import java.util.List;

public class BlockNode extends ASTNode {
    public final String value;
    public final List<ASTNode> elements;
    public BlockNode(int line, String value, List<ASTNode> elements) {
        super("Block", line);
        this.value = value;
        this.elements = elements;
    }
    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name + " (line " + line + ") : " + value);
        System.out.println(super.indent(indent+2)+"Name : "+value);
        for (ASTNode element : elements) {
            element.printTree(indent+2);
        }
        System.out.println(super.indent(indent)+"EndBlock");
    }
}
