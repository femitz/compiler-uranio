grammar TesteVariavel;

import INT_EXPRESSION;

prog: declaration+;

declaration: TYPE ID '=' value ';';

value:   STRING | CHAR | BOOLEAN
        | INT_EXPRESSION;

TYPE:  'string'|'char'|'boolean'|'int';
ID: [a-zA-Z][a-zA-Z0-9_-]*;

CHAR: '"' . '"'         | '\'' . '\'';
STRING: '"' ~["]* '"'   | '\''  ~["]* '\'';

BOOLEAN: 'true'|'false';

// Skip whitespace and newlines
WS: [ \t\r\n]+ -> skip;

/*
ok  - string hello = "hello wolrd";
ok  - char character = "!";

ok  - int numero_inteiro = 1;
    - double numero_double = 10.20;
    - float numero_float = 20.40;

    - boolean verifica = false;
*/