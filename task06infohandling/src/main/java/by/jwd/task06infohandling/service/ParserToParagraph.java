package by.jwd.task06infohandling.service;

import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task06infohandling.entity.Composite;
import by.jwd.task06infohandling.entity.DelimeterType;
import by.jwd.task06infohandling.entity.Component;

/**
 * Class ParserToParagraph for parsing of String text into the paragraphs
 * 
 * @author Evlashkina
 */

public class ParserToParagraph extends Handler {

	static Logger logger = LogManager.getLogger(ParserToParagraph.class);

	private static final String REGEX = ("[\r\n\t]+");

	public ParserToParagraph(Handler nextParser) {
		this.nextParser = nextParser;
	}

	/**
	 * Parse string to paragraphs, add paragraphs to text *
	 * 
	 * @param stringToParse
	 * @return IComponent
	 */

	@Override
	public Component parse(String stringToParse) {

		Component text = new Composite(DelimeterType.TEXT);

		Pattern pattern = Pattern.compile(REGEX);

		String[] paragraphs = pattern.split(stringToParse);

		for (String p : paragraphs) {
			Component paragraph = nextParser.parse(p);
			text.add(paragraph);
		}
		logger.debug("text has been parsed to paragraphs {}", text);
		return text;
	}
}