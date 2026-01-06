package Front.AST.CSS;

import Front.AST.ASTNode;
import Front.AST.CSS.Property.PropertyNode;
import Front.AST.CSS.Value.ValueNode;

import java.util.List;

public class DeclarationNode extends ASTNode {
    public final PropertyNode key;
    public final List<ValueNode>values;
    public DeclarationNode(int line, PropertyNode key, List<ValueNode> values) {
        super("Declaration", line);
        this.key = key;
        this.values = values;
    }

    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name + " (line " + line + ") :");
        key.printTree(indent+2);
        System.out.println(super.indent(indent+2)+"Values");
        for (ValueNode value : values) {
            value.printTree(indent+4);
        }
    }
}
