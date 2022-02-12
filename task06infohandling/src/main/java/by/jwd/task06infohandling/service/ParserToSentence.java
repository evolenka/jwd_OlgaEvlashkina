package by.jwd.task06infohandling.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task06infohandling.entity.Component;
import by.jwd.task06infohandling.entity.Delimeter;
import by.jwd.task06infohandling.entity.IComponent;

/**
 * Class ParserToSentence for parsing of String text into the sentences
 * 
 * @author Evlashkina
 */

public class ParserToSentence implements Handler {

	static Logger logger = LogManager.getLogger(ParserToSentence.class);

	private static final String REGEX = (".+?(\\.{3}|[\\.?!](\\!)?)");

	private Handler next;

	public ParserToSentence(Handler next) {
		super();
		this.next = next;
	}

	/**
	 * Parse string to senteces, add sentences to paragraph
	 *
	 * @param stringToParse
	 * @return IComponent
	 */

	@Override
	public IComponent parse(String stringToParse) {

		IComponent paragraph = new Component(Delimeter.PARAGRAPH);

		Pattern p = Pattern.compile(REGEX);
		Matcher m = p.matcher(stringToParse);

		while (m.find()) {
			IComponent sentence = next.parse(m.group());
			paragraph.add(sentence);
		}
		logger.debug("paragraph has been parsed to sentences {}", paragraph);
		return paragraph;
	}
}