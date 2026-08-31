import CodeGeneration.BackGenerator;
import CodeGeneration.FrontGenerator;

import CodeGeneration.JinjaRenderer;
import Front.AST.Html.HtmlDocument;
import SymbolTable.*;
import SymbolTable.SymbolTableVisitor;
import org.antlr.v4.runtime.*;
import BackLang.*;
import FrontLang.*;
import org.antlr.v4.runtime.tree.ParseTree;
//import Back.Visitor.ASTVisitor;
//import Front.Visitor.ASTVisitor;
//import Back.AST.ASTNode;
//import Front.AST.ASTNode;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import SymbolTable.SymbolTableFrontVisitor;
public class App
{

    static int passed = 0;
    static int failed = 0;

    static void pass(String name) {
        System.out.println("  ✅ PASS : " + name);
        passed++;
    }

    static void fail(String name, String reason) {
        System.out.println("  ❌ FAIL : " + name);
        System.out.println("          → " + reason);
        failed++;
    }

    static void section(String title) {
        System.out.println("\n══════════════════════════════════════════");
        System.out.println("  " + title);
        System.out.println("══════════════════════════════════════════");
    }

    static void summary() {
        System.out.println("\n══════════════════════════════════════════");
        System.out.printf("  result : %d نجح  |  %d failed  |  sum %d%n",
                passed, failed, passed + failed);
        System.out.println("══════════════════════════════════════════\n");
    }

    // ═══════════════════════════════════════════════════════
    //  BACK
    // ═══════════════════════════════════════════════════════

    static Back.AST.Program parseBack(String fileName) throws IOException {
        CharStream input = CharStreams.fromFileName(fileName);

        List<String> lexerErrors = new ArrayList<>();
        BackLexer lexer = new BackLexer(input);
        lexer.removeErrorListeners();
        lexer.addErrorListener(new BaseErrorListener() {
            @Override public void syntaxError(Recognizer<?,?> r, Object sym,
                                              int line, int col, String msg, RecognitionException e) {
                lexerErrors.add("line " + line + ":" + col + " " + msg);
            }
        });
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        tokens.fill();

        if (lexerErrors.isEmpty())
            pass("Back Lexer — " + fileName + " (no errors)");
        else
            fail("Back Lexer — " + fileName, String.join(" | ", lexerErrors));

        List<String> parserErrors = new ArrayList<>();
        BackParser parser = new BackParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(new BaseErrorListener() {
            @Override public void syntaxError(Recognizer<?,?> r, Object sym,
                                              int line, int col, String msg, RecognitionException e) {
                parserErrors.add("line " + line + ":" + col + " " + msg);
            }
        });
        ParseTree tree = parser.program();

        if (parserErrors.isEmpty())
            pass("Back Parser — " + fileName + " (no errors)");
        else
            fail("Back Parser — " + fileName, String.join(" | ", parserErrors));

        try {
            Back.AST.Program ast =
                    (Back.AST.Program) new Back.Visitor.ASTVisitor().visit(tree);
            if (ast != null && ast.statements != null && !ast.statements.isEmpty())
                pass("Back AST — " + ast.statements.size() + " statements");
            else
                fail("Back AST", "Empty or null");
            return ast;
        } catch (Exception e) {
            fail("Back AST — Visitor", e.getMessage());
            return null;
        }
    }

    // ═══════════════════════════════════════════════════════
    //  SYMBOL TABLE
    // ═══════════════════════════════════════════════════════

