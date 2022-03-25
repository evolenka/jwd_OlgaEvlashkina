package by.jwd.task01basic.service.impl;

import by.jwd.task01basic.entity.NumberData;
import by.jwd.task01basic.service.ArithmeticDoubleService;

/*5 linear task: find average of two numbers*/

public class AverageOfTwoNumberServiceImpl implements ArithmeticDoubleService {
	
	/**
	 * Calculate average of two numbers a and b
	 * 
	 * @author evlashkina
	 * @version 1
	 * @param numberData (list of values a and b)
	 * @return double result of calculation
	 */

	@Override
	public double calculate(NumberData <Double> numberData) {
		
		return (numberData.getNumberData().get(0) + numberData.getNumberData().get(1)) / 2;
	}
}