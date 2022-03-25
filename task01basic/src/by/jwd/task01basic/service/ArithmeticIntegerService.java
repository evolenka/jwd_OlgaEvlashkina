package by.jwd.task01basic.service;

import by.jwd.task01basic.entity.NumberData;

public interface ArithmeticIntegerService {

	/**
	 * Arithmetic calculations over integer numbers
	 * 
	 * @author evlashkina
	 * @version 1
	 * @param numberData (list of int numbers)
	 * @return int result of calculation
	 * @exception ServiceException
	 * @throws ServiceException, if the argument is invalid for the calculation
	 */

	public int calculate(NumberData<Integer> numberData) throws ServiceException;
}