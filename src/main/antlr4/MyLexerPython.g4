lexer grammar MyLexerPython;

@header {
package parser;
}

// الكلمات المفتاحية
DEF     : 'def';
RETURN  : 'return';
IF      : 'if';
ELIF    : 'elif';
ELSE    : 'else';
WHILE   : 'while';
FOR     : 'for';
IN      : 'in';
BREAK   : 'break';
CONTINUE: 'continue';
PASS    : 'pass';

// العمليات والعلامات
EQ      : '=';
PLUS    : '+';
MINUS   : '-';
STAR    : '*';
SLASH   : '/';
PERC    : '%';
COLON   : ':';
COMMA   : ',';
LPAREN  : '(';
RPAREN  : ')';

// المعرفات والأرقام والسلاسل
NAME
    : [a-zA-Z_] [a-zA-Z0-9_]*
    ;

NUMBER
    : [0-9]+ ('.' [0-9]+)?
    ;

STRING
    : '\'' (~['\r\n])* '\''
    | '"'  (~["\r\n])* '"'
    ;

// الأسطر الجديدة والمسافات
NEWLINE
    : [\r\n]+
    ;

WS
    : [ \t]+ -> skip
;

// Placeholder لـ Python INDENT/DEDENT
INDENT : '<INDENT>';
DEDENT : '<DEDENT>';
