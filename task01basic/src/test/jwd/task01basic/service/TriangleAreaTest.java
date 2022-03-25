package test.jwd.task01basic.service;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import by.jwd.task01basic.entity.Triangle;
import by.jwd.task01basic.service.ServiceException;
import by.jwd.task01basic.service.TriangleService;
import by.jwd.task01basic.service.impl.TriangleAreaServiceImpl;

public class TriangleAreaTest {

	TriangleService triangleService = new TriangleAreaServiceImpl();
	Triangle triangle = new Triangle();

	@DataProvider(name = "DataForAreaPos")
	public Object[][] createDataForAreaCalculationPos() {
		return new Object[][] { { 10.0, 43.30127018922193 }, { 1.0, 0.4330127018922193 }, { 2.0, 1.7320508075688772 },
				{ Integer.MAX_VALUE, 1996918621258038800.0 } };
	}

	@DataProvider(name = "DataForAreaNeg")
	public Object[][] createDataForAreaCalculationNeg() {
		return new Object[][] { { 0.0, 0 }, { -5, 0.0 }, { -Integer.MAX_VALUE, 0.0 } };
	}

	@Test(description = "Positive scenario", groups = { "service" }, dataProvider = "DataForAreaPos")
	public void testAreaCalculationPos(double a, double c) throws ServiceException {

		triangle.setSide1(a);
		double actual = triangleService.doCalculation(triangle);
		double expected = c;
		assertEquals(actual, expected);
	}

	@Test(description = "Negative scenario", groups = {
			"service" }, dataProvider = "DataForAreaNeg", expectedExceptions = ServiceException.class)
	public void testAreaCalculationNeg(double a, double c) throws ServiceException {

		triangle.setSide1(a);
		double actual = triangleService.doCalculation(triangle);
		double expected = c;
		assertEquals(actual, expected);
	}
}