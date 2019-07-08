grammar dules;

higher: pageShowRule | questionShowRule;

pageShowRule: '.page(' rule ')';
questionShowRule: '.question('  rule ')';

rule: triggers | rule AND rule | rule OR rule | NOT rule;

triggers: statedriven | contextdriven;

statedriven: allPagesComplete | pageComplete;
contextdriven: answerExists | answerMatches | answerIn | answerDateBefore | answerDateAfter | answerLessThan | answerMoreThan | pageExists;

allPagesComplete: Complete;
answerDateAfter: String Und String Und GreaterThan Date;
answerDateBefore: String Und String Und LessThan Date;
answerExists:  String  Und  String;
answerIn: String  Und  String  Und Ref;
answerLessThan: String Und String Und LessThan Number;
answerMatches:  String  Und  String  Und  String;
answerMoreThan: String Und String Und GreaterThan Number;
pageComplete: Complete Und String;
pageExists: String;

Complete: 'complete';
AND: ' & ';
OR: ' || ';
NOT: '!';
Number: [0-9]+;
String: ['a-zA-Z']+;
Ref: '$'['a-zA-Z']+;
Date: Number'-'Number'-'Number;
Und: '__';
LessThan: '<';
GreaterThan: '>';