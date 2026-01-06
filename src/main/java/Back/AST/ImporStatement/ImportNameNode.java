package Back.AST.ImporStatement;
import java.util.List;

    public class ImportNameNode extends ImportStatementNode {
    public final List<ImportNode> names;
    public ImportNameNode(int line,List<ImportNode> names){
        super(line,"ImportName");
        this.names = names;
    }

         @Override
        public void printTree(int indent) {
            System.out.println(super.indent(indent) + super.name + " (line " + line + ")");
            for (ImportNode n : names) {
                n.printTree(indent+2);
            }
        }
}
