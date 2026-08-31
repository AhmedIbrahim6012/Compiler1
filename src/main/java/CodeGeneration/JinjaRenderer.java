package CodeGeneration;

import Front.AST.*;
import Front.AST.CSS.*;
import Front.AST.CSS.Property.NamePropertyNode;
import Front.AST.CSS.Property.PropertyNode;
import Front.AST.CSS.Property.VariablePropertyNode;
import Front.AST.CSS.Selector.*;
import Front.AST.CSS.Value.*;
import Front.AST.CSS.combinators.Combinator;
import Front.AST.CSS.combinators.GTCombinator;
import Front.AST.CSS.combinators.PlusCombinator;
import Front.AST.Html.AttributeValuesNode;
import Front.AST.Html.HtmlAttributeNode;
import Front.AST.Html.HtmlDocument;
import Front.AST.Html.HtmlElementNode;
import Front.AST.JInja2.BlockNode;
import Front.AST.JInja2.ExpressionStatement.*;
import Front.AST.JInja2.ExpressionStatement.Operators.*;
import Front.AST.JInja2.ForStatementNode;
import Front.AST.JInja2.IfStatementNode;

import java.util.*;


public class JinjaRenderer {

    private final Map<String, Object> context;
    private final StringBuilder output = new StringBuilder();

    public JinjaRenderer(Map<String, Object> context) {
        this.context = context != null ? context : new HashMap<>();
    }

    public String render(ASTNode node) {
        output.setLength(0);
        renderNode(node);
        return output.toString();
    }

    // =========================================================
    // Render Node
    // =========================================================

    private void renderNode(ASTNode node) {
        if (node == null) return;

        if (node instanceof HtmlDocument)    { renderHtmlDocument((HtmlDocument) node);    return; }
        if (node instanceof TextNode)        { output.append(((TextNode) node).text);       return; }
        if (node instanceof HtmlElementNode) { renderHtmlElement((HtmlElementNode) node);   return; }
        if (node instanceof ExpressionNode)  { renderExpression((ExpressionNode) node);     return; }
        if (node instanceof IfStatementNode) { renderIf((IfStatementNode) node);            return; }
        if (node instanceof ForStatementNode){ renderFor((ForStatementNode) node);           return; }
        if (node instanceof BlockNode)       { renderBlock((BlockNode) node);                return; }
        if (node instanceof CSSStatements){ renderStyleElement((CSSStatements) node);  return; }
        if (node instanceof CSSStatements)   { renderCSSStatements((CSSStatements) node);   return; }
        if (node instanceof ATMediaNode)     { renderATMedia((ATMediaNode) node);            return; }
        if (node instanceof CSSRuleNode)     { renderCSSRule((CSSRuleNode) node);            return; }
        if (node instanceof CSSBlockNode)    { renderCSSBlock((CSSBlockNode) node);          return; }
        if (node instanceof DeclarationNode) { renderDeclaration((DeclarationNode) node);    return; }
    }

    // =========================================================
    // HTML
    // =========================================================

    private void renderHtmlDocument(HtmlDocument doc) {
        if (doc.doctype != null)
            output.append(doc.doctype.value).append("\n");
        if (doc.elements != null)
            for (ASTNode el : doc.elements) renderNode(el);
    }

    private void renderHtmlElement(HtmlElementNode element) {
        output.append("<").append(plainName(element.tagName));

        if (element.attributes != null) {
            for (HtmlAttributeNode attr : element.attributes) {
                output.append(" ").append(plainName(attr.key));
                if (attr.value != null)
                    output.append("=\"").append(renderAttribute(attr.value)).append("\"");
            }
        }

        output.append(">");

        if (!element.isSelfClose) {
            if (element.children != null)
                for (ASTNode child : element.children) renderNode(child);
            output.append("</").append(plainName(element.tagName)).append(">");
        }
    }

    private void renderExpression(ExpressionNode expr) {
        Object value = evaluateExpression(expr.expression);
        if (value != null) output.append(value);
    }

