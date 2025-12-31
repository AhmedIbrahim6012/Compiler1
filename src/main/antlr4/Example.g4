lexer grammar Example;
@header {
package antlr;
}

EXPRESSION : '{{' .*? '}}' ;
STATEMENT : '{%' .*? '%}';
COMMENT_JINJA2 : '{#' .*? '#}' -> skip ;

//htmllexer
DOCTYPE: '<!' [Dd][Oo][Cc][Tt][Yy][Pp][Ee] (~'>')* '>';

OPEN_STYLE: '<style' .*? '>' ;
CLOSE_STYLE: '</style>';
//-> pushMode(CSS_MODE);
OPEN_TAG: '<' -> pushMode(TAG_MODE);
CLOSE_TAG: '</' -> pushMode(TAG_MODE);
ENTITY: '&' [A-Za-z0-9#]+ ';' ;
TEXT: ~[<\r\n]+ ;
COMMENT:'<!--' .*? '-->' -> skip ;
LBRACE_HTML: '{' ;
WS: [ \t]+ -> skip;
NEWLINE: [ \r\n]+ -> skip;


mode TAG_MODE;
EXPRESSION_ : '{{' .*? '}}' ;
STATEMENT_ : '{%' .*? '%}' ;

TAG_NAME: [A-Za-z_] [A-Za-z0-9:_-]* ;
EQUALS: '=' ;
DOUBLE_QUOTED_VALUE:'"' (~[\r\n\t])* '"';
SINGLE_QUOTED_VALUE:'\'' (~['\r\n\t])* '\'';
UNQUOTED_VALUE: [A-Za-z0-9_./:-]+;
SLASH: '/';

SELF_CLOSE: '/>' -> popMode ;
TAG_CLOSE: '>' -> popMode;
COMMENT_:'<!--' .*? '-->' ;
WS_IN_TAG: [ \t\r\n]+ -> skip;


LBRACE: '{';
RBRACE: '}';
COLON: ':';
SEMICOLON: ';';
COMMA: ',';
STAR: '*';
AT: '@';
COLOR_HEX: '#' ([0-9A-Fa-f]{6}|[0-9A-Fa-f]{3});
NUMBER_UNIT: [0-9]+ ('.'[0-9]+)? ('px'|'em'|'rem'|'%'|'vh'|'vw'|'s'|'ms'|'auto');
NUMBER: [0-9]+ ('.'[0-9]+)?;
UNIT: ('px'|'em'|'rem'|'%'|'vh'|'vw'|'s'|'ms'|'auto');
STRING: '"' (~["\r\n])* '"';
IDENT: [A-Za-z_][A-Za-z0-9_-]*;
WS_CSS: [ \t\r\n]+ -> skip;
OPEN_PARE: '(';
CLOSE_PARE: ')';
CLASS_SELECTOR: '.' IDENT;
ID_SELECTOR: '#' IDENT;

// //csslexer style
// mode CSS_MODE;
// CLOSE_STYLE: '</style>' -> popMode;
// LBRACE: '{' ;
//  RBRACE: '}' ;
//  COLON: ':' ;
//  SEMICOLON: ';' ;
//  STAR: '*' ;
//  COMMA: ',' ;
//  COLOR_HEX : '#' ([0-9A-Fa-f]{6} | [0-9A-Fa-f]{3});
//   CLASS_SELECTOR: '.' IDENT ;
//   ID_SELECTOR: '#'   IDENT ;
//   AT: '@';
//
// NUMBER_UNIT: [0-9]+ ('.' [0-9]+)? ('px'|'em'|'rem'|'%'|'vh'|'vw'|'s'|'ms'|'auto');
// NUMBER: [0-9]+ ('.' [0-9]+)? ;
// UNIT: ('px'|'em'|'rem'|'%'|'vh'|'vw'|'s'|'ms' |'auto') ;
// STRING: '"' (~["])* '"' ;
// IDENT: [A-Za-z_][A-Za-z0-9_-]*;
// OPEN_PARE:'(';
// CLOSE_PARE:')';
// WS_IN_CSS: [ \t\r\n]+ -> skip;

