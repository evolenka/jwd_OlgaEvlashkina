package test.jwd.task01basic.service;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import by.jwd.task01basic.entity.Triangle;
import by.jwd.task01basic.service.TriangleService;
import by.jwd.task01basic.service.impl.TriangleRadiusInServiceImpl;

public class TriangleRadiusInTest {

	TriangleService triangleService = new TriangleRadiusInServiceImpl();
	Triangle triangle = new Triangle();

	/*
	 * data should be > 0, see validation in
	 * by.jwd.task01basic.controller.impl.GeometricControllerImpl
	 */

	@DataProvider(name = "DataForRadiusIn")
	public Object[][] createDataForRadiusInCalculation() {
		return new Object[][] { { 5.0, 1.443376 }, { 1.0, 0.288675 }, { 2.0, 0.57735 }, { 100, 28.867513 },
				{ Integer.MAX_VALUE, 619925130.837885 } };
	}

	@Test(groups = { "service" }, dataProvider = "DataForRadiusIn")
	public void testRadiusInCalculation(double a, double c) {

		triangle.setSide1(a);
		double actual = triangleService.doCalculation(triangle);
		double expected = c;
		assertEquals(actual, expected, 0.000001);
	}
}