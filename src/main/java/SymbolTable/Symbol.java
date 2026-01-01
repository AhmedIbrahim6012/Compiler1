package SymbolTable;

public class Symbol {
    public final String name;
    public final int line;
    public  final Type type;
    public Symbol(String name, int line, Type type) {
        this.name = name;
        this.line = line;
        this.type = type;
    }
}
