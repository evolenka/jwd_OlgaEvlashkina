package test.jwd.task01basic.service;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import by.jwd.task01basic.entity.NumberData;
import by.jwd.task01basic.service.ArithmeticDoubleService;
import by.jwd.task01basic.service.impl.AverageOfTwoNumberServiceImpl;

public class AverageOfTwoNumberTest {

	ArithmeticDoubleService arithmetic = new AverageOfTwoNumberServiceImpl();

	@DataProvider(name = "DataForAverage")
	public Object[][] createDataForCalculationAverage() {
		return new Object[][] { { new double[] { 0.0, 0.0 }, 0.0 }, { new double[] { 1.0, 1.0 }, 1.0 },
				{ new double[] { 4.0, 2.0 }, 3.0 }, { new double[] { 8.0, 4.0 }, 6.0 },
				{ new double[] { -3.0, 3.0 }, 0.0 }, { new double[] { -6.0, 3.0 }, -1.5 },
				{ new double[] { 6.0, -3.0 }, 1.5 }, { new double[] { -6.0, -3.0 }, -4.5 },
				{ new double[] { Integer.MAX_VALUE, Integer.MAX_VALUE }, Integer.MAX_VALUE },
				{ new double[] { -Integer.MAX_VALUE, Integer.MAX_VALUE }, 0 },
				{ new double[] { -Integer.MAX_VALUE, -Integer.MAX_VALUE }, -Integer.MAX_VALUE } };
	}

	@Test(groups = { "service" }, dataProvider = "DataForAverage")
	public void testCalculationAverage(double[] ab, double c) {

		NumberData<Double> numberdata = new NumberData<>();
		numberdata.addNumberData(ab[0]);
		numberdata.addNumberData(ab[1]);

		double actual = arithmetic.calculate(numberdata);
		double expected = c;
		assertEquals(actual, expected);
	}
}