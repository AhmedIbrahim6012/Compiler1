package Front.AST.CSS;

import Front.AST.ASTNode;
import Front.AST.CSS.Value.NameNode;

import java.util.List;

public class AtKeyFramesNode extends ASTNode {
    public final NameNode value;
    public final List<KeyFrameBlockNode> block;
    public AtKeyFramesNode(int line, NameNode value, List<KeyFrameBlockNode> block) {
        super("KeyFrames", line);
        this.value = value;
        this.block = block;
    }

    @Override
    public void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name + " (line " + line + ") :");
        value.printTree(indent+2);
        for (KeyFrameBlockNode blockNode : block) {
            blockNode.printTree(indent+2);
        }
    }
}
