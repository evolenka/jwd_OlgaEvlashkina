package by.jwd.task06infohandling.service;

import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task06infohandling.entity.Component;
import by.jwd.task06infohandling.entity.Delimeter;
import by.jwd.task06infohandling.entity.IComponent;

/**
 * Class ParserToLexeme for parsing of String text into the lexemes
 * 
 * @author Evlashkina
 */

public class ParserToLexeme implements Handler {

	static Logger logger = LogManager.getLogger(ParserToLexeme.class);

	private static final String REGEX = ("[\s\t\r\n]+");

	private Handler next;

	public ParserToLexeme(Handler next) {
		super();
		this.next = next;
	}

	/**
	 * Parse string to lexemes, add lexemes to sentence
	 *
	 * @param stringToParse
	 * @return IComponent
	 */

	@Override
	public IComponent parse(String stringToParse) {

		IComponent sentence = new Component(Delimeter.SENTENCE);

		Pattern p = Pattern.compile(REGEX);

		String[] lexemes = p.split(stringToParse.trim());

		for (String l : lexemes) {
			sentence.add(next.parse(l));
		}
		logger.debug("sentence has been parsed to lexemes {}", sentence);
		return sentence;
	}
}