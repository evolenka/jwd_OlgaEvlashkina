package by.jwd.task01basic.service.impl;

import by.jwd.task01basic.entity.NumberData;
import by.jwd.task01basic.service.ArithmeticIntegerService;

/*5 loops task: Calculate the sum of all odd numbers from 1 to 99 (including) using while.*/

public class SumOfOddNumberServiceImpl implements ArithmeticIntegerService {

	/**
	 * Calculate the sum of all odd numbers from 1 to 99 (including) using operator
	 * while.
	 * 
	 * @author evlashkina
	 * @version 1
	 * @return int result of calculation
	 */

	@Override
	public int calculate(NumberData<Integer> numberdata) {

		int i = numberdata.getNumberData().get(0);
		int sum = 0;

		while (i < numberdata.getNumberData().size()) {
			if (i % 2 != 0) {
				sum = sum + i;
			}
			i++;
		}
		return sum;
	}
}