grammar gram;
r : (select_statement | delete_statement | insert_statement );
select_statement : 'select' column 'from' table ('where' condition)*';';
delete_statement : 'delete from' table ('where' condition)*';' ;
insert_statement : 'insert into' table ('(' columnlist)* 'values (' (inputValue (', ' inputValue)*) ');';
column : ('*' | 'studno' | 'studentname' | 'birthday' | 'degree' | 'major' |  'unitsearned' | 'studno,' column | 'studentname,' column | 'birthday,' column |  'degree,' column | 'major,' column | 'unitsearned,' column | 'description'| 'action' | 'datefiled' | 'dateresolved' | 'description,' column | 'action,' column | 'datefiled,' column | 'dateresolved,' column | 'cno' | 'ctitle' | 'cdesc' | 'noofunits' | 'haslab' | 'semoffered' | 'cno,' column | 'ctitle,' column | 'cdesc,' column | 'noofunits,' column | 'haslab,' column | 'semoffered,' column | 'semester' | 'acadyear' | 'section' | 'time' | 'maxstud' | 'semester,' column | 'acadyear,' column | 'section,' column | 'time,' column |  'maxstud,' column );
columnlist : ('studno)' | 'studentname)' | 'birthday)' | 'degree)' | 'major)' |  'unitsearned)' | 'studno,' columnlist | 'studentname,' columnlist | 'birthday,' columnlist |  'degree,' columnlist | 'major,' columnlist | 'unitsearned,' columnlist | 'description'| 'action)' | 'datefiled)' | 'dateresolved)' | 'description,' columnlist | 'action,' columnlist | 'datefiled,' columnlist | 'dateresolved,' columnlist | 'cno)' | 'ctitle)' | 'cdesc)' | 'noofunits)' | 'haslab)' | 'semoffered)' | 'cno,' columnlist | 'ctitle,' columnlist | 'cdesc,' columnlist | 'noofunits,' columnlist | 'haslab,' columnlist | 'semoffered,' columnlist | 'semester)' | 'acadyear)' | 'section)' | 'time)' | 'maxstud)' | 'semester,' columnlist | 'acadyear,' columnlist | 'section,' columnlist | 'time,' columnlist |  'maxstud,' columnlist );
table : 'student' | 'studenthistory' | 'course' | 'courseoffering' | 'studcourse' ;
ID: ('a'..'z'|'A'..'Z'|'0'..'9')+;
inputValue: (.)+?;
operators: ( '<' | '>' | '=' | '!=' );
operands: ('AND' condition | 'OR' condition);
condition : column operators inputValue (operands)*;
WS : [ \r\t\n]+ -> skip ;




