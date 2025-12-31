parser grammar ExampleParser;

@header {

package antlr;  }
options { tokenVocab = Example;}

htmlDocument:element* doctype? element* EOF;
//cssFile: cssStatement* EOF;
doctype: DOCTYPE;
element:
    // jinja2Element
    htmlElement
 //   |styleElement
    |EXPRESSION
    |STATEMENT
    | LBRACE_HTML
    | TEXT
    | ENTITY

     ;
    htmlElement
        : OPEN_TAG TAG_NAME attribute* TAG_CLOSE element* CLOSE_TAG TAG_NAME TAG_CLOSE
        | OPEN_TAG TAG_NAME attribute* SELF_CLOSE
        |  CLOSE_TAG TAG_NAME TAG_CLOSE
//        | OPEN_TAG TAG_NAME attribute* TAG_CLOSE jinja2Element* CLOSE_TAG TAG_NAME TAG_CLOSE
        ;

    attribute:TAG_NAME EQUALS attributeValue
    | TAG_NAME;
    attributeValue: DOUBLE_QUOTED_VALUE
    | SINGLE_QUOTED_VALUE
    | UNQUOTED_VALUE;

    jinja2Rule:EXPRESSION
        |STATEMENT
        |COMMENT_JINJA2;

  //  styleElement: OPEN_STYLE cssStatement* CLOSE_STYLE;
//
    //cssStatement: cssRule
   //     | atRule;
//    atRule: AT IDENT selectorList? cssInnerBlock;
//    cssInnerBlock
//        : cssDeclaration* LBRACE (cssStatement | cssDeclaration)* RBRACE;
//    cssDeclaration
//        : IDENT COLON cssValue+ SEMICOLON
//        |IDENT
//        |COLON IDENT
//        | IDENT COLON cssValue+
//        | IDENT COLON cssValue+ (COMMA cssValue+)+ SEMICOLON;
//    cssValue
//        : NUMBER_UNIT
//        | NUMBER
//        | UNIT
//        | COLOR_HEX
//        | STRING
//        | IDENT
//        |OPEN_PARE
//        |CLOSE_PARE;
//    cssRule : selectorList cssInnerBlock;
//    selectorList: selector (COMMA selector)*;
//    selector
//        : CLASS_SELECTOR
//        | ID_SELECTOR
//        | IDENT
//        |OPEN_PARE
//        |CLOSE_PARE
//        | STAR;

cssFile
    : cssRule* EOF
    ;

cssRule
    : selectorList cssBlock
    ;

cssBlock
    : LBRACE cssDeclaration* RBRACE
    ;

cssDeclaration
    : IDENT COLON cssValueList SEMICOLON
    ;

cssValueList
    : cssValue+
    ;

cssValue
    : NUMBER_UNIT
    | NUMBER
    | COLOR_HEX
    | STRING
    | IDENT
    | FUNCTION
    ;

selectorList
    : selector (COMMA selector)*
    ;

selector
    : CLASS_SELECTOR
    | ID_SELECTOR
    | IDENT
    | STAR
    ;



