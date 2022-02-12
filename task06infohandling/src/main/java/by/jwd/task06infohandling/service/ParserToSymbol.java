package by.jwd.task06infohandling.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task06infohandling.entity.Component;
import by.jwd.task06infohandling.entity.Delimeter;
import by.jwd.task06infohandling.entity.IComponent;
import by.jwd.task06infohandling.entity.Symbol;

/**
 * Class ParserToSymbol for parsing of String text into the words
 * 
 * @author Evlashkina
 */

public class ParserToSymbol implements Handler {

	static Logger logger = LogManager.getLogger(ParserToSymbol.class);

	public ParserToSymbol() {
		super();
	}

	/**
	 * Parse string to symbols, add symbols to word
	 *
	 * @param stringToParse
	 * @return IComponent
	 */

	@Override
	public IComponent parse(String stringToParse) {

		IComponent word = new Component(Delimeter.WORD);
		for (int i = 0; i < stringToParse.length(); i++) {
			IComponent symbol = new Symbol(stringToParse.charAt(i));
			word.add(symbol);
		}
		logger.debug("word has been parsed to symbols {}", word);
		return word;
	}
}