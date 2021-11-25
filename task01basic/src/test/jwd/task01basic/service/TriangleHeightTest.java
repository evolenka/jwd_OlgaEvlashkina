package test.jwd.task01basic.service;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import by.jwd.task01basic.entity.Triangle;
import by.jwd.task01basic.service.TriangleService;
import by.jwd.task01basic.service.impl.TriangleHeightImpl;

public class TriangleHeightTest {
	
	TriangleService triangleService;
	Triangle triangle;

	@BeforeClass
	public void setUp() {
		triangleService = new TriangleHeightImpl();
		triangle = new Triangle();
	}

	/*
	 * data should be > 0, see validation in
	 * by.jwd.task01basic.controller.impl.GeometricControllerImpl
	 */

	@DataProvider(name = "DataForHeight")
	public Object[][] createDataForHeightCalculation() {
		return new Object[][] { 
			{ 5.0, 4.33 },
			{ 1.0, 0.866 },
			{ 2.0, 1.732 },
			{ 100, 86.603 }, 
			{ Integer.MAX_VALUE, 1.8597753925136538E9} };
	}

	@Test(dataProvider = "DataForHeight")
	public void testHeightCalculation(double a, double c) {
		
		triangle.setSide1(a);
		double actual = triangleService.doCalculation(triangle);
		double expected = c;
		assertEquals(actual, expected, 0.001);
	}

	@AfterClass
	public void tierDown() {
		triangleService = null;
		triangle = null;
	}
}