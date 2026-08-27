package Front.AST.CSS;

import Front.AST.ASTNode;
import Front.AST.NameNode;

public class MediaQueryNode extends ASTNode {
    public final NameNode name ;
    public final MediaValueNode mediaValue;
    public MediaQueryNode(int line,NameNode name, MediaValueNode mediaQuery) {
        super("Media Query",line);
        this.name = name;
        this.mediaValue = mediaQuery;
    }

    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name + " (line " + line + ")");
        name.printTree(indent + 2);
        mediaValue.printTree(indent + 2);
    }
}
