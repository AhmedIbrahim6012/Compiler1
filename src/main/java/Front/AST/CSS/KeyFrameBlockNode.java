package Front.AST.CSS;

import Front.AST.ASTNode;

import java.util.List;

public class KeyFrameBlockNode extends ASTNode {
    public final KeyFrameSelector selector;
    public final List<DeclarationNode> declarations;
    public KeyFrameBlockNode(int line, KeyFrameSelector selector, List<DeclarationNode> declarations) {
        super("Block", line);
        this.selector = selector;
        this.declarations = declarations;
    }

    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name + " (line " + line + ") :");
        System.out.println(super.indent(indent+2)+selector.name());
        for (DeclarationNode declaration : declarations) {
            declaration.printTree(indent+2);
        }

    }
}

