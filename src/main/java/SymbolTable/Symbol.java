package SymbolTable;

import java.util.Map;

abstract public class Symbol {
    protected final String name;
    protected final int line;
    protected final SymbolKind kind;
    public Symbol(String name, int line,SymbolKind kind) {
        this.name = name;
        this.line = line;
        this.kind = kind;
    }
    public int getLine() {
        return line;
    }
    public String getName() {
        return name;
    }

    public void print(){
        System.out.println(name+"  line :"+line);
    }
}
