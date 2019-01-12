grammar JapaneseParser;

parse : 
	Word ;

Word
  :  ('a'..'z' | 'A'..'Z') ('a'..'z' | 'A'..'Z' | DIGIT)*
  | JAPANESE*
  ;

fragment DIGIT     : [0-9]+ ;
 
WHITESPACE : (' ' | '\t' | '\r' | '\n') -> skip;

fragment JAPANESE : [\p{Script=Hiragana}\p{Script=Katakana}\p{Script=Han}];