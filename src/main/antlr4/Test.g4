grammar Test;
tokens {
    INDENT,
    DEDENT
}
options {
  language=Java;
}
@lexer::members {
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
      this.emit(commonToken(TestParser.NEWLINE, "\n"));
      while (!indents.isEmpty()) {
        this.emit(createDedent());
        indents.pop();
      }
      this.emit(commonToken(TestParser.EOF, "<EOF>"));
    }
    Token next = super.nextToken();
    if (next.getChannel() == Token.DEFAULT_CHANNEL) {
      this.lastToken = next;
    }
    return tokens.isEmpty() ? next : tokens.poll();
  }

    private Token createDedent() {
      CommonToken dedent = commonToken(TestParser.DEDENT, "");
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
 : ( {atStartOfInput()}?   WS
   | ( '\r'? '\n' | '\r' ) WS?
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
         emit(commonToken(TestParser.INDENT, spaces));
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

prog
    : statement+ EOF
    ;

if_stmt
    : IF condition COLON NEWLINE suite
      (
          ELIF condition COLON NEWLINE suite
      )*
      (
          ELSE COLON NEWLINE suite
      )?
    ;

condition
    : expression
    ;

// A simplified definition of a block of statements (indented code)
suite
    : INDENT statement+ DEDENT
    ;

// A simplified definition of a statement
statement
    : assignment_stmt NEWLINE
    | print_stmt NEWLINE
    | if_stmt // Allow nested if statements
    | NEWLINE
    ;

// Simple examples of other statements (needs more detail for a real language)
assignment_stmt
    : ID '=' expression
    ;

print_stmt
    : 'print' expression
    ;

// A simple expression for conditions/assignments
expression
    : expression rel_op expression
    | primary
    ;

primary
    : ID
    | INT
    | STRING
    | LPAREN expression RPAREN
    ;

// --- Lexer Rules (Tokens) ---

// Keywords
IF : 'if' ;
ELIF : 'elif' ;
ELSE : 'else' ;
PRINT : 'print' ;

// Operators
EQUAL : '=' ;
COLON : ':' ;
LPAREN : '(' ;
RPAREN : ')' ;

rel_op
    : LESS_THAN | GREATER_THAN | EQUALS
    ;
LESS_THAN          : '<';
GREATER_THAN       : '>';
EQUALS             : '==';
ID : [a-zA-Z_] [a-zA-Z_0-9]* ;
INT : [0-9]+ ;
STRING : '"' .*? '"' ;

//NEWLINE : '\r'? '\n' ;

// Placeholder for INDENT/DEDENT - in a real Python grammar, these are generated
// by an external utility or custom ANTLR logic based on tracking columns.
// This simplified version assumes they are generated tokens.


WS : [ \t]+ -> skip ;