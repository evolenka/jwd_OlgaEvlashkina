package by.jwd.task01basic.service.impl;

import by.jwd.task01basic.entity.NumberData;
import by.jwd.task01basic.service.ArithmeticDoubleService;

/*7. Calculate absolute value of expression a*x*x + b*x + c*/

public class AbsValueOfExpressionServiceImpl implements ArithmeticDoubleService {

	@Override
	public double calculate(NumberData<Double>numberData) {

		double a;
		double b;
		double c;
		double x;

		a = numberData.getNumberData().get(0);
		b = numberData.getNumberData().get(1);
		c = numberData.getNumberData().get(2);
		x = numberData.getNumberData().get(3);

		return (Math.abs(a * x * x + b * x + c));
	}
}