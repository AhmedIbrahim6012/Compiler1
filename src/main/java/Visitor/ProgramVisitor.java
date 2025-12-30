package Visitor;
import AST.Program;
import MyLang.MyParser;
import MyLang.MyParserBaseVisitor;
import AST.*;

import java.util.ArrayList;
import java.util.List;

public class ProgramVisitor extends MyParserBaseVisitor<Program> {

    @Override
    public Program visitProgram(MyParser.ProgramContext ctx) {
        List<ASTNode> statements = new ArrayList<>();
        for (int i = 0; i < ctx.simple_statements().size(); i++) {
            statements.add(new ASTVisitor().visit(ctx.simple_statements(i)));
        }
        for (int i = 0; i < ctx.compound_statements().size(); i++) {
            statements.add(new ASTVisitor().visit(ctx.compound_statements(i)));
        }
        for (int i = 0; i < ctx.decorated().size(); i++) {
            statements.add(new ASTVisitor().visit(ctx.decorated(i)));
        }
        return new Program(statements);
    }




}
