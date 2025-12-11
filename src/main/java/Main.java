import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import parser.*; // استورد ملفات Lexer و Parser

public class Main {
    public static void main(String[] args) throws Exception {
        // مثال كود Python صغير
//        String code = """
//            def hello(x, y):
//                if x > y:
//                    return x
//                else:
//                    return y
//            """;

        // 1. إنشاء Lexer
        CharStream input = CharStreams.fromString(code);
        MyLexerPython lexer = new MyLexerPython(input);

        // 2. إنشاء TokenStream
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // 3. إنشاء Parser
        MyParserPython parser = new MyParserPython(tokens);

        // 4. بدء التحليل من القاعدة الأساسية
        ParseTree tree = parser.program();

        // 5. طباعة شجرة التحليل
        System.out.println(tree.toStringTree(parser));
    }
}
