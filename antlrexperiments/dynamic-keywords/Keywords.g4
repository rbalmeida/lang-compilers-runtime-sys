grammar Keywords;

tokens { BEGIN, END, IF, THEN, WHILE }

@lexer::header{
import java.util.*;
}

@lexer::members{
Map<String,Integer> keywords = new HashMap<String,Integer>() {{
	put("begin", KeywordsParser.BEGIN);
	put("end", KeywordsParser.END);
	put("if", KeywordsParser.IF);
	put("then", KeywordsParser.THEN);
	put("while", KeywordsParser.WHILE);
}};
}


stat: 	BEGIN stat* END
	| IF expr THEN stat
	| WHILE expr stat
	| ID '=' expr ';'
	;

expr : INT | CHAR;



ID 	: 	[a-zA-Z]+
	{
	if (keywords.containsKey(getText())) {
		setType(keywords.get(getText()));
	}
	}
	;
	
INT : [0-9]+;
CHAR : '\'' . '\'' {setText(String.valueOf(getText().charAt(1))); };
WS : [ \t\n\r] -> skip;
