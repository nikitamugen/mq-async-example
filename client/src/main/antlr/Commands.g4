grammar Commands ;

command : ( addCommand | deleteCommand | getCommand | helpCommand | exitCommand ) ;
addCommand : ( ADD code value+ ) ;
deleteCommand : ( DELETE code value+ ) ;
getCommand : ( GET code ) ;
helpCommand: ( HELP | '?' ) ;
exitCommand: ( EXIT | QUIT | 'q' ) ;

code : WORD ;
value : WORD ;

fragment A : ('A'|'a') ;
fragment D : ('D'|'d') ;
fragment E : ('E'|'e') ;
fragment L : ('L'|'l') ;
fragment T : ('T'|'t') ;
fragment G : ('G'|'g') ;
fragment H : ('H'|'h') ;
fragment P : ('P'|'p') ;
fragment X : ('X'|'x') ;
fragment I : ('I'|'i') ;
fragment Q : ('Q'|'q') ;
fragment U : ('U'|'u') ;

ADD : A D D ;
DELETE : D E L E T E ;
GET : G E T ;

HELP : H E L P ;
EXIT : E X I T ;
QUIT : Q U I T ;

WORD : [_a-zA-Zа-ЯА-ЯёЁ0-9]+ ;
WS: [ \t\n\r]+ -> skip ;