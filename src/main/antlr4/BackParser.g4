parser grammar BackParser;
options {
    tokenVocab = BackLexer;
}

program
    : (simple_statements | compound_statements | decorated | NEWLINE)* EOF
    ;



simple_statements
    : simple_statement ((SEMI_COLON simple_statement)* | SEMI_COLON?) NEWLINE?
    ;

simple_statement
    : expression_statement
    | import_statement
    | flow_statement
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
     : OPEN_PAREN paramlist? CLOSE_PAREN
     ;

paramlist
     : NAME (COMMA NAME)*
     ;




flow_statement
    : return_statement
    | raise_statement
    ;

return_statement
    : RETURN expression?
    ;
raise_statement
    : RAISE (test (FROM test)?)?
    ;

compound_statements
    : if_statement
    | for_statement
    | try_statement
    | funcdef
    ;

if_statement
    : IF test COLON block (ELIF test COLON block)* (ELSE COLON block)?
    ;
block
     : simple_statements
     | NEWLINE INDENT statements+ DEDENT
     ;
statements
    : simple_statements
    | compound_statements
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
    : import_name
    | import_from
    ;

import_from
    : (
        FROM dotted_name IMPORT (
            OPEN_PAREN import_as_names CLOSE_PAREN
            | import_as_names
        )
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
    : NOT not_test
    | comparison
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
    : atom trailer*
    ;

atom
    : OPEN_PAREN expression? CLOSE_PAREN
    | OPEN_BRACK expression? CLOSE_BRACK
    | OPEN_BRACE dictmaker? CLOSE_BRACE
    | value
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
    : OPEN_PAREN arglist? CLOSE_PAREN
    | DOT NAME
    | OPEN_BRACK test CLOSE_BRACK
    ;

arglist
    : argument (COMMA argument)*
    ;

argument
    : test (ASSIGN test)?
    ;