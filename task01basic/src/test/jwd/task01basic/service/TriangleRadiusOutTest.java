package test.jwd.task01basic.service;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import by.jwd.task01basic.entity.Triangle;
import by.jwd.task01basic.service.TriangleService;
import by.jwd.task01basic.service.impl.TriangleRadiusOutImpl;

public class TriangleRadiusOutTest {

	TriangleService triangleService;
	Triangle triangle;

	@BeforeClass
	public void setUp() {
		triangleService = new TriangleRadiusOutImpl();
		triangle = new Triangle();
	}

	/*
	 * data should be > 0, see validation in
	 * by.jwd.task01basic.controller.impl.GeometricControllerImpl
	 */

	@DataProvider(name = "DataForRadiusOut")
	public Object[][] createDataForRadiusOutCalculation() {
		return new Object[][] { 
			{ 5.0, 2.886751 },
			{ 1.0, 0.57735 },
			{ 2.0, 1.154701 },
			{ 100, 57.735027 },
			{ Integer.MAX_VALUE, 1239850261.675769 }};
	}

	@Test(dataProvider = "DataForRadiusOut")
	public void testRadiusInCalculation(double a, double c) {
		triangle.setSide1(a);
		double actual = triangleService.doCalculation(triangle);
		double expected = c;
		assertEquals(actual, expected, 0.000001);
	}

	@AfterClass
	public void tierDown() {
		triangleService = null;
		triangle = null;
	}
}