    // =========================================================
    // Style
    // =========================================================

    private void renderStyleElement(CSSStatements node) {
        output.append("\n<style>\n");
        if (node.statements != null)
            for (ASTNode stmt : node.statements) renderNode(stmt);
        output.append("</style>\n");
    }

    private void renderCSSStatements(CSSStatements css) {
        if (css.statements != null)
            for (ASTNode stmt : css.statements) renderNode(stmt);
    }

    // ─── @media ───────────────────────────────────────────────

    private void renderATMedia(ATMediaNode media) {
        // من الـ AST: MediaQueryNode يحمل Name كنص جاهز مثل "(max-width:768px)"
        // نأخذ الاسم فقط ونتجاهل الـ Value المكررة
        output.append("@media ").append(renderMediaQuery(media.mediaQuery)).append(" {\n");
        if (media.cssRules != null)
            for (CSSRuleNode rule : media.cssRules) renderCSSRule(rule);
        output.append("}\n");
    }

    private String renderMediaQuery(ASTNode node) {
        if (node == null) return "";
        if (node instanceof MediaQueryNode) {
            MediaQueryNode mq = (MediaQueryNode) node;
            // Name يحمل النص الكامل مثل "(max-width:768px)"
            // نأخذه مباشرة ونتجاهل mq.mediaValue لأنه مكرر من الـ Visitor
            String name = plainName(mq.name);
            // إذا كان النص يحتوي على القيمة بالفعل، لا نضيف شيئاً
            return name;
        }
        return plainName(node);
    }

    // ─── CSS Rule ─────────────────────────────────────────────

    private void renderCSSRule(CSSRuleNode rule) {
        output.append(renderSelectorGroup(rule.selectorGroup)).append(" {\n");
        if (rule.block != null) renderNode(rule.block);
        output.append("}\n");
    }

    private void renderCSSBlock(CSSBlockNode block) {
        if (block.declarations != null)
            for (DeclarationNode dec : block.declarations) renderNode(dec);
    }

    private void renderDeclaration(DeclarationNode dec) {
        output.append("  ").append(renderProperty(dec.key)).append(": ");
        if (dec.values != null) {
            for (int i = 0; i < dec.values.size(); i++) {
                output.append(renderCSSValue(dec.values.get(i)));
                if (i < dec.values.size() - 1) output.append(" ");
            }
        }
        output.append(";\n");
    }

    // =========================================================
    // Selector Rendering
    // =========================================================

    private String renderSelectorGroup(ASTNode node) {
        if (node == null) return "";
        if (node instanceof SelectorGroupNode) {
            SelectorGroupNode sg = (SelectorGroupNode) node;
            StringBuilder sb = new StringBuilder();
            if (sg.selectors != null) {
                for (int i = 0; i < sg.selectors.size(); i++) {
                    sb.append(renderCombineSelectors(sg.selectors.get(i)));
                    if (i < sg.selectors.size() - 1) sb.append(", ");
                }
            }
            return sb.toString();
        }
        return plainName(node);
    }

    private String renderCombineSelectors(ASTNode node) {
        if (node instanceof CombineSelectorsNode) {
            CombineSelectorsNode csn = (CombineSelectorsNode) node;
            StringBuilder sb = new StringBuilder();
            if (csn.Combineselectors != null)
                for (CombineSelectorNode cs : csn.Combineselectors)
                    sb.append(renderCombineSelector(cs));
            return sb.toString().trim();
        }
        return plainName(node);
    }

    private String renderCombineSelector(CombineSelectorNode cs) {
        if (cs == null) return "";
        String sel = renderSimpleSelector(cs.selector);
        if (cs.combinator != null)
            return sel + " " + renderCombinator(cs.combinator) + " ";
        return sel;
    }

