import AST.Program;
import Visitor.ProgramVisitor;
import org.antlr.v4.runtime.*;
import SymbolTable.*;
import MyLang.*;
import MyLang.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
public class App
{

    public static void main(String[] args) throws IOException {
        CharStream input = CharStreams.fromFileName("test.txt");
        MyLexer lexer = new MyLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MyParser parser = new MyParser(tokens);
//        ParseTree tree = parser.program();
//        System.out.println(tree.toStringTree(parser));
        ProgramVisitor visitor = new ProgramVisitor();
        Program program = visitor.visitProgram(parser.program());
        program.printTree();
//        SymbolTableVisitor st = new SymbolTableVisitor();
//        st.analyze(program);

    }

}
