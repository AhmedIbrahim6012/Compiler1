package Front.AST.CSS.Value;

import Front.AST.ASTNode;

public class IntValueNode extends ASTNode {
    public final int value;
    public final String unit;
    public IntValueNode(int line, int value, String unit) {
        super("Int Number", line);
        this.value = value;
        this.unit = unit;
    }

    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name + " (line " + line + ") :");
        System.out.print(super.indent(indent+2)+value);
        if (unit != null) {
            System.out.println(" "+unit);
        }else {
            System.out.println();
        }

    }
}
