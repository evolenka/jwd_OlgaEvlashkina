package by.jwd.task06infohandling.service;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task06infohandling.service.impl.NonTerminalBitwiseAndImpl;
import by.jwd.task06infohandling.service.impl.NonTerminalBitwiseOrImpl;
import by.jwd.task06infohandling.service.impl.NonTerminalBitwiseXorImpl;
import by.jwd.task06infohandling.service.impl.NonTerminalShiftLeftImpl;
import by.jwd.task06infohandling.service.impl.NonTerminalShiftRightImpl;
import by.jwd.task06infohandling.service.impl.NonTerminalShiftRightWithZeroPaddingImpl;
import by.jwd.task06infohandling.service.impl.NotTerminalBitwiseUnaryNotImpl;
import by.jwd.task06infohandling.service.impl.TerminalExpressionNumberImpl;

/**
 * Class Interpreter for calculating of bit expression
 * 
 * @author Evlashkina
 */

public class Interpreter {

	static Logger logger = LogManager.getLogger(Interpreter.class);

	private ArrayList<AbstracMathExpression> listExpression;

	public Interpreter(String expression) {
		listExpression = new ArrayList<>();
		parse(expression);
	}

	/* parsing bit expression into Polish notation */
	private void parse(String expression) {
		ParseToPolishNotation parser = new ParseToPolishNotation();
		String polishNotation = parser.parse(expression);

		/*
		 * parsing polish notation, creating the respective non terminal and terminal
		 * objects and adding them to list
		 */
		for (String operation : polishNotation.split("\\s+")) {

			if (operation.isEmpty()) {
				continue;
			}

			String temp = operation;
			switch (temp) {
			case "~":
				listExpression.add(new NotTerminalBitwiseUnaryNotImpl());
				break;
			case "&":
				listExpression.add(new NonTerminalBitwiseAndImpl());
				break;
			case "|":
				listExpression.add(new NonTerminalBitwiseOrImpl());
				break;
			case "^":
				listExpression.add(new NonTerminalBitwiseXorImpl());
				break;
			case "<<":
				listExpression.add(new NonTerminalShiftLeftImpl());
				break;
			case ">>":
				listExpression.add(new NonTerminalShiftRightImpl());
				break;
			case ">>>":
				listExpression.add(new NonTerminalShiftRightWithZeroPaddingImpl());
				break;
			default:
				listExpression.add(new TerminalExpressionNumberImpl(Integer.parseInt(temp)));
			}
		}
	}

	/* calculating of bit operations and collecting the result */
	public int calculate() {

		Context context = new Context();

		for (AbstracMathExpression terminal : listExpression) {
			terminal.interpret(context);
		}
		return context.popValue();
	}
}