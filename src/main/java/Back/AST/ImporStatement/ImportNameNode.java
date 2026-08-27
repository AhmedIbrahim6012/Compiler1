package Back.AST.ImporStatement;
import java.util.List;

    public class ImportNameNode extends ImportStatementNode {
    public final List<DottedAsNameNode> DottedAsNames;
    public ImportNameNode(int line,List<DottedAsNameNode> DottedAsNames){
        super(line,"ImportName");
        this.DottedAsNames = DottedAsNames;
    }

         @Override
        public void printTree(int indent) {
            System.out.println(super.indent(indent) + super.name + " (line " + line + ")");
            for (ImportNode n : DottedAsNames) {
                n.printTree(indent+2);
            }
        }
}
