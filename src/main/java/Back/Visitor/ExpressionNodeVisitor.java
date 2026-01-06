package Back.Visitor;

import Back.AST.ExpressionStatement.*;
import Back.AST.ExpressionStatement.Operators.AndOperatorNode;
import Back.AST.ExpressionStatement.Operators.NotOperatorNode;
import Back.AST.ExpressionStatement.Operators.OperatorNode;
import Back.AST.ExpressionStatement.Operators.OrOperatorNode;
import BackLang.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpressionNodeVisitor extends BackParserBaseVisitor<ExpressionNode> {
    @Override
    public ExpressionNode visitExpression_statement(BackParser.Expression_statementContext ctx) {
        if (ctx.ASSIGN().isEmpty()){
            return visit(ctx.expression(0));
        }else {
            ExpressionNode left = visit(ctx.expression(0));
            List<ExpressionNode> right = new ArrayList<>();
            for (int i = 0; i < ctx.ASSIGN().size(); i++) {
                right.add( visit(ctx.expression(i+1)));
            }
            return new AssignmentStatement(ctx.start.getLine(),right,left);
        }
    }

    @Override
    public ExpressionNode visitExpression(BackParser.ExpressionContext ctx) {
        if (ctx.COMMA().isEmpty()){
            return visit(ctx.test(0));
        }
        List<ExpressionNode>list = new ArrayList<>();
        for (int i = 0; i < ctx.test().size(); i++) {
            list.add(visit(ctx.test(i)));
        }
        return new ListExpressionNode(ctx.start.getLine(),list);
    }

    @Override
    public ExpressionNode visitTest(BackParser.TestContext ctx) {
        ExpressionNode left = visit(ctx.and_test(0));
        if (ctx.OR().isEmpty()){
            return left;
        }
        List<OperatorNode>ops = new ArrayList<>();
        List<ExpressionNode>list = new ArrayList<>();
        for (int i = 0; i < ctx.OR().size(); i++) {

            ops.add(new OrOperatorNode(ctx.start.getLine()));
            list.add(visit(ctx.and_test(i+1)));
        }
        return new BinaryExpressionNode(ctx.start.getLine(),left,list,ops);
    }

    @Override
    public ExpressionNode visitAnd_test(BackParser.And_testContext ctx) {
        ExpressionNode left = visit(ctx.not_test(0));
        if (ctx.AND().isEmpty()){
            return left;
        }
        List<OperatorNode>ops = new ArrayList<>();
        List<ExpressionNode>list = new ArrayList<>();
        for (int i = 0; i < ctx.AND().size(); i++) {
            ops.add(new AndOperatorNode(ctx.start.getLine()));
            list.add(visit(ctx.not_test(i+1)));
        }
        return new BinaryExpressionNode(ctx.start.getLine(),left,list,ops);
    }

    @Override
    public ExpressionNode visitNot_test(BackParser.Not_testContext ctx) {
        if (ctx.NOT()==null){
            return visit(ctx.comparison());
        }
        ExpressionNode node = visit(ctx.not_test());
        return new UnaryExpressionNode(ctx.start.getLine(),new NotOperatorNode(ctx.start.getLine()),node);
    }

    @Override
    public ExpressionNode visitComparison(BackParser.ComparisonContext ctx) {
        ExpressionNode left = visit(ctx.expr(0));
        if (ctx.comp_op().isEmpty()){
            return left;
        }
        List<OperatorNode>ops = new ArrayList<>();
        List<ExpressionNode>list = new ArrayList<>();
        for (int i = 0; i < ctx.comp_op().size(); i++) {
            ops.add(new OperatorVisitor().visit((ctx.comp_op(i))));
            list.add(visit(ctx.expr(i+1)));
        }
        return new CompareExpressionNode(ctx.start.getLine(),left,ops,list);
    }



    @Override
    public ExpressionNode visitExpr(BackParser.ExprContext ctx) {
        ExpressionNode currentAtom = visit((ctx.atom()));
       for (BackParser.TrailerContext trailer: ctx.trailer()){
            currentAtom = handleTrailer(currentAtom,trailer);
        }
        return  currentAtom;
    }

    private ExpressionNode handleTrailer(ExpressionNode currentAtom,BackParser.TrailerContext ctx) {
        int line = ctx.start.getLine();
        if (ctx.OPEN_PAREN()!=null){
            ExpressionNode args = null;
            if (ctx.arglist()!=null){
                args = visit(ctx.arglist());
            }
            return new CallExpressionNode(line,currentAtom,args);
        }
        if (ctx.DOT() != null) {
            return new AttributeExpressionNode(
                    line,
                    currentAtom,
                    ctx.NAME().getText()
            );
        }
        return new IndexExpressionNode(
                line,
                currentAtom,
                visit(ctx.test())
        );
    }

    @Override
    public ExpressionNode visitAtom(BackParser.AtomContext ctx) {
        if (ctx.OPEN_PAREN()!=null){
            List<ExpressionNode>list = new ArrayList<>();
            if (ctx.expression()!=null){
                for (int i = 0; i < ctx.expression().test().size(); i++) {
                    list.add(visit(ctx.expression().test(i)));
                }
            }
            return new TupleExpressionNode(ctx.start.getLine(),list);
        }else if (ctx.OPEN_BRACK()!=null){
            List<ExpressionNode>list = new ArrayList<>();
            if (ctx.expression()!=null){
                for (int i = 0; i < ctx.expression().test().size(); i++) {
                    list.add(visit(ctx.expression().test(i)));
                }
            }
        return new ListExpressionNode(ctx.start.getLine(),list);
        } else if (ctx.OPEN_BRACE()!=null) {
            if (ctx.dictmaker()==null){
                return new DictionaryExpressionNode(ctx.start.getLine(),new HashMap<>());
            }
            return visit(ctx.dictmaker());
        } else {
         return (new AtomVisitor()).visit(ctx);
        }
    }


    @Override
    public ExpressionNode visitDictmaker(BackParser.DictmakerContext ctx) {
        Map<ExpressionNode, ExpressionNode> map = new HashMap<>();
            for (int i = 0; i < ctx.COLON().size(); i++) {
                ExpressionNode key = visit(ctx.test(i));
                ExpressionNode value = visit(ctx.test(i+1));
                map.put(key,value);
            }
        return new DictionaryExpressionNode(ctx.start.getLine(),map);
    }


    @Override
    public ExpressionNode visitArglist(BackParser.ArglistContext ctx) {
        List<ExpressionNode> arglist = new ArrayList<>();
        for (int i = 0; i < ctx.argument().size(); i++) {
            arglist.add(visit(ctx.argument(i)));
        }
        return new ArgumentsExpressionNode(ctx.start.getLine(), arglist);
    }

    @Override
    public ExpressionNode visitArgument(BackParser.ArgumentContext ctx) {
        ExpressionNode left = visit(ctx.test(0));
        List<ExpressionNode> right = new ArrayList<>();
        if (ctx.ASSIGN()!=null){
            right.add(visit((ctx.test(1))));
            return new AssignmentStatement(ctx.start.getLine(),right,left);
        }
        return left;
    }
}
