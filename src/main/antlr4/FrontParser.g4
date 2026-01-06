parser grammar FrontParser;

options { tokenVocab = FrontLexer;}

program
    : htmlDocument
    | cssFile
    ;
htmlDocument
    : doctype? element* EOF;


doctype: DOCTYPE;

element
    : htmlElement
    | jinja2Rule
    | styleElement
    | ENTITY
    | TEXT
    | IDENT
    | NUMBER
    ;
    htmlElement
        : OPEN_TAG TAG_NAME attribute* TAG_CLOSE element* CLOSE_TAG TAG_NAME TAG_CLOSE
        | OPEN_TAG TAG_NAME attribute* SELF_CLOSE
        ;

    attribute
        :TAG_NAME (EQUALS attributeValue)?
        ;

    attributeValue
        : TAG_STRING
        | UNQUOTED_VALUE
        ;

    cssFile
        : cssStatement* EOF;


    styleElement: OPEN_STYLE cssStatement* CLOSE_STYLE;

    cssStatement
        : cssRule
        | atRule
        ;

    atRule: AT_KEYFRAMES IDENT LBRACE keyframeBlock+ RBRACE;

    keyframeBlock
        : keyframeSelector LBRACE cssDeclaration* RBRACE
        ;

    keyframeSelector
        : FROM
        | TO
        ;

    cssDeclaration
        : property  COLON cssValue+ (COMMA cssValue+)* SEMICOLON
        ;

    property
        : IDENT
        | variableDeff
        ;
    variableDeff
        :VARIABLE_DASH IDENT
        ;

    cssValue
        : NUMBER UNIT? #NumberUnit
        | COLOR_HEX #Color
        | STRING #String
        | KEYWORD #Keyword
        | IDENT #Name
        | variableDeff #Variable
        | function #CallFunction
        ;

    cssRule
        : selectorGroup cssInnerBlock
        ;

    function
        : IDENT OPEN_PARE cssValue+ (COMMA cssValue+)* CLOSE_PARE
        ;

    cssInnerBlock
        : LBRACE (cssDeclaration)* RBRACE
        ;

    selectorGroup: combineSelector (COMMA combineSelector)*;

    combineSelector:selector (GT? selector)*;

    selector
        : CLASS_SELECTOR #ClassSelector
        | ID_SELECTOR #IDSelector
        | IDENT #NameSelector
        | STAR #StarSelector
        | COLON IDENT #PseudoSelector
        ;


    jinja2Rule
        : jinjaExpression
        | jinjaStatement
        | COMMENT_JINJA2
        ;

    jinjaExpression
         : JINJA_EXPR_START expression JINJA_EXPR_END
         ;

    jinjaStatement
        : ifStatement
        | forStatement
        | blockStatement
        ;
    ifStatement
        :  ifShape  elifShape* elseShape?
          (JINJA_STMT_START ENDIF  JINJA_STMT_END)
        ;
    ifShape
        :(JINJA_STMT_START IF expression JINJA_STMT_END) element* ;
    elifShape
        :((JINJA_STMT_START ELIF expression JINJA_STMT_END) element*);
    elseShape
        : ((JINJA_STMT_START ELSE JINJA_STMT_END)
                   element*);
    forStatement
        : (JINJA_STMT_START FOR JINJA_IDENT IN expression JINJA_STMT_END)
          element*
          (JINJA_STMT_START ENDFOR  JINJA_STMT_END)
        ;
    blockStatement
        : (JINJA_STMT_START BLOCK? JINJA_IDENT JINJA_STMT_END)
          element*
          (JINJA_STMT_START ENDBLOCK  JINJA_STMT_END)
        ;
    expression
        :andExpression (OR andExpression)*
        ;
    andExpression
        :notExpression (AND notExpression)*
        ;
    notExpression
        : NOT notExpression
        | comparison
        ;
    comparison
        : expr (comp_op expr)*
        ;
    expr
        : atom trailer*
        ;
    trailer
        : JINJA_OPEN_PARE expression (JINJA_COMMA expression)* JINJA_CLOSE_PARE
        | DOT JINJA_IDENT
        | OPEN_BRACK expression CLOSE_BRACK
        ;
    comp_op
        : LT #LessThan
        | GT #GreaterThan
        | EQ #Equal
        | GTE #GreaterThanOrEqual
        | LTE #LessThanOrEqual
        | NEQ #NotEqual
        ;
    atom
        : JINJA_NUMBER #Number
        | JINJA_STRING #Text
        | JINJA_IDENT  #AtomName
        | TRUE  #Bool
        | FALSE #Bool
        ;




