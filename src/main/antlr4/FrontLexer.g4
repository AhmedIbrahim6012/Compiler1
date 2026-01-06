lexer grammar FrontLexer;

LBRACE: '{';
RBRACE: '}';
JINJA_EXPR_START   : '{{'-> pushMode(JINJA_MODE);
JINJA_STMT_START   : '{%'->pushMode(JINJA_MODE);
COMMENT_JINJA2 : '{#' ~[#]* '#}' -> skip ;
COMMENT_CSS:'/*' .*? '*/' -> skip ;
FROM:'from';
TO:'to';

DOCTYPE: '<!' [Dd][Oo][Cc][Tt][Yy][Pp][Ee] (~'>')* '>';
VARIABLE_DASH: '--';


OPEN_STYLE: '<style' .*? '>';//-> pushMode(CSS_MODE);
UNIT: ('px'|'em'|'rem'|'%'|'vh'|'vw'|'s'|'ms');
KEYWORD : 'auto' | 'inherit' | 'initial' | 'unset';
IDENT: [a-zA-Z_]([a-zA-Z_0-9-])*;
//mode CSS_MODE
CLOSE_STYLE: '</style>' ;//-> popMode;

COLON: ':';
SEMICOLON: ';';
COMMA: ',';
STAR: '*';
AT: '@';
AT_KEYFRAMES:'@keyframes';
OPEN_PARE: '(';
CLOSE_PARE: ')';
COLOR_HEX: '#' (HEX6 | HEX3);
NUMBER:[-]? [0-9]+ ('.'[0-9]+)?;
STRING: '"' (~["\r\n])* '"';
WS_CSS: [ \t\r\n]+ -> skip;
CLASS_SELECTOR: '.' IDENT;
ID_SELECTOR: '#' IDENT;
TEXT: ~[<{\n]+ ;


OPEN_TAG: '<' -> pushMode(TAG_MODE);
CLOSE_TAG: '</' -> pushMode(TAG_MODE);
ENTITY: '&' [A-Za-z0-9#]+ ';';
COMMENT:'<!--' .*? '-->' -> skip ;
WS: [ \t]+ -> skip;
NEWLINE: [ \r\n]+ -> skip;


mode TAG_MODE;
EXPRESSION_ : '{{' .*? '}}' ;
STATEMENT_ : '{%' .*? '%}' ;

TAG_NAME: [A-Za-z_] [A-Za-z0-9:_-]* ;
EQUALS: '=' ;
TAG_STRING:DOUBLE_QUOTED_VALUE | SINGLE_QUOTED_VALUE;
UNQUOTED_VALUE: [A-Za-z0-9_./:-]+;
SLASH: '/';
TAG_EXPRESSION : '{{' .*? '}}';
SELF_CLOSE: '/>' -> popMode;
TAG_CLOSE: '>' -> popMode;
COMMENT_:'<!--' .*? '-->' ;
WS_IN_TAG: [ \t\r\n]+ -> skip;

fragment HEX6
    : HEX HEX HEX HEX HEX HEX
    ;
fragment HEX3
    : HEX HEX HEX
    ;
fragment HEX
    : [0-9A-Fa-f]
    ;
fragment DOUBLE_QUOTED_VALUE:'"' (~["\r\n\t])* '"';
fragment SINGLE_QUOTED_VALUE:'\'' (~['\r\n\t])* '\'';

mode JINJA_MODE;
JINJA_EXPR_END     : '}}'-> popMode;
JINJA_STMT_END     : '%}'->popMode ;
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
JINJA_OPEN_PARE: '(';
JINJA_CLOSE_PARE: ')';
JINJA_COMMA: ',';


