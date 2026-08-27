package CodeGeneration;

import Front.AST.*;
import Front.AST.Html.*;
import Front.AST.JInja2.*;
import Front.AST.JInja2.ExpressionStatement.*;
import Front.AST.JInja2.ExpressionStatement.Operators.*;
import Front.AST.CSS.*;
import Front.AST.CSS.Selector.*;
import Front.AST.CSS.Property.*;
import Front.AST.CSS.Value.*;
import Front.AST.CSS.combinators.*;

public class FrontGenerator {

    private final CodeWriter writer = new CodeWriter();


    public String generate(ASTNode node) {
        generateNode(node);
        return writer.getCode();
    }

    private void generateNode(ASTNode node) {
        if (node == null) return;

        if (node instanceof Program) {
            for (ASTNode stmt : ((Program) node).statements) {
                generateNode(stmt);
            }
        }
        else if (node instanceof TextNode) {
            writer.writeln(((TextNode) node).text);
        }

        else if (node instanceof HtmlDocument) {
            HtmlDocument doc = (HtmlDocument) node;
            if (doc.doctype != null) {
                writer.writeln(doc.doctype.value);
            }
            if (doc.elements != null) {
                for (ASTNode el : doc.elements) {
                    generateNode(el);
                }
            }
        }
        else if (node instanceof HtmlElementNode) {
            HtmlElementNode element = (HtmlElementNode) node;
            StringBuilder tag = new StringBuilder("<");
            tag.append(evaluateInline(element.tagName));

            if (element.attributes != null) {
                for (HtmlAttributeNode attr : element.attributes) {
                    tag.append(" ").append(evaluateInline(attr.key));
                    if (attr.value != null) {
                        tag.append("=\"").append(evaluateAttributeValues(attr.value)).append("\"");
                    }
                }
            }

            if (element.isSelfClose) {
                tag.append(">");
                writer.writeln(tag.toString());
            } else {
                tag.append(">");
                writer.writeln(tag.toString());

                writer.indent();
                if (element.children != null) {
                    for (ASTNode child : element.children) {
                        generateNode(child);
                    }
                }
                writer.dedent();

                writer.writeln("</" + evaluateInline(element.tagName) + ">");
            }
        }

        else if (node instanceof BlockNode) {
            BlockNode block = (BlockNode) node;
            writer.writeln("{% block " + block.value + " %}");
            writer.indent();
            if (block.elements != null) {
                for (ASTNode el : block.elements) generateNode(el);
            }
            writer.dedent();
            writer.writeln("{% endblock %}");
        }
        else if (node instanceof ForStatementNode) {
            ForStatementNode forNode = (ForStatementNode) node;
            String iterator = evaluateInline(forNode.itrator);
            String expression = evaluateInline(forNode.expression);
            writer.writeln("{% for " + iterator + " in " + expression + " %}");
            writer.indent();
            if (forNode.elements != null) {
                for (ASTNode el : forNode.elements) generateNode(el);
            }
            writer.dedent();
            writer.writeln("{% endfor %}");
        }
        else if (node instanceof IfStatementNode) {
            IfStatementNode ifNode = (IfStatementNode) node;
            writer.writeln("{% if " + evaluateInline(ifNode.expression) + " %}");
            writer.indent();
            if (ifNode.elements != null) {
                for (ASTNode el : ifNode.elements) generateNode(el);
            }
            writer.dedent();

            if (ifNode.elseIf != null) {
                for (IfStatementNode.ElseIf elif : ifNode.elseIf) {
                    writer.writeln("{% elif " + evaluateInline(elif.expression) + " %}");
                    writer.indent();
                    if (elif.elements != null) {
                        for (ASTNode el : elif.elements) generateNode(el);
                    }
                    writer.dedent();
                }
            }
            if (ifNode.elseBody != null) {
                writer.writeln("{% else %}");
                writer.indent();
                if (ifNode.elseBody.elements != null) {
                    for (ASTNode el : ifNode.elseBody.elements) generateNode(el);
                }
                writer.dedent();
            }
            writer.writeln("{% endif %}");
        }
        else if (node instanceof ExpressionNode) {
            ExpressionNode expr = (ExpressionNode) node;
            writer.writeln("{{ " + evaluateInline(expr.expression) + " }}");
        }

        else if (node instanceof CSSStatements) {
            CSSStatements css = (CSSStatements) node;
            if (css.statements != null) {
                for (ASTNode stmt : css.statements) generateNode(stmt);
            }
        }
        else if (node instanceof CSSRuleNode) {
            CSSRuleNode rule = (CSSRuleNode) node;
            writer.writeln(evaluateInline(rule.selectorGroup) + " {");
            writer.indent();
            generateNode(rule.block);
            writer.dedent();
            writer.writeln("}");
        }
        else if (node instanceof CSSBlockNode) {
            CSSBlockNode block = (CSSBlockNode) node;
            if (block.declarations != null) {
                for (DeclarationNode dec : block.declarations) {
                    generateNode(dec);
                }
            }
        }
        else if (node instanceof DeclarationNode) {
            DeclarationNode dec = (DeclarationNode) node;
            StringBuilder valBuilder = new StringBuilder();
            if (dec.values != null) {
                for (int i = 0; i < dec.values.size(); i++) {
                    valBuilder.append(evaluateInline(dec.values.get(i)));
                    if (i < dec.values.size() - 1) valBuilder.append(" ");
                }
            }
            writer.writeln(evaluateInline(dec.key) + ": " + valBuilder.toString() + ";");
        }
        else if (node instanceof ATMediaNode) {
            ATMediaNode media = (ATMediaNode) node;
            writer.writeln("@media " + evaluateInline(media.mediaQuery) + " {");
            writer.indent();
            if (media.cssRules != null) {
                for (CSSRuleNode rule : media.cssRules) generateNode(rule);
            }
            writer.dedent();
            writer.writeln("}");
        }
    }
    private String evaluateAttributeValues(AttributeValuesNode node) {
        StringBuilder sb = new StringBuilder();
        if (node.values != null) {
            for (ASTNode val : node.values) {
                if (val instanceof ExpressionNode) {
                    sb.append("{{ ").append(evaluateInline(((ExpressionNode) val).expression)).append(" }}");
                } else {
                    sb.append(evaluateInline(val));
                }
            }
        }
        return sb.toString();
    }
    private String evaluateInline(ASTNode node) {
        if (node == null) return "";

        if (node instanceof NameNode) return ((NameNode) node).value;
        if (node instanceof Front.AST.StringNode) return ((Front.AST.StringNode) node).value;
        if (node instanceof Front.AST.CSS.Value.StringNode) return "\"" + ((Front.AST.CSS.Value.StringNode) node).value + "\"";
        if (node instanceof TextNode) return ((TextNode) node).text;
        if (node instanceof IntNumberAtomNode) return String.valueOf(((IntNumberAtomNode) node).value);
        if (node instanceof DoubleNumberAtomNode) return String.valueOf(((DoubleNumberAtomNode) node).value);
        if (node instanceof BoolAtomNode) return ((BoolAtomNode) node).value ? "True" : "False";

        if (node instanceof IntValueNode) {
            IntValueNode iv = (IntValueNode) node;
            return iv.unit != null ? iv.value + iv.unit : String.valueOf(iv.value);
        }
        if (node instanceof KeyboardNode) {
            return ((KeyboardNode) node).keyboard;
        }
        if (node instanceof VariableNode) {
            return ((VariableNode) node).variable;
        }
        if (node instanceof ValueNode) {
            return evaluateInline(((ValueNode) node).value);
        }

        if (node instanceof PropertyAccessExpressionNode) {
            PropertyAccessExpressionNode prop = (PropertyAccessExpressionNode) node;
            return evaluateInline(prop.value) + "." + evaluateInline(prop.property);
        }
        if (node instanceof IndexAccessExpressionNode) {
            IndexAccessExpressionNode idx = (IndexAccessExpressionNode) node;
            return evaluateInline(idx.object) + "[" + evaluateInline(idx.index) + "]";
        }
        if (node instanceof CallExpressionNode) {
            CallExpressionNode call = (CallExpressionNode) node;
            String func = evaluateInline(call.function);
            StringBuilder args = new StringBuilder();
            if (call.arguments != null && call.arguments.arguments != null) {
                for (int i = 0; i < call.arguments.arguments.size(); i++) {
                    args.append(evaluateInline(call.arguments.arguments.get(i)));
                    if (i < call.arguments.arguments.size() - 1) args.append(", ");
                }
            }
            return func + "(" + args + ")";
        }
        if (node instanceof BinaryExpressionNode) {
            BinaryExpressionNode bin = (BinaryExpressionNode) node;
            StringBuilder sb = new StringBuilder(evaluateInline(bin.left));
            for (int i = 0; i < bin.operator.size(); i++) {
                sb.append(" ").append(getJinjaOperator(bin.operator.get(i))).append(" ")
                        .append(evaluateInline(bin.right.get(i)));
            }
            return sb.toString();
        }
        if (node instanceof CompareExpressionNode) {
            CompareExpressionNode comp = (CompareExpressionNode) node;
            StringBuilder sb = new StringBuilder(evaluateInline(comp.left));
            for (int i = 0; i < comp.ops.size(); i++) {
                sb.append(" ").append(getJinjaOperator(comp.ops.get(i))).append(" ")
                        .append(evaluateInline(comp.comparators.get(i)));
            }
            return sb.toString();
        }
        if (node instanceof UnaryExpressionNode) {
            UnaryExpressionNode unary = (UnaryExpressionNode) node;
            String op = getJinjaOperator(unary.operator);
            return op + (op.equals("not") ? " " : "") + evaluateInline(unary.operand);
        }

        if (node instanceof ClassSelectorNode) return "." + ((ClassSelectorNode) node).className;
        if (node instanceof IDSelectorNode) return "#" + ((IDSelectorNode) node).id;
        if (node instanceof NameSelectorNode) return ((NameSelectorNode) node).value;
        if (node instanceof PseudoClassSelectorNode) return ":" + ((PseudoClassSelectorNode) node).className;
        if (node instanceof StarSelectorNode) return "*";

        if (node instanceof SelectorNode) return evaluateInline(((SelectorNode) node).selector);

        if (node instanceof CombineSelectorNode) {
            CombineSelectorNode cs = (CombineSelectorNode) node;
            String sel = evaluateInline(cs.selector);
            if (cs.combinator != null) {
                sel += " " + evaluateInline(cs.combinator) + " ";
            }
            return sel;
        }
        if (node instanceof CombineSelectorsNode) {
            CombineSelectorsNode cssels = (CombineSelectorsNode) node;
            StringBuilder sb = new StringBuilder();
            if (cssels.Combineselectors != null) {
                for (CombineSelectorNode cs : cssels.Combineselectors) sb.append(evaluateInline(cs));
            }
            return sb.toString();
        }
        if (node instanceof SelectorGroupNode) {
            SelectorGroupNode sg = (SelectorGroupNode) node;
            StringBuilder sb = new StringBuilder();
            if (sg.selectors != null) {
                for (int i = 0; i < sg.selectors.size(); i++) {
                    sb.append(evaluateInline(sg.selectors.get(i)));
                    if (i < sg.selectors.size() - 1) sb.append(", ");
                }
            }
            return sb.toString();
        }

        if (node instanceof GTCombinator) return ">";
        if (node instanceof PlusCombinator) return "+";
        if (node instanceof Combinator) return evaluateInline(((Combinator) node).combinator);

        if (node instanceof NamePropertyNode) return ((NamePropertyNode) node).value;
        if (node instanceof VariablePropertyNode) return ((VariablePropertyNode) node).value;
        if (node instanceof PropertyNode) return evaluateInline(((PropertyNode) node).property);

        if (node instanceof ColorNode) return ((ColorNode) node).color;
        if (node instanceof DoubleValueNode) {
            DoubleValueNode dv = (DoubleValueNode) node;
            return dv.unit != null ? dv.value + dv.unit : String.valueOf(dv.value);
        }
        if (node instanceof FunctionNode) {
            FunctionNode fn = (FunctionNode) node;
            StringBuilder args = new StringBuilder();
            if (fn.arguments != null) {
                for (int i = 0; i < fn.arguments.size(); i++) {
                    args.append(evaluateInline(fn.arguments.get(i)));
                    if (i < fn.arguments.size() - 1) args.append(", ");
                }
            }
            return evaluateInline(fn.name) + "(" + args + ")";
        }

        if (node instanceof MediaQueryNode) {
            MediaQueryNode mq = (MediaQueryNode) node;
            return evaluateInline(mq.name) + " " + evaluateInline(mq.mediaValue);
        }
        if (node instanceof MediaValueNode) return evaluateInline(((MediaValueNode) node).value);

        return "";
    }
    private String getJinjaOperator(ASTNode op) {
        if (op instanceof AndOperatorNode) return "and";
        if (op instanceof OrOperatorNode) return "or";
        if (op instanceof NotOperatorNode) return "not";
        if (op instanceof EqualOperatorNode) return "==";
        if (op instanceof NotEqualOperatorNode) return "!=";
        if (op instanceof GreaterThanOperatorNode) return ">";
        if (op instanceof GreaterThanOrEqualOperatorNode) return ">=";
        if (op instanceof LessThanOperatorNode) return "<";
        if (op instanceof LessThanOrEqualOperatorNode) return "<=";
        return "";
    }
}
