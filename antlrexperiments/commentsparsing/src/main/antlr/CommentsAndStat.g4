grammar CommentsAndStat;

compilationUnit : stat+;

stat : STRING+;

NL: '\r'? '\n' ->skip;
COMMENT: '/*' .*? '*/' -> skip;
LINE_COMMENT : '//' .*? '\n' ->skip;
WS : [ \t\n\r] -> skip;


STRING: '"' (ESC | .)*? '"';
fragment ESC : '\\' [btnr"\\];