package SymbolTable;

public class VariableSymbol extends  Symbol {
    private final DataType type;
    public VariableSymbol(String name,int line, DataType type) {
        super(name,line,SymbolKind.VARIABLE);
        this.type = type;
    }
    public DataType getType() {
        return type;
    }

    @Override
    public void print() {
        System.out.println("name : "+name+" line : "+line+" type : "+type);
    }
}
