package Back.AST.ImporStatement;

import java.util.List;

public class ImportFromNode extends ImportStatementNode{
    public final DottedNameNode dottedName;
    public final ImportAsNamesNode importAsNames;
    public ImportFromNode(int line, DottedNameNode dottedName, ImportAsNamesNode importAsNames) {
        super(line,"ImportFrom");
        this.dottedName = dottedName;
        this.importAsNames = importAsNames;
    }

    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name + " (line " + line + ")");
        dottedName.printTree(indent + 2);
        importAsNames.printTree(indent + 2);
    }
}
