package by.jwd.task01basic.service.impl;

import by.jwd.task01basic.entity.NumberData;
import by.jwd.task01basic.service.ArithmeticDoubleService;

/*5. Find min of two numbers a and b*/

public class MinOfTwoNumberServiceImpl implements ArithmeticDoubleService {

	@Override
	public double calculate(NumberData<Double> numberData) {

		if (numberData.getNumberData().get(0) < numberData.getNumberData().get(1)) {
			return numberData.getNumberData().get(0);
		} else
			return numberData.getNumberData().get(1);
	}
}