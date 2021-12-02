package test.jwd.task01basic.service;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import by.jwd.task01basic.entity.NumberData;
import by.jwd.task01basic.service.ArithmeticDoubleService;
import by.jwd.task01basic.service.impl.AbsValueOfExpressionServiceImpl;

public class AbsValueOfExpressionTest {

	ArithmeticDoubleService arithmetic = new AbsValueOfExpressionServiceImpl();

	@DataProvider(name = "AbsValueOfExpression")
	public Object[][] createDataForAbsValueOfExpression() {

		return new Object[][] { { new double[] { 2.0, 2.0, 2.0, 0.0 }, 2.0 },
				{ new double[] { 2.0, 4.0, 6.0, -5.0 }, 36.0 }, { new double[] { -3.0, 2.0, 0, 1.0 }, 1.0 },
				{ new double[] { 7.0, -4.0, 3.0, 2.0 }, 23.0 }, { new double[] { 4.0, 5.0, -8.0, 2.0 }, 18.0 },
				{ new double[] { 0, 0, 0, 0, }, 0 },
				{ new double[] { Integer.MAX_VALUE, 2, -Integer.MAX_VALUE, 1 }, 2 }, };
	}

	@Test(groups = { "service" }, dataProvider = "AbsValueOfExpression")
	public void testAbsValueOfExpression(double[] ab, double c) {

		NumberData<Double> numberdata = new NumberData<>();
		numberdata.addNumberData(ab[0]);
		numberdata.addNumberData(ab[1]);
		numberdata.addNumberData(ab[2]);
		numberdata.addNumberData(ab[3]);

		double actual = arithmetic.calculate(numberdata);
		double expected = c;
		assertEquals(actual, expected);
	}
}