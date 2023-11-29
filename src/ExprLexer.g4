lexer grammar ExprLexer;

AND : '&&' ;
OR : '|' ;
NOT : '!' ;
EQ : '=' ;
COMMA : ',' ;
SEMI : ';' ;
LPAREN : '(' ;
RPAREN : ')' ;
LCURLY : '{' ;
RCURLY : '}' ;

IF : 'if';
ELSE: 'else';
WHILE: 'while';
FOR: 'for';

TRUE: 'true';
FALSE: 'false';
RETURN: 'return';

CHAR: '"' . '"'         | '\'' . '\'';
STRING: '"' ~["]* '"'   | '\''  ~["]* '\'';

INT : [0-9]+ ;
ID: [a-zA-Z_][a-zA-Z_0-9]* ;
WS: [ \t\n\r\f]+ -> skip ;