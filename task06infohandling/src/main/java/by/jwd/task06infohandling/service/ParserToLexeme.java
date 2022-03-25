package by.jwd.task06infohandling.service;

import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task06infohandling.entity.Composite;
import by.jwd.task06infohandling.entity.DelimeterType;
import by.jwd.task06infohandling.entity.Component;

/**
 * Class ParserToLexeme for parsing of String text into the lexemes
 * 
 * @author Evlashkina
 */

public class ParserToLexeme extends Handler {

	static Logger logger = LogManager.getLogger(ParserToLexeme.class);

	private static final String REGEX = ("[\s\t\r\n]+");

	public ParserToLexeme(Handler nextParser) {
		this.nextParser = nextParser;
	}

	/**
	 * Parse string to lexemes, add lexemes to sentence
	 *
	 * @param stringToParse
	 * @return IComponent
	 */

	@Override
	public Component parse(String stringToParse) {

		Component sentence = new Composite(DelimeterType.SENTENCE);

		Pattern p = Pattern.compile(REGEX);

		String[] lexemes = p.split(stringToParse.trim());

		for (String l : lexemes) {
			sentence.add(nextParser.parse(l));
		}
		logger.debug("sentence has been parsed to lexemes {}", sentence);
		return sentence;
	}
}