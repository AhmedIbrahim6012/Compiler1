import AST.ASTBuilder;
import AST.ASTNode;
import AST.AstPrinter;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class Main {
    public static void main(String[] args) throws Exception {

        String input = "<!DOCTYPE html><div>Hello</div>";

        Example lexer =
                new Example(CharStreams.fromString(input));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExampleParser parser = new ExampleParser(tokens);

        ASTBuilder builder = new ASTBuilder();
        ASTNode ast = builder.visit(parser.htmlDocument());

        AstPrinter printer = new AstPrinter();
        ast.accept(printer);
    }
}
