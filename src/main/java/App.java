import CodeGeneration.BackGenerator;
import CodeGeneration.FrontGenerator;

import Front.AST.Html.HtmlDocument;
import SymbolTable.*;
import SymbolTable.SymbolTableVisitor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import BackLang.*;
import FrontLang.*;
import org.antlr.v4.runtime.tree.ParseTree;
//import Back.Visitor.ASTVisitor;
//import Front.Visitor.ASTVisitor;
//import Back.AST.ASTNode;
//import Front.AST.ASTNode;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import SymbolTable.SymbolTableFrontVisitor;
public class App
{
    public static void main(String[] args) throws IOException {

        CharStream binput = CharStreams.fromFileName("back_test.txt");
        BackLexer blexer = new BackLexer(binput);
        CommonTokenStream btokens = new CommonTokenStream(blexer);
        BackParser bparser = new BackParser(btokens);
        ParseTree btree = bparser.program();
        //System.out.println(btree.toStringTree(bparser));
        Back.AST.Program bastNode =(Back.AST.Program) new Back.Visitor.ASTVisitor().visit(btree);
        //bastNode.printTree(0);
        BackGenerator generator = new BackGenerator();
        String code = generator.generate(bastNode);
        System.out.println("#######################");
       //System.out.println(code);

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
        SymbolTable symbolTable = new SymbolTable();
        SymbolTableVisitor symbolTableVisitor = new SymbolTableVisitor(symbolTable);
        symbolTableVisitor.visit(bastNode);
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
