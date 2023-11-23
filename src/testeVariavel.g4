grammar testeVariavel;

import INT_EXPRESSION;

// Entry point of the grammar
prog: declaration+;

declaration: TYPE ID ( '=' value)? ';';

value: STRING | INT_EXPRESSION;

TYPE: 'int' | 'string';
ID: [a-zA-Z_][a-zA-Z0-9_]*;

STRING: '"' ~["]* '"';

// Skip whitespace and newlines
WS: [ \t\r\n]+ -> skip;