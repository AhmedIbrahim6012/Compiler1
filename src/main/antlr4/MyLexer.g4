lexer grammar MyLexer;

tokens {
    INDENT,
    DEDENT
}


@members {
    private java.util.LinkedList<Token> tokens = new java.util.LinkedList<>();
    private java.util.Stack<Integer> indents = new java.util.Stack<>();
    private int opened = 0;
    private Token lastToken = null;
    @Override
      public void emit(Token t) {
        super.setToken(t);
        tokens.offer(t);
      }
  @Override
  public Token nextToken() {
    if (_input.LA(1) == EOF && !this.indents.isEmpty()) {
      for (int i = tokens.size() - 1; i >= 0; i--) {
        if (tokens.get(i).getType() == EOF) {
          tokens.remove(i);
        }
      }

      this.emit(commonToken(MyParser.NEWLINE, "\n"));
      while (!indents.isEmpty()) {
        this.emit(createDedent());
        indents.pop();
      }
      this.emit(commonToken(MyParser.EOF, "<EOF>"));
    }
    Token next = super.nextToken();
    if (next.getChannel() == Token.DEFAULT_CHANNEL) {
      this.lastToken = next;
    }
    return tokens.isEmpty() ? next : tokens.poll();
  }

    private Token createDedent() {
      CommonToken dedent = commonToken(MyParser.DEDENT, "");
      dedent.setLine(this.lastToken.getLine());
      return dedent;
    }

      private CommonToken commonToken(int type, String text) {
        int stop = this.getCharIndex() - 1;
        int start = text.isEmpty() ? stop : stop - text.length() + 1;
        return new CommonToken(this._tokenFactorySourcePair, type, DEFAULT_TOKEN_CHANNEL, start, stop);
      }

       static int getIndentationCount(String spaces) {
          int count = 0;
          for (char ch : spaces.toCharArray()) {
            switch (ch) {
              case '\t':
                count += 8 - (count % 8);
                break;
              default:
                count++;
            }
          }

          return count;
        }

         boolean atStartOfInput() {
            return super.getCharPositionInLine() == 0 && super.getLine() == 1;
          }
}

NEWLINE
 : ( {atStartOfInput()}?   SPACES
   | ( '\r'? '\n' | '\r' ) SPACES?
   )
   {
     String newLine = getText().replaceAll("[^\r\n]+", "");
     String spaces = getText().replaceAll("[\r\n]+", "");
     int next = _input.LA(1);
     if (opened > 0 || next == '\r' || next == '\n' || next == '#') {
       skip();
     }
     else {
       emit(commonToken(NEWLINE, newLine));
       int indent = getIndentationCount(spaces);
       int previous = indents.isEmpty() ? 0 : indents.peek();
       if (indent == previous) {
         skip();
       }
       else if (indent > previous) {
         indents.push(indent);
         emit(commonToken(MyParser.INDENT, spaces));
       }
       else {
         while(!indents.isEmpty() && indents.peek() > indent) {
           this.emit(createDedent());
           indents.pop();
         }
       }
     }
   }
 ;

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
OPEN_PAREN         : '(' {{opened++;}};
CLOSE_PAREN        : ')' {{opened--;}};
COMMA              : ',';
COLON              : ':';
SEMI_COLON         : ';';
POWER              : '**';
ASSIGN             : '=';
OPEN_BRACK         : '[' {{opened++;}};
CLOSE_BRACK        : ']' {{opened--;}};
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
OPEN_BRACE         : '{' {{opened++;}};
CLOSE_BRACE        : '}' {{opened--;}};
LESS_THAN          : '<';
GREATER_THAN       : '>';
EQUALS             : '==';
GT_EQ              : '>=';
LT_EQ              : '<=';
NOT_EQ           : '!=';
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

NAME : [a-zA-Z_] ([a-zA-Z_0-9])* ;
SKIP_: ( SPACES | COMMENT | LINE_JOINING) -> skip;
UNKNOWN_CHAR: .;


INVALID_NAME
    : DIGIT+ [a-zA-Z_] [a-zA-Z_0-9]*
      {
        throw new RuntimeException(
            "Invalid identifier: identifiers cannot start with a digit -> " + getText()
        );
      }
    ;

fragment FLOAT_NUMBER:(DIGIT+)? DOT DIGIT+|DIGIT+DOT;
fragment INTEGER:([1-9] DIGIT*) | '0'+;

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


