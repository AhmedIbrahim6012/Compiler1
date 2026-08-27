package Front.AST.Html;

import Front.AST.ASTNode;

import java.util.List;

public class HtmlDocument extends ASTNode {
    public final  DoctypeNode doctype;
    public final List<ASTNode> elements;
    private String fileName;
    public HtmlDocument(int line, DoctypeNode doctype, List<ASTNode> elements) {
        super("HTML", line);
        this.doctype = doctype;
        this.elements = elements;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name + " (line " + line + ") :");
        if (doctype != null) {
            doctype.printTree(indent+2);
        }
        System.out.println(super.indent(indent+2)+"Elements :");
        if (elements != null) {
            for (ASTNode element : elements) {
                element.printTree(indent+4);
            }
        }
    }
}
