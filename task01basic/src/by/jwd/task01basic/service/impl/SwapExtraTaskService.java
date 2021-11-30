package by.jwd.task01basic.service.impl;

import by.jwd.task01basic.entity.NumberData;

public class SwapExtraTaskService {

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

		swapedData = new NumberData<Integer>();

		swapedData.addNumberData(a);
		swapedData.addNumberData(b);

		return swapedData;
	}

	public NumberData<Integer> swapSecondMethod(NumberData<Integer> numberdata) {

		int a;
		int b;
		NumberData<Integer> swapedData;

		a = numberdata.getNumberData().get(0);
		b = numberdata.getNumberData().get(1);

		a = a + b;
		b = a - b;
		a = a - b;

		swapedData = new NumberData<Integer>();

		swapedData.addNumberData(a);
		swapedData.addNumberData(b);

		return swapedData;
	}

	public NumberData<Integer> swapThirdMethod(NumberData<Integer> numberdata) {

		int a;
		int b;
		NumberData<Integer> swapedData;

		a = numberdata.getNumberData().get(0);
		b = numberdata.getNumberData().get(1);

		a = a ^ b;
		b = b ^ a;
		a = a ^ b;

		swapedData = new NumberData<Integer>();

		swapedData.addNumberData(a);
		swapedData.addNumberData(b);

		return swapedData;
	}
}