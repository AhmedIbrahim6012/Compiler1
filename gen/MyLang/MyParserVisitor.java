// Generated from H:/Compiler Projects/NewCompiler/src/main/antlr4/MyParser.g4 by ANTLR 4.13.2
package MyLang;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MyParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MyParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MyParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(MyParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatements(MyParser.StatementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#simple_statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimple_statements(MyParser.Simple_statementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#simple_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimple_statement(MyParser.Simple_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#decorated}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecorated(MyParser.DecoratedContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#decorator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecorator(MyParser.DecoratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#funcdef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncdef(MyParser.FuncdefContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameters(MyParser.ParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#paramlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamlist(MyParser.ParamlistContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(MyParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#flow_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlow_statement(MyParser.Flow_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#return_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn_statement(MyParser.Return_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#raise_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRaise_statement(MyParser.Raise_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#compound_statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompound_statements(MyParser.Compound_statementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#if_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_statement(MyParser.If_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#try_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTry_statement(MyParser.Try_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#for_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_statement(MyParser.For_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#exprlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprlist(MyParser.ExprlistContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#import_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImport_statement(MyParser.Import_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#import_from}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImport_from(MyParser.Import_fromContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#import_as_names}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImport_as_names(MyParser.Import_as_namesContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#import_as_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImport_as_name(MyParser.Import_as_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#import_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImport_name(MyParser.Import_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#dotted_as_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDotted_as_name(MyParser.Dotted_as_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#dotted_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDotted_name(MyParser.Dotted_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#expression_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression_statement(MyParser.Expression_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(MyParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#test}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTest(MyParser.TestContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#and_test}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd_test(MyParser.And_testContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#not_test}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNot_test(MyParser.Not_testContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#comparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison(MyParser.ComparisonContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LessThan}
	 * labeled alternative in {@link MyParser#comp_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLessThan(MyParser.LessThanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GreaterThan}
	 * labeled alternative in {@link MyParser#comp_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreaterThan(MyParser.GreaterThanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Equal}
	 * labeled alternative in {@link MyParser#comp_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqual(MyParser.EqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GreaterThanOrEqual}
	 * labeled alternative in {@link MyParser#comp_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreaterThanOrEqual(MyParser.GreaterThanOrEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LessThanOrEqual}
	 * labeled alternative in {@link MyParser#comp_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLessThanOrEqual(MyParser.LessThanOrEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NotEqual}
	 * labeled alternative in {@link MyParser#comp_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotEqual(MyParser.NotEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code In}
	 * labeled alternative in {@link MyParser#comp_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIn(MyParser.InContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NotIn}
	 * labeled alternative in {@link MyParser#comp_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotIn(MyParser.NotInContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Is}
	 * labeled alternative in {@link MyParser#comp_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIs(MyParser.IsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IsNot}
	 * labeled alternative in {@link MyParser#comp_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsNot(MyParser.IsNotContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(MyParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(MyParser.AtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Number}
	 * labeled alternative in {@link MyParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(MyParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Name}
	 * labeled alternative in {@link MyParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitName(MyParser.NameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code String}
	 * labeled alternative in {@link MyParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(MyParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code None}
	 * labeled alternative in {@link MyParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNone(MyParser.NoneContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Bool}
	 * labeled alternative in {@link MyParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool(MyParser.BoolContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#dictmaker}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDictmaker(MyParser.DictmakerContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#trailer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrailer(MyParser.TrailerContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#arglist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArglist(MyParser.ArglistContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgument(MyParser.ArgumentContext ctx);
}