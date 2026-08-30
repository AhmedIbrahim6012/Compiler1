package Back.Visitor;

import Back.AST.*;
import Back.AST.ExpressionStatement.*;
import Back.AST.ExpressionStatement.Atoms.*;
import Back.AST.ExpressionStatement.Operators.*;
import Back.AST.FlowStatement.BreakStatementNode;
import Back.AST.FlowStatement.ContinueStatementNode;
import Back.AST.FlowStatement.RaiseStatementNode;
import Back.AST.FlowStatement.ReturnStatementNode;
import Back.AST.ImporStatement.*;
import BackLang.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ASTVisitor extends BackParserBaseVisitor<ASTNode> {
    @Override
    public ASTNode visitBreakStatementNode(BackParser.BreakStatementNodeContext ctx) {
        return new BreakStatementNode(ctx.start.getLine());
    }

    @Override
    public ASTNode visitContinueStatementNode(BackParser.ContinueStatementNodeContext ctx) {
        return new ContinueStatementNode(ctx.start.getLine());
    }

    @Override
    public ASTNode visitProgram(BackParser.ProgramContext ctx) {
        List<ASTNode>statements = new ArrayList<>();
        for (int i = 0; i < ctx.statement().size(); i++) {
           ASTNode node =  visit(ctx.statement(i));
           if (node != null) {
               statements.add(node);
           }
        }
        return new Program(statements);
    }
    @Override
    public ASTNode visitSimpleStatementsNode(BackParser.SimpleStatementsNodeContext ctx) {
        return visit(ctx.simple_statements());
    }
    @Override
    public ASTNode visitSimple_statements(BackParser.Simple_statementsContext ctx) {
        List<SimpleStatementNode>statements = new ArrayList<>();
        for (int i = 0; i < ctx.simple_statement().size(); i++) {
            statements.add((SimpleStatementNode) visit(ctx.simple_statement(i)));
        }
        return new SimpleStatementsNode(statements);
    }
    @Override
    public ASTNode visitExpressionStatementNode(BackParser.ExpressionStatementNodeContext ctx) {
        return visit(ctx.expression_statement());
    }
    @Override
    public ASTNode visitExpression_statement(BackParser.Expression_statementContext ctx) {
        if (ctx.ASSIGN().isEmpty()) {
            return visit(ctx.expression(0));
        }else {
            ExpressionNode value = (ExpressionNode) visit(ctx.expression(ctx.ASSIGN().size()));
            List<ExpressionNode> targets = new ArrayList<>();
            for (int i = 0; i < ctx.ASSIGN().size(); i++) {
                targets.add((ExpressionNode) visit(ctx.expression(i)));
            }
            return new AssignmentStatement(ctx.start.getLine(),targets,value);
        }
    }

    @Override
    public ASTNode visitExpression(BackParser.ExpressionContext ctx) {
        if (ctx.COMMA().isEmpty()){
            return visit(ctx.test(0));
        }
        List<ExpressionNode>list = new ArrayList<>();
        for (int i = 0; i < ctx.test().size(); i++) {
            list.add((ExpressionNode) visit(ctx.test(i)));
        }
        return new ListExpressionNode(ctx.start.getLine(),list);
    }
    @Override
    public ASTNode visitTest(BackParser.TestContext ctx) {
        ExpressionNode left =(ExpressionNode) visit(ctx.and_test(0));
        if (ctx.OR().isEmpty()){
            return left;
        }
        List<OperatorNode>ops = new ArrayList<>();
        List<ExpressionNode>list = new ArrayList<>();
        for (int i = 0; i < ctx.OR().size(); i++) {
            ops.add(new OrOperatorNode(ctx.start.getLine()));
            list.add((ExpressionNode) visit(ctx.and_test(i+1)));
        }
        return new BinaryExpressionNode(ctx.start.getLine(),left,list,ops);
    }
    @Override
    public ASTNode visitAnd_test(BackParser.And_testContext ctx) {
        ExpressionNode left =(ExpressionNode) visit(ctx.not_test(0));
        if (ctx.AND().isEmpty()){
            return left;
        }
        List<OperatorNode>ops = new ArrayList<>();
        List<ExpressionNode>list = new ArrayList<>();
        for (int i = 0; i < ctx.AND().size(); i++) {
            ops.add(new AndOperatorNode(ctx.start.getLine()));
            list.add((ExpressionNode) visit(ctx.not_test(i+1)));
        }
        return new BinaryExpressionNode(ctx.start.getLine(),left,list,ops);
    }

    @Override
    public ASTNode visitNotExpressionNode(BackParser.NotExpressionNodeContext ctx) {
        ExpressionNode node =(ExpressionNode) visit(ctx.not_test());
        return new UnaryExpressionNode(ctx.start.getLine(),new NotOperatorNode(ctx.start.getLine()),node);
    }
    @Override
    public ASTNode visitComparisionNode(BackParser.ComparisionNodeContext ctx) {
        return visit(ctx.comparison());
    }
    @Override
    public ASTNode visitComparison(BackParser.ComparisonContext ctx) {
        ExpressionNode left =(ExpressionNode) visit(ctx.expr(0));
        if (ctx.comp_op().isEmpty()){
            return left;
        }
        List<OperatorNode>ops = new ArrayList<>();
        List<ExpressionNode>list = new ArrayList<>();
        for (int i = 0; i < ctx.comp_op().size(); i++) {
            ops.add((OperatorNode) visit((ctx.comp_op(i))));
            list.add((ExpressionNode) visit(ctx.expr(i+1)));
        }
        return new CompareExpressionNode(ctx.start.getLine(),left,ops,list);
    }
    @Override
    public ASTNode visitLessThan(BackParser.LessThanContext ctx) {
        return new LessThanOperatorNode(ctx.start.getLine());
    }
    @Override
    public ASTNode visitGreaterThan(BackParser.GreaterThanContext ctx) {
        return  new GreaterThanOperatorNode(ctx.start.getLine());
    }
    @Override
    public ASTNode visitEqual(BackParser.EqualContext ctx) {
        return new EqualOperatorNode(ctx.start.getLine());
    }
    @Override
    public ASTNode visitGreaterThanOrEqual(BackParser.GreaterThanOrEqualContext ctx) {
        return new GreaterThanOrEqualOperatorNode(ctx.start.getLine());
    }
    @Override
    public ASTNode visitLessThanOrEqual(BackParser.LessThanOrEqualContext ctx) {
        return new LessThanOrEqualOperatorNode(ctx.start.getLine());
    }
    @Override
    public ASTNode visitNotEqual(BackParser.NotEqualContext ctx) {
        return new NotEqualOperatorNode(ctx.start.getLine());
    }
    @Override
    public ASTNode visitIn(BackParser.InContext ctx) {
        return new InOperatorNode(ctx.start.getLine());
    }
    @Override
    public ASTNode visitNotIn(BackParser.NotInContext ctx) {
        return new NotInOperatorNode(ctx.start.getLine());
    }
    @Override
    public ASTNode visitIs(BackParser.IsContext ctx) {
        return new IsOperatorNode(ctx.start.getLine());
    }
    @Override
    public ASTNode visitIsNot(BackParser.IsNotContext ctx) {
        return new IsNotOperatorNode(ctx.start.getLine());
    }

    @Override
    public ASTNode visitAtomExpression(BackParser.AtomExpressionContext ctx) {
        ASTNode atom = visit(ctx.atom());
        for (int i = 0; i < ctx.trailer().size(); i++) {
            atom = handleTrailer(atom,ctx.trailer(i));
        }
        return  atom;
    }

    @Override
    public ASTNode visitAdditiveExpression(BackParser.AdditiveExpressionContext ctx) {
        ExpressionNode left =(ExpressionNode) visit(ctx.expr(0));
        ExpressionNode right =(ExpressionNode) visit(ctx.expr(1));
        if (ctx.MINUS() != null){
            return new ArithmeticExpressionNode(ctx.start.getLine(),left,new MinusOperatorNode(ctx.start.getLine()),right);
        }else {
            return new ArithmeticExpressionNode(ctx.start.getLine(),left,new PlusOperatorNode(ctx.start.getLine()),right);
        }
    }

    private ASTNode handleTrailer(ASTNode currentAtom, BackParser.TrailerContext trailer) {
        int line = trailer.start.getLine();
        if (trailer instanceof BackParser.CallFunctionTrailerContext){
            ASTNode arguments = visit(trailer);
            return new CallExpressionNode(line,(ExpressionNode) currentAtom,(ArgumentsExpressionNode) arguments);
        }else if(trailer instanceof BackParser.AccessPropertyTrailerContext){
            return new AttributeExpressionNode(line,(ExpressionNode) currentAtom,((BackParser.AccessPropertyTrailerContext) trailer).NAME().getText());
        }else{
            ASTNode index = visit(trailer);
            return new IndexExpressionNode(line,(ExpressionNode) currentAtom,(ExpressionNode) index);
        }
    }
    @Override
    public ASTNode visitCallFunctionTrailer(BackParser.CallFunctionTrailerContext ctx) {
         if (ctx.arglist() != null){
             return visit(ctx.arglist());
         }
         return null;
    }
    @Override
    public ASTNode visitAccessIndexTrailer(BackParser.AccessIndexTrailerContext ctx) {
        return visit(ctx.test());
    }
    @Override
    public ASTNode visitTupleNode(BackParser.TupleNodeContext ctx) {
        List<ExpressionNode>list = new ArrayList<>();
        if (ctx.expression()!=null){
            for (int i = 0; i < ctx.expression().test().size(); i++) {
                list.add((ExpressionNode) visit(ctx.expression().test(i)));
            }
        }
        return new TupleExpressionNode(ctx.start.getLine(),list);
    }
    @Override
    public ASTNode visitListNode(BackParser.ListNodeContext ctx) {
        List<ExpressionNode>list = new ArrayList<>();
        if (ctx.expression()!=null){
            for (int i = 0; i < ctx.expression().test().size(); i++) {
                list.add((ExpressionNode) visit(ctx.expression().test(i)));
            }
        }
        return new ListExpressionNode(ctx.start.getLine(),list);
    }
    @Override
    public ASTNode visitDictionaryNode(BackParser.DictionaryNodeContext ctx) {
        if (ctx.dictmaker()==null){
            return new DictionaryExpressionNode(ctx.start.getLine(),new HashMap<>());
        }
        return visit(ctx.dictmaker());
    }
    @Override
    public ASTNode visitDictmaker(BackParser.DictmakerContext ctx) {
        Map<ExpressionNode, ExpressionNode> map = new HashMap<>();
        for (int i = 0; i < ctx.test().size(); i+=2) {
            ExpressionNode key =(ExpressionNode) visit(ctx.test(i));
            ExpressionNode value =(ExpressionNode) visit(ctx.test(i+1));
            map.put(key,value);
        }
        return new DictionaryExpressionNode(ctx.start.getLine(),map);
    }
    @Override
    public ExpressionNode visitArglist(BackParser.ArglistContext ctx) {
        List<ExpressionNode> arglist = new ArrayList<>();
        for (int i = 0; i < ctx.argument().size(); i++) {
            arglist.add((ExpressionNode) visit(ctx.argument(i)));
        }
        return new ArgumentsExpressionNode(ctx.start.getLine(), arglist);
    }
    @Override
    public ExpressionNode visitArgument(BackParser.ArgumentContext ctx) {
        if (ctx.ASSIGN() == null) {
            return (ExpressionNode) visit(ctx.test(0));
        }else {
            ExpressionNode value = (ExpressionNode) visit(ctx.test(1));
            List<ExpressionNode> targets = new ArrayList<>();
            targets.add((ExpressionNode) visit(ctx.test(0)));
            return new AssignmentStatement(ctx.start.getLine(),targets,value);
        }
    }
    @Override
    public AtomNode visitNumber(BackParser.NumberContext ctx) {
        if (ctx.NUMBER().getText().contains(".")){
            return new DoubleNumberAtomNode(ctx.start.getLine(),Double.parseDouble(ctx.NUMBER().getText()));
        }else {
            return new IntNumberAtomNode(ctx.start.getLine(),Integer.parseInt(ctx.NUMBER().getText()));
        }
    }
    @Override
    public ASTNode visitValueNode(BackParser.ValueNodeContext ctx) {
        return visit(ctx.value());
    }
    @Override
    public ASTNode visitBool(BackParser.BoolContext ctx) {
        return new BoolAtomNode(ctx.start.getLine(),Boolean.parseBoolean(ctx.getChild(0).getText()));
    }
    @Override
    public ASTNode visitNone(BackParser.NoneContext ctx) {
        return new NoneAtomNode(ctx.start.getLine());
    }
    @Override
    public ASTNode visitName(BackParser.NameContext ctx) {
        return new NameAtomNode(ctx.start.getLine(),ctx.NAME().getText());
    }
    @Override
    public ASTNode visitString(BackParser.StringContext ctx) {
        String value = ctx.STRING().getText();
        value =  value.substring(1,value.length()-1);
        return new StringAtomNode(ctx.start.getLine(),value);
    }
    @Override
    public ASTNode visitImportNameNode(BackParser.ImportNameNodeContext ctx) {
        return visit(ctx.import_name());
    }
    @Override
    public ASTNode visitImport_name(BackParser.Import_nameContext ctx) {
        List<DottedAsNameNode>dottedAsNames = new ArrayList<>();
        for (int i = 0; i < ctx.dotted_as_name().size(); i++) {
            dottedAsNames.add((DottedAsNameNode) visit(ctx.dotted_as_name(i)));
        }
        return new ImportNameNode(ctx.start.getLine(),dottedAsNames);
    }
    @Override
    public ASTNode visitDotted_as_name(BackParser.Dotted_as_nameContext ctx) {
        DottedNameNode dottedNameNode =(DottedNameNode) visit(ctx.dotted_name());
        String alias=ctx.NAME() == null ? null : ctx.NAME().toString();
        return new DottedAsNameNode(ctx.start.getLine(),dottedNameNode,alias);
    }
    @Override
    public ASTNode visitDotted_name(BackParser.Dotted_nameContext ctx) {
        List<String> parts=new ArrayList<>();
        for (int i = 0; i < ctx.NAME().size(); i++) {
            parts.add(ctx.NAME().get(i).toString());
        }
        return new DottedNameNode(ctx.start.getLine(),parts);
    }
    @Override
    public ASTNode visitImportFromNode(BackParser.ImportFromNodeContext ctx) {
        return visit(ctx.import_from());
    }
    @Override
    public ASTNode visitImport_from(BackParser.Import_fromContext ctx) {
        DottedNameNode dottedName =(DottedNameNode) visit(ctx.dotted_name());
        ImportAsNamesNode importNode =(ImportAsNamesNode) visit(ctx.import_as_names());
        return new ImportFromNode(ctx.start.getLine(),dottedName,importNode);
    }
    @Override
    public ASTNode visitImport_as_name(BackParser.Import_as_nameContext ctx) {
        ImportNode importNode;
        if (ctx.NAME().size() == 1){
            importNode =new ImportAsNameNode(ctx.start.getLine(),ctx.NAME(0).toString(),null);
        }else {
            importNode =new ImportAsNameNode(ctx.start.getLine(),ctx.NAME(0).toString(),ctx.NAME(1).toString());
        }
        return importNode;
    }
    @Override
    public ASTNode visitImport_as_names(BackParser.Import_as_namesContext ctx) {
        List<ImportAsNameNode>importNodes = new ArrayList<>();
        for (int i = 0; i < ctx.import_as_name().size(); i++) {
            importNodes.add((ImportAsNameNode) visit(ctx.import_as_name(i)));
        }
        return new ImportAsNamesNode(ctx.start.getLine(),importNodes);
    }
    @Override
    public ASTNode visitFlowStatementNode(BackParser.FlowStatementNodeContext ctx) {
        return visit(ctx.flow_statement());
    }
    @Override
    public ASTNode visitReturnStatementNode(BackParser.ReturnStatementNodeContext ctx) {
        return visit(ctx.return_statement());
    }

    @Override
    public ASTNode visitRaiseStatementNode(BackParser.RaiseStatementNodeContext ctx) {
        return visit(ctx.raise_statement());
    }

    @Override
    public ASTNode visitReturn_statement(BackParser.Return_statementContext ctx) {
        return new ReturnStatementNode(ctx.start.getLine(),(ExpressionNode) visit(ctx.expression()));
    }
    @Override
    public ASTNode visitRaise_statement(BackParser.Raise_statementContext ctx) {
        ExpressionNode before = null,after = null;
        if (ctx.test() != null) {
            before = (ExpressionNode) visit(ctx.test(0));
            if (ctx.test().size()==2){
                after =(ExpressionNode) visit(ctx.test(1));
            }
        }
        return new RaiseStatementNode(ctx.start.getLine(),before,after);
    }
    @Override
    public ASTNode visitCompoundStatementsNode(BackParser.CompoundStatementsNodeContext ctx) {
        return visit(ctx.compound_statements());
    }
    @Override
    public ASTNode visitIfStatementNode(BackParser.IfStatementNodeContext ctx) {
        return visit(ctx.if_statement());
    }
    @Override
    public ASTNode visitIf_statement(BackParser.If_statementContext ctx) {
        ExpressionNode ifCondition = (ExpressionNode) visit(ctx.test(0));
        BlockNode ifBlock =(BlockNode) visit(ctx.block(0));
        List<IfStatementNode.ElseIf>elseIfs = new ArrayList<>();
        for (int i = 0; i < ctx.ELIF().size(); i++) {
            ExpressionNode elseIfCondition = (ExpressionNode) visit(ctx.test(i+1));
            BlockNode elseIfBlock =(BlockNode) visit(ctx.block(i+1));
            elseIfs.add(new IfStatementNode.ElseIf(ctx.test(i+1).start.getLine(),elseIfCondition,elseIfBlock));
        }
        IfStatementNode.Else elseBody=null;
        if (ctx.ELSE() != null) {
            elseBody = new IfStatementNode.Else(ctx.block(ctx.block().size() - 1).start.getLine(),(BlockNode) visit(ctx.block(ctx.block().size() - 1)));
        }
        return new IfStatementNode(ctx.start.getLine(),ifCondition,ifBlock,elseIfs,elseBody);
    }

    @Override
    public ASTNode visitForStatementNode(BackParser.ForStatementNodeContext ctx) {
        return visit(ctx.for_statement());
    }
    @Override
    public ASTNode visitFor_statement(BackParser.For_statementContext ctx) {
        List<ExpressionNode>params = new ArrayList<>();
        for (int i = 0; i < ctx.exprlist().expr().size(); i++) {
            ExpressionNode parsmNode = (ExpressionNode) visit((ctx.exprlist().expr(i)));
            params.add(parsmNode);
        }
        ExpressionNode expression = (ExpressionNode) visit(ctx.expression());
        BlockNode body =(BlockNode)  visit(ctx.block(0));
        ForStatementNode.Else elseBody = null;
        if (ctx.ELSE() != null) {
            elseBody = new ForStatementNode.Else(ctx.block(1).start.getLine(),(BlockNode) visit(ctx.block(1)));
        }
        return new ForStatementNode(ctx.start.getLine(),expression,params,body,elseBody);
    }
    @Override
    public ASTNode visitTryStatementNode(BackParser.TryStatementNodeContext ctx) {
        return visit(ctx.try_statement());
    }
    @Override
    public ASTNode visitTry_statement(BackParser.Try_statementContext ctx) {
        BlockNode body = (BlockNode) visit(ctx.block(0));
        List<TryStatementNode.Except>excepts = new ArrayList<>();
        for (int i = 1; i < ctx.block().size(); i++) {
            BlockNode exceptBody = (BlockNode) visit(ctx.block(i));
            ExpressionNode expression = null;
            if ((i < ctx.block().size()-1) || (i == ctx.block().size()-1 && ctx.test(i-1) != null)) {
                expression =(ExpressionNode) visit(ctx.test(i-1));
            }
            excepts.add(new TryStatementNode.Except(ctx.start.getLine(),expression,exceptBody));
        }
        return new TryStatementNode(ctx.start.getLine(),body,excepts);
    }
    @Override
    public ASTNode visitFundefStatementNode(BackParser.FundefStatementNodeContext ctx) {
        return visit(ctx.funcdef());
    }
    @Override
    public ASTNode visitFuncdef(BackParser.FuncdefContext ctx) {
        NameAtomNode name = new NameAtomNode(ctx.start.getLine(),ctx.NAME().getText());
        ArgumentsExpressionNode params = (ArgumentsExpressionNode) visit(ctx.parameters());
        BlockNode body =(BlockNode) visit(ctx.block());
        return new FunctionDefNode(ctx.start.getLine(),name,params,body);
    }

    @Override
    public ASTNode visitParameters(BackParser.ParametersContext ctx) {
        if (ctx.arglist() !=null) {
            return visit(ctx.arglist());
        }else {
            return null;
        }
    }

    @Override
    public ASTNode visitSimpleStatementsBlockNode(BackParser.SimpleStatementsBlockNodeContext ctx) {
        List<ASTNode> statements=new ArrayList<>();
        statements.add(visit(ctx.simple_statements()));
        return new BlockNode(ctx.start.getLine(),statements);
    }
    @Override
    public ASTNode visitStatementBlockNode(BackParser.StatementBlockNodeContext ctx) {
        List<ASTNode> statements=new ArrayList<>();
        for (int i = 0; i < ctx.statements().size(); i++) {
            statements.add(visit(ctx.statements(i)));
        }
        return new BlockNode(ctx.start.getLine(),statements);
    }

    @Override
    public ASTNode visitSimpleStatements1Node(BackParser.SimpleStatements1NodeContext ctx) {
        return visit(ctx.simple_statements());
    }
    @Override
    public ASTNode visitCompoundStatements1Node(BackParser.CompoundStatements1NodeContext ctx) {
        return visit(ctx.compound_statements());
    }
    @Override
    public ASTNode visitDecorated(BackParser.DecoratedContext ctx) {
        List<DecoratorNode.Decorate>decorators = new ArrayList<>();
        for (int i = 0; i < ctx.decorator().size(); i++) {
            decorators.add((DecoratorNode.Decorate) visit(ctx.decorator(i)));
        }
        FunctionDefNode function = (FunctionDefNode) visit(ctx.funcdef());
        DecoratorNode.Decorate d = decorators.get(0);
        if (!d.pathParameters.isEmpty()){
            if (function.parameters==null){
                throw new RuntimeException("Type error : some path parameters must exist for the function as parameters at line : "+function.line);
            } else  {
                if (function.parameters.arguments.size() == d.pathParameters.size()){
                    for (int i = 0; i < d.pathParameters.size(); i++) {
                        ExpressionNode n = function.parameters.arguments.get(i);
                        if (n instanceof  NameAtomNode) {
                            if (!(d.pathParameters.get(i).equals(((NameAtomNode) n).value))) {
                                throw new RuntimeException("Type error : function parameters must be as the same as function parameters");
                            }
                        }
                    }
                }else {
                    throw new RuntimeException("Type error : some path parameters must exist for the function as parameters at line : "+function.line);
                }
            }
        }
        return new DecoratorNode(ctx.start.getLine(),decorators,function);
    }
    private List<String> pathParams(String path){
        List<String>pps =new ArrayList<>();
        int count = (int) path.chars().filter(ch -> ch == '<').count();
        String sub = path;
        for (int i = 0; i < count; i++) {
            String param = sub.substring(sub.indexOf('<')+1,sub.indexOf('>'));
           int colon =  param.indexOf(':');
           param = colon > 0 ?param.substring(colon+1):param;
           pps.add(param);
           sub = sub.substring(sub.indexOf('>')+1);
        }
        return pps;
    }
    @Override
    public ASTNode visitDecorator(BackParser.DecoratorContext ctx) {
        DottedNameNode dottedName =(DottedNameNode) visit(ctx.dotted_name());

        ArgumentsExpressionNode arguments = null;
        if (ctx.arglist() != null){
            arguments =(ArgumentsExpressionNode) visit(ctx.arglist());
        }
        List<String>pathParams = new ArrayList<>();
        if (arguments != null){
           ExpressionNode node =  arguments.arguments.get(0);
           if (node instanceof StringAtomNode){
               pathParams =  pathParams(((StringAtomNode) node).value);
           }
        }
        return new DecoratorNode.Decorate(ctx.start.getLine(),dottedName,pathParams,arguments);
    }

    @Override
    public ASTNode visitDecoratedNode(BackParser.DecoratedNodeContext ctx) {
        return visit(ctx.decorated());
    }

}
