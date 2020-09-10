grammar Imperative;


compilationUnit: (varDecl | funcDecl)+;

varDecl : type ID ('=' expr)? ';';

type: 'float' | 'int' | 'void';

funcDecl:   type ID '(' formalParameters? ')' block;

formalParameters : formalParameter (',' formalParameter)*;

formalParameter : type ID;

block   :    '{' stat*  '}';

stat:   block
    |   varDecl
    | 'if' expr 'then' stat ('else' stat)?
    | 'return' expr? ';'
    | 'while' '(' expr ')' stat
    | expr '=' expr ';'
    | expr ';'
    ;

expr:   ID
    |   '-' expr
    |   '!' expr
    |   expr '*' expr
    |   expr ('+' | '-') expr
    |   expr '==' expr
    |   INT
    |   '(' expr ')'
    |   ID '(' exprList ')'
    ;

exprList : expr (',' expr)*;


INT: [0-9]+;
ID:  [a-zA-Z]+;
WS:  [ \t\r\n] ->skip;