package SymbolTable;

import Back.AST.ExpressionStatement.Atoms.NameAtomNode;
import Front.AST.ASTNode;
import Front.AST.CSS.Value.FunctionNode;
import Front.AST.CSS.Value.ValueNode;
import Front.AST.Html.*;
import Front.AST.CSS.*;
import Front.AST.JInja2.*;
import Front.AST.JInja2.ExpressionStatement.*;
import Front.AST.JInja2.IfStatementNode;
import Front.AST.JInja2.ForStatementNode;
import Front.AST.NameNode;
import Front.AST.StringNode;
import Front.AST.CSS.Property.*;
public class SymbolTableFrontVisitor {
    public final SymbolTable symbolTable ;
    public final TemplateInfo template;
    public  SymbolTableFrontVisitor(SymbolTable symbolTable,TemplateInfo template) {
        this.symbolTable = symbolTable;
        this.template = template;
    }

    public void visit(ASTNode node){
        if (node == null){
            return;
        }
        if (node instanceof HtmlAttributeNode){
            visit((HtmlAttributeNode)node);

        }else if (node instanceof AttributeValuesNode) {
            visit((AttributeValuesNode)node);
        }  else if (node instanceof HtmlDocument) {
            visit((HtmlDocument)node);
        } else if (node instanceof HtmlElementNode) {
            visit((HtmlElementNode)node);
        }else if (node instanceof CSSRuleNode) {
            visit((CSSRuleNode)node);
        } else if (node instanceof CSSStatements) {
            visit((CSSStatements)node);
        }else if (node instanceof DeclarationNode) {
            visit((DeclarationNode)node);
        } else if (node instanceof ExpressionNode) {
            visit((ExpressionNode)node);
        } else if (node instanceof CallExpressionNode) {
            visit((CallExpressionNode)node);
        } else if (node instanceof IndexAccessExpressionNode) {
            visit(((IndexAccessExpressionNode)node));
        } else if (node instanceof PropertyAccessExpressionNode) {
            visit(((PropertyAccessExpressionNode)node));
        } else if (node instanceof ArgumentListNode) {
            visit((ArgumentListNode)node);
        } else if (node instanceof IfStatementNode) {
            visit((IfStatementNode)node);
        }else if (node instanceof ForStatementNode) {
            visit((ForStatementNode)node);
        }
    }
    public void visit(ExpressionNode node){
        visit(node.expression);
    }

    public void visit(IfStatementNode node){
        if (node == null)return;
        if (node.expression.expression instanceof NameNode){
            checkVariable((NameNode)node.expression.expression);
        }else {
            visit(node.expression.expression);
        }
        for (ASTNode element:node.elements){
            visit(element);
        }
        for (IfStatementNode.ElseIf elseIf:node.elseIf){
            if (elseIf.expression.expression instanceof NameNode){
               checkVariable((NameNode)elseIf.expression.expression);
            }else {
                visit(elseIf.expression.expression);
            }
            for (ASTNode element:elseIf.elements){
                visit(element);
            }
        }
        if (node.elseBody != null){
            for (ASTNode element:node.elseBody.elements){
                visit(element);
            }
        }
    }

    public void visit(ForStatementNode node){
        if (node == null)return;
        if (node.expression.expression instanceof NameNode){
            checkVariable((NameNode)node.expression.expression);
        }
        symbolTable.enterScope();
        symbolTable.define(new VariableSymbol(node.itrator.value,node.itrator.line,DataType.UNKNOWN));
        for (ASTNode element:node.elements){
            visit(element);
        }
        symbolTable.exitScope();
    }

    private void checkVariable(NameNode name){
        Symbol symbol = symbolTable.lookupUnderGlobal(name.value);
        if (symbol == null){
            symbol = template.lookup(name.value);
            if (symbol == null){
                if (symbolTable.isGlobalScope()){
                    throw new RuntimeException("Missing Flask variable : " + name.value + "  at line :" + name.line);
                }else {
                    throw  new RuntimeException("Error undefined :  name " + name.value + "  at line :" + name.line);
                }
            }
        }
    }

