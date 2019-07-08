grammar dules;

higher: pageShowRule | questionShowRule;

pageShowRule: '.page(' rule ')';
questionShowRule: '.question('  rule ')';

rule: triggers | rule AND rule | rule OR rule | NOT rule;

triggers: statedriven | contextdriven;

statedriven: allPagesComplete;
contextdriven : answerExists | answerMatches | answerIn | answerDateBefore | answerDateAfter;

answerMatches:  String  Und  String  Und  String;
answerExists:  String  Und  String;
answerIn: String  Und  String  Und Ref;
answerDateBefore: String Und String Und LessThan Date;
answerDateAfter: String Und String Und GreaterThan Date;
allPagesComplete: Complete;

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
GreaterThan: '<';