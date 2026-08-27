package SymbolTable;
import java.util.HashMap;
import java.util.Map;
public class Scope {
    private final Map<String, Symbol> symbols =
            new HashMap<>();
    public boolean contains(String name) {
        return symbols.containsKey(name);
    }
    public void define(Symbol symbol) {
        symbols.put(symbol.getName(), symbol);
    }
    public Symbol resolve(String name) {
        return symbols.get(name);
    }

    public Map<String, Symbol> getSymbols() {
        return symbols;
    }

    public void print(){
        for (Map.Entry<String, Symbol> entry : symbols.entrySet()) {
            System.out.println("######################");
            System.out.println("Name : " + entry.getKey());
            entry.getValue().print();
        }
    }
}
