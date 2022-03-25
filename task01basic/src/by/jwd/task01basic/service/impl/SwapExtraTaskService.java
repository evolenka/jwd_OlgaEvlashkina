package by.jwd.task01basic.service.impl;

import by.jwd.task01basic.entity.NumberData;

/* Extra task: swap two numbers in 3 different ways*/

public class SwapExtraTaskService {

	/**
	 * Swap values of two numbers through temp variable
	 * 
	 * @author evlashkina
	 * @version 1
	 * @param numberdata (two numbers)
	 * @return two numbers after swap
	 */

	public NumberData<Integer> swapFirstMethod(NumberData<Integer> numberdata) {

		int a;
		int b;
		int temp;

		NumberData<Integer> swapedData;

		a = numberdata.getNumberData().get(0);
		b = numberdata.getNumberData().get(1);

		temp = a;
		a = b;
		b = temp;

		swapedData = new NumberData<>();

		swapedData.addNumberData(a);
		swapedData.addNumberData(b);

		return swapedData;
	}

	/**
	 * Swap values of two int numbers by the arithmetic operations
	 * 
	 * @author evlashkina
	 * @version 1
	 * @param numberdata (two numbers)
	 * @return two numbers after swap
	 */

	public NumberData<Integer> swapSecondMethod(NumberData<Integer> numberdata) {

		int a;
		int b;
		NumberData<Integer> swapedData;

		a = numberdata.getNumberData().get(0);
		b = numberdata.getNumberData().get(1);

		a = a + b;
		b = a - b;
		a = a - b;

		swapedData = new NumberData<>();

		swapedData.addNumberData(a);
		swapedData.addNumberData(b);

		return swapedData;
	}

	/**
	 * Swap values of two int numbers by operator ^
	 * 
	 * @author evlashkina
	 * @version 1
	 * @param numberdata (two numbers)
	 * @return two numbers after swap
	 */

	public NumberData<Integer> swapThirdMethod(NumberData<Integer> numberdata) {

		int a;
		int b;
		NumberData<Integer> swapedData;

		a = numberdata.getNumberData().get(0);
		b = numberdata.getNumberData().get(1);

		a = a ^ b;
		b = b ^ a;
		a = a ^ b;

		swapedData = new NumberData<>();

		swapedData.addNumberData(a);
		swapedData.addNumberData(b);

		return swapedData;
	}
}