    static SymbolTable buildSymbolTable(Back.AST.Program ast) {
        if (ast == null) {
            fail("SymbolTable", "AST empty");
            return new SymbolTable();
        }
        try {
            SymbolTable st = new SymbolTable();
            new SymbolTableVisitor(st).visit(ast);

            int routeCount = 0;
            for (Map.Entry<String, Symbol> entry : st.getGlobalScopeSymbols().entrySet()) {
                if (!(entry.getValue() instanceof RouteSymbol)) continue;
                RouteSymbol rs = (RouteSymbol) entry.getValue();
                routeCount++;
                System.out.println("    🔗 Route: " + entry.getKey());
                for (TemplateInfo ti : rs.getTemplates()) {
                    System.out.println("       📄 Template: " + ti.getTemplateName());
                    for (Symbol s : ti.getVariables()) {
                        System.out.println("          📦 Var: " + s.getName()
                                + " = " + (s instanceof VariableSymbol
                                ? ((VariableSymbol) s).getData() : "?"));
                    }
                }
            }

            if (routeCount > 0)
                pass("SymbolTable — " + routeCount + " route(s) registered");
            else
                fail("SymbolTable", "No routes registered");

            return st;
        } catch (Exception e) {
            fail("SymbolTable — build", e.getMessage());
            return new SymbolTable();
        }
    }

    static void renderTemplate(SymbolTable symbolTable,
                               String templateName,
                               Path outputDir) {

        String filePath = "templates/" + templateName;

        if (!new File(filePath).exists()) {
            fail("Front — " + templateName, "File not found: " + filePath);
            return;
        }

        // ── Lexer + Parser ────────────────────────────────────
        Front.AST.Html.HtmlDocument doc;
        try {
            List<String> lexerErrors = new ArrayList<>();
            CharStream input = CharStreams.fromFileName(filePath);
            FrontLexer lexer = new FrontLexer(input);
            lexer.removeErrorListeners();
            lexer.addErrorListener(new BaseErrorListener() {
                @Override public void syntaxError(Recognizer<?,?> r, Object sym,
                                                  int line, int col, String msg, RecognitionException e) {
                    lexerErrors.add("line " + line + ":" + col + " " + msg);
                }
            });

            CommonTokenStream tokens = new CommonTokenStream(lexer);

            List<String> parserErrors = new ArrayList<>();
            FrontParser parser = new FrontParser(tokens);
            parser.removeErrorListeners();
            parser.addErrorListener(new BaseErrorListener() {
                @Override public void syntaxError(Recognizer<?,?> r, Object sym,
                                                  int line, int col, String msg, RecognitionException e) {
                    parserErrors.add("line " + line + ":" + col + " " + msg);
                }
            });

            ParseTree tree = parser.htmlDocument();

            if (lexerErrors.isEmpty())
                pass("Front Lexer — " + templateName + " (no errors)");
            else
                fail("Front Lexer — " + templateName, String.join(" | ", lexerErrors));

            if (parserErrors.isEmpty())
                pass("Front Parser — " + templateName + " (no errors)");
            else
                fail("Front Parser — " + templateName, String.join(" | ", parserErrors));

            doc = (Front.AST.Html.HtmlDocument)
                    new Front.Visitor.ASTVisitor().visit(tree);

            if (doc != null)
                pass("Front AST — " + templateName);
            else {
                fail("Front AST — " + templateName, "null document");
                return;
            }

        } catch (Exception e) {
            fail("Front Lexer/Parser — " + templateName, e.getMessage());
            return;
        }

        // ── Semantic Check (SymbolTableFrontVisitor) ──────────
        TemplateInfo templateInfo = findTemplateInfo(symbolTable, templateName);

        if (templateInfo == null) {
            fail("Semantic — " + templateName,
                    "TemplateInfo not found in SymbolTable (no matching route?)");
        } else {
            try {
                symbolTable.enterScope();
                new SymbolTableFrontVisitor(symbolTable, templateInfo).visit(doc);
                symbolTable.exitScope();
                pass("Semantic — " + templateName + " (no errors)");
            } catch (Exception e) {
                fail("Semantic — " + templateName, e.getMessage());
            }
        }

        // ── Build context ─────────────────────────────────────
        Map<String, Object> context = buildContext(symbolTable, templateName);
        System.out.println("    🗂  Context keys: " + context.keySet());

        // ── Render ────────────────────────────────────────────
        String html;
        try {
            html = new JinjaRenderer(context).render(doc);

            if (html == null || html.isBlank()) {
                fail("Renderer — " + templateName, "Result empty");
                return;
            }

            pass("Renderer — " + templateName + " (result not empty)");

        } catch (Exception e) {
            fail("Renderer — " + templateName, e.getMessage());
            return;
        }

        // ── Save to output/ ───────────────────────────────────
        try {
            Path outFile = outputDir.resolve(templateName);
            Files.writeString(outFile, html, StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING);
            pass("Output saved — output/" + templateName);
            System.out.println("    💾 Saved: " + outFile.toAbsolutePath());
        } catch (IOException e) {
            fail("Output save — " + templateName, e.getMessage());
        }
    }

