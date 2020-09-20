lexer grammar CymbolLexer;

channels {WHITESPACE, COMMENTS}

EQOP : '=';
SEMICOL : ';';
FLOATKW : 'float';
INTKW: 'int';
VOIDKW: 'void';
OPENPAR : '(';
CLOSEPAR : ')';
OPENCURLY : '{';
CLOSECURLY : '}';
COMMA: ',';
IF : 'if';
THEN: 'then';
ELSE: 'else';
RETURN : 'return';
OPENSQUARE: '[';
CLOSESQUARE : ']';
MINUSOP: '-';
NOTOP : '!';
MULTOP: '*';
ADDOP : '+';
EQUALSOP: '==';

ID  :   LETTER (LETTER | [0-9])* ;
fragment
LETTER : [a-zA-Z] ;

INT :   [0-9]+ ;

WS  :   [ \t\n\r]+ -> channel(WHITESPACE) ;  // channel(1)

SL_COMMENT
    :   '//' .*? '\n' -> channel(COMMENTS)   // channel(2)
    ;