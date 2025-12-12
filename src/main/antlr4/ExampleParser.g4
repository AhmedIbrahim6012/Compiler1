parser grammar ExampleParser;
options { tokenVocab = Example;}

htmlDocument:element* doctype? element* EOF;
doctype: DOCTYPE;
element:
    // jinja2Element
    htmlElement
    |styleElement
    |EXPRESSION
    |STATEMENT

    | LBRACE_HTML
    | TEXT
    | ENTITY
    |COMMENT;
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

//    jinja2Element: IDENT_JINJA2* JINJA_EXPR_START jinja2Rule*
//        |JINJA_STMT_START jinja2Rule*
//        |JINJA_COMM_START jinja2Rule*;

    jinja2Rule:EXPRESSION
        |STATEMENT
        |COMMENT_JINJA2;

    styleElement: OPEN_STYLE cssStatement* CLOSE_STYLE;

    cssStatement: cssRule
        | atRule;
    atRule: AT IDENT selectorList? cssInnerBlock;
    cssInnerBlock
        : cssDeclaration* LBRACE (cssStatement | cssDeclaration)* RBRACE;
    cssDeclaration
        : IDENT COLON cssValue+ SEMICOLON
        | IDENT COLON cssValue+
        | IDENT COLON cssValue+ (COMMA cssValue+)+ SEMICOLON;
    cssValue
        : NUMBER_UNIT
        | NUMBER
        | UNIT
        | COLOR_HEX
        | STRING
        | IDENT
        |OPEN_PARE
        |CLOSE_PARE;
    cssRule : selectorList cssInnerBlock;
    selectorList: selector (COMMA selector)*;
    selector
        : CLASS_SELECTOR
        | ID_SELECTOR
        | IDENT
        |OPEN_PARE
        |CLOSE_PARE
        | STAR;



