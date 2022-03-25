package by.jwd.task06infohandling.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task06infohandling.service.AbstracMathExpression;
import by.jwd.task06infohandling.service.Context;

/**
 * Implements operation of bitwise XOR over two numbers
 * 
 * @author Evlashkina
 */

public class NonTerminalBitwiseXorImpl implements AbstracMathExpression {

	static Logger logger = LogManager.getLogger(NonTerminalBitwiseXorImpl.class);

	@Override
	public void interpret(Context c) {

		int arg2 = c.popValue();
		int arg1 = c.popValue();
		c.pushValue(arg1 ^ arg2);

		logger.debug("NonTerminalBitwiswXor has been applied, temp result = {}", arg1 ^ arg2);
	}
}