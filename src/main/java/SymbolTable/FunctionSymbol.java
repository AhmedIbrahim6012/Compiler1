package SymbolTable;

public class FunctionSymbol extends Symbol{
    private final int paramCount;
    private final DataType returnType;
    public FunctionSymbol(String name, int line, int paramCount, DataType returnType) {
        super(name,line,SymbolKind.FUNCTION);
        this.paramCount = paramCount;
        this.returnType = returnType;
    }
    public  int getParamCount() {
        return paramCount;
    }
    public DataType getReturnType() {
        return  returnType;
    }
    @Override
    public void print(){
        System.out.println("name : "+name+"  line : "+line+" param count : "+paramCount+" return type : "+returnType);
    }
}
