package by.jwd.task06infohandling.service;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class ParserToPolishNotation for parsing of the String bit expression to the
 * String Polish notation
 * 
 * @author Evlashkina
 */
public class ParseToPolishNotation {

	static Logger logger = LogManager.getLogger(ParseToPolishNotation.class);

	static final String REGEX = ("(\\d+)*+(\\<{2}|\\>{2,3}|[\\(\\)\\~\\&\\^\\|]?)");

	/**
	 * Parses bit expression to the Polish notation *
	 * 
	 * @param expression
	 * @return Sting
	 */
	public String parse(String expression) {

		StringBuilder result = new StringBuilder();

		/* create stacks for operands and operations */
		Deque<String> firstStack = new ArrayDeque<>();
		Deque<String> secondStack = new ArrayDeque<>();

		Pattern p = Pattern.compile(REGEX);
		Matcher m = p.matcher(expression);

		/*
		 * while matcher finds group (1) which corresponds to operand, push it to the
		 * first stack, group (2) - correspond to operation, so push it to the second
		 * stack, following the rules for polish notation
		 */
		while (m.find()) {
			String operand = m.group(1);
			logger.debug("operand {}", operand);

			String operation = m.group(2);
			logger.debug("operation {}", operation);

			if (operand != null) {
				firstStack.push(operand);
				logger.debug("operand has been pushed to the first stack {}", operand);
			}

			if (operation != null && operation.equals(")")) {
				while (!secondStack.peek().equals("(")) {
					firstStack.push(secondStack.pop());

					if (logger.isDebugEnabled()) {
						logger.debug("operation has been pushed from the second stack to the first stack {}",
								firstStack.peek());
					}
				}
				logger.debug("delete ( from second stack");
				secondStack.pop();
			} else if (operation != null
					&& (isOperationOfHigherPriority(operation, secondStack.peek()) || operation.equals("("))) {
				secondStack.push(operation);
				logger.debug("operation has been added to second stack {}", operation);

			} else if (operation != null) {
				while (secondStack.peek() != null && !secondStack.peek().equals("(")) {

					firstStack.push(secondStack.pop());

					if (logger.isDebugEnabled()) {
						logger.debug("operation has been pushed from the second stack to the first stack {}",
								firstStack.peek());
					}
				}
				secondStack.push(operation);
				logger.debug("operation has been added to second stack {}", operation);
			}
		}

		/*
		 * after all operands and operations from the bit expression have been puted to
		 * the stacks, push the remaining operations from the second stack to the first
		 * stack
		 */
		while (!secondStack.isEmpty()) {
			firstStack.push(secondStack.pop());

			if (logger.isDebugEnabled()) {
				logger.debug("operation has been added to the first stack {}", firstStack.peek());
			}
		}

		/* create String result from the first stack */
		while (!firstStack.isEmpty()) {
			result.append(firstStack.pollLast());
			result.append(" ");
		}

		logger.debug("polish notation has been created");
		return result.toString();
	}

	/**
	 * Defines the priority of the operation from the bit expression in relation to
	 * the last operation in the second stack
	 *
	 * @param operation, operationInSecondStack
	 * @return boolean, returns true - in case operation has higher priority than
	 *         the last operation in second stack, otherwise returns false
	 */
	public static boolean isOperationOfHigherPriority(String operation, String operationInSecondStack) {

		boolean res = false;
		/*
		 * in case the second stack is empty, the priority of operation is higher by
		 * default
		 */
		if (operationInSecondStack == null) {
			res = true;
		} else {

			switch (operation) {
			case (">>"), (">>>"), ("<<"): {
				if (!"~>>><<".contains(operationInSecondStack)) {
					res = true;
					logger.debug("operation {}", operation);
					logger.debug("has higher priority than {}", operationInSecondStack);
				} else {
					logger.debug("operation {}", operation);
					logger.debug("has lower  priority than {}", operationInSecondStack);
				}
				break;
			}
			case ("&"): {
				if (!"~~>>><<&".contains(operationInSecondStack)) {
					res = true;
					logger.debug("operation {}", operation);
					logger.debug("has higher priority than {} ", operationInSecondStack);
				} else {
					logger.debug("operation {}", operation);
					logger.debug("has lower  priority than {} ", operationInSecondStack);
				}
				break;
			}
			case ("^"): {
				if (!"~>>><<&^".contains(operationInSecondStack)) {
					res = true;
					logger.debug("operation {}", operation);
					logger.debug("has higher priority than {} ", operationInSecondStack);
				} else {
					logger.debug("operation {}", operation);
					logger.debug("has lower  priority than {} ", operationInSecondStack);
				}
				break;
			}
			case ("|"): {
				if (!"~>>><<&^|".contains(operationInSecondStack)) {
					res = true;
					logger.debug("operation {}", operation);
					logger.debug("has higher priority than {} ", operationInSecondStack);
				} else {
					logger.debug("operation {}", operation);
					logger.debug("has lower priority than {} ", operationInSecondStack);
				}
				break;
			}
			default:
				res = true;
			}
		}
		return res;
	}
}