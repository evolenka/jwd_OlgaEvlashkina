package test.jwd.task01basic.service;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import by.jwd.task01basic.entity.Triangle;
import by.jwd.task01basic.service.ServiceException;
import by.jwd.task01basic.service.TriangleService;
import by.jwd.task01basic.service.impl.TriangleRadiusOutServiceImpl;

public class TriangleRadiusOutTest {

	TriangleService triangleService = new TriangleRadiusOutServiceImpl();
	Triangle triangle = new Triangle();

	@DataProvider(name = "DataForRadiusOut")
	public Object[][] createDataForRadiusOutCalculation() {
		return new Object[][] { { 5.0, 2.886751 }, { 1.0, 0.57735 }, { 2.0, 1.154701 }, { 100, 57.735027 },
				{ Integer.MAX_VALUE, 1239850261.675769 } };
	}

	@Test(groups = { "service" }, dataProvider = "DataForRadiusOut")
	public void testRadiusOutCalculation(double a, double c) throws ServiceException {

		triangle.setSide1(a);
		double actual = triangleService.doCalculation(triangle);
		double expected = c;
		assertEquals(actual, expected, 0.000001);
	}
}