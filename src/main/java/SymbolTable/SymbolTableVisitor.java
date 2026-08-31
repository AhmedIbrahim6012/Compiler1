package SymbolTable;
import Back.AST.*;
import Back.AST.ExpressionStatement.*;
import Back.AST.ExpressionStatement.Atoms.*;
import Back.AST.ExpressionStatement.Operators.*;
import Back.AST.FlowStatement.FlowStatementNode;
import Back.AST.FlowStatement.RaiseStatementNode;
import Back.AST.FlowStatement.ReturnStatementNode;
import Back.AST.ImporStatement.*;
import Front.AST.CSS.Value.FunctionNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SymbolTableVisitor {
    public final SymbolTable symbolTable;
    public  SymbolTableVisitor(SymbolTable symbolTable) {
        this.symbolTable = symbolTable;
    }

    public Object visit(Program node) {
        if (node == null) {
            return null;
        }
        for (ASTNode statement : node.statements) {
            visit(statement);
        }
        return  null;
    }

    public Object visit(ASTNode node){
        if (node == null) {
            return null;
        }
        if (node instanceof BlockNode){
            visit((BlockNode)node);
        } else if (node instanceof CompoundStatementNode) {
            visit((CompoundStatementNode)node);
        } else if (node instanceof DecoratorNode){
            visit((DecoratorNode)node);
        } else if (node instanceof SimpleStatementNode) {
            visit((SimpleStatementNode)node);
        } else if (node instanceof SimpleStatementsNode) {
            visit((SimpleStatementsNode)node);
        } else if (node instanceof ImportNode) {
            visit((ImportNode)node);
        }else {
            return null;
        }
        return  null;
    }

    public Object visit(DecoratorNode node){
        if (node == null) {
            return null;
        }
        List<TemplateInfo> templates = new ArrayList<>();
        FunctionDefNode fnode = node.function;
        symbolTable.enterScope();
        if (fnode.parameters != null){
            for (ExpressionNode param:fnode.parameters.arguments){
                if (param instanceof NameAtomNode) {
                    DataType type = getDataType(param);
                    symbolTable.define(new VariableSymbol(((NameAtomNode) param).value,param.line,type,null));
                }
            }
        }
        visit(fnode.body);
        analyzeTemplateBody(fnode.body,templates);
        symbolTable.exitScope();
        symbolTable.define(new RouteSymbol(node.function.name.value
                ,node.line
                ,node.decorates.get(0).pathParameters
                ,templates));
        return  null;
    }

    private TemplateInfo analyzeRenderTemplate(CallExpressionNode node){
        List<Symbol> templateParams = new ArrayList<>();
        String templateName;
        if (node.arguments != null && !node.arguments.arguments.isEmpty()){
            ExpressionNode firstArg = node.arguments.arguments.get(0);
            if (firstArg instanceof StringAtomNode){
                templateName = ((StringAtomNode) firstArg).value;
            }else {
                throw  new RuntimeException("Error : first arg of render_template must be String");
            }
            for (int i = 1; i < node.arguments.arguments.size(); i++) {
                ExpressionNode arg = node.arguments.arguments.get(i);
                if (arg instanceof AssignmentStatement){
                    NameAtomNode name =(NameAtomNode) ((AssignmentStatement) arg).targets.get(0);
                    ExpressionNode value = ((AssignmentStatement) arg).value;
                    if (value instanceof NameAtomNode){
                        Symbol symbol =  symbolTable.lookup(((NameAtomNode) value).value);
                        if (symbol == null){
                            throw new RuntimeException("Error undefined name : " + ((NameAtomNode) value).value + "  at line :" + ((NameAtomNode) value).line);
                        }
                        templateParams.add(symbol);
                    }else {
                        DataType type = getDataType(arg);
                        templateParams.add(new VariableSymbol(name.value,name.line,type,null));
                    }

                }
            }
        }else {
            throw   new RuntimeException("Error : arguments of render_template must be exist");
        }
        return new TemplateInfo(templateName,templateParams);
    }

    private void analyzeTemplateBody(ASTNode node,List<TemplateInfo>templates){
        if (node == null)return;
        if (node instanceof CallExpressionNode) {
            if (((CallExpressionNode) node).function instanceof NameAtomNode){
                if (((NameAtomNode) ((CallExpressionNode) node).function).value.equals("render_template")){
                  TemplateInfo TemplateInfo =   analyzeRenderTemplate((CallExpressionNode) node);
                  templates.add(TemplateInfo);
                }
            }
        } else if (node instanceof ListExpressionNode) {
            for (ExpressionNode expressionNode:((ListExpressionNode) node).elements){
                analyzeTemplateBody(expressionNode,templates);
            }
        } else if (node instanceof ReturnStatementNode){
            analyzeTemplateBody(((ReturnStatementNode) node).expression,templates);
        } else if (node instanceof BlockNode) {
            for (ASTNode statement : ((BlockNode) node).statements) {
                analyzeTemplateBody(statement,templates);
            }
        } else if (node instanceof SimpleStatementsNode) {
            for (ASTNode statement : ((SimpleStatementsNode) node).statements) {
                analyzeTemplateBody(statement,templates);
            }
        } else if (node instanceof IfStatementNode) {
            analyzeTemplateBody(((IfStatementNode) node).body,templates);
            for (IfStatementNode.ElseIf elseIf : ((IfStatementNode) node).elseIf){
                analyzeTemplateBody(elseIf.body,templates);
            }
            if (((IfStatementNode) node).elseBody != null){
                analyzeTemplateBody(((IfStatementNode) node).elseBody,templates);
            }
        } else if (node instanceof TryStatementNode) {
            analyzeTemplateBody(((TryStatementNode) node).body,templates);
            for (TryStatementNode.Except except:((TryStatementNode) node).excepts){
                analyzeTemplateBody(except.body,templates);
            }
        }
    }

    public Object visit(SimpleStatementsNode node){
        if (node == null) {
            return null;
        }
        for (SimpleStatementNode statement : node.statements) {
            visit((SimpleStatementNode)statement);
        }
        return  null;
    }

    public Object visit(CompoundStatementNode node){
        if (node == null) {
            return null;
        }
        if (node instanceof ForStatementNode){
            visit((ForStatementNode)node);
        } else if (node instanceof FunctionDefNode){
            visit((FunctionDefNode)node);
        } else if (node instanceof IfStatementNode) {
            visit((IfStatementNode)node);
        } else if (node instanceof TryStatementNode) {
            visit((TryStatementNode)node);
        }
        return  null;
    }

    public Object visit(SimpleStatementNode node){
        if (node == null) {
            return null;
        }
        if (node instanceof ExpressionNode){
            visit((ExpressionNode)node);
        } else if (node instanceof FlowStatementNode) {
            visit((FlowStatementNode)node);
        }
        else if (node instanceof ImportStatementNode){
            visit((ImportStatementNode)node);
        }
        return  null;
    }

    public Object visit(FlowStatementNode node){
        if (node == null) {
            return null;
        }
        if (node instanceof ReturnStatementNode){
            visit((ReturnStatementNode)node);
        } else if (node instanceof RaiseStatementNode) {
            visit((RaiseStatementNode)node);
        }
        return  null;
    }

    public Object visit(ImportStatementNode node){
        if (node == null) {
            return null;
        }
        if (node instanceof ImportFromNode){
            visit((ImportFromNode)node);
        } else if (node instanceof ImportNameNode) {
            visit((ImportNameNode)node);
        }
        return  null;
    }

    public Object visit(ImportFromNode node){
        if (node == null) {
            return null;
        }
        for (ImportAsNameNode n:node.importAsNames.importAsNameNodes){
            if (n.alias != null){
                symbolTable.define(new FunctionSymbol(n.alias,n.line,0,null));
            }else {
                symbolTable.define(new FunctionSymbol(n.name,n.line,0,null));
            }
        }
        return  null;
    }

    public Object visit(ImportNameNode node){
        if (node == null) {
            return null;
        }
        for (DottedAsNameNode n : node.DottedAsNames){
            if (n.alias != null){
                symbolTable.define(new FunctionSymbol(n.alias,n.line,0,null));
            }else {
                symbolTable.define(new FunctionSymbol(n.dottedName.parts.get(n.dottedName.parts.size()-1),n.line,0,null));
            }
        }
        return  null;
    }

    public Object visit(ReturnStatementNode node){
        if (node == null) {
            return null;
        }
        visit(node.expression);
        return  null;
    }

    public Object visit(RaiseStatementNode node){
        if (node == null) {
            return null;
        }
        visit(node.expressionBeforeFrom);
        visit(node.expressionAfterFrom);
        return  null;
    }

    public Object visit(ExpressionNode node){
        if (node == null) {
            return null;
        }
        if (node instanceof ArgumentsExpressionNode){
            visit((ArgumentsExpressionNode)node);
        } else if (node instanceof AssignmentStatement) {
            visit((AssignmentStatement)node);
        } else if (node instanceof AttributeExpressionNode){
            visit((AttributeExpressionNode)node);
        } else if (node instanceof BinaryExpressionNode) {
            visit((BinaryExpressionNode)node);
        } else if (node instanceof CallExpressionNode){
            visit((CallExpressionNode)node);
        } else if (node instanceof CompareExpressionNode) {
            visit((CompareExpressionNode)node);
        } else if (node instanceof DictionaryExpressionNode){
           return visit((DictionaryExpressionNode)node);
        }else if (node instanceof IndexExpressionNode) {
            visit((IndexExpressionNode)node);
        } else if (node instanceof ListExpressionNode){
           return visit((ListExpressionNode)node);
        }else if (node instanceof TupleExpressionNode) {
          return   visit((TupleExpressionNode)node);
        } else if (node instanceof UnaryExpressionNode){
            visit((UnaryExpressionNode)node);
        }else if (node instanceof AtomNode){
            return visit((AtomNode)node);
        } else if (node instanceof ArithmeticExpressionNode) {
            visit((ArithmeticExpressionNode) node);
        }
        return  null;
    }

    public Object visit(AttributeExpressionNode node){
        if (node == null) {
            return null;
        }
        if (node.value instanceof NameAtomNode){
            Symbol symbol = symbolTable.lookup(((NameAtomNode) node.value).value);
            if (symbol == null){
                throw  new RuntimeException("Error undefined :  name " + ((NameAtomNode) node.value).value + "  at line :" + (node.value).line);
            }
        }else {
            visit(node.value);
        }
        return  null;
    }

    public Object visit(UnaryExpressionNode node){
        if (node == null) {
            return null;
        }
        if (node.operand instanceof NameAtomNode){
            Symbol symbol = symbolTable.lookup(((NameAtomNode) node.operand).value);
            if (symbol == null){
                throw  new RuntimeException("Error undefined :  name " + ((NameAtomNode) node.operand).value + "  at line :" + (node.operand).line);
            }
        }else {
            visit(node.operand);
        }
        return  null;
    }

    public Object visit(BinaryExpressionNode node){
        if (node == null) {
            return null;
        }
        if (node.left instanceof NameAtomNode){
            Symbol symbol = symbolTable.lookup(((NameAtomNode) node.left).value);
            if (symbol == null){
                throw  new RuntimeException("Error undefined :  name " + ((NameAtomNode) node.left).value + "  at line :" + (node.left).line);
            }
        }else {
            visit(node.left);
        }
        for (ExpressionNode right:node.right){
            if (right instanceof NameAtomNode){
                Symbol symbol = symbolTable.lookup(((NameAtomNode) right).value);
                if (symbol == null){
                    throw new RuntimeException("Error undefined :  name " + ((NameAtomNode) right).value + "  at line :" + ((NameAtomNode) right).line);
                }
            }else {
                visit(right);
            }
        }
        return  null;
    }

    public Object visit(ArithmeticExpressionNode node){
        if (node == null) {
            return null;
        }
        DataType leftType = getDataType(node.left);
        DataType rightType = getDataType(node.right);
        boolean isValid =
                (leftType.equals(DataType.INT) && rightType.equals(DataType.STRING))
                ||(leftType.equals(DataType.STRING) && rightType.equals(DataType.INT))
                ||(leftType.equals(DataType.UNKNOWN) && rightType.equals(DataType.STRING))
                ||(leftType.equals(DataType.STRING) && rightType.equals(DataType.UNKNOWN))
                ||(leftType.equals(DataType.INT) && rightType.equals(DataType.UNKNOWN))
                ||(leftType.equals(DataType.UNKNOWN) && rightType.equals(DataType.INT));
        if (isValid){
            throw  new RuntimeException("Mismatch type error : "+leftType+" , "+rightType+"  at line : "+node.line);
        }
        return  null;
    }

    public Object visit(CompareExpressionNode node){
        if (node == null) {
            return null;
        }
        if (node.left instanceof NameAtomNode){
            Symbol symbol = symbolTable.lookup(((NameAtomNode) node.left).value);
            if (symbol == null){
                throw  new RuntimeException("Error undefined :  name " + ((NameAtomNode) node.left).value + "  at line :" + ((NameAtomNode) node.left).line);
            }
        }else {
            visit(node.left);
        }
        for (ExpressionNode right:node.comparators){
            if (right instanceof NameAtomNode){
                Symbol symbol = symbolTable.lookup(((NameAtomNode) right).value);
                if (symbol == null){
                    throw  new RuntimeException("Error undefined :  name " + ((NameAtomNode) right).value + "  at line :" + ((NameAtomNode) right).line);
                }
            }else {
                visit(right);
            }
        }
        return  null;
    }

    public Object visit(IndexExpressionNode node){
        if (node == null) {
            return null;
        }
        if (node.object instanceof NameAtomNode){
            String name = ((NameAtomNode) node.object).value;
            Symbol symbol = symbolTable.lookup(name);
            if (symbol == null) {
                throw new RuntimeException("Error undefined name : " + name + "  at line :" + node.line);
            }
//            if (((VariableSymbol)symbol).getType() != DataType.DICTIONARY && ((VariableSymbol)symbol).getType() != DataType.LIST){
//              throw new RuntimeException(
//                      "Error: Type '" + ((VariableSymbol)symbol).getType() + "' is not indexable at line " + node.line
//              );
//            }
        }else {
            visit(node.object);
        }
        return  null;
    }

    public Object visit(DictionaryExpressionNode node){
        if (node == null) {
            return null;
        }
        Map<Object, Object> dict = new HashMap<>();
        for (Map.Entry<ExpressionNode, ExpressionNode> element : node.map.entrySet()) {
            if (!isValidDictionaryKey(element.getKey())) {
                throw new RuntimeException("Type Error: " + element.getKey().name + " is not valid key at line " + node.line);
            }
            Object key = visit(element.getKey());
            if (element.getValue() instanceof NameAtomNode){
                String name = ((NameAtomNode) element.getValue()).value;
               Symbol sym =  symbolTable.lookup(name);
                if (sym == null) {
                    throw new RuntimeException("Error undefined name : " + name + "  at line :" + node.line);
                }
                if (sym instanceof VariableSymbol){
                    dict.put(key, ((VariableSymbol) sym).getData());
                }
            }else {
              Object o =   visit(element.getValue());
              dict.put(key, o);
            }
        }
        return  dict;
    }

    private boolean isValidDictionaryKey(ExpressionNode node){
        if (node == null)return false;
        return (node instanceof StringAtomNode) || (node instanceof IntNumberAtomNode) || (node instanceof BoolAtomNode) || (node instanceof DoubleNumberAtomNode) || (node instanceof NoneAtomNode) || (node instanceof TupleExpressionNode);
    }

    public Object visit(TupleExpressionNode node){
        if (node == null) {
            return null;
        }
        for (ExpressionNode element : node.elements) {
            if (element instanceof NameAtomNode){
              Symbol symbol =   symbolTable.lookup(((NameAtomNode) element).value);
                if (symbol == null){
                    throw  new RuntimeException("Error undefined :  name " + ((NameAtomNode) element).value + "  at line :" + element.line);
                }
            }else {
                visit(element);
            }
        }
        return  null;
    }

    public Object visit(ListExpressionNode node){
        if (node == null) {
            return null;
        }
        List<Object> list = new ArrayList<>();
        for (ExpressionNode element : node.elements) {
            if (element instanceof NameAtomNode){
               Symbol symbol =  symbolTable.lookup(((NameAtomNode) element).value);
                if (symbol == null){
                    throw  new RuntimeException("Error undefined :  name " + ((NameAtomNode) element).value + "  at line :" + element.line);
                }
                if (symbol instanceof VariableSymbol){
                     list.add(((VariableSymbol) symbol).getData());
                }
            }else {
               Object object =  visit(element);
               list.add(object);
            }
        }
        return  list;
    }

    public Object visit(AtomNode node){
        if (node == null)return null;
        if (node instanceof StringAtomNode){
            return ((StringAtomNode) node).value;
        } else if (node instanceof BoolAtomNode) {
            return ((BoolAtomNode) node).value;
        } else if (node instanceof DoubleNumberAtomNode) {
            return ((DoubleNumberAtomNode) node).value;
        } else if (node instanceof  IntNumberAtomNode) {
            return  ((IntNumberAtomNode) node).value;
        } else if (node instanceof NameAtomNode) {
            Symbol symbol =  symbolTable.lookup(((NameAtomNode) node).value);
            if (symbol == null){
                throw  new RuntimeException("Error undefined :  name " + ((NameAtomNode) node).value + "  at line :" + node.line);
            }
            if (symbol instanceof VariableSymbol){
                return ((VariableSymbol) symbol).getData();
            }else {
                return null;
            }
        }else {
            return null;
        }
    }

    public Object visit(ImportNode node){
        if (node == null) {
            return null;
        }
        if (node instanceof DottedAsNameNode){
            visit(node);
        } else if (node instanceof DottedNameNode) {
            visit(node);
        } else if (node instanceof ImportAsNameNode){
            visit(node);
        }else if (node instanceof ImportAsNamesNode){
            visit(node);
        }
        return  null;
    }

    public Object visit(AssignmentStatement node){
        if (node == null) {
            return null;
        }
       Object object =  visit(node.value);
        DataType type = getDataType(node.value);
        for (ExpressionNode taget:node.targets){
            if (taget instanceof NameAtomNode){
                symbolTable.define(
                        new VariableSymbol(
                                ((NameAtomNode) taget).value,
                                taget.line,
                                type,object
                        )
                );
            }else if (isPrimitive(taget)){
                throw new RuntimeException("cannot assign to primitive value");
            }else {
                visit(taget);
            }
        }
        return  null;
    }

    private boolean isPrimitive(ExpressionNode node){
        if (node instanceof IntNumberAtomNode) {
            return true;
        } else if (node instanceof DoubleNumberAtomNode) {
            return true;
        } else if (node instanceof StringAtomNode) {
            return true;
        } else if (node instanceof BoolAtomNode) {
            return true;
        }else if (node instanceof NoneAtomNode) {
            return true;
        }else {
            return false;
        }
    }

    private DataType getDataType(ExpressionNode node) {
        if (node instanceof IntNumberAtomNode) {
            return DataType.INT;
        } else if (node instanceof DoubleNumberAtomNode) {
            return DataType.FLOAT;
        } else if (node instanceof StringAtomNode) {
            return DataType.STRING;
        } else if (node instanceof BoolAtomNode) {
            return DataType.BOOLEAN;
        } else if ((node instanceof ListExpressionNode) || (node instanceof TupleExpressionNode)) {
            return DataType.LIST;
        } else if (node instanceof DictionaryExpressionNode) {
            return DataType.DICTIONARY;
        }
        return DataType.UNKNOWN;
    }

    public Object visit(FunctionDefNode node){
        if (node == null) {
            return null;
        }
        int paramsCount = 0;
        if (node.parameters != null){
            paramsCount = node.parameters.arguments.size();
        }
        symbolTable.define(new FunctionSymbol(node.name.value,node.name.line,paramsCount,null));
        symbolTable.enterScope();
        if (node.parameters != null){
            for (ExpressionNode param:node.parameters.arguments){
                if (param instanceof NameAtomNode) {
                    DataType type = getDataType(param);
                    symbolTable.define(new VariableSymbol(((NameAtomNode) param).value,param.line,type,null));
                }
            }
        }
        visit(node.body);
        symbolTable.exitScope();
        return  null;
    }

    public Object visit(CallExpressionNode node){
        if (node == null) {
            return null;
        }
        if (node.function instanceof NameAtomNode) {
            String funcName = ((NameAtomNode) node.function).value;
            Symbol sym = symbolTable.lookup(funcName);
            if (sym == null) {
                throw new RuntimeException("Error undefined : function name " + funcName + "  at line :" + node.line);
            }
            if (!(sym instanceof FunctionSymbol)) {
                throw new RuntimeException("Error: " + funcName + " is not a callable at line " + node.line);
            }
//            if (node.arguments == null)return;
//            if (node.arguments.arguments.size() != ((FunctionSymbol) sym).getParamCount()){
//                throw new RuntimeException("Error: " + funcName + " has " + ((FunctionSymbol) sym).getParamCount() + " arguments at line " + node.line);
//            }
        }else {
            visit(node.function);
        }
        visit(node.arguments);
        return  null;
    }

    public Object visit(ArgumentsExpressionNode node){
        if (node == null) {
            return null;
        }
       for (ExpressionNode argument:node.arguments){
           if (argument instanceof NameAtomNode){
               String funcName = ((NameAtomNode) argument).value;
             Symbol symbol =   symbolTable.lookup(funcName);
               if (symbol == null){
                   throw  new RuntimeException("Error undefined :  name " + ((NameAtomNode) argument).value + "  at line :" + argument.line);
               }
           }
       }
        return  null;
    }

    public Object visit(BlockNode node){
        if (node == null) {
            return null;
        }
        for (ASTNode statement: node.statements){
            visit(statement);
        }
        return  null;
    }

    private Object visit(IfStatementNode node){
        if (node == null) {
            return null;
        }
        if (node.condition instanceof NameAtomNode){
            Symbol symbol = symbolTable.lookup(((NameAtomNode) node.condition).value);
            if (symbol == null){
                throw  new RuntimeException("Error undefined :  name " + ((NameAtomNode) node.condition).value + "  at line :" + ((NameAtomNode) node.condition).line);
            }
        }else {
            visit(node.condition);
        }
        visit(node.body);
        for (IfStatementNode.ElseIf elseIf : node.elseIf){
            if (elseIf.condition instanceof NameAtomNode){
                Symbol symbol = symbolTable.lookup(((NameAtomNode) elseIf.condition).value);
                if (symbol == null){
                    throw  new RuntimeException("Error undefined :  name " + ((NameAtomNode) elseIf.condition).value + "  at line :" + ((NameAtomNode) node.condition).line);
                }
            }else {
                visit(elseIf.condition);
            }
            visit(elseIf.body);
        }
        if (node.elseBody != null){
            visit(node.elseBody);
        }
        return  null;
    }

    public Object visit(ForStatementNode node){
        if (node == null) {
            return null;
        }
        if (node.expression instanceof  NameAtomNode) {
          Symbol symbol =  symbolTable.lookup(((NameAtomNode) node.expression).value);
            if (symbol == null){
                throw  new RuntimeException("Error undefined :  name " + ((NameAtomNode) node.expression).value + "  at line :" + ((NameAtomNode) node.expression).line);
            }
        }else {
            visit(node.expression);
        }
        for (ExpressionNode param : node.params){
            if (param instanceof NameAtomNode){
                symbolTable.define(new VariableSymbol(((NameAtomNode) param).value,param.line,DataType.UNKNOWN,null));
            }else{
                visit(param);
            }
        }
        visit(node.body);
        if (node.elseBody != null){
            visit(node.elseBody.body);
        }
        return  null;
    }

    public Object visit(TryStatementNode node){
        if (node == null) {
            return null;
        }
        visit(node.body);
        for (TryStatementNode.Except ex:node.excepts){
            visit(ex.body);
        }
        return  null;
    }
}