    static TemplateInfo findTemplateInfo(SymbolTable st, String templateName) {
        try {
            for (Map.Entry<String, Symbol> entry : st.getGlobalScopeSymbols().entrySet()) {
                if (!(entry.getValue() instanceof RouteSymbol)) continue;
                for (TemplateInfo ti : ((RouteSymbol) entry.getValue()).getTemplates()) {
                    if (ti.getTemplateName().equals(templateName))
                        return ti;
                }
            }
        } catch (Exception ignored) {}
        return null;
    }

    // ═══════════════════════════════════════════════════════
    //  HELPERS
    // ═══════════════════════════════════════════════════════

    static Map<String, Object> buildContext(SymbolTable st, String templateName) {
        Map<String, Object> context = new HashMap<>();
        try {
            for (Map.Entry<String, Symbol> entry : st.getGlobalScopeSymbols().entrySet()) {
                if (!(entry.getValue() instanceof RouteSymbol)) continue;
                RouteSymbol route = (RouteSymbol) entry.getValue();
                for (TemplateInfo ti : route.getTemplates()) {
                    if (!ti.getTemplateName().equals(templateName)) continue;
                    for (Symbol s : ti.getVariables()) {
                        if (s instanceof VariableSymbol)
                            context.put(s.getName(), ((VariableSymbol) s).getData());
                    }
                }
            }
        } catch (Exception ignored) {}
        return context;
    }


