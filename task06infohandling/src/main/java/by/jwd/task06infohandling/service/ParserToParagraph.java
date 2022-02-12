package by.jwd.task06infohandling.service;

import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task06infohandling.entity.Component;
import by.jwd.task06infohandling.entity.Delimeter;
import by.jwd.task06infohandling.entity.IComponent;

/**
 * Class ParserToParagraph for parsing of String text into the paragraphs
 * 
 * @author Evlashkina
 */

public class ParserToParagraph implements Handler {

	static Logger logger = LogManager.getLogger(ParserToParagraph.class);

	private static final String REGEX = ("[\r\n\t]+");

	private Handler next;

	public ParserToParagraph(Handler next) {
		super();
		this.next = next;
	}

	/**
	 * Parse string to paragraphs, add paragraphs to text *
	 * 
	 * @param stringToParse
	 * @return IComponent
	 */

	@Override
	public IComponent parse(String stringToParse) {

		IComponent text = new Component(Delimeter.TEXT);

		Pattern pattern = Pattern.compile(REGEX);

		String[] paragraphs = pattern.split(stringToParse);

		for (String p : paragraphs) {
			IComponent paragraph = next.parse(p);
			text.add(paragraph);
		}
		logger.debug("text has been parsed to paragraphs {}", text);
		return text;
	}
}