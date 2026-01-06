
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;

import java.io.IOException;
public class App
{

    public static void main(String[] args) throws IOException {
        CharStream input = CharStreams.fromFileName("test.txt");
//        MyLexer lexer = new MyLexer(input);
//        CommonTokenStream tokens = new CommonTokenStream(lexer);
//        MyParser parser = new MyParser(tokens);
//        //ParseTree tree = parser.program();
//        //System.out.println(tree.toStringTree(parser));
//        ProgramVisitor visitor = new ProgramVisitor();
//        //System.out.println(parser.program());
//        Program program = visitor.visitProgram(parser.program());
//        program.printTree();
//        SymbolTableVisitor st = new SymbolTableVisitor();
        //st.analyze(program);
//
//        FrontLexer lexer = new FrontLexer(input);
//        CommonTokenStream tokens = new CommonTokenStream(lexer);
//        FrontParser parser = new FrontParser(tokens);
//        //ParseTree tree = parser.program();
//        //System.out.println(tree.toStringTree(parser));
//        Program program = (Program) new ASTVisitor().visit(parser.program());
//        program.printTree();
    }
}
