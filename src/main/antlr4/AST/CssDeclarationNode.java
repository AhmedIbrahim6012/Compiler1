package AST;

import java.util.ArrayList;
import java.util.List;

public class CssDeclarationNode extends ASTNode{
    private String name;
    private List<CssValueNode> values = new ArrayList<>();

    public CssDeclarationNode(String name, int line) {
        super("CssDeclaration", line);
        this.name = name;
    }

    public void addValue(CssValueNode value) {
        values.add(value);
    }

    public List<CssValueNode> getValues() {
        return values;
    }

    public String getName() {
        return name;
    }

    @Override
    public <R> R accept(AstVisitor<R> visitor) {
        return visitor.visitCssDeclaration(this);
    }


}
