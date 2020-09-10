grammar LExpr;

s   : e
    | '(' e ')'
    ;

e   :   e '*' e # Mult
    |   e '+' e # Add
    |   INT     # Int
    ;

INT : [0-9]+;
WS: [ \t\n\r] -> skip;