    private String renderSimpleSelector(ASTNode node) {
        if (node instanceof SelectorNode)
            return renderSimpleSelector(((SelectorNode) node).selector);

        // ✅ إصلاح: ClassSelectorNode يحمل ".navbar" مع النقطة من الـ Visitor
        // نضمن عدم تكرار النقطة
        if (node instanceof ClassSelectorNode) {
            String cn = ((ClassSelectorNode) node).className;
            return cn.startsWith(".") ? cn : "." + cn;
        }

        if (node instanceof IDSelectorNode) {
            String id = ((IDSelectorNode) node).id;
            return id.startsWith("#") ? id : "#" + id;
        }

        if (node instanceof NameSelectorNode)
            return ((NameSelectorNode) node).value;

        // ✅ إصلاح: PseudoClassSelectorNode يحمل ":root" أو "root"؟
        // نضمن نقطة واحدة فقط
        if (node instanceof PseudoClassSelectorNode) {
            String cn = ((PseudoClassSelectorNode) node).className;
            return cn.startsWith(":") ? cn : ":" + cn;
        }

        if (node instanceof StarSelectorNode) return "*";
        return plainName(node);
    }

    private String renderCombinator(ASTNode node) {
        if (node instanceof GTCombinator)   return ">";
        if (node instanceof PlusCombinator) return "+";
        if (node instanceof Combinator)     return renderCombinator(((Combinator) node).combinator);
        return "";
    }

    // =========================================================
    // Property Rendering
    // =========================================================

    private String renderProperty(ASTNode node) {
        if (node instanceof NamePropertyNode)
            return ((NamePropertyNode) node).value;

        // ✅ إصلاح: Variable في property = CSS custom property definition
        // من الـ AST: Variable(primary-color) بدون -- ، نضيفها
        if (node instanceof VariablePropertyNode) {
            String v = ((VariablePropertyNode) node).value;
            return v.startsWith("--") ? v : "--" + v;
        }

        if (node instanceof PropertyNode)
            return renderProperty(((PropertyNode) node).property);

        return plainName(node);
    }

    // =========================================================
    // CSS Value Rendering
    // =========================================================

    private String renderCSSValue(ASTNode node) {
        if (node == null) return "";

        // ✅ IntValueNode: "8 px" → "8px" (إزالة الفراغ بين الرقم والوحدة)
        if (node instanceof IntValueNode) {
            IntValueNode iv = (IntValueNode) node;
            return iv.unit != null ? iv.value + iv.unit : String.valueOf(iv.value);
        }
        if (node instanceof DoubleValueNode) {
            DoubleValueNode dv = (DoubleValueNode) node;
            return dv.unit != null ? dv.value + dv.unit : String.valueOf(dv.value);
        }

        if (node instanceof ColorNode)    return ((ColorNode) node).color;
        if (node instanceof KeyboardNode) return ((KeyboardNode) node).keyboard;

        // ✅ إصلاح VariableNode في القيم: "dark-color" → "var(--dark-color)"
        if (node instanceof VariableNode) {
            String v = ((VariableNode) node).variable;
            // أحياناً يأتي بـ -- وأحياناً بدونها
            String withDashes = v.startsWith("--") ? v : "--" + v;
            return "var(" + withDashes + ")";
        }

        if (node instanceof Front.AST.CSS.Value.StringNode)
            return "\"" + ((Front.AST.CSS.Value.StringNode) node).value + "\"";

        if (node instanceof ValueNode)
            return renderCSSValue(((ValueNode) node).value);

        // NameNode في CSS = اسم ثابت كـ "flex", "auto", "none", "deg"
        if (node instanceof NameNode)
            return ((NameNode) node).value;

        if (node instanceof FunctionNode)
            return renderFunction((FunctionNode) node);

        return "";
    }

    // ─── Function ─────────────────────────────────────────────

