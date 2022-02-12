package by.jwd.task06infohandling.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task06infohandling.entity.Component;
import by.jwd.task06infohandling.entity.Delimeter;
import by.jwd.task06infohandling.entity.IComponent;

/**
 * Class ParserToWord for parsing of String text into the words
 * 
 * @author Evlashkina
 */

public class ParserToWord implements Handler {

	static Logger logger = LogManager.getLogger(ParserToWord.class);

	private static final String LEXEME_REGEX = ("[\s\t\r\n]+");
	private static final String WORD_REGEX =("(\\(*\\~*\\-*\\w*[\\d\\-\\|\\&\\^\\~\\>+\\<+\\(\\)]*)([\\,\\'\\!\\:\\;\\?\\.+\\?!]*)");

	private Handler next;

	public ParserToWord(Handler next) {
		super();
		this.next = next;
	}

	/**
	 * Parse string to words, add words to lexeme
	 *
	 * @param stringToParse
	 * @return IComponent
	 */

	@Override
	public IComponent parse(String stringToParse) {

		IComponent lexeme = new Component(Delimeter.LEXEME);

		Pattern pattern1 = Pattern.compile(LEXEME_REGEX);
		String[] lexemes = pattern1.split(stringToParse.trim());
		Pattern pattern2 = Pattern.compile(WORD_REGEX);
		
		for (String l : lexemes) {
			Matcher m = pattern2.matcher(l);
//			if (l.equals("-")) {
//				IComponent word = next.parse("-");
//				lexeme.add(word);
//				IComponent punctuation = next.parse("");
//				lexeme.add(punctuation);
				
	//		}
			while (m.find()) {
				IComponent word = next.parse(m.group(1));
				lexeme.add(word);
				IComponent punctuation = next.parse(m.group(2));
				lexeme.add(punctuation);
			}
		}
		logger.debug("lexeme has been parsed to words {}", lexeme);
		return lexeme;
	}
}