    public void visit(CallExpressionNode node){
        if (node==null)return;
        if (node.function instanceof NameNode){
            checkVariable((NameNode) node.function);
            if (((NameNode) node.function).value.equals("url_for")){
                analyzeUrlforMethod(node);
            }
        }else {
            visit(node.function);
        }
    }

    private void analyzeUrlforMethod(CallExpressionNode node){
        if (node.arguments == null || node.arguments.arguments.isEmpty())return;
        ASTNode arg = node.arguments.arguments.get(0);
        if (arg instanceof StringNode){
            String name =((StringNode) arg).value.substring(1,((StringNode) arg).value.length()-1);
            Symbol symbol = symbolTable.lookup(name);
            if (symbol == null || symbol.kind != SymbolKind.ROUTE){
                throw  new RuntimeException("Error undefined route with:  name " + name + "  at line :" + arg.line);
            }
        }
    }
    public void visit(IndexAccessExpressionNode node){
        if (node==null)return;
        if(node.object instanceof NameNode){
            checkVariable((NameNode)node.object);
        }else {
            visit(node.object);
        }
    }
    public   void visit(PropertyAccessExpressionNode node){
        if (node==null)return;
        if (node.value instanceof NameNode){
          checkVariable((NameNode) node.value);
        }else {
            visit(node.value);
        }
    }
    public  void visit(ArgumentListNode node){}

    public void visit(HtmlDocument node){
        if (node == null)return;
        for (ASTNode element:node.elements){
            visit(element);
        }
    }

    public void visit(HtmlElementNode node){
        if (node == null)return;
        if (isOrphanNodes(node)){
            if (!node.isSelfClose){
                throw new RuntimeException("SemanticError : this element must not have children : "+node.tagName.value);
            }
        }
        for (ASTNode child:node.attributes){
            visit(child);
        }
        for (ASTNode child:node.children){
            visit(child);
        }
    }
    private boolean isOrphanNodes(HtmlElementNode node){
        return node.tagName.value.equals("hr") || node.tagName.value.equals("input") || node.tagName.value.equals("br") || node.tagName.value.equals("img");
    }

    public void visit(HtmlAttributeNode node){
        if (node == null)return;
        if (node.key.value.equals("id")){
            if (node.value !=null){
                ASTNode value =  node.value.values.get(0);
             if (value instanceof StringNode){
                 String v = ((StringNode) value).value;
                 Symbol symbol =  symbolTable.lookupUnderGlobal(v);
                 if(symbol != null && symbol.kind == SymbolKind.HTML_ID){
                     throw new RuntimeException(
                             "SemanticError: Duplicate ID '" + v + "' found at line " + value.line +
                                     ". It was already defined at line " + symbol.getLine()
                     );
                 }
                 symbolTable.define(new HTMLIDSymbol(value.line,v));
             }
            }
        }else {
            visit(node.value);
        }
    }

    public void visit(AttributeValuesNode node){
        if (node == null)return;
        for (ASTNode value:node.values){
            visit(value);
        }
    }



    public void visit(CSSStatements node){
        if (node == null)return;
        for (ASTNode cssNode:node.statements){
            visit(cssNode);
        }
    }
    public void visit(CSSRuleNode node){
        for (CombineSelectorsNode c:node.selectorGroup.selectors){
            visit(c);
        }
        for (DeclarationNode n:node.block.declarations){
            visit(n);
        }
    }
    public void visit(CombineSelectorsNode node){
    }
    public void visit(DeclarationNode node){
        if (node == null)return;
        if (node.key.property instanceof VariablePropertyNode){
            VariablePropertyNode value =   ((VariablePropertyNode) node.key.property);
            symbolTable.define(new CSSVariableSymbol(value.value,value.line));
        }
        for(ValueNode value:node.values){
            if (value.value instanceof FunctionNode){
                visit((FunctionNode)value.value);
            }
        }
    }

    public void visit(FunctionNode node){
        if (node == null)return;
        if (node.name.value.equals("var")){
           VariablePropertyNode variable = (VariablePropertyNode) node.arguments.get(0);
           Symbol symbol =  symbolTable.lookupUnderGlobal(variable.value);
           if (symbol == null || symbol.kind != SymbolKind.CSS_VARIABLE){
               throw new RuntimeException("not defined this variable : "+variable.value+" at line : "+variable.line);
           }
        }
    }

}
