package by.jwd.task01basic.service.impl;

import by.jwd.task01basic.entity.NumberData;
import by.jwd.task01basic.service.ArithmeticIntegerService;

/*19. Count quantity of positive numbers among a,b,c.*/

public class QuantityOfPositiveNumberServiceImpl implements ArithmeticIntegerService {

	@Override
	public int calculate(NumberData<Integer> numberData) {

		int a;
		int b;
		int c;
		int result = 0;

		a = numberData.getNumberData().get(0);
		b = numberData.getNumberData().get(1);
		c = numberData.getNumberData().get(2);

		if (a > 0) {
			result++;
		}
		if (b > 0) {
			result++;
		}
		if (c > 0) {
			result++;
		}

		return result;
	}
}