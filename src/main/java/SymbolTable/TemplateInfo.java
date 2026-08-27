package SymbolTable;

import java.util.List;

public class TemplateInfo {
    private final String templateName;
    private final List<Symbol> variables;
    public TemplateInfo(String templateName,
                        List<Symbol> variables) {
        this.templateName = templateName;
        this.variables = variables;
    }

    public String getTemplateName() {
        return templateName;
    }

    public List<Symbol> getVariables() {
        return variables;
    }

    public Symbol lookup(String name){
        for (Symbol variable : variables) {
            if (variable.getName().equals(name)) {
                return  variable;
            }
        }
        return  null;
    }

    public void print(){
        System.out.println("template name : "+templateName);
        System.out.println("variables : ");
        for (Symbol symbol : variables) {
            symbol.print();
        }
    }
}
