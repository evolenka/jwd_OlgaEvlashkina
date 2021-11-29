package by.jwd.task01basic.service.impl;

import by.jwd.task01basic.entity.NumberData;
import by.jwd.task01basic.service.ArithmeticDoubleService;

public class AverageOfTwoNumberServiceImpl implements ArithmeticDoubleService {

	@Override
	public double calculate(NumberData <Double> numberData) {
		
		return (numberData.getNumberData().get(0) + numberData.getNumberData().get(1)) / 2;
	}
}