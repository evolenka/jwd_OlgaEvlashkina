package by.jwd.task06infohandling.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task06infohandling.entity.Composite;
import by.jwd.task06infohandling.entity.DelimeterType;
import by.jwd.task06infohandling.entity.Component;
import by.jwd.task06infohandling.entity.Symbol;

/**
 * Class ParserToSymbol for parsing of String text into the words
 * 
 * @author Evlashkina
 */

public class ParserToSymbol extends Handler {

	static Logger logger = LogManager.getLogger(ParserToSymbol.class);

	public ParserToSymbol(Handler nextParser) {
		this.nextParser = nextParser;
	}

	/**
	 * Parse string to symbols, add symbols to word
	 *
	 * @param stringToParse
	 * @return IComponent
	 */

	@Override
	public Component parse(String stringToParse) {

		Component word = new Composite(DelimeterType.WORD);

		for (int i = 0; i < stringToParse.length(); i++) {
			Component symbol = new Symbol(stringToParse.charAt(i));
			word.add(symbol);
		}

		logger.debug("word has been parsed to symbols");
		return word;
	}
}