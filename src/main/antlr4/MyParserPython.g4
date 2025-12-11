parser grammar MyParserPython;

options { tokenVocab=MyLexerPython; }

program
    : statement* EOF
    ;

// أي نوع من العبارات
statement
    : simple_stmt
    | compound_stmt
    ;

// العبارات البسيطة
simple_stmt
    : expr_stmt
    | flow_stmt
    ;

// العبارات المركبة
compound_stmt
    : if_stmt
    | while_stmt
    | for_stmt
    | funcdef
    ;

// أوامر التحكم
flow_stmt
    : RETURN expr?
    | BREAK
    | CONTINUE
    | PASS
    ;

// تعريف دالة
funcdef
    : DEF NAME LPAREN param_list? RPAREN COLON suite
    ;

// قائمة المعاملات
param_list
    : NAME (COMMA NAME)*
    ;

// if statement
if_stmt
    : IF expr COLON suite (ELIF expr COLON suite)* (ELSE COLON suite)?
    ;

// while loop
while_stmt
    : WHILE expr COLON suite
    ;

// for loop
for_stmt
    : FOR NAME IN expr COLON suite
    ;

// مجموعة تعليمات
suite
    : simple_stmt
    | NEWLINE INDENT statement+ DEDENT
    ;

// تعابير
expr_stmt
    : NAME EQ expr
    | expr
    ;

expr
    : expr PLUS expr
    | expr MINUS expr
    | expr STAR expr
    | expr SLASH expr
    | expr PERC expr
    | LPAREN expr RPAREN
    | NUMBER
    | STRING
    | NAME
    ;
