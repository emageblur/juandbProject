grammar gram;
r : (select_statement | delete_statement | insert_statement );
select_statement : 'SELECT' column 'FROM' table ('WHERE' condition)*';';
delete_statement : 'DELETE FROM' table ('WHERE' condition)*';' ;
insert_statement : 'INSERT INTO' table ('(' columnList)* 'VALUES (' (inputValue (', ' inputValue)*) ');';
column : ('*' | 'StudNo' | 'StudentName' | 'Birthday' | 'Degree' | 'Major' |  'UnitsEarned' | 'StudNo,' column | 'StudentName,' column | 'Birthday,' column |  'Degree,' column | 'Major,' column | 'UnitsEarned,' column | 'Description'| 'Action' | 'DateFile' | 'DateResolved' | 'Description,' column | 'Action,' column | 'DateFile,' column | 'DateResolved,' column | 'CNo' | 'CTitle' | 'CDesc' | 'NoOfUnits' | 'HasLab' | 'SemOffered' | 'CNo,' column | 'CTitle,' column | 'CDesc,' column | 'NoOfUnits,' column | 'HasLab,' column | 'SemOffered,' column | 'Semester' | 'AcadYear' | 'Section' | 'Time' | 'MaxStud' | 'Semester,' column | 'AcadYear,' column | 'Section,' column | 'Time,' column |  'MaxStud,' column );
columnList : ('StudNo)' | 'StudentName)' | 'Birthday)' | 'Degree)' | 'Major)' |  'UnitsEarned)' | 'StudNo,' columnList | 'StudentName,' columnList | 'Birthday,' columnList |  'Degree,' columnList | 'Major,' columnList | 'UnitsEarned,' columnList | 'Description'| 'Action)' | 'DateFile)' | 'DateResolved)' | 'Description,' columnList | 'Action,' columnList | 'DateFile,' columnList | 'DateResolved,' columnList | 'CNo)' | 'CTitle)' | 'CDesc)' | 'NoOfUnits)' | 'HasLab)' | 'SemOffered)' | 'CNo,' columnList | 'CTitle,' columnList | 'CDesc,' columnList | 'NoOfUnits,' columnList | 'HasLab,' columnList | 'SemOffered,' columnList | 'Semester)' | 'AcadYear)' | 'Section)' | 'Time)' | 'MaxStud)' | 'Semester,' columnList | 'AcadYear,' columnList | 'Section,' columnList | 'Time,' columnList |  'MaxStud,' columnList );
table : 'STUDENT' | 'STUDENTHISTORY' | 'COURSE' | 'COURSEOFFERING' | 'STUDCOURSE'; 
ID: ('a'..'z'|'A'..'Z'|'0'..'9')+;
INT: ('0'..'9');
allChar: (.)+?;
birthday: ('1'|'2') INT INT INT '-' ('0'|'1') INT '-' ('0'|'1'|'2'|'3') INT;
time: ('0'|'1'|'2') INT ':' ('0'|'1'|'2'|'3'|'4'|'5') INT;
studentNo: ('1'|'2') INT INT INT '-' INT INT INT INT INT;
sem: ('1st' | '2nd' | 'Sum');
inputValue: (allChar | birthday | time | studentNo | sem );
operators: ( '<' | '>' | '=' | '!=' );
operands: ('AND' condition | 'OR' condition);
condition : column operators inputValue (operands)*;
WS : [ \r\t\n]+ -> skip ;




