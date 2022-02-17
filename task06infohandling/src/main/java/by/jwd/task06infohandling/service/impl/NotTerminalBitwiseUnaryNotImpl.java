package by.jwd.task06infohandling.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task06infohandling.service.AbstracMathExpression;
import by.jwd.task06infohandling.service.Context;

/**
 * Implements bit operation of unary NOT
 * 
 * @author Evlashkina
 */

public class NotTerminalBitwiseUnaryNotImpl implements AbstracMathExpression {

	static Logger logger = LogManager.getLogger(NotTerminalBitwiseUnaryNotImpl.class);

	@Override
	public void interpret(Context c) {

		int arg = c.popValue();
		c.pushValue(~arg);

		logger.debug("NotTerminalBitwiseUnaryNot has been applied, temp result = {}", ~arg);
	}
}