    private String renderFunction(FunctionNode fn) {
        String name = plainName(fn.name);
        if (fn.arguments == null || fn.arguments.isEmpty())
            return name + "()";

        // ✅ إصلاح linear-gradient:
        // من الـ AST: params = [135, "deg", var(--primary-color), 0%, #2980b9, 100%]
        // المطلوب: linear-gradient(135deg, var(--primary-color) 0%, #2980b9 100%)
        if (name.equals("linear-gradient") || name.equals("radial-gradient"))
            return name + "(" + renderGradientArgs(fn.arguments) + ")";

        // ✅ إصلاح repeat/minmax:
        // من الـ AST: minmax(280px, 1, fr) → minmax(280px, 1fr)
        if (name.equals("repeat") || name.equals("minmax"))
            return name + "(" + renderGridArgs(fn.arguments) + ")";

        // var(), rgba(), scale(), translateY(), ...
        StringBuilder args = new StringBuilder();
        for (int i = 0; i < fn.arguments.size(); i++) {
            args.append(renderCSSValue(fn.arguments.get(i)));
            if (i < fn.arguments.size() - 1) args.append(", ");
        }
        return name + "(" + args + ")";
    }

    /**
     * linear-gradient: أول حجة هي الاتجاه (قد تكون رقم + "deg" منفصلان)
     * الباقي: color-stop pairs (color + position)
     * مثال من الـ AST: [135, "deg", var(--x), 0%, #color, 100%]
     * الناتج: 135deg, var(--x) 0%, #color 100%
     */
    private String renderGradientArgs(List<ASTNode> args) {
        StringBuilder sb = new StringBuilder();
        int i = 0;

        // الاتجاه: رقم + deg منفصلان أو رقم بوحدة
        if (i < args.size()) {
            ASTNode first = args.get(i);
            String firstStr = renderCSSValue(first);

            // إذا كان الأول رقماً صافياً (بدون وحدة) والثاني "deg"
            if (i + 1 < args.size() && isPlainNumber(first)) {
                ASTNode second = args.get(i + 1);
                if (second instanceof NameNode &&
                        ((NameNode) second).value.equals("deg")) {
                    sb.append(firstStr).append("deg");
                    i += 2;
                } else {
                    sb.append(firstStr);
                    i++;
                }
            } else {
                sb.append(firstStr);
                i++;
            }
        }

        // color-stops: يأتون بشكل أزواج (color + position) أو منفردين
        while (i < args.size()) {
            sb.append(", ");
            String val = renderCSSValue(args.get(i));
            i++;
            // هل الذي يليه position (رقم%)؟
            if (i < args.size() && isPositionValue(args.get(i))) {
                val += " " + renderCSSValue(args.get(i));
                i++;
            }
            sb.append(val);
        }

        return sb.toString();
    }

