package AST;

public class StyleElementNode extends ASTNode{

    public StyleElementNode(int line) {
        super("StyleElement", line);
    }

    @Override
    public <R> R accept(AstVisitor<R> visitor) {
        return visitor.visitCssStylesheet(this);
    }
}
