grammar grammar01;

r : 'hello' ID;

ID : [a-z]+;

WS : [ \t\r\n] -> skip;
