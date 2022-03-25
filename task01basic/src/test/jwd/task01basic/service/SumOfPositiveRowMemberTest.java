package test.jwd.task01basic.service;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import by.jwd.task01basic.entity.NumberData;
import by.jwd.task01basic.service.ArithmeticDoubleService;
import by.jwd.task01basic.service.impl.SumOfPositiveRowMemberServiceImpl;

public class SumOfPositiveRowMemberTest {

	ArithmeticDoubleService arithmetic = new SumOfPositiveRowMemberServiceImpl();

	@DataProvider(name = "SumOfPositive")
	public Object[][] createDataForSumOfPositive() {

		return new Object[][] { { new double[] { 0.5, 2.0 }, 0.8333333333333333 }, { new double[] { 0.0, 0.0 }, 0.0 },
				{ new double[] { 0.9, 1.0 }, 0.0 }, { new double[] { -0.5, 2.0 }, 1.1944444444444444 },
				{ new double[] { 0.25, 2.0 }, 1.1944444444444444 }, { new double[] { -3, 3.0 }, 1.3564814814814814 },
				{ new double[] { 0.7, -3.0 }, 0.0 } };
	}

	@Test(groups = { "service" }, dataProvider = "SumOfPositive")
	public void testSumOfPositive(double[] ab, double c) {

		NumberData<Double> numberdata = new NumberData<>();
		numberdata.addNumberData(ab[0]);
		numberdata.addNumberData(ab[1]);

		double actual = arithmetic.calculate(numberdata);
		double expected = c;
		assertEquals(actual, expected);
	}
}
