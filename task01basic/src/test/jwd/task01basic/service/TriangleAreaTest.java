package test.jwd.task01basic.service;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import by.jwd.task01basic.entity.Triangle;
import by.jwd.task01basic.service.TriangleService;
import by.jwd.task01basic.service.impl.TriangleAreaServiceImpl;


public class TriangleAreaTest {

	TriangleService triangleService = new TriangleAreaServiceImpl();
	Triangle triangle = new Triangle();
	
	/*
	 * data should be > 0, see validation in
	 * by.jwd.task01basic.controller.impl.GeometricControllerImpl
	 */
	
	@DataProvider(name = "DataForArea")
	public Object[][] createDataForAreaCalculation() {
		return new Object[][] {
			{ 10.0, 43.30127018922193 },
			{ 1.0, 0.4330127018922193 },
			{ 2.0, 1.7320508075688772 },
			{ Integer.MAX_VALUE, 1996918621258038800.0} };
	}

	@Test(groups = {"service"}, dataProvider = "DataForArea")
	public void testAreaCalculation(double a, double c) {
		
		triangle.setSide1(a);
		double actual = triangleService.doCalculation(triangle);
		double expected = c;
		assertEquals(actual, expected);
	}
}