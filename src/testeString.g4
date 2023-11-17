grammar testeString;
prule: 'string ' VAR;
VAR: [a-zA-Z][a-zA-Z_\-]+ ;
WS : [ \t\r\n]+ -> skip ;
