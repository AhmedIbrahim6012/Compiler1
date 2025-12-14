import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.IOException;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {

        CharStream input = CharStreams.fromFileName("test.txt");
        MyLexer lexer = new MyLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MyParser parser = new MyParser(tokens);
        ParseTree tree = parser.input();
        System.out.println(tree.toStringTree(parser));

//        CharStream input = CharStreams.fromFileName("test.txt");
//        TestLexer lexer = new TestLexer(input);
//        CommonTokenStream tokens = new CommonTokenStream(lexer);
//        TestParser parser = new TestParser(tokens);
//        ParseTree tree = parser.prog();
//        System.out.println(tree.toStringTree(parser));

        // 1. Create a CharStream from the input
//        String input = "a = 5\n" +
//                "b = 10\n" +
//                "a + b * 2\n";
//        CharStream charStream = CharStreams.fromString(input);
//
//        // 2. Create a Lexer
//        ExprLexer lexer = new ExprLexer(charStream);
//
//        // 3. Create a CommonTokenStream
//        CommonTokenStream tokens = new CommonTokenStream(lexer);
//
//        // 4. Create a Parser
//        ExprParser parser = new ExprParser(tokens);
//
//        // 5. Invoke the desired rule (prog is the starting rule)
//        ParseTree tree = parser.prog();
//
//        // 6. Print the parse tree (for demonstration)
//        System.out.println("Parse Tree: " + tree.toStringTree(parser));
//
//        // In a real compiler, you would now use a Listener or Visitor to walk the tree
//        // and perform semantic analysis or code generation.
//        System.out.println("\nSuccessfully parsed the expression language input.");
    }
}
