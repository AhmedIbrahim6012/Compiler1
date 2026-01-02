package SymbolTable;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class SymbolTable {
    private Stack<Map<String, Type>> scopes;
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
    public void addSymbol(String name,Type type) {
        if (scopes.peek().containsKey(name)) {
            throw new RuntimeException(
                    "Symbol already defined: " + name
            );
        }
        scopes.peek().put(name,type);    }
    public String lookup(String name) {
        for (int i = scopes.size() - 1; i >= 0; i--) {
            Type type = scopes.get(i).get(name);
            if (type != null) {
                return name;
            }
        }
        return null;
    }
}
