grammar Uranio;

program: line* EOF;

line: statement | ifBlock | whileBlock ;

statement: (typeAssigment | assigment | functionCall) ';' ;

ifBlock: 'if' expression block ('else' elseIfBlock)?;

elseIfBlock: block | ifBlock;

whileBlock: 'while' expression block;

assigment: IDENTIFIER '=' expression;

typeAssigment: type IDENTIFIER '=' expression;

type: 'string' | 'int' | 'float' | 'boolean' | 'double' | 'char';

functionCall: IDENTIFIER '(' (expression (',' expression)*)? ')';

expression
    : constant
    | IDENTIFIER
    | functionCall
    | '(' expression ')'
    | '!' expression
    | expression multOp expression
    | expression addOp expression
    | expression compareOp expression
    | expression booleanOp expression
    ;

multOp: '*' | '/' | '%';
addOp: '+' | '-';
compareOp: '==' | '!=' | '>' | '<' | '>=' | '<=' ;
booleanOp: 'and' | '||' | 'or' | '&&';

constant: INTEGER | FLOAT | STRING | BOOLEAN | NULL;

INTEGER: [0-9]+;
FLOAT: [0-9]+ '.' [0-9]+;
STRING: ('"' ~'"'* '"' ) | ('\'' ~'\''* '\'');
BOOLEAN: 'true' | 'false';
NULL: 'null';

block: '{' line* '}';

WS: [ \t\r\n]+ -> skip;
IDENTIFIER: [a-zA-Z_][a-zA-Z0-9_]*;