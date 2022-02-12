package by.jwd.task06infohandling.controller;

import java.util.ArrayList;
import java.util.List;

import by.jwd.task06infohandling.dao.DaoException;
import by.jwd.task06infohandling.dao.ReadFromFile;
import by.jwd.task06infohandling.entity.Component;
import by.jwd.task06infohandling.entity.Delimeter;
import by.jwd.task06infohandling.entity.IComponent;
import by.jwd.task06infohandling.service.ParserToLexeme;
import by.jwd.task06infohandling.service.ParserToParagraph;
import by.jwd.task06infohandling.service.ParserToSentence;
import by.jwd.task06infohandling.service.ParserToSymbol;
import by.jwd.task06infohandling.service.ParserToWord;
import by.jwd.task06infohandling.service.SortLexemeByQuantityOfGivenSymbol;
import by.jwd.task06infohandling.service.SortParagraphBySentenceQuantity;
import by.jwd.task06infohandling.service.SortWordsByLength;

public class Runner {
	
	
	public static void main (String [ ] args){
		
		ReadFromFile reader = new ReadFromFile ();
		List<String> text = null;
		String t = "";
		try {
			text = reader.read("data.txt");
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
for (int i =0; i <text.size();i++) {
	
	t += text.get(i);
}
//System.out.println (t);

//ParserToSymbol parser1 = new ParserToSymbol();

//ParserToWord parser2 = new ParserToWord (parser1);
//IComponent finaltext = new Component (Delimeter.PARAGRAPH);

//IComponent lexeme = parser2.parse("hello word");

//System.out.println (lexeme);
//}

ParserToParagraph parser = new ParserToParagraph(new ParserToSentence(new ParserToLexeme (new ParserToWord (new ParserToSymbol()))));

IComponent finaltext = parser.parse(t);
//System.out.println(finaltext.getChild(0).getSize());
//System.out.println(finaltext.getChild(1).getSize());
//System.out.println(finaltext.getChild(2).getSize());

SortParagraphBySentenceQuantity s = new SortParagraphBySentenceQuantity();

SortLexemeByQuantityOfGivenSymbol s2 = new SortLexemeByQuantityOfGivenSymbol(',');


SortWordsByLength s1 = new SortWordsByLength();


//System.out.println(finaltext.getChild(0).getChild(0).getChild(7).getChild(0));

System.out.println (s1.sort(finaltext));
//(s.sort(finaltext));
//(finaltext.collect());

//for (int i = 0; i < finaltext.getSize(); i++) {
	//System.out.print(finaltext.toString());
	//res = finaltext.getChild(i) + " \t";
}
		//System.out.print(res);

	//System.out.println (finaltext.collect());
	
	//new ParserToParagraph (new ParserToSentence (new ParserToLexeme 
//ew ParserToParagraph (new ParserToSentence (new ParserToLexeme 
}

