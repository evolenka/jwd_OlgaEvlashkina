package by.jwd.task06infohandling.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task06infohandling.service.AbstracMathExpression;
import by.jwd.task06infohandling.service.Context;

/**
 * Implements bit operation of shift left over two numbers
 * 
 * @author Evlashkina
 */

public class NonTerminalShiftLeftImpl implements AbstracMathExpression {

	static Logger logger = LogManager.getLogger(NonTerminalShiftLeftImpl.class);

	@Override
	public void interpret(Context c) {
		
		int arg2 = c.popValue();
		int arg1 = c.popValue();
		c.pushValue(arg1 << arg2);
		
		logger.debug("NonTerminalShiftLeft has been applied, temp result = {}", arg1 << arg2);
	}
}