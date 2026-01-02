package AST.ImporStatement;
import java.util.ArrayList;
import java.util.List;

public class DottedNameNode extends ImportNode {
    public final List<String> parts;

    public DottedNameNode(int line, List<String> parts) {
        super(line, "DottedName");
        this.parts = new ArrayList<>(parts);
    }
    @Override
    public String toString() {
        return String.join(".", parts);
    }

    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name + " " +
                String.join(".", parts) +
                " (line " + line + ")");
    }
}
