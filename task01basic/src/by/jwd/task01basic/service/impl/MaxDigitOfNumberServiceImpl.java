package by.jwd.task01basic.service.impl;

import by.jwd.task01basic.entity.NumberData;
import by.jwd.task01basic.service.ArithmeticIntegerService;

/*33. Find max digit of the given natural number.*/

public class MaxDigitOfNumberServiceImpl implements ArithmeticIntegerService {

	@Override
	public int calculate(NumberData<Integer> numberData) {
		int a = numberData.getNumberData().get(0);

		int maxDigit = 0;

		while (a > 0) {
			int temp = a % 10;
			if (temp > maxDigit) {
				maxDigit = temp;
			}
			a = a / 10;
		}
		return maxDigit;
	}
}