    /**
     * grid args: repeat/minmax
     * إصلاح: [1, "fr"] → "1fr"  و  [auto-fill, minmax(...)] → "auto-fill, minmax(...)"
     */
    private String renderGridArgs(List<ASTNode> args) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < args.size()) {
            ASTNode current = args.get(i);
            String val = renderCSSValue(current);

            // إذا كان رقماً صافياً والتالي "fr"
            if (isPlainNumber(current) && i + 1 < args.size()) {
                ASTNode next = args.get(i + 1);
                if (next instanceof NameNode &&
                        ((NameNode) next).value.equals("fr")) {
                    val = val + "fr";
                    i += 2;
                    sb.append(val);
                    if (i < args.size()) sb.append(", ");
                    continue;
                }
            }

            // FunctionNode داخلية (مثل minmax داخل repeat)
            if (current instanceof FunctionNode) {
                val = renderFunction((FunctionNode) current);
            }

            sb.append(val);
            i++;
            if (i < args.size()) sb.append(", ");
        }
        return sb.toString();
    }

    // =========================================================
    // Attribute Rendering
    // =========================================================

    private String renderAttribute(AttributeValuesNode node) {
        if (node == null || node.values == null) return "";
        StringBuilder result = new StringBuilder();
        for (ASTNode val : node.values) {
            if (val instanceof ExpressionNode) {
                Object evaluated = evaluateExpression(((ExpressionNode) val).expression);
                if (evaluated != null) result.append(evaluated);
            } else {
                result.append(plainName(val));
            }
        }
        return result.toString();
    }

    // =========================================================
    // Jinja IF
    // =========================================================

    private void renderIf(IfStatementNode node) {
        Object condition = evaluateExpression(node.expression.expression);
        if (isTruthy(condition)) {
            renderElements(node.elements);
            return;
        }
        if (node.elseIf != null) {
            for (IfStatementNode.ElseIf elif : node.elseIf) {
                Object c = evaluateExpression(elif.expression.expression);
                if (isTruthy(c)) { renderElements(elif.elements); return; }
            }
        }
        if (node.elseBody != null)
            renderElements(node.elseBody.elements);
    }

    // =========================================================
    // Jinja FOR
    // =========================================================

    private void renderFor(ForStatementNode node) {
        Object iterable = evaluateExpression(node.expression.expression);
        if (iterable == null) return;
        String varName = node.itrator.value;

        if (iterable instanceof Iterable<?>) {
            for (Object item : (Iterable<?>) iterable) {
                context.put(varName, item);
                renderElements(node.elements);
            }
            context.remove(varName);
            return;
        }
        if (iterable.getClass().isArray()) {
            int len = java.lang.reflect.Array.getLength(iterable);
            for (int i = 0; i < len; i++) {
                context.put(varName, java.lang.reflect.Array.get(iterable, i));
                renderElements(node.elements);
            }
            context.remove(varName);
        }
    }

    // =========================================================
    // Jinja BLOCK
    // =========================================================

    private void renderBlock(BlockNode block) {
        if (block.elements != null)
            for (ASTNode el : block.elements) renderNode(el);
    }

    private void renderElements(List<ASTNode> elements) {
        if (elements == null) return;
        for (ASTNode el : elements) renderNode(el);
    }

    // =========================================================
    // Expression Evaluation
    // =========================================================

    private Object evaluateExpression(ASTNode node) {
        if (node == null) return null;

        if (node instanceof NameNode)
            return context.getOrDefault(((NameNode) node).value, null);

        if (node instanceof Front.AST.StringNode) {
            String v = ((Front.AST.StringNode) node).value;
            if (v != null && v.length() >= 2 &&
                    ((v.startsWith("\"") && v.endsWith("\"")) ||
                            (v.startsWith("'")  && v.endsWith("'")))) {
                return v.substring(1, v.length() - 1);
            }
            return v;
        }

        if (node instanceof IntNumberAtomNode)    return ((IntNumberAtomNode) node).value;
        if (node instanceof DoubleNumberAtomNode) return ((DoubleNumberAtomNode) node).value;
        if (node instanceof BoolAtomNode)         return ((BoolAtomNode) node).value;

        if (node instanceof PropertyAccessExpressionNode) {
            PropertyAccessExpressionNode prop = (PropertyAccessExpressionNode) node;
            Object obj = evaluateExpression(prop.value);
            if (obj == null) return null;
            String key = ((NameNode) prop.property).value;
            return getProperty(obj, key);
        }

        if (node instanceof IndexAccessExpressionNode) {
            IndexAccessExpressionNode idx = (IndexAccessExpressionNode) node;
            return getIndex(evaluateExpression(idx.object), evaluateExpression(idx.index));
        }

        if (node instanceof BinaryExpressionNode)  return evaluateBinary((BinaryExpressionNode) node);
        if (node instanceof CompareExpressionNode) return evaluateCompare((CompareExpressionNode) node);

        if (node instanceof UnaryExpressionNode) {
            UnaryExpressionNode u = (UnaryExpressionNode) node;
            Object v = evaluateExpression(u.operand);
            if (u.operator instanceof NotOperatorNode) return !isTruthy(v);
            return v;
        }

        if (node instanceof CallExpressionNode) return evaluateCall((CallExpressionNode) node);
        return null;
    }

    // =========================================================
    // Property / Index Access
    // =========================================================

    @SuppressWarnings("unchecked")
    private Object getProperty(Object obj, String key) {
        if (obj instanceof Map<?, ?>) return ((Map<String, Object>) obj).get(key);
        try { var f = obj.getClass().getDeclaredField(key); f.setAccessible(true); return f.get(obj); }
        catch (Exception ignored) {}
        try {
            String m = "get" + Character.toUpperCase(key.charAt(0)) + key.substring(1);
            return obj.getClass().getMethod(m).invoke(obj);
        } catch (Exception ignored) {}
        return null;
    }

    @SuppressWarnings("unchecked")
    private Object getIndex(Object obj, Object idx) {
        if (obj == null || idx == null) return null;
        if (obj instanceof List<?>) {
            int i = ((Number) idx).intValue();
            List<?> l = (List<?>) obj;
            return (i >= 0 && i < l.size()) ? l.get(i) : null;
        }
        if (obj instanceof Map<?, ?>) return ((Map<String, Object>) obj).get(idx.toString());
        return null;
    }

    // =========================================================
    // Binary / Compare
    // =========================================================

    private Object evaluateBinary(BinaryExpressionNode node) {
        Object result = evaluateExpression(node.left);
        if (node.operator == null) return result;
        for (int i = 0; i < node.operator.size(); i++) {
            Object right = evaluateExpression(node.right.get(i));
            String op = getOperator(node.operator.get(i));
            switch (op) {
                case "and": result = isTruthy(result) && isTruthy(right); break;
                case "or":  result = isTruthy(result) || isTruthy(right); break;
                case "+":
                    if (result instanceof Number && right instanceof Number)
                        result = ((Number)result).doubleValue() + ((Number)right).doubleValue();
                    else result = String.valueOf(result) + String.valueOf(right);
                    break;
                case "-": result = ((Number)result).doubleValue() - ((Number)right).doubleValue(); break;
                case "*": result = ((Number)result).doubleValue() * ((Number)right).doubleValue(); break;
                case "/": result = ((Number)result).doubleValue() / ((Number)right).doubleValue(); break;
            }
        }
        return result;
    }

    private Object evaluateCompare(CompareExpressionNode node) {
        Object left = evaluateExpression(node.left);
        for (int i = 0; i < node.ops.size(); i++) {
            Object right = evaluateExpression(node.comparators.get(i));
            if (!compare(left, right, getOperator(node.ops.get(i)))) return false;
            left = right;
        }
        return true;
    }

    @SuppressWarnings({"unchecked","rawtypes"})
    private boolean compare(Object l, Object r, String op) {
        if (op.equals("==")) return Objects.equals(l, r);
        if (op.equals("!=")) return !Objects.equals(l, r);
        if (l instanceof Comparable && r != null) {
            int c = ((Comparable) l).compareTo(r);
            switch (op) {
                case ">": return c > 0; case ">=": return c >= 0;
                case "<": return c < 0; case "<=": return c <= 0;
            }
        }
        return false;
    }

    // =========================================================
    // Function Calls (Jinja)
    // =========================================================

    private Object evaluateCall(CallExpressionNode node) {
        if (!(node.function instanceof NameNode)) return null;
        String fn = ((NameNode) node.function).value;

        List<Object> args = new ArrayList<>();
        if (node.arguments != null && node.arguments.arguments != null)
            for (ASTNode a : node.arguments.arguments)
                args.add(evaluateExpression(a));

        // دوال مسجّلة في الـ context
        Object registered = context.get(fn);
        if (registered instanceof java.util.function.Function) {
            @SuppressWarnings("unchecked")
            java.util.function.Function<List<Object>, Object> f =
                    (java.util.function.Function<List<Object>, Object>) registered;
            return f.apply(args);
        }

        switch (fn) {
            case "len":
                if (args.isEmpty()) return 0;
                Object v = args.get(0);
                if (v instanceof Collection<?>) return ((Collection<?>) v).size();
                if (v instanceof String)        return ((String) v).length();
                return 0;
            case "str":   return args.isEmpty() ? "" : String.valueOf(args.get(0));
            case "range":
                List<Integer> r = new ArrayList<>();
                if (args.size() == 1) for (int i=0;i<((Number)args.get(0)).intValue();i++) r.add(i);
                else if (args.size()>=2) for (int i=((Number)args.get(0)).intValue();i<((Number)args.get(1)).intValue();i++) r.add(i);
                return r;
            case "url_for":
            default:
                return "";
        }
    }

    // =========================================================
    // Truthiness
    // =========================================================

    private boolean isTruthy(Object v) {
        if (v == null) return false;
        if (v instanceof Boolean)       return (Boolean) v;
        if (v instanceof String)        return !((String) v).isEmpty();
        if (v instanceof Collection<?>) return !((Collection<?>) v).isEmpty();
        if (v instanceof Map<?,?>)      return !((Map<?,?>) v).isEmpty();
        if (v instanceof Number)        return ((Number) v).doubleValue() != 0;
        return true;
    }

    // =========================================================
    // Operator mapping
    // =========================================================

    private String getOperator(ASTNode op) {
        if (op instanceof AndOperatorNode)                return "and";
        if (op instanceof OrOperatorNode)                 return "or";
        if (op instanceof NotOperatorNode)                return "not";
        if (op instanceof EqualOperatorNode)              return "==";
        if (op instanceof NotEqualOperatorNode)           return "!=";
        if (op instanceof GreaterThanOperatorNode)        return ">";
        if (op instanceof GreaterThanOrEqualOperatorNode) return ">=";
        if (op instanceof LessThanOperatorNode)           return "<";
        if (op instanceof LessThanOrEqualOperatorNode)    return "<=";
        return "";
    }

    // =========================================================
    // Helpers
    // =========================================================

    /**
     * plainName: يأخذ NameNode أو أي node ويرجع قيمته النصية الخام.
     * مخصص للـ HTML (أسماء tags، attributes) والـ CSS (أسماء selectors، functions).
     * لا يبحث في الـ context أبداً.
     */
    private String plainName(ASTNode node) {
        if (node == null) return "";
        if (node instanceof NameNode)          return ((NameNode) node).value;
        if (node instanceof TextNode)          return ((TextNode) node).text;
        if (node instanceof Front.AST.StringNode)
            return ((Front.AST.StringNode) node).value;
        if (node instanceof VariableNode)      return ((VariableNode) node).variable;
        if (node instanceof KeyboardNode)      return ((KeyboardNode) node).keyboard;
        if (node instanceof ColorNode)         return ((ColorNode) node).color;
        if (node instanceof ValueNode)         return plainName(((ValueNode) node).value);
        if (node instanceof MediaValueNode)    return plainName(((MediaValueNode) node).value);
        if (node instanceof IntValueNode) {
            IntValueNode iv = (IntValueNode) node;
            return iv.unit != null ? iv.value + iv.unit : String.valueOf(iv.value);
        }
        if (node instanceof DoubleValueNode) {
            DoubleValueNode dv = (DoubleValueNode) node;
            return dv.unit != null ? dv.value + dv.unit : String.valueOf(dv.value);
        }
        if (node instanceof IntNumberAtomNode)    return String.valueOf(((IntNumberAtomNode) node).value);
        if (node instanceof DoubleNumberAtomNode) return String.valueOf(((DoubleNumberAtomNode) node).value);
        return "";
    }

    /** هل الـ node عبارة عن رقم بدون وحدة؟ */
    private boolean isPlainNumber(ASTNode node) {
        if (node instanceof IntValueNode)
            return ((IntValueNode) node).unit == null;
        if (node instanceof DoubleValueNode)
            return ((DoubleValueNode) node).unit == null;
        if (node instanceof IntNumberAtomNode || node instanceof DoubleNumberAtomNode)
            return true;
        return false;
    }

    /** هل الـ node قيمة موضع (مثل 0%, 100%)؟ */
    private boolean isPositionValue(ASTNode node) {
        if (node instanceof IntValueNode)
            return "%".equals(((IntValueNode) node).unit);
        if (node instanceof DoubleValueNode)
            return "%".equals(((DoubleValueNode) node).unit);
        return false;
    }
}