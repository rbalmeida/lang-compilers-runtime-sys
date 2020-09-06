grammar Comments;

compilationUnit : row+;

row : STRING+ (NL | LINE_COMMENT);

NL: '\r'? '\n';
COMMENT: '/*' .*? '*/' -> skip;
LINE_COMMENT : '//' .*? '\n';
WS : [ \t\n\r] -> skip;


STRING: '"' (ESC | .)*? '"';
fragment ESC : '\\' [btnr"\\];