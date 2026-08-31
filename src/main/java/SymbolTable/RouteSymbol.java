package SymbolTable;

import java.util.List;

public class RouteSymbol extends  Symbol{

   private final List<String> parameters;
   private final List<TemplateInfo> templates;
   public RouteSymbol(String name,int line,List<String>parameters,List<TemplateInfo> templates) {
       super(name,line,SymbolKind.ROUTE);
       this.parameters = parameters;
       this.templates = templates;
   }
   public List<String> getParameters() {
       return  parameters;
   }
   public  List<TemplateInfo> getTemplates() {
       return  templates;
   }

    @Override
    public void print() {
        System.out.println("name : "+name+"  line : "+line+" path parameter : "+parameters);
        System.out.println("templates : ");
        for (TemplateInfo template : templates) {
            template.print();
        }
    }
}
