package CodeGeneration;

import Back.AST.*;
import Back.AST.ExpressionStatement.*;
import Back.AST.ExpressionStatement.Atoms.*;
import Back.AST.ExpressionStatement.Operators.OperatorNode;
import Back.AST.FlowStatement.*;
import Back.AST.ImporStatement.*;
import Back.AST.ExpressionStatement.Operators.*;
import java.util.Map;


    public class BackGenerator {

        private final CodeWriter writer = new CodeWriter();
        public String generate(ASTNode node) {
            generateStatement(node);
            return writer.getCode();
        }
        private void generateStatement(ASTNode node) {
            if (node == null) return;

            if (node instanceof Program) {
                Program prog = (Program) node;
                if (prog.statements != null) {
                    for (ASTNode stmt : prog.statements) {
                        generateStatement(stmt);
                    }
                }
            }
            else if (node instanceof BlockNode) {
                BlockNode block = (BlockNode) node;
                if (block.statements == null || block.statements.isEmpty()) {
                    writer.writeln("pass");
                } else {
                    for (ASTNode stmt : block.statements) {
                        generateStatement(stmt);
                    }
                }
            }
            else if (node instanceof SimpleStatementsNode) {
                SimpleStatementsNode ssn = (SimpleStatementsNode) node;
                if (ssn.statements != null) {
                    for (SimpleStatementNode stmt : ssn.statements) {
                        generateStatement(stmt);
                    }
                }
            }

            else if (node instanceof FunctionDefNode) {
                FunctionDefNode func = (FunctionDefNode) node;
                String name = evaluateExpression(func.name);
                String params = func.parameters != null ? evaluateExpression(func.parameters) : "";
                writer.writeln("def " + name + "(" + params + "):");
                writer.indent();
                generateStatement(func.body);
                writer.dedent();
            }
            else if (node instanceof DecoratorNode) {
                DecoratorNode decNode = (DecoratorNode) node;
                if (decNode.decorates != null) {
                    for (DecoratorNode.Decorate dec : decNode.decorates) {
                        StringBuilder sb = new StringBuilder("@");
                        sb.append(evaluateExpression(dec.dottedName));
                        if (dec.argumentsExpression != null) {
                            sb.append("(").append(evaluateExpression(dec.argumentsExpression)).append(")");
                        }
                        writer.writeln(sb.toString());
                    }
                }
                generateStatement(decNode.function);
            }

            else if (node instanceof ForStatementNode) {
                ForStatementNode forNode = (ForStatementNode) node;
                StringBuilder params = new StringBuilder();
                if (forNode.params != null) {
                    for (int i = 0; i < forNode.params.size(); i++) {
                        params.append(evaluateExpression(forNode.params.get(i)));
                        if (i < forNode.params.size() - 1) {
                            params.append(", ");
                        }
                    }
                }
                writer.writeln("for " + params + " in " + evaluateExpression(forNode.expression) + ":");
                writer.indent();
                generateStatement(forNode.body);
                writer.dedent();
                if (forNode.elseBody != null) {
                    writer.writeln("else:");
                    writer.indent();
                    generateStatement(forNode.elseBody.body);
                    writer.dedent();
                }
            }
            else if (node instanceof IfStatementNode) {
                IfStatementNode ifNode = (IfStatementNode) node;
                writer.writeln("if " + evaluateExpression(ifNode.condition) + ":");
                writer.indent();
                generateStatement(ifNode.body);
                writer.dedent();
                if (ifNode.elseIf != null) {
                    for (IfStatementNode.ElseIf elif : ifNode.elseIf) {
                        writer.writeln("elif " + evaluateExpression(elif.condition) + ":");
                        writer.indent();
                        generateStatement(elif.body);
                        writer.dedent();
                    }
                }
                if (ifNode.elseBody != null) {
                    writer.writeln("else:");
                    writer.indent();
                    generateStatement(ifNode.elseBody.body);
                    writer.dedent();
                }
            }
            else if (node instanceof TryStatementNode) {
                TryStatementNode tryNode = (TryStatementNode) node;
                writer.writeln("try:");
                writer.indent();
                generateStatement(tryNode.body);
                writer.dedent();
                if (tryNode.excepts != null) {
                    for (TryStatementNode.Except exc : tryNode.excepts) {
                        if (exc.expression != null) {
                            writer.writeln("except " + evaluateExpression(exc.expression) + ":");
                        } else {
                            writer.writeln("except:");
                        }
                        writer.indent();
                        generateStatement(exc.body);
                        writer.dedent();
                    }
                }
            }

            else if (node instanceof BreakStatementNode) {
                writer.writeln("break");
            }
            else if (node instanceof ContinueStatementNode) {
                writer.writeln("continue");
            }
            else if (node instanceof ReturnStatementNode) {
                ReturnStatementNode ret = (ReturnStatementNode) node;
                if (ret.expression != null) {
                    writer.writeln("return " + evaluateExpression(ret.expression));
                } else {
                    writer.writeln("return");
                }
            }
            else if (node instanceof RaiseStatementNode) {
                RaiseStatementNode raise = (RaiseStatementNode) node;
                StringBuilder sb = new StringBuilder("raise");
                if (raise.expressionBeforeFrom != null) {
                    sb.append(" ").append(evaluateExpression(raise.expressionBeforeFrom));
                }
                if (raise.expressionAfterFrom != null) {
                    sb.append(" from ").append(evaluateExpression(raise.expressionAfterFrom));
                }
                writer.writeln(sb.toString());
            }

            else if (node instanceof ImportFromNode) {
                ImportFromNode impFrom = (ImportFromNode) node;
                String dotted = evaluateExpression(impFrom.dottedName);
                String names = evaluateExpression(impFrom.importAsNames);
                writer.writeln("from " + dotted + " import " + names);
            }
            else if (node instanceof ImportNameNode) {
                ImportNameNode impName = (ImportNameNode) node;
                StringBuilder sb = new StringBuilder("import ");
                if (impName.DottedAsNames != null) {
                    for (int i = 0; i < impName.DottedAsNames.size(); i++) {
                        sb.append(evaluateExpression(impName.DottedAsNames.get(i)));
                        if (i < impName.DottedAsNames.size() - 1) {
                            sb.append(", ");
                        }
                    }
                }
                writer.writeln(sb.toString());
            }

            else if (node instanceof ExpressionNode) {
                writer.writeln(evaluateExpression((ExpressionNode) node));
            }
        }
        private String evaluateExpression(ASTNode node) {
            if (node == null) return "";

            if (node instanceof BoolAtomNode) {
                return ((BoolAtomNode) node).value ? "True" : "False";
            }
            else if (node instanceof IntNumberAtomNode) {
                return String.valueOf(((IntNumberAtomNode) node).value);
            }
            else if (node instanceof DoubleNumberAtomNode) {
                return String.valueOf(((DoubleNumberAtomNode) node).value);
            }
            else if (node instanceof StringAtomNode) {
                String val = ((StringAtomNode) node).value;
                if (val == null) return "''";
                if ((val.startsWith("\"") && val.endsWith("\"")) || (val.startsWith("'") && val.endsWith("'"))) {
                    return val;
                } else {
                    return "\"" + val + "\"";
                }
            }
            else if (node instanceof NameAtomNode) {
                return ((NameAtomNode) node).value;
            }
            else if (node instanceof NoneAtomNode) {
                return "None";
            }

            else if (node instanceof ArgumentsExpressionNode) {
                ArgumentsExpressionNode args = (ArgumentsExpressionNode) node;
                StringBuilder sb = new StringBuilder();
                if (args.arguments != null) {
                    for (int i = 0; i < args.arguments.size(); i++) {
                        sb.append(evaluateExpression(args.arguments.get(i)));
                        if (i < args.arguments.size() - 1) {
                            sb.append(", ");
                        }
                    }
                }
                return sb.toString();
            }
            else if (node instanceof ArithmeticExpressionNode) {
                ArithmeticExpressionNode arith = (ArithmeticExpressionNode) node;
                return evaluateExpression(arith.left) + " " + getOperatorStr(arith.operator) + " " + evaluateExpression(arith.right);
            }
            else if (node instanceof BinaryExpressionNode) {
                BinaryExpressionNode bin = (BinaryExpressionNode) node;
                StringBuilder sb = new StringBuilder();
                sb.append(evaluateExpression(bin.left));
                if (bin.operator != null && bin.right != null) {
                    for (int i = 0; i < bin.operator.size(); i++) {
                        sb.append(" ").append(getOperatorStr(bin.operator.get(i))).append(" ");
                        sb.append(evaluateExpression(bin.right.get(i)));
                    }
                }
                return sb.toString();
            }
            else if (node instanceof CompareExpressionNode) {
                CompareExpressionNode comp = (CompareExpressionNode) node;
                StringBuilder sb = new StringBuilder();
                sb.append(evaluateExpression(comp.left));
                if (comp.ops != null && comp.comparators != null) {
                    for (int i = 0; i < comp.ops.size(); i++) {
                        sb.append(" ").append(getOperatorStr(comp.ops.get(i))).append(" ");
                        sb.append(evaluateExpression(comp.comparators.get(i)));
                    }
                }
                return sb.toString();
            }
            else if (node instanceof CallExpressionNode) {
                CallExpressionNode call = (CallExpressionNode) node;
                String func = evaluateExpression(call.function);
                String args = call.arguments != null ? evaluateExpression(call.arguments) : "";
                return func + "(" + args + ")";
            }
            else if (node instanceof AttributeExpressionNode) {
                AttributeExpressionNode attr = (AttributeExpressionNode) node;
                return evaluateExpression(attr.value) + "." + attr.attribute;
            }
            else if (node instanceof IndexExpressionNode) {
                IndexExpressionNode idx = (IndexExpressionNode) node;
                return evaluateExpression(idx.object) + "[" + evaluateExpression(idx.index) + "]";
            }
            else if (node instanceof ListExpressionNode) {
                ListExpressionNode list = (ListExpressionNode) node;
                StringBuilder sb = new StringBuilder("[");
                if (list.elements != null) {
                    for (int i = 0; i < list.elements.size(); i++) {
                        sb.append(evaluateExpression(list.elements.get(i)));
                        if (i < list.elements.size() - 1) {
                            sb.append(", ");
                        }
                    }
                }
                sb.append("]");
                return sb.toString();
            }
            else if (node instanceof TupleExpressionNode) {
                TupleExpressionNode tuple = (TupleExpressionNode) node;
                StringBuilder sb = new StringBuilder("(");
                if (tuple.elements != null) {
                    for (int i = 0; i < tuple.elements.size(); i++) {
                        sb.append(evaluateExpression(tuple.elements.get(i)));
                        if (i < tuple.elements.size() - 1) {
                            sb.append(", ");
                        }
                    }
                    if (tuple.elements.size() == 1) {
                        sb.append(",");
                    }
                }
                sb.append(")");
                return sb.toString();
            }
            else if (node instanceof DictionaryExpressionNode) {
                DictionaryExpressionNode dict = (DictionaryExpressionNode) node;
                StringBuilder sb = new StringBuilder("{");
                if (dict.map != null) {
                    int count = 0;
                    for (Map.Entry<ExpressionNode, ExpressionNode> entry : dict.map.entrySet()) {
                        sb.append(evaluateExpression(entry.getKey()))
                                .append(": ")
                                .append(evaluateExpression(entry.getValue()));
                        if (++count < dict.map.size()) {
                            sb.append(", ");
                        }
                    }
                }
                sb.append("}");
                return sb.toString();
            }
            else if (node instanceof UnaryExpressionNode) {
                UnaryExpressionNode unary = (UnaryExpressionNode) node;
                String op = getOperatorStr(unary.operator);
                String spacing = op.equals("not") ? " " : "";
                return op + spacing + evaluateExpression(unary.operand);
            }
            else if (node instanceof AssignmentStatement) {
                AssignmentStatement assign = (AssignmentStatement) node;
                StringBuilder sb = new StringBuilder();
                if (assign.targets != null) {
                    for (ExpressionNode target : assign.targets) {
                        sb.append(evaluateExpression(target)).append(" = ");
                    }
                }
                sb.append(evaluateExpression(assign.value));
                return sb.toString();
            }

            else if (node instanceof DottedAsNameNode) {
                DottedAsNameNode dan = (DottedAsNameNode) node;
                String dotted = evaluateExpression(dan.dottedName);
                return dan.alias == null ? dotted : dotted + " as " + dan.alias;
            }
            else if (node instanceof DottedNameNode) {
                DottedNameNode dn = (DottedNameNode) node;
                return dn.parts == null ? "" : String.join(".", dn.parts);
            }
            else if (node instanceof ImportAsNameNode) {
                ImportAsNameNode ian = (ImportAsNameNode) node;
                return ian.alias == null ? ian.name : ian.name + " as " + ian.alias;
            }
            else if (node instanceof ImportAsNamesNode) {
                ImportAsNamesNode ians = (ImportAsNamesNode) node;
                StringBuilder sb = new StringBuilder();
                if (ians.importAsNameNodes != null) {
                    for (int i = 0; i < ians.importAsNameNodes.size(); i++) {
                        sb.append(evaluateExpression(ians.importAsNameNodes.get(i)));
                        if (i < ians.importAsNameNodes.size() - 1) {
                            sb.append(", ");
                        }
                    }
                }
                return sb.toString();
            }

            return "";
        }
        private String getOperatorStr(OperatorNode op) {
            if (op == null) return "";
            if (op instanceof AndOperatorNode) return "and";
            if (op instanceof OrOperatorNode) return "or";
            if (op instanceof NotOperatorNode) return "not";
            if (op instanceof InOperatorNode) return "in";
            if (op instanceof NotInOperatorNode) return "not in";
            if (op instanceof IsOperatorNode) return "is";
            if (op instanceof LessThanOperatorNode) return "<";
            if (op instanceof LessThanOrEqualOperatorNode) return "<=";
            if (op instanceof PlusOperatorNode) return "+";
            if (op instanceof MinusOperatorNode) return "-";
            if (op instanceof NotEqualOperatorNode) return "!=";
            if (op instanceof EqualOperatorNode) return "==";

            return op.name != null ? op.name : "";
        }
    }