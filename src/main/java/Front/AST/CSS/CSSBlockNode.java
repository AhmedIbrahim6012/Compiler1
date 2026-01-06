package Front.AST.CSS;

import Front.AST.ASTNode;

import java.util.List;

public class CSSBlockNode extends ASTNode {
   public final List<DeclarationNode>declarations;

    public CSSBlockNode(int line,List<DeclarationNode> declarations) {
        super("Block",line);
        this.declarations = declarations;
    }

    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name + " (line " + line + ") :");
        for (DeclarationNode declaration : declarations) {
            declaration.printTree(indent+2);
        }
    }
}
