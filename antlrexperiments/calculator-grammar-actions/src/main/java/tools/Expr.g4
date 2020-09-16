grammar Expr;

@header {
package tools;
import java.util.*; a   
}

@parser::members {
    Map<String, Integer> memory = new HashMap<>();

    int eval(int left, int op, int right){
        switch(op){
            case MUL : return left * right;
            case DIV : return left / right;
            case ADD : return left + right;
            case SUB : return left - right;
        }
        return 0;
    }


}

/** The start rule; begin parsing here. */
prog:   stat+ ;

stat:   e NEWLINE            {System.out.println($e.v);}
    |   ID '=' e NEWLINE     {memory.put($ID.text, $e.v);}
    |   NEWLINE
    ;

e   returns [int v]
    :   a=e op=('*'|'/') b=e    {$v = eval($a.v, $op.type, $b.v);}
    |   a=e op=('+'|'-') b=e    {$v = eval($a.v, $op.type, $b.v);}
    |   INT                     {$v = $INT.int;}
    |   ID {
        String id = $ID.text;
        $v = memory.containsKey(id) ? memory.get(id) : 0;
    }
    |   '(' e ')'               {$v = $e.v;}
    ;

MUL : '*' ;
DIV : '/' ;
ADD : '+' ;
SUB : '-' ;

ID  :   [a-zA-Z]+ ;      // match identifiers <label id="code.tour.expr.3"/>
INT :   [0-9]+ ;         // match integers
NEWLINE:'\r'? '\n' ;     // return newlines to parser (is end-statement signal)
WS  :   [ \t]+ -> skip ; // toss out whitespace