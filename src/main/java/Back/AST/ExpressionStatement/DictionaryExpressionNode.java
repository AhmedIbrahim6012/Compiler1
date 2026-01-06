package Back.AST.ExpressionStatement;

import java.util.HashMap;
import java.util.Map;

public class DictionaryExpressionNode extends ExpressionNode {
    public Map<ExpressionNode, ExpressionNode> map = new HashMap<>();
    public DictionaryExpressionNode(int line,Map<ExpressionNode, ExpressionNode> map) {
        super(line,"Dictionary");
        this.map=map;

    }

    @Override
    public  void printTree(int indent) {
        System.out.println(super.indent(indent) + super.name + " (line " + line + ")");
        if (map.isEmpty()){
            System.out.println(super.indent(indent+2)+"Empty");
        }
        map.forEach((key,value)->{
            System.out.println(super.indent(indent+2)+"Key:");
            key.printTree(indent + 4);
            System.out.println(super.indent(indent+2)+"Value:");
            value.printTree(indent + 4);
        });

    }
}
