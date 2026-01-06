package SymbolTable;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class SymbolTable {
    private Stack<Map<String, Symbol>> scopes;
    public SymbolTable() {
        scopes = new Stack<>();
        enterScope();
    }
    public void enterScope() {
        scopes.push(new HashMap<>());
    }
    public void exitScope() {
        if (scopes.size() > 1) {
            scopes.pop();
        }
    }
    public void addSymbol(String name,Type type,int line) {
        scopes.peek().put(name,new Symbol(name,line,type));
    }
    public void lookup(String name,int line) {
        for (int i = scopes.size() - 1; i >= 0; i--) {
            Symbol symbol = scopes.get(i).get(name);
            if (symbol != null) {
                return;
            }
        }
        throw new RuntimeException(
                "Symbol : " + name+"  not defined!"+" at line  "+line
        );
    }
}
