package by.jwd.task01basic.service.impl;

import by.jwd.task01basic.entity.NumberData;
import by.jwd.task01basic.service.FunctionValueService;

/*Find the value of function  y on the segment [a, b] with the step h:
y = x, if x > 2 and y = -x, if x <= 2*/

public class FunctionValueServiceImpl implements FunctionValueService {

	@Override
	public NumberData<Double> findFunctionValue(NumberData<Double> numberData) {

		NumberData<Double> result = new NumberData<>();

		double a;
		double b;
		double h;
		double x;

		a = numberData.getNumberData().get(0);
		b = numberData.getNumberData().get(1);
		h = numberData.getNumberData().get(2);
		x = a;

		for (double i = a; i <= b; i += h) {
			if (x > 2 || x == 0) {
				result.addNumberData(x);
			} else {
				result.addNumberData(-x);
			}
			x += h;
		}
		return result;
	}
}