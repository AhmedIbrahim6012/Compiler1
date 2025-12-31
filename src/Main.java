import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.File;
import java.io.IOException;

import antlr.Example;
import antlr.ExampleParser;

public class Main {

    public static void main(String[] args) throws IOException {

        File dir = new File("products_app/static/css");
        if (!dir.exists() || !dir.isDirectory()) {
            System.err.println("Directory not found: " + dir.getAbsolutePath());
            return;
        }
        File[] files = dir.listFiles();
        if (files == null) {
            System.err.println("No files found in directory");
            return;
        }
        for (File file : files) {

            if (!file.isFile()) continue;
            if (!file.getName().endsWith(".css")) continue;

            System.out.println("\n==============================");
            System.out.println("Parsing file: " + file.getName());

            // 1️⃣ CharStream
            CharStream input = CharStreams.fromFileName(file.getAbsolutePath());

            // 2️⃣ Lexer
            Example lexer = new Example(input);

            // 🔍 اطبع التوكنز (اختياري للتشخيص)
            /*
            Token t;
            while ((t = lexer.nextToken()).getType() != Token.EOF) {
                System.out.println(lexer.getVocabulary().getSymbolicName(t.getType())
                        + " -> " + t.getText());
            }
            lexer.reset();
            */

            CommonTokenStream tokens = new CommonTokenStream(lexer);

            // 3️⃣ Parser
            ExampleParser parser = new ExampleParser(tokens);
            parser.removeErrorListeners();
            parser.addErrorListener(new DiagnosticErrorListener());

            // 4️⃣ Entry rule (CSS)
            ParseTree tree = parser.cssFile();

            // 5️⃣ طباعة Parse Tree
            System.out.println("\n--- Parse Tree ---");
            System.out.println(tree.toStringTree(parser));
        }
    }
}
