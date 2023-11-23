grammar MainANTRL;

import TesteVariavel, TesteFuncao;

programa: declaration+;

declaration: value ;

value:TesteVariavel | TesteFuncao;

WS: [ \t\r\n]+ -> skip;


