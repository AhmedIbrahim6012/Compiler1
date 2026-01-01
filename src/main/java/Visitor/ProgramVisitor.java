package Visitor;
import AST.Program;
import MyLang.MyParser;
import MyLang.MyParserBaseVisitor;
import AST.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.List;

public class ProgramVisitor extends MyParserBaseVisitor<Program> {

    @Override
    public Program visitProgram(MyParser.ProgramContext ctx) {
        List<ASTNode> statements = new ArrayList<>();
        for (ParseTree child:ctx.children){
            if (child instanceof MyParser.Simple_statementsContext) {
                statements.add(new ASTVisitor().visit(child));
            }
            if (child instanceof MyParser.Compound_statementsContext) {
                statements.add(new ASTVisitor().visit(child));
            }
            if (child instanceof MyParser.DecoratedContext){
                statements.add(new ASTVisitor().visit(child));
            }
        }
        return new Program(statements);
    }




}
