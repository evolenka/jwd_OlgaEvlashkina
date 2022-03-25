package by.jwd.task06infohandling.service.impl;

import by.jwd.task06infohandling.service.AbstracMathExpression;
import by.jwd.task06infohandling.service.Context;

public class TerminalExpressionNumberImpl implements AbstracMathExpression {

	private int number;

	public TerminalExpressionNumberImpl(int number) {
		this.number = number;
	}

	@Override
	public void interpret(Context c) {
		c.pushValue(number);
	}
}
