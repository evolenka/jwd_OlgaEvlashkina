package by.jwd.task06infohandling.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task06infohandling.entity.Composite;
import by.jwd.task06infohandling.entity.DelimeterType;
import by.jwd.task06infohandling.entity.Component;

/**
 * Class ParserToSentence for parsing of String text into the sentences
 * 
 * @author Evlashkina
 */

public class ParserToSentence extends Handler {

	static Logger logger = LogManager.getLogger(ParserToSentence.class);

	private static final String REGEX = (".+?(\\.{3}|[\\.?!](\\!)?)");

	public ParserToSentence(Handler nextParser) {
		this.nextParser = nextParser;
	}

	/**
	 * Parse string to senteces, add sentences to paragraph
	 *
	 * @param stringToParse
	 * @return IComponent
	 */

	@Override
	public Component parse(String stringToParse) {

		Component paragraph = new Composite(DelimeterType.PARAGRAPH);

		Pattern p = Pattern.compile(REGEX);
		Matcher m = p.matcher(stringToParse);

		while (m.find()) {
			Component sentence = nextParser.parse(m.group());
			paragraph.add(sentence);
		}
		logger.debug("paragraph has been parsed to sentences {}", paragraph);
		return paragraph;
	}
}