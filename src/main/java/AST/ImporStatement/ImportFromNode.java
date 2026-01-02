package AST.ImporStatement;

import java.util.List;

public class ImportFromNode extends ImportStatementNode{
    public final ImportNode moduleName;
    public final List<ImportNode> importAsNames;
    public ImportFromNode(int line, ImportNode moduleName, List<ImportNode> importAsNames) {
        super(line,"ImportFrom");
        this.moduleName = moduleName;
        this.importAsNames = importAsNames;
    }

    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name + " (line " + line + ")");
        moduleName.printTree(indent + 2);
        for (ImportNode n : importAsNames) {
            n.printTree(indent + 4);
        }
    }
}
