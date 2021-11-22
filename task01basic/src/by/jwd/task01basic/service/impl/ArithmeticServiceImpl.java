package by.jwd.task01basic.service.impl;

import by.jwd.task01basic.entity.NumberData;
import by.jwd.task01basic.service.ArithmeticService;

public class ArithmeticServiceImpl implements ArithmeticService {

	@Override
	public double calculate(NumberData numberData) {

		return (numberData.getNumberData().get(0) + numberData.getNumberData().get(1)) / 2;
	}
}