package by.jwd.task01basic.service.impl;

import by.jwd.task01basic.entity.NumberData;
import by.jwd.task01basic.service.ArithmeticDoubleService;

/*7 conditional task: calculate absolute value of expression a*x*x + b*x + c for given values of a, b, c and x*/

public class AbsValueOfExpressionServiceImpl implements ArithmeticDoubleService {

	/**
	 * Calculate absolute value of expression a*x*x + b*x + c for given values of a,
	 * b, c and x
	 * 
	 * @author evlashkina
	 * @version 1
	 * @param numberData (list of values a, b, c and x)
	 * @return double result of calculation
	 */

	@Override
	public double calculate(NumberData<Double> numberData) {

		double a;
		double b;
		double c;
		double x;

		double result;

		a = numberData.getNumberData().get(0);
		b = numberData.getNumberData().get(1);
		c = numberData.getNumberData().get(2);
		x = numberData.getNumberData().get(3);

		result = a * x * x + b * x + c;

		if (result < 0) {
			result *= -1;
		}
		return result;
	}
}