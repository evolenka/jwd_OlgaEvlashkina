package by.jwd.task06infohandling.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task06infohandling.entity.Component;

/**
 * Checks whether the word is a bit expression or not
 * 
 * @author Evlashkina
 */

public class IsExpression {

	static Logger logger = LogManager.getLogger(IsExpression.class);

	private static final String EXPRESSION_REGEX = ("([\\(+\\~]*\\d+[\\(\\d\\&\\^\\>{2,3}\\<{2}\\)+\\|]+)");
	public boolean isBitExpression(Component component) {

		Pattern pattern = Pattern.compile(EXPRESSION_REGEX);
		Matcher m = pattern.matcher(component.toString().trim());

		if (m.find() && (m.group().equals(component.toString().trim()))) {

			logger.debug("bit expression has been found {}", component);
			return true;

		} else {
			return false;
		}
	}
}