package Front.AST.CSS.Property;

import Front.AST.ASTNode;

abstract public class PropertyNode extends ASTNode {
    public PropertyNode(String name, int line) {
        super(name, line);
    }

    @Override
    public void printTree(int indent) {
        super.printTree(indent);
    }
}
