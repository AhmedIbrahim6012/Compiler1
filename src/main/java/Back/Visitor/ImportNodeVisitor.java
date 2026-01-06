package Back.Visitor;
import Back.AST.ImporStatement.DottedAsNameNode;
import Back.AST.ImporStatement.DottedNameNode;
import Back.AST.ImporStatement.ImportAsNameNode;
import Back.AST.ImporStatement.ImportNode;
import BackLang.*;

import java.util.ArrayList;
import java.util.List;

public class ImportNodeVisitor extends BackParserBaseVisitor<ImportNode> {
    @Override
    public ImportNode visitDotted_name(BackParser.Dotted_nameContext ctx) {
        List<String> parts=new ArrayList<>();
        for (int i = 0; i < ctx.NAME().size(); i++) {
          parts.add(ctx.NAME().get(i).toString());
        }
        return new DottedNameNode(ctx.start.getLine(),parts);
    }

    @Override
    public ImportNode visitDotted_as_name(BackParser.Dotted_as_nameContext ctx) {
        ImportNode importNode = visit(ctx.dotted_name());
        String alias=ctx.NAME()==null?null:ctx.NAME().toString();
        return new DottedAsNameNode(ctx.start.getLine(),importNode,alias);
    }

    @Override
    public ImportNode visitImport_as_name(BackParser.Import_as_nameContext ctx) {
        ImportNode importNode;
        if (ctx.NAME().size()==1){
            importNode =new ImportAsNameNode(ctx.start.getLine(),ctx.NAME(0).toString(),null);
        }else {
            importNode =new ImportAsNameNode(ctx.start.getLine(),ctx.NAME(0).toString(),ctx.NAME(1).toString());
        }
        return importNode;
    }

    @Override
    public ImportNode visitImport_as_names(BackParser.Import_as_namesContext ctx) {
        System.out.println("i a ns");
        return super.visitImport_as_names(ctx);
    }
}
