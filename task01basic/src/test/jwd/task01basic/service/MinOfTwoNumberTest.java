package test.jwd.task01basic.service;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.jwd.task01basic.entity.NumberData;
import by.jwd.task01basic.service.ArithmeticDoubleService;
import by.jwd.task01basic.service.impl.MinOfTwoNumberServiceImpl;

public class MinOfTwoNumberTest {

	ArithmeticDoubleService arithmetic = new MinOfTwoNumberServiceImpl();

	@DataProvider(name = "MinOfTwo")
	public Object[][] createDataForMinOfTwo() {

		return new Object[][] { { new double[] { 0.0, 0.0 }, 0 }, { new double[] { 1, -1 }, -1 },
				{ new double[] { -5, 9 }, -5 }, { new double[] { 9, -6 }, -6 },
				{ new double[] { -Integer.MAX_VALUE, 0 }, -Integer.MAX_VALUE },
				{ new double[] { Integer.MAX_VALUE, -Integer.MAX_VALUE }, -Integer.MAX_VALUE } };
	}

	@Test(groups = { "service" }, dataProvider = "MinOfTwo")
	public void testMinOfTwo(double[] ab, double c) {

		NumberData<Double> numberdata = new NumberData<>();
		numberdata.addNumberData(ab[0]);
		numberdata.addNumberData(ab[1]);

		double actual = arithmetic.calculate(numberdata);
		double expected = c;
		assertEquals(actual, expected);
	}
}