package Back.Visitor;
import Back.AST.ASTNode;
import Back.AST.Program;
import BackLang.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.List;

public class ProgramVisitor extends BackParserBaseVisitor<Program> {

    @Override
    public Program visitProgram(BackParser.ProgramContext ctx) {
        List<ASTNode> statements = new ArrayList<>();
        for (ParseTree child:ctx.children){
            if (child instanceof BackParser.Simple_statementsContext) {
                statements.add(new ASTVisitor().visit(child));
            }
            if (child instanceof BackParser.Compound_statementsContext) {
                statements.add(new ASTVisitor().visit(child));
            }
            if (child instanceof BackParser.DecoratedContext){
                statements.add(new ASTVisitor().visit(child));
            }
        }
        return new Program(statements);
    }
}
