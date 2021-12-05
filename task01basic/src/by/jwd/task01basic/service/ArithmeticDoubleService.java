package by.jwd.task01basic.service;

import by.jwd.task01basic.entity.NumberData;

public interface ArithmeticDoubleService {

	/**
	 * Arithmetic calculations over double numbers
	 * 
	 * @author evlashkina
	 * @version 1
	 * @param numberData
	 * @return double result of calculation
	 */

	public double calculate(NumberData<Double> numberData);
}
