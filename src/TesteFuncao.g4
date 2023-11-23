grammar TesteFuncao;

import TesteVariavel;

func: 'func' NAME '(' params ')' '{' block '}';

NAME: [a-zA-Z][a-zA-Z0-9_-]*;

params: PARAM (',' PARAM)* | /* empty */;
PARAM: [a-zA-Z0-9_-]*;

block: TesteVariavel | /* empty */;

WS: [ \t\r\n]+ -> skip;