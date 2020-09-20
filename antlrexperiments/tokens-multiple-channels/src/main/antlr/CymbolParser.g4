/** Simple statically-typed programming language with functions and variables
 *  taken from "Language Implementation Patterns" book.
 */
parser grammar CymbolParser;
options { tokenVocab = CymbolLexer;}

file:   (functionDecl | varDecl)+ ;

varDecl
    :   type ID (EQOP expr)? SEMICOL
    ;
type:   FLOATKW | INTKW | VOIDKW ; // user-defined types

functionDecl
    :   type ID OPENPAR formalParameters? CLOSEPAR block // "void f(int x) {...}"
    ;

formalParameters
    :   formalParameter (COMMA formalParameter)*
    ;
formalParameter
    :   type ID
    ;

block:  OPENCURLY stat* CLOSECURLY ;   // possibly empty statement block

stat:   block
    |   varDecl
    |   IF expr THEN stat (ELSE stat)?
    |   RETURN expr? SEMICOL
    |   expr EQOP expr SEMICOL // assignment
    |   expr SEMICOL          // func call
    ;

expr:   ID OPENPAR exprList? CLOSEPAR    // func call like f(), f(x), f(1,2)
    |   expr OPENSQUARE expr CLOSESQUARE       // array index like a[i], a[i][j]
    |   MINUSOP expr                // unary minus
    |   NOTOP expr                // boolean not
    |   expr MULTOP expr
    |   expr (ADDOP | MINUSOP) expr
    |   expr EQUALSOP expr          // equality comparison (lowest priority op)
    |   ID                      // variable reference
    |   INT
    |   OPENPAR expr CLOSEPAR
    ;

exprList : expr (COMMA expr)* ;   // arg list