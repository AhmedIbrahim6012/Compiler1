lexer grammar FrontLexer;

COMMENT:'<!--' .*? '-->' -> skip ;
COMMENT_JINJA2 : '{#'.*? '#}' -> skip ;

JINJA_EXPR_START   : '{{'-> pushMode(JINJA_MODE);
JINJA_STMT_START   : '{%'->pushMode(JINJA_MODE);


DOCTYPE: '<!' [Dd][Oo][Cc][Tt][Yy][Pp][Ee] (~'>')* '>';
HTML_TEXT
    : ~[<{\r\n]+
    ;
OPEN_STYLE: '<style' [^>]* '>'-> pushMode(CSS_MODE);
CLOSE_TAG: '</' -> pushMode(TAG_MODE);
OPEN_TAG: '<' -> pushMode(TAG_MODE);

ENTITY: '&' [A-Za-z0-9#]+ ';';

WS: [ \t]+ -> skip;
NEWLINE: [ \r\n]+ -> skip;

//tag mode
mode TAG_MODE;
TAG_QUOTE_OPEN : '"' -> pushMode(TAG_ATTR_DOUBLE_MODE);
TAG_SINGLE_QUOTE_OPEN : '\'' -> pushMode(TAG_ATTR_SINGLE_MODE);
//TAG_TEXT : ~["{]+;
TAG_NAME: [A-Za-z_] [A-Za-z0-9:_-]*;
EQUALS: '=' ;
//TAG_STRING:DOUBLE_QUOTED_VALUE | SINGLE_QUOTED_VALUE;
UNQUOTED_VALUE: [A-Za-z0-9_./:-]+;
SLASH: '/';
SELF_CLOSE: '/>' -> popMode;
TAG_CLOSE: '>' -> popMode;
COMMENT_TAG :'<!--' .*? '-->' ;
WS_IN_TAG: [ \t\r\n]+ -> skip;
IDENT: [a-zA-Z_]([a-zA-Z_0-9-])*;
fragment DOUBLE_QUOTED_VALUE:'"' (~["\r\n\t{])* '"';
fragment SINGLE_QUOTED_VALUE:'\'' (~['\r\n\t{])* '\'';

//=============== TAG DOUBLE QUOTE ATTRIBUTE MODE ===============//
mode TAG_ATTR_DOUBLE_MODE;
TAG_QUOTE_CLOSE : '"' -> popMode;
TAG_JINJA_EXPR_D: '{{' -> pushMode(JINJA_MODE);
TAG_JINJA_STMT_D: '{%' -> pushMode(JINJA_MODE);
TAG_ATTR_TEXT_D : ~["{]+;

//=============== TAG SINGLE QUOTE ATTRIBUTE MODE ===============//
mode TAG_ATTR_SINGLE_MODE;
TAG_SINGLE_QUOTE_CLOSE : '\'' -> popMode;
TAG_JINJA_EXPR_S: '{{' -> pushMode(JINJA_MODE);
TAG_JINJA_STMT_S: '{%' -> pushMode(JINJA_MODE);
TAG_ATTR_TEXT_S : ~['{]+;


mode CSS_MODE;
CLOSE_STYLE: '</style>' -> popMode;

FROM:'from';
TO:'to';
UNIT: ('px'|'em'|'rem'|'%'|'vh'|'vw'|'s'|'ms');
KEYWORD : 'auto' | 'inherit' | 'initial' | 'unset';
AT_KEYFRAMES:'@keyframes';
AT_MEDIA:'@media';
AT_SUPPORTS:'@supports';
AT_IMPORT:'@import';
AT_CHARSET:'@charset';
CSS_COLON: ':';
CSS_SEMICOLON: ';';
CSS_COMMA: ',';
STAR: '*';
PLUS: '+';
GT_CSS    : '>' ;
SLASH_CSS: '/';
OPEN_PARE: '(';
CLOSE_PARE: ')';
COLOR_HEX: '#' (HEX6 | HEX3);
fragment CSS_ID: [a-zA-Z_]([a-zA-Z_0-9-])*;
CSS_NUMBER:[-]? [0-9]+ ('.'[0-9]+)?;
CSS_STRING: '"' (~["\r\n])* '"' | '\'' (~["\r\n])* '\'';
CSS_STRING_SINGLE: '\'' (~["\r\n])* '\'';
WS_CSS: [ \t\r\n]+ -> skip;
CLASS_SELECTOR: '.' CSS_ID;
ID_SELECTOR: '#' CSS_ID;
PSEUDO_SELECTOR: ':' CSS_ID;
CSS_IDENT: CSS_ID;
//CSS_TEXT: ~[<{\n]+;
LBRACE: '{';
RBRACE: '}';
COMMENT_CSS:'/*' .*? '*/' -> skip ;
fragment HEX6
    : HEX HEX HEX HEX HEX HEX
    ;
fragment HEX3
    : HEX HEX HEX
    ;
fragment HEX
    : [0-9A-Fa-f]
    ;
VARIABLE_DASH: '--';


mode JINJA_MODE;
JINJA_EXPR_END     : '}}'-> popMode;
JINJA_STMT_END     : '%}'->popMode ;
ASSIGN             : '=' ;
JINJA_OPEN_PARE: '(';
JINJA_CLOSE_PARE: ')';
EQ     : '==' ;
NEQ    : '!=' ;
LT     : '<' ;
LTE    : '<=' ;
GTE    : '>=' ;
JINJA_LBRACE: '{';
JINJA_RBRACE: '}';
GT     : '>' ;
DOT:'.';
OPEN_BRACK:'[';
CLOSE_BRACK:']';
TRUE:'true';
FALSE:'false';
AND        : 'and';
OR         : 'or';
NOT        : 'not';
IF        : 'if' ;
ELIF      : 'elif' ;
ELSE      : 'else' ;
ENDIF     : 'endif' ;
FOR       : 'for' ;
IN        : 'in' ;
ENDFOR    : 'endfor' ;
BLOCK     : 'block' ;
ENDBLOCK  : 'endblock' ;

JINJA_IDENT: [a-zA-Z_]([a-zA-Z_0-9-])*;
JINJA_NUMBER : [0-9]+ ('.' [0-9]+)?;
JINJA_STRING : DOUBLE_QUOTED_VALUE_1 | SINGLE_QUOTED_VALUE_1;
fragment DOUBLE_QUOTED_VALUE_1:'"' (~["\r\n\t])* '"';
fragment SINGLE_QUOTED_VALUE_1:'\'' (~['\r\n\t])* '\'';
WS_JINJA : [ \t\r\n]+ -> skip;
JINJA_COMMA: ',';


