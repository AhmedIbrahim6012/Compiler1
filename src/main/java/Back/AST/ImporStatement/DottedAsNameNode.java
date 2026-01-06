package Back.AST.ImporStatement;

public class DottedAsNameNode extends  ImportNode {
    public final ImportNode  dottedName;
    public final String alias;
    public DottedAsNameNode(int line, ImportNode dottedName, String alias) {
        super(line, "DottedAsName");
        this.dottedName = dottedName;
        this.alias = alias;
    }

    @Override
    public String toString(){
        return dottedName+(alias==null?"":" as "+alias);
    }

    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + name +
                (alias == null ? "" : " as " + alias) +
                " (line " + line + ")");
        dottedName.printTree(indent+2);
    }

}
