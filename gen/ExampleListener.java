// Generated from C:/Users/Lenovo/IdeaProjects/Antlr/src/main/antlr4/Example.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExampleParser}.
 */
public interface ExampleListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ExampleParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(ExampleParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExampleParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(ExampleParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExampleParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(ExampleParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExampleParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(ExampleParser.ExprContext ctx);
}