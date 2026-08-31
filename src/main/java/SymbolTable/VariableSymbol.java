package SymbolTable;

public class VariableSymbol extends  Symbol {
    private final DataType type;
    private final Object data;
    public VariableSymbol(String name,int line, DataType type,Object data) {
        super(name,line,SymbolKind.VARIABLE);
        this.type = type;
        this.data = data;
    }
    public DataType getType() {
        return type;
    }

    public  Object getData() {
        return  data;
    }

    @Override
    public void print() {
        System.out.println("name : "+name+" line : "+line+" type : "+type+" data : "+this.data);
    }
}
