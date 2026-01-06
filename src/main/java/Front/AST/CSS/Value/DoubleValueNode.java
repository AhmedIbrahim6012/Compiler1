package Front.AST.CSS.Value;

public class DoubleValueNode extends ValueNode{
    public final double value;
    public final String unit;
    public DoubleValueNode(int line, double value, String unit) {
        super("Double", line);
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
