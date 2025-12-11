lexer grammar MyLexer;

tokens {
    INDENT,
    DEDENT
}

options {
    superClass = Python3LexerBase;
}


STRING: SHORT_STRING | LONG_STRING;
NUMBER: INTEGER | FLOAT_NUMBER ;



AND         : 'and';
AS         : 'as';
DEF        : 'def';
ELIF       : 'elif';
ELSE       : 'else';
EXCEPT     : 'except';
FALSE      : 'False';
FOR        : 'for';
FROM       : 'from';
IF         : 'if';
IMPORT     : 'import';
IN         : 'in';
IS         : 'is';
NONE       : 'None';
NOT        : 'not';
OR         : 'or';
RAISE      : 'raise';
RETURN     : 'return';
TRUE       : 'True';
TRY        : 'try';
UNDERSCORE : '_';




DOT                : '.';
ELLIPSIS           : '...';
STAR               : '*';
OPEN_PAREN         : '(' {this.openBrace();};
CLOSE_PAREN        : ')' {this.closeBrace();};
COMMA              : ',';
COLON              : ':';
SEMI_COLON         : ';';
POWER              : '**';
ASSIGN             : '=';
OPEN_BRACK         : '[' {this.openBrace();};
CLOSE_BRACK        : ']' {this.closeBrace();};
OR_OP              : '|';
XOR                : '^';
AND_OP             : '&';
LEFT_SHIFT         : '<<';
RIGHT_SHIFT        : '>>';
ADD                : '+';
MINUS              : '-';
DIV                : '/';
MOD                : '%';
IDIV               : '//';
NOT_OP             : '~';
OPEN_BRACE         : '{' {this.openBrace();};
CLOSE_BRACE        : '}' {this.closeBrace();};
LESS_THAN          : '<';
GREATER_THAN       : '>';
EQUALS             : '==';
GT_EQ              : '>=';
LT_EQ              : '<=';
NOT_EQ_1           : '<>';
NOT_EQ_2           : '!=';
AT                 : '@';
ARROW              : '->';
ADD_ASSIGN         : '+=';
SUB_ASSIGN         : '-=';
MULT_ASSIGN        : '*=';
AT_ASSIGN          : '@=';
DIV_ASSIGN         : '/=';
MOD_ASSIGN         : '%=';
AND_ASSIGN         : '&=';
OR_ASSIGN          : '|=';
XOR_ASSIGN         : '^=';
LEFT_SHIFT_ASSIGN  : '<<=';
RIGHT_SHIFT_ASSIGN : '>>=';
POWER_ASSIGN       : '**=';
IDIV_ASSIGN        : '//=';

// Tokens that must be kept for structure/parsing
NEWLINE: (//{this.atStartOfInput()}? SPACES |
 ( '\r'? '\n' | '\r' | '\f') SPACES?) {this.onNewLine();};
NAME : [a-zA-Z_] ([a-zA-Z_0-9])* ;
SKIP_: ( SPACES | COMMENT | LINE_JOINING) -> skip;
UNKNOWN_CHAR: .;

fragment FLOAT_NUMBER:(DIGIT+)? DOT DIGIT+|DIGIT+DOT;
fragment INTEGER: ([1-9] DIGIT+) | '0'+;
fragment SHORT_STRING:
    '\'' (STRING_ESCAPE_SEQ | ~[\\\r\n\f'])* '\''
    | '"' ( STRING_ESCAPE_SEQ | ~[\\\r\n\f"])* '"'
;
fragment LONG_STRING: '\'\'\'' LONG_STRING_ITEM*? '\'\'\'' | '"""' LONG_STRING_ITEM*? '"""';
fragment LONG_STRING_ITEM: LONG_STRING_CHAR | STRING_ESCAPE_SEQ;
fragment LONG_STRING_CHAR: ~'\\';
fragment STRING_ESCAPE_SEQ: '\\' . | '\\' NEWLINE;

fragment DIGIT: [0-9];

fragment SPACES: [ \t]+ ;
fragment COMMENT: '#' ~[\r\n\f]*;
fragment LINE_JOINING: '\\' SPACES? ( '\r'? '\n' | '\r' | '\f');


