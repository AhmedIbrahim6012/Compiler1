package Front.AST.CSS.combinators;

import Front.AST.ASTNode;

public class Combinator extends ASTNode {
    public final ASTNode combinator;
    public Combinator(int line,ASTNode combinator) {
        super("Combinator",line);
        this.combinator = combinator;
    }

    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name + " (line " + line + ")");
        combinator.printTree(indent+2);
    }
}