    public static void main(String[] args) throws IOException {


        Path outputDir = Paths.get("output");
        if (!Files.exists(outputDir)) {
            Files.createDirectory(outputDir);
            System.out.println("📁 Created folder: output/");
        } else {
            System.out.println("📁 Output folder: output/");
        }

        // ── 1. Back ───────────────────────────────────────────
        section("1. Back — back_test.txt");
        Back.AST.Program backAST = parseBack("back_test.txt");
        SymbolTable symbolTable  = buildSymbolTable(backAST);

        // ── 2. Front → Render → Save ──────────────────────────
        String[] templates = {
                "index.html",
                "add_product.html",
                "product_detail.html"
        };

        for (String template : templates) {
            section("2. Front — " + template);
            renderTemplate(symbolTable, template, outputDir);
        }

        summary();
//        CharStream binput = CharStreams.fromFileName("back_test.txt");
//        BackLexer blexer = new BackLexer(binput);
//        CommonTokenStream btokens = new CommonTokenStream(blexer);
//        BackParser bparser = new BackParser(btokens);
//        ParseTree btree = bparser.program();
//        //System.out.println(btree.toStringTree(bparser));
//        Back.AST.Program bastNode = (Back.AST.Program) new Back.Visitor.ASTVisitor().visit(btree);
        //bastNode.printTree(0);
//        BackGenerator generator = new BackGenerator();
//        String code = generator.generate(bastNode);
//        System.out.println("#######################");
       //System.out.println(code);

//        SymbolTable symbolTable = new SymbolTable();
//        SymbolTableVisitor symbolTableVisitor = new SymbolTableVisitor(symbolTable);
//        symbolTableVisitor.visit(bastNode);
       // symbolTable.print();


//        CharStream finput = CharStreams.fromFileName("templates/index.html");
//        FrontLexer flexer = new FrontLexer(finput);
//        CommonTokenStream ftokens = new CommonTokenStream(flexer);
//        FrontParser fparser = new FrontParser(ftokens);
//        ParseTree ftree = fparser.htmlDocument();
//        Front.AST.Html.HtmlDocument fastNode =(Front.AST.Html.HtmlDocument) new Front.Visitor.ASTVisitor().visit(ftree);
//        /// fastNode.printTree(0);
//        RouteSymbol routeSymbol = (RouteSymbol) symbolTable.lookup("index");
//        TemplateInfo ti = null;
//        for (TemplateInfo t:routeSymbol.getTemplates()){
//            if (t.getTemplateName().equals("index.html")){
//                for (Symbol s:t.getVariables()){
//                    if (s.getName().equals("products")){
//                      List products =(List) ((VariableSymbol)s).getData();
//                        Map<String, Object> context = new HashMap<>();
//                        context.put("products", products);
//                        JinjaRenderer jinjaRenderer = new JinjaRenderer(context);
//                        String html =  jinjaRenderer.render(fastNode);
//                         System.out.println(html);
//                    }
//                }
//                break;
//            }
//        }


//        CharStream finput = CharStreams.fromFileName("templates/product_detail.html");
//        FrontLexer flexer = new FrontLexer(finput);
//        CommonTokenStream ftokens = new CommonTokenStream(flexer);
//        FrontParser fparser = new FrontParser(ftokens);
//        ParseTree ftree = fparser.htmlDocument();
//        Front.AST.Html.HtmlDocument fastNode =(Front.AST.Html.HtmlDocument) new Front.Visitor.ASTVisitor().visit(ftree);
//        /// fastNode.printTree(0);
//        RouteSymbol routeSymbol = (RouteSymbol) symbolTable.lookup("index");
//        TemplateInfo ti = null;
//        for (TemplateInfo t:routeSymbol.getTemplates()){
//            if (t.getTemplateName().equals("product_detail.html")){
//                for (Symbol s:t.getVariables()){
//                    if (s.getName().equals("products")){
//                        List products =(List) ((VariableSymbol)s).getData();
//                        Map<String, Object> context = new HashMap<>();
//                        context.put("products", products);
//                        JinjaRenderer jinjaRenderer = new JinjaRenderer(context);
//                        String html =  jinjaRenderer.render(fastNode);
//                        System.out.println(html);
//                    }
//                }
//                break;
//            }
//        }
//






//        List<HtmlDocument>frontPrograms = new ArrayList<>();
//         for(Path path : Files.list(Paths.get("templates")).toList()) {
//            //if (!path.getFileName().toString().contains("index")) continue;
//            System.out.println(path);
//            CharStream finput = CharStreams.fromPath(path);
//            FrontLexer flexer = new FrontLexer(finput);
//            CommonTokenStream ftokens = new CommonTokenStream(flexer);
//            FrontParser fparser = new FrontParser(ftokens);
//            ParseTree ftree = fparser.htmlDocument();
//            //System.out.println(ftree.toStringTree(fparser));
//            Front.AST.Html.HtmlDocument fastNode =(Front.AST.Html.HtmlDocument) new Front.Visitor.ASTVisitor().visit(ftree);
//            fastNode.setFileName(path.getFileName().toString());
//            frontPrograms.add(fastNode);
//            //System.out.println("###################");
//          // fastNode.printTree(0);
////            FrontGenerator generator = new FrontGenerator();
////            String code = generator.generate(fastNode);
////            System.out.println(code);
//        }


//

//        symbolTable.enterScope();
//        symbolTable.injectJinjaMethods();
//        for (Map.Entry<String, Symbol> entry : symbolTable.getGlobalScopeSymbols().entrySet()) {
//            if (!(entry.getValue() instanceof RouteSymbol)){
//                continue;
//            }
//            for (TemplateInfo template:((RouteSymbol) entry.getValue()).templates){
//                frontPrograms.forEach(frontProgram -> {
//                    if (frontProgram.getFileName().equals(template.getTemplateName())){
//                        SymbolTableFrontVisitor symbolTableFrontVisitor = new SymbolTableFrontVisitor(symbolTable,template);
//                        symbolTableFrontVisitor.visit(frontProgram);
//                    }
//                });
//            }
//        }
//        symbolTable.exitScope();

        //symbolTable.print();
        //SymbolTableFrontVisitor symbolTableFrontVisitor = new SymbolTableFrontVisitor(symbolTable);
        ///symbolTableFrontVisitor.visit(fastNode);
        //symbolTable.print();
    }
}
