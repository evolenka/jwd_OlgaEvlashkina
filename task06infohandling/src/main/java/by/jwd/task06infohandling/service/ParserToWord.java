package by.jwd.task06infohandling.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task06infohandling.entity.Composite;
import by.jwd.task06infohandling.entity.DelimeterType;
import by.jwd.task06infohandling.entity.Component;

/**
 * Class ParserToWord for parsing of String text into the words
 * 
 * @author Evlashkina
 */

public class ParserToWord extends Handler {

	static Logger logger = LogManager.getLogger(ParserToWord.class);

	private static final String LEXEME_REGEX = ("[\s\t\r\n]+");
	private static final String WORD_REGEX = ("(\\(*\\~*\\-*\\w*[\\d\\-\\|\\&\\^\\~\\>+\\<+\\(\\)]*)([\\,\\'\\!\\:\\;\\?\\.+\\?!]*)");

	public ParserToWord(Handler nextParser) {
		this.nextParser = nextParser;
	}

	/**
	 * Parse string to words, add words to lexeme
	 *
	 * @param stringToParse
	 * @return IComponent
	 */

	@Override
	public Component parse(String stringToParse) {

		Component lexeme = new Composite(DelimeterType.LEXEME);

		Pattern pattern1 = Pattern.compile(LEXEME_REGEX);
		String[] lexemes = pattern1.split(stringToParse.trim());
		Pattern pattern2 = Pattern.compile(WORD_REGEX);

		for (String l : lexemes) {
			Matcher m = pattern2.matcher(l);

			while (m.find()) {
				Component word = nextParser.parse(m.group(1));
				lexeme.add(word);
				Component punctuation = nextParser.parse(m.group(2));
				lexeme.add(punctuation);
			}
		}
		logger.debug("lexeme has been parsed to words {}", lexeme);
		return lexeme;
	}
}