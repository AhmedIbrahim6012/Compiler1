package SymbolTable;

public class HTMLIDSymbol extends Symbol{
    public  HTMLIDSymbol(int line ,String name){
        super(name,line,SymbolKind.HTML_ID);
    }

    @Override
    public void print() {
        System.out.println("name : "+name+" , line : "+line);
    }
}
