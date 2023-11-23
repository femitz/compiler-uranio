grammar INT_EXPRESSION;

prog:   prog ('*'|'/') prog
    |   prog ('+'|'-') prog
    |   INT
    |   '(' prog ')'
    ;

NEWLINE : [\r\n]+ ;
INT     : [0-9]+ ;