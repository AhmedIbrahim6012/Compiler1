import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.File;
import java.io.IOException;

import antlr.Example;
import antlr.ExampleParser;

public class Main {

    public static void main(String[] args) throws IOException {

        File dir = new File("products_app/templates/");
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

            boolean isCss  = file.getName().endsWith(".css");
            boolean isHtml = file.getName().endsWith(".html");

            if (!isCss && !isHtml) continue;

            System.out.println("\n==============================");
            System.out.println("Parsing file: " + file.getName());

            try {
                // 1️⃣ CharStream
                CharStream input = CharStreams.fromFileName(file.getAbsolutePath());

                // 2️⃣ Lexer
                Example lexer = new Example(input);
                CommonTokenStream tokens = new CommonTokenStream(lexer);

                // 3️⃣ Parser
                ExampleParser parser = new ExampleParser(tokens);
                parser.removeErrorListeners();
                parser.addErrorListener(new DiagnosticErrorListener());

                ParseTree tree;

                // 4️⃣ Entry rule حسب نوع الملف
                if (isCss) {
                    tree = parser.cssFile();
                } else {
                    tree = parser.htmlDocument();
                }

                // 5️⃣ طباعة Parse Tree
                System.out.println("\n--- Parse Tree ---");
                System.out.println(tree.toStringTree(parser));

            } catch (Exception e) {
                System.err.println("❌ Error parsing: " + file.getName());
                e.printStackTrace();
            }
        }
    }
}
