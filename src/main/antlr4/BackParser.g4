parser grammar BackParser;
options {
    tokenVocab = BackLexer;
}


program
    : statement* EOF
    ;

statement
    : simple_statements    #SimpleStatementsNode
    | compound_statements  #CompoundStatementsNode
    | decorated            #DecoratedNode
    | NEWLINE              #BlackLine
    ;


simple_statements
    : simple_statement ((SEMI_COLON simple_statement)* | SEMI_COLON?) NEWLINE?
    ;

simple_statement
    : expression_statement #ExpressionStatementNode
    | import_statement #ImportStatementNode
    | flow_statement #FlowStatementNode
    ;

decorated
    : decorator+ funcdef
    ;

decorator
    : AT dotted_name (OPEN_PAREN arglist? CLOSE_PAREN)?  NEWLINE
    ;

funcdef
    : DEF NAME parameters COLON block
    ;

parameters
     : OPEN_PAREN arglist? CLOSE_PAREN
     ;

paramlist
     : NAME (COMMA NAME)*
     ;

flow_statement
    : return_statement #ReturnStatementNode
    | raise_statement #RaiseStatementNode
    | BREAK #BreakStatementNode
    | CONTINUE #ContinueStatementNode
    ;

return_statement
    : RETURN expression?
    ;
raise_statement
    : RAISE (test (FROM test)?)?
    ;

compound_statements
    : if_statement #IfStatementNode
    | for_statement #ForStatementNode
    | try_statement #TryStatementNode
    | funcdef #FundefStatementNode
    ;

if_statement
    : IF test COLON block (ELIF test COLON block)* (ELSE COLON block)?
    ;
block
     : simple_statements #SimpleStatementsBlockNode
     | NEWLINE INDENT statements+ DEDENT #StatementBlockNode
     ;
statements
    : simple_statements #SimpleStatements1Node
    | compound_statements #CompoundStatements1Node
    ;

try_statement
    : TRY COLON block (EXCEPT test COLON block)* (EXCEPT test? COLON block)
    ;

for_statement
    : FOR exprlist IN expression COLON block (ELSE COLON block)?
    ;

exprlist
    : expr  (COMMA expr )* COMMA?
    ;

import_statement
    : import_name #ImportNameNode
    | import_from #ImportFromNode
    ;

import_from
    : FROM dotted_name IMPORT (
            OPEN_PAREN import_as_names CLOSE_PAREN
            | import_as_names
        )
    ;

import_as_names
    : import_as_name (COMMA import_as_name)* COMMA?
    ;

import_as_name
    : NAME (AS NAME)?
    ;

import_name
    :IMPORT dotted_as_name (COMMA dotted_as_name)*
    ;

dotted_as_name
    : dotted_name (AS NAME)?
    ;

dotted_name
    : NAME (DOT NAME)*
    ;

expression_statement
    : expression (ASSIGN expression)*
    ;

expression
    : test (COMMA test)* COMMA?
    ;

test
    : and_test (OR and_test)*
    ;

and_test
    : not_test (AND not_test)*
    ;

not_test
    : NOT not_test #NotExpressionNode
    | comparison #ComparisionNode
    ;

comparison
     : expr (comp_op expr)*
     ;

comp_op
     : LESS_THAN #LessThan
     | GREATER_THAN #GreaterThan
     | EQUALS #Equal
     | GT_EQ #GreaterThanOrEqual
     | LT_EQ #LessThanOrEqual
     | NOT_EQ #NotEqual
     | IN #In
     | NOT IN #NotIn
     | IS #Is
     | IS NOT #IsNot
     ;

expr
    : atom trailer* #AtomExpression
    | expr (ADD | MINUS) expr #AdditiveExpression
    ;

atom
    : OPEN_PAREN expression? CLOSE_PAREN #TupleNode
    | OPEN_BRACK expression? CLOSE_BRACK #ListNode
    | OPEN_BRACE dictmaker? CLOSE_BRACE #DictionaryNode
    | value #ValueNode
    ;

value
    : NUMBER  #Number
    | NAME    #Name
    | STRING  #String
    | NONE    #None
    | TRUE    #Bool
    | FALSE   #Bool
    ;




dictmaker
    : test COLON test (COMMA test COLON test)*
    ;

trailer
    : OPEN_PAREN arglist? CLOSE_PAREN #CallFunctionTrailer
    | DOT NAME #AccessPropertyTrailer
    | OPEN_BRACK test CLOSE_BRACK #AccessIndexTrailer
    ;

arglist
    : argument (COMMA argument)*
    ;

argument
    : test (ASSIGN test)?
    ;