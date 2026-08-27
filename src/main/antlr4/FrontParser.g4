parser grammar FrontParser;

options { tokenVocab = FrontLexer;}

htmlDocument
    : doctype element* EOF;


doctype: DOCTYPE?;

element
    : htmlElement #HtmlElementNode
    | jinja2Rule #Jinja2Node
    | styleElement #StyleElementNode
    | ENTITY #EntityNode
    | HTML_TEXT #HtmlTextNode
    | IDENT #IdentNode
    ;

    htmlElement
        : OPEN_TAG TAG_NAME attribute* TAG_CLOSE element* CLOSE_TAG TAG_NAME TAG_CLOSE
        | OPEN_TAG TAG_NAME attribute* SELF_CLOSE
        ;

    attribute
        :TAG_NAME (EQUALS attributeValue)?
        ;

    attributeValue
        : doubleQuotedAttribute #DoubleQuotedAttributeNode
        | singleQuotedAttribute #SingleQuotedAttributeNode
        | UNQUOTED_VALUE #UnquotedValueNode
        ;

    doubleQuotedAttribute
        : TAG_QUOTE_OPEN doubleAttrContent* TAG_QUOTE_CLOSE
        ;

    singleQuotedAttribute
       : TAG_SINGLE_QUOTE_OPEN singleAttrContent* TAG_SINGLE_QUOTE_CLOSE
       ;

    singleAttrContent
       : TAG_ATTR_TEXT_S #SingleAttrText
       | TAG_JINJA_EXPR_S expression JINJA_EXPR_END #SingleAttrJinjaExpr
       | TAG_JINJA_STMT_S jinjaStatement JINJA_STMT_END #SingleAttrJinjaStmt
       ;

    doubleAttrContent
        : TAG_ATTR_TEXT_D #DoubleAttrText
        | TAG_JINJA_EXPR_D expression JINJA_EXPR_END #DoubleAttrJinjaExpr
        | TAG_JINJA_STMT_D jinjaStatement JINJA_STMT_END #DoubleAttrJinjaStmt
        ;


    styleElement: OPEN_STYLE cssStatement* CLOSE_STYLE;

    cssStatement
        : cssRule #CSSRuleNode
        | atRule #ATRuleNode
        ;

    atRule
       : atMedia #ATMediaNode
       ;

    atMedia
        : AT_MEDIA mediaQuery LBRACE cssRule* RBRACE
        ;

    mediaQuery
        : OPEN_PARE CSS_IDENT CSS_COLON mediaValue CLOSE_PARE
        ;

    mediaValue
        : CSS_NUMBER UNIT? #MediaNumberNode
        | CSS_IDENT #MediaNameNode
        ;

    cssDeclaration
        : property  CSS_COLON cssValue+ (CSS_COMMA cssValue+)* CSS_SEMICOLON
        ;

    property
        : CSS_IDENT #PropertyNameNode
        | variableDeff #VariableDeffNode
        ;
    variableDeff
        :VARIABLE_DASH CSS_IDENT
        ;

    cssValue
        : CSS_NUMBER UNIT? #NumberCSSNode
        | COLOR_HEX #ColorCSSNode
        | CSS_STRING #StringCSSNode
        | KEYWORD #KeywordCSSNode
        | variableDeff #VariableCSSNode
        | function #CallFunctionCSSNode
        | CSS_IDENT #NameCSSNode
        ;

    cssRule
        : selectorGroup cssInnerBlock
        ;

    function
        : CSS_IDENT OPEN_PARE cssValue (cssValue | CSS_COMMA)* CLOSE_PARE
        ;

    cssInnerBlock
        : LBRACE (cssDeclaration)* RBRACE
        ;

    selectorGroup: combineSelector (CSS_COMMA combineSelector)*;

    combineSelector
        : selector selectorPart*
        ;

    selectorPart
        : combinator? selector
        ;

    combinator
        : GT_CSS #GTCSSNode
        | PLUS #PlusCSSNode
        ;

    selector
        : CLASS_SELECTOR #ClassSelector
        | ID_SELECTOR #IDSelector
        | PSEUDO_SELECTOR #PseudoSelector
        | CSS_IDENT #ElementSelector
        | STAR #StarSelector
        ;

    jinja2Rule
        : jinjaExpression #JinjaExpressionNode
        | jinjaStatement #JinjaStatementNode
        ;

    jinjaExpression
         : JINJA_EXPR_START expression JINJA_EXPR_END
         ;

    jinjaStatement
        : ifStatement  #IfStatementNode
        | forStatement #ForStatementNode
        | blockStatement #BlockStatementNode
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
        : JINJA_OPEN_PARE argumentList? JINJA_CLOSE_PARE #FunctionCallTrailer
        | DOT JINJA_IDENT  #PropertyAccessTrailer
        | OPEN_BRACK expression CLOSE_BRACK #IndexAccessTrailer
        ;

    argumentList
        : argument (JINJA_COMMA argument)*
        ;

    argument
        : JINJA_IDENT ASSIGN expression   #KeywordArgument
        | expression                      #PositionalArgument
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
        : JINJA_NUMBER #NumberNode
        | JINJA_STRING #StringNode
        | JINJA_IDENT  #NameNode
        | TRUE  #BoolNode
        | FALSE #BoolNode
        ;




