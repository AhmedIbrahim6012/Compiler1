package SymbolTable;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
public class SymbolTable {
    private Stack<Scope> scopes;
    public SymbolTable() {
        scopes = new Stack<>();
        enterScope();
        initializeBuiltins();
    }
    public void enterScope() {
        scopes.push(new Scope());
    }
    public void exitScope() {
        if (scopes.size() > 1) {
            scopes.pop();
        }
    }
    public void define(Symbol symbol) {
        Scope current = scopes.peek();
        current.define(symbol);
    }

    public Symbol  lookup(String name) {
        for (int i = scopes.size() - 1; i >= 0; i--) {
            Symbol symbol = scopes.get(i).resolve(name);
            if (symbol != null) {
             return symbol;
            }
        }
        return null;
    }

    public Symbol lookupUnderGlobal(String name) {
        for (int i = scopes.size() - 1; i > 0; i--) {
            Symbol symbol = scopes.get(i).resolve(name);
            if (symbol != null) {
                return symbol;
            }
        }
        return null;
    }

    public void print(){
        System.out.println(scopes.size());
        for (int i = 0; i < scopes.size(); i++) {
            System.out.println("Scope "+i);
            scopes.get(i).print();
        }
    }

    public Map<String, Symbol>  getGlobalScopeSymbols(){
        return scopes.get(0).getSymbols();
    }

    public void injectJinjaMethods(){
        define(new FunctionSymbol(
                "url_for",0, 1,
                DataType.UNKNOWN));
    }

    public boolean isGlobalScope(){
        return scopes.size() == 2;
    }

    private void initializeBuiltins(){
        define(new FunctionSymbol(
                "print",0, 1,
                DataType.UNKNOWN));

        define(new FunctionSymbol(
                "len",0,
                1,
                DataType.INT));
        define(new FunctionSymbol(
                "url_for",0,
                1,
                DataType.STRING));

        define(new FunctionSymbol(
                "range",0,
                1,
                DataType.LIST));
        define(new FunctionSymbol(
                "float",0,
                1,
                DataType.FLOAT));
        define(new FunctionSymbol(
                "ValueError",0,
                1,
                DataType.UNKNOWN));
    }
}
