package test.jwd.task01basic.service;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import by.jwd.task01basic.entity.NumberData;
import by.jwd.task01basic.service.ArithmeticIntegerService;
import by.jwd.task01basic.service.ServiceException;
import by.jwd.task01basic.service.impl.MaxDigitOfNumberServiceImpl;

public class MaxDigitOfNumberTest {

	ArithmeticIntegerService arithmetic = new MaxDigitOfNumberServiceImpl();

	@DataProvider(name = "MaxDigitOfNumberPos")
	public Object[][] createPositiveDataForMaxDigitOfNumber() {

		return new Object[][] { { 1589, 9 }, { 8426, 8 }, { 1151, 5 }, { 5555, 5 } };
	}

	@DataProvider(name = "MaxDigitOfNumberNeg")
	public Object[][] createNegativeDataForMaxDigitOfNumber() {

		return new Object[][] { { -8, 0 }, { 0, 0 }, { -98567, 0 } };
	}

	@Test(description = "Positive_scenario", groups = { "service" }, dataProvider = "MaxDigitOfNumberPos")
	public void testMaxDigitOfNumberPos(int a, int c) throws ServiceException {

		NumberData<Integer> numberdata = new NumberData<>();
		numberdata.addNumberData(a);

		double actual = arithmetic.calculate(numberdata);
		double expected = c;
		assertEquals(actual, expected);
	}

	@Test(description = "Negative_scenario", groups = {
			"service" }, dataProvider = "MaxDigitOfNumberNeg", expectedExceptions = ServiceException.class)
	public void testMaxDigitOfNumberNeg(int a, int c) throws ServiceException {

		NumberData<Integer> numberdata = new NumberData<>();
		numberdata.addNumberData(a);

		double actual = arithmetic.calculate(numberdata);
		double expected = c;
		assertEquals(actual, expected);
	}
}