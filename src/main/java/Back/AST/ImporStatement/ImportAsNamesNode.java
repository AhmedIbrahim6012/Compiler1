package Back.AST.ImporStatement;

import java.util.ArrayList;
import java.util.List;

public class ImportAsNamesNode extends ImportNode{
   public final List<ImportAsNameNode>importAsNameNodes ;
    public ImportAsNamesNode(int line,List<ImportAsNameNode> importAsNameNodes){
        super(line,"Import As Names");
        this.importAsNameNodes = importAsNameNodes;
    }

    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name + " (line " + line + ")");
        for(ImportNode n:importAsNameNodes){
            n.printTree(indent + 2);
        }
    }
}
