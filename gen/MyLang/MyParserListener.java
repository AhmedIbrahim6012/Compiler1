// Generated from H:/Compiler Projects/NewCompiler/src/main/antlr4/MyParser.g4 by ANTLR 4.13.2
package MyLang;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MyParser}.
 */
public interface MyParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MyParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(MyParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(MyParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#statements}.
	 * @param ctx the parse tree
	 */
	void enterStatements(MyParser.StatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#statements}.
	 * @param ctx the parse tree
	 */
	void exitStatements(MyParser.StatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#simple_statements}.
	 * @param ctx the parse tree
	 */
	void enterSimple_statements(MyParser.Simple_statementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#simple_statements}.
	 * @param ctx the parse tree
	 */
	void exitSimple_statements(MyParser.Simple_statementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#simple_statement}.
	 * @param ctx the parse tree
	 */
	void enterSimple_statement(MyParser.Simple_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#simple_statement}.
	 * @param ctx the parse tree
	 */
	void exitSimple_statement(MyParser.Simple_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#decorated}.
	 * @param ctx the parse tree
	 */
	void enterDecorated(MyParser.DecoratedContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#decorated}.
	 * @param ctx the parse tree
	 */
	void exitDecorated(MyParser.DecoratedContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#decorator}.
	 * @param ctx the parse tree
	 */
	void enterDecorator(MyParser.DecoratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#decorator}.
	 * @param ctx the parse tree
	 */
	void exitDecorator(MyParser.DecoratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#funcdef}.
	 * @param ctx the parse tree
	 */
	void enterFuncdef(MyParser.FuncdefContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#funcdef}.
	 * @param ctx the parse tree
	 */
	void exitFuncdef(MyParser.FuncdefContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#parameters}.
	 * @param ctx the parse tree
	 */
	void enterParameters(MyParser.ParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#parameters}.
	 * @param ctx the parse tree
	 */
	void exitParameters(MyParser.ParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#paramlist}.
	 * @param ctx the parse tree
	 */
	void enterParamlist(MyParser.ParamlistContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#paramlist}.
	 * @param ctx the parse tree
	 */
	void exitParamlist(MyParser.ParamlistContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(MyParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(MyParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#flow_statement}.
	 * @param ctx the parse tree
	 */
	void enterFlow_statement(MyParser.Flow_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#flow_statement}.
	 * @param ctx the parse tree
	 */
	void exitFlow_statement(MyParser.Flow_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#return_statement}.
	 * @param ctx the parse tree
	 */
	void enterReturn_statement(MyParser.Return_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#return_statement}.
	 * @param ctx the parse tree
	 */
	void exitReturn_statement(MyParser.Return_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#raise_statement}.
	 * @param ctx the parse tree
	 */
	void enterRaise_statement(MyParser.Raise_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#raise_statement}.
	 * @param ctx the parse tree
	 */
	void exitRaise_statement(MyParser.Raise_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#compound_statements}.
	 * @param ctx the parse tree
	 */
	void enterCompound_statements(MyParser.Compound_statementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#compound_statements}.
	 * @param ctx the parse tree
	 */
	void exitCompound_statements(MyParser.Compound_statementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void enterIf_statement(MyParser.If_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void exitIf_statement(MyParser.If_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#try_statement}.
	 * @param ctx the parse tree
	 */
	void enterTry_statement(MyParser.Try_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#try_statement}.
	 * @param ctx the parse tree
	 */
	void exitTry_statement(MyParser.Try_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#for_statement}.
	 * @param ctx the parse tree
	 */
	void enterFor_statement(MyParser.For_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#for_statement}.
	 * @param ctx the parse tree
	 */
	void exitFor_statement(MyParser.For_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#exprlist}.
	 * @param ctx the parse tree
	 */
	void enterExprlist(MyParser.ExprlistContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#exprlist}.
	 * @param ctx the parse tree
	 */
	void exitExprlist(MyParser.ExprlistContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#import_statement}.
	 * @param ctx the parse tree
	 */
	void enterImport_statement(MyParser.Import_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#import_statement}.
	 * @param ctx the parse tree
	 */
	void exitImport_statement(MyParser.Import_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#import_from}.
	 * @param ctx the parse tree
	 */
	void enterImport_from(MyParser.Import_fromContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#import_from}.
	 * @param ctx the parse tree
	 */
	void exitImport_from(MyParser.Import_fromContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#import_as_names}.
	 * @param ctx the parse tree
	 */
	void enterImport_as_names(MyParser.Import_as_namesContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#import_as_names}.
	 * @param ctx the parse tree
	 */
	void exitImport_as_names(MyParser.Import_as_namesContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#import_as_name}.
	 * @param ctx the parse tree
	 */
	void enterImport_as_name(MyParser.Import_as_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#import_as_name}.
	 * @param ctx the parse tree
	 */
	void exitImport_as_name(MyParser.Import_as_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#import_name}.
	 * @param ctx the parse tree
	 */
	void enterImport_name(MyParser.Import_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#import_name}.
	 * @param ctx the parse tree
	 */
	void exitImport_name(MyParser.Import_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#dotted_as_name}.
	 * @param ctx the parse tree
	 */
	void enterDotted_as_name(MyParser.Dotted_as_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#dotted_as_name}.
	 * @param ctx the parse tree
	 */
	void exitDotted_as_name(MyParser.Dotted_as_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#dotted_name}.
	 * @param ctx the parse tree
	 */
	void enterDotted_name(MyParser.Dotted_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#dotted_name}.
	 * @param ctx the parse tree
	 */
	void exitDotted_name(MyParser.Dotted_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#expression_statement}.
	 * @param ctx the parse tree
	 */
	void enterExpression_statement(MyParser.Expression_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#expression_statement}.
	 * @param ctx the parse tree
	 */
	void exitExpression_statement(MyParser.Expression_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(MyParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(MyParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#test}.
	 * @param ctx the parse tree
	 */
	void enterTest(MyParser.TestContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#test}.
	 * @param ctx the parse tree
	 */
	void exitTest(MyParser.TestContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#and_test}.
	 * @param ctx the parse tree
	 */
	void enterAnd_test(MyParser.And_testContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#and_test}.
	 * @param ctx the parse tree
	 */
	void exitAnd_test(MyParser.And_testContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#not_test}.
	 * @param ctx the parse tree
	 */
	void enterNot_test(MyParser.Not_testContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#not_test}.
	 * @param ctx the parse tree
	 */
	void exitNot_test(MyParser.Not_testContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#comparison}.
	 * @param ctx the parse tree
	 */
	void enterComparison(MyParser.ComparisonContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#comparison}.
	 * @param ctx the parse tree
	 */
	void exitComparison(MyParser.ComparisonContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LessThan}
	 * labeled alternative in {@link MyParser#comp_op}.
	 * @param ctx the parse tree
	 */
	void enterLessThan(MyParser.LessThanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LessThan}
	 * labeled alternative in {@link MyParser#comp_op}.
	 * @param ctx the parse tree
	 */
	void exitLessThan(MyParser.LessThanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GreaterThan}
	 * labeled alternative in {@link MyParser#comp_op}.
	 * @param ctx the parse tree
	 */
	void enterGreaterThan(MyParser.GreaterThanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GreaterThan}
	 * labeled alternative in {@link MyParser#comp_op}.
	 * @param ctx the parse tree
	 */
	void exitGreaterThan(MyParser.GreaterThanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Equal}
	 * labeled alternative in {@link MyParser#comp_op}.
	 * @param ctx the parse tree
	 */
	void enterEqual(MyParser.EqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Equal}
	 * labeled alternative in {@link MyParser#comp_op}.
	 * @param ctx the parse tree
	 */
	void exitEqual(MyParser.EqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GreaterThanOrEqual}
	 * labeled alternative in {@link MyParser#comp_op}.
	 * @param ctx the parse tree
	 */
	void enterGreaterThanOrEqual(MyParser.GreaterThanOrEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GreaterThanOrEqual}
	 * labeled alternative in {@link MyParser#comp_op}.
	 * @param ctx the parse tree
	 */
	void exitGreaterThanOrEqual(MyParser.GreaterThanOrEqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LessThanOrEqual}
	 * labeled alternative in {@link MyParser#comp_op}.
	 * @param ctx the parse tree
	 */
	void enterLessThanOrEqual(MyParser.LessThanOrEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LessThanOrEqual}
	 * labeled alternative in {@link MyParser#comp_op}.
	 * @param ctx the parse tree
	 */
	void exitLessThanOrEqual(MyParser.LessThanOrEqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NotEqual}
	 * labeled alternative in {@link MyParser#comp_op}.
	 * @param ctx the parse tree
	 */
	void enterNotEqual(MyParser.NotEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NotEqual}
	 * labeled alternative in {@link MyParser#comp_op}.
	 * @param ctx the parse tree
	 */
	void exitNotEqual(MyParser.NotEqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code In}
	 * labeled alternative in {@link MyParser#comp_op}.
	 * @param ctx the parse tree
	 */
	void enterIn(MyParser.InContext ctx);
	/**
	 * Exit a parse tree produced by the {@code In}
	 * labeled alternative in {@link MyParser#comp_op}.
	 * @param ctx the parse tree
	 */
	void exitIn(MyParser.InContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NotIn}
	 * labeled alternative in {@link MyParser#comp_op}.
	 * @param ctx the parse tree
	 */
	void enterNotIn(MyParser.NotInContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NotIn}
	 * labeled alternative in {@link MyParser#comp_op}.
	 * @param ctx the parse tree
	 */
	void exitNotIn(MyParser.NotInContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Is}
	 * labeled alternative in {@link MyParser#comp_op}.
	 * @param ctx the parse tree
	 */
	void enterIs(MyParser.IsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Is}
	 * labeled alternative in {@link MyParser#comp_op}.
	 * @param ctx the parse tree
	 */
	void exitIs(MyParser.IsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IsNot}
	 * labeled alternative in {@link MyParser#comp_op}.
	 * @param ctx the parse tree
	 */
	void enterIsNot(MyParser.IsNotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IsNot}
	 * labeled alternative in {@link MyParser#comp_op}.
	 * @param ctx the parse tree
	 */
	void exitIsNot(MyParser.IsNotContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(MyParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(MyParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(MyParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(MyParser.AtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Number}
	 * labeled alternative in {@link MyParser#value}.
	 * @param ctx the parse tree
	 */
	void enterNumber(MyParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Number}
	 * labeled alternative in {@link MyParser#value}.
	 * @param ctx the parse tree
	 */
	void exitNumber(MyParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Name}
	 * labeled alternative in {@link MyParser#value}.
	 * @param ctx the parse tree
	 */
	void enterName(MyParser.NameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Name}
	 * labeled alternative in {@link MyParser#value}.
	 * @param ctx the parse tree
	 */
	void exitName(MyParser.NameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code String}
	 * labeled alternative in {@link MyParser#value}.
	 * @param ctx the parse tree
	 */
	void enterString(MyParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code String}
	 * labeled alternative in {@link MyParser#value}.
	 * @param ctx the parse tree
	 */
	void exitString(MyParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code None}
	 * labeled alternative in {@link MyParser#value}.
	 * @param ctx the parse tree
	 */
	void enterNone(MyParser.NoneContext ctx);
	/**
	 * Exit a parse tree produced by the {@code None}
	 * labeled alternative in {@link MyParser#value}.
	 * @param ctx the parse tree
	 */
	void exitNone(MyParser.NoneContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Bool}
	 * labeled alternative in {@link MyParser#value}.
	 * @param ctx the parse tree
	 */
	void enterBool(MyParser.BoolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Bool}
	 * labeled alternative in {@link MyParser#value}.
	 * @param ctx the parse tree
	 */
	void exitBool(MyParser.BoolContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#dictmaker}.
	 * @param ctx the parse tree
	 */
	void enterDictmaker(MyParser.DictmakerContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#dictmaker}.
	 * @param ctx the parse tree
	 */
	void exitDictmaker(MyParser.DictmakerContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#trailer}.
	 * @param ctx the parse tree
	 */
	void enterTrailer(MyParser.TrailerContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#trailer}.
	 * @param ctx the parse tree
	 */
	void exitTrailer(MyParser.TrailerContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#arglist}.
	 * @param ctx the parse tree
	 */
	void enterArglist(MyParser.ArglistContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#arglist}.
	 * @param ctx the parse tree
	 */
	void exitArglist(MyParser.ArglistContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#argument}.
	 * @param ctx the parse tree
	 */
	void enterArgument(MyParser.ArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#argument}.
	 * @param ctx the parse tree
	 */
	void exitArgument(MyParser.ArgumentContext ctx);
}