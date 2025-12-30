package AST.ImporStatement;

public class ImportAsNameNode extends ImportNode{
    public String name;
    public String alias;
    public ImportAsNameNode(int line, String name, String alias) {
        super(line, "ImportAsName");
        this.name = name;
        this.alias = alias;
    }

    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent)+super.name+"  "+this.name +
                (alias == null ? "" : " as " + alias)+
                " (line " + line+")");
    }
}
