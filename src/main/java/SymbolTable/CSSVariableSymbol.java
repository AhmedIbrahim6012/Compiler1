package SymbolTable;

public class CSSVariableSymbol extends Symbol{
    public  CSSVariableSymbol(String name,int line){
        super(name,line,SymbolKind.CSS_VARIABLE);
    }
    @Override
    public void print() {
        System.out.println("name : "+name+" , line : "+line);
    }
}
