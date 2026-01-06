package Back.Visitor;
import Back.AST.ImporStatement.ImportFromNode;
import Back.AST.ImporStatement.ImportNameNode;
import Back.AST.ImporStatement.ImportNode;
import Back.AST.ImporStatement.ImportStatementNode;
import BackLang.*;

import java.util.ArrayList;
import java.util.List;

public class ImportStatementVisitor extends BackParserBaseVisitor<ImportStatementNode> {
    @Override
    public ImportStatementNode visitImport_name(BackParser.Import_nameContext ctx) {
        List<ImportNode>names = new ArrayList<>();
        for (int i = 0; i < ctx.dotted_as_name().size(); i++) {
            names.add((new ImportNodeVisitor()).visit(ctx.dotted_as_name().get(i)));
        }
        return new ImportNameNode(ctx.start.getLine(),names);
    }

    @Override
    public ImportStatementNode visitImport_from(BackParser.Import_fromContext ctx) {
        List<ImportNode>names = new ArrayList<>();
        for (int i = 0; i < ctx.import_as_names().import_as_name().size(); i++) {
            names.add((new ImportNodeVisitor()).visit(ctx.import_as_names().import_as_name().get(i)));
        }
        ImportNode moduleName = (new ImportNodeVisitor()).visit(ctx.dotted_name());

        return new ImportFromNode(ctx.start.getLine(),moduleName,names);
    }
}
