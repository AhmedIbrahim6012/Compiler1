parser grammar MyParser;
options {
    tokenVocab = MyLexer;
}

input
    : (single_statement | compound_stmt | decorated | NEWLINE)+ EOF
    ;

stmt
    : single_statement
    | compound_stmt
    ;

single_statement
    : simple_statement (SEMI_COLON simple_statement)* NEWLINE?
    ;

simple_statement
    : expr_stmt
    | import_stat
    | flow_stmt
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

block
     : single_statement
     | NEWLINE INDENT stmt+ DEDENT
     ;


flow_stmt
    : return_stmt
    | raise_stmt
    ;

return_stmt
    : RETURN testlist?
    ;

raise_stmt
    : RAISE (test (FROM test)?)?
    ;

compound_stmt
    : if_stmt
    | try_stmt
    | funcdef
    ;

if_stmt
    : IF test COLON block (ELIF test COLON block)* (ELSE COLON block)?
    ;

try_stmt
    : TRY COLON block (EXCEPT test? COLON block)+
    ;

import_stat
    : import_name
    |import_from
    ;

import_from
    : (
        FROM ((DOT | ELLIPSIS)* dotted_name | (DOT | ELLIPSIS)+) IMPORT (
            STAR
            | OPEN_PAREN import_as_names CLOSE_PAREN
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
    : dotted_as_name (COMMA dotted_as_name)*
    ;

dotted_as_name
    : dotted_name (AS NAME)?
    ;

dotted_name
    : NAME (DOT NAME)*
    ;

expr_stmt
    : testlist (ASSIGN testlist)*
    ;

testlist
    : test (COMMA test)* COMMA?
    ;

test
    : or_test
    ;

or_test
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
     : LESS_THAN
     | GREATER_THAN
     | EQUALS
     | GT_EQ
     | LT_EQ
     | NOT_EQ_1
     | NOT_EQ_2
     | IN
     | NOT IN
     | IS
     | IS NOT
     ;

expr
     : atom_expr
     ;
atom_expr
    : atom trailer*
    ;

atom
    : OPEN_PAREN testlist_comp? CLOSE_PAREN
    | OPEN_BRACK testlist_comp? CLOSE_BRACK
    | OPEN_BRACE dictmaker? CLOSE_BRACE
    | NUMBER
    | NAME
    | STRING
    | NONE
    | TRUE
    | FALSE
    ;

testlist_comp
    : test (comp_for | (COMMA test)* COMMA?)
    ;

comp_iter
    : comp_for
    | comp_if
    ;

comp_for
    :  FOR exprlist IN or_test comp_iter?
    ;

exprlist
    : expr  (COMMA expr )* COMMA?
    ;

comp_if
    : IF or_test comp_iter?
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
    : test comp_for? | test ASSIGN test
    ;