package Front.Visitor;
import Front.AST.Html.ExpressionStatement.*;
import Front.AST.Html.ExpressionStatement.Operators.*;
import FrontLang.FrontParser;
import FrontLang.FrontParserBaseVisitor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpressionNodeVisitor extends FrontParserBaseVisitor<ExpressionNode> {
    @Override
    public ExpressionNode visitExpression(FrontParser.ExpressionContext ctx) {
        ExpressionNode left = visit(ctx.andExpression(0));
        if (ctx.OR().isEmpty()){
            return left;
        }
        List<OperatorNode>ops = new ArrayList<>();
        List<ExpressionNode>list = new ArrayList<>();
        for (int i = 0; i < ctx.OR().size(); i++) {
            ops.add(new OrOperatorNode(ctx.start.getLine()));
            list.add(visit(ctx.andExpression(i+1)));
        }
        return new BinaryExpressionNode(ctx.start.getLine(),left,list,ops);
    }

    @Override
    public ExpressionNode visitAndExpression(FrontParser.AndExpressionContext ctx) {
        ExpressionNode left = visit(ctx.notExpression(0));
        if (ctx.AND().isEmpty()){
            return left;
        }
        List<OperatorNode>ops = new ArrayList<>();
        List<ExpressionNode>list = new ArrayList<>();
        for (int i = 0; i < ctx.AND().size(); i++) {
            ops.add(new AndOperatorNode(ctx.start.getLine()));
            list.add(visit(ctx.notExpression(i+1)));
        }
        return new BinaryExpressionNode(ctx.start.getLine(),left,list,ops);
    }

    @Override
    public ExpressionNode visitNotExpression(FrontParser.NotExpressionContext ctx) {
        if (ctx.NOT()==null){
            return visit(ctx.comparison());
        }
        ExpressionNode node = visit(ctx.notExpression());
        return new UnaryExpressionNode(ctx.start.getLine(),new NotOperatorNode(ctx.start.getLine()),node);
    }

    @Override
    public ExpressionNode visitComparison(FrontParser.ComparisonContext ctx) {
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
    public ExpressionNode visitExpr(FrontParser.ExprContext ctx) {
        ExpressionNode currentAtom = new AtomVisitor().visit(ctx.atom());
       for (FrontParser.TrailerContext trailer: ctx.trailer()){
            currentAtom = handleTrailer(currentAtom,trailer);
        }
        return  currentAtom;
    }

    private ExpressionNode handleTrailer(ExpressionNode currentAtom,FrontParser.TrailerContext ctx) {
        int line = ctx.start.getLine();
        if (ctx.JINJA_OPEN_PARE()!=null){
            List<ExpressionNode> args = new ArrayList<>();
            if (ctx.expression()!=null){
                for (int i = 0; i < ctx.expression().size(); i++) {
                    args.add(visit(ctx.expression(i)));
                }
            }
            return new CallExpressionNode(line,currentAtom,args);
        }
        if (ctx.DOT() != null) {
            return new AttributeExpressionNode(
                    line,
                    currentAtom,
                    ctx.JINJA_IDENT().getText()
            );
        }
        return new IndexExpressionNode(
                line,
                currentAtom,
                visit(ctx.expression(0))
        );
    }








}
