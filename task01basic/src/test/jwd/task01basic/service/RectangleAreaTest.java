package test.jwd.task01basic.service;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import by.jwd.task01basic.entity.Rectangle;
import by.jwd.task01basic.service.RectangleService;
import by.jwd.task01basic.service.impl.RectangleAreaImpl;

public class RectangleAreaTest {

	RectangleService rectangleService;
	Rectangle rectangle;

	@BeforeClass
	public void setUp() {
		rectangleService = new RectangleAreaImpl();
		rectangle = new Rectangle();
	}

	/*
	 * data should be > 0, see validation in
	 * by.jwd.task01basic.controller.impl.GeometricControllerImpl
	 */

	@DataProvider(name = "DataForArea")
	public Object[][] createDataForAreaCalculation() {
		return new Object[][] {
			{new double[] { 1.0, 0.5 }, 0.5 },
			{new double[] { 2.0, 1.0 }, 2.0 },
			{new double[] { 100.0, 50.0 }, 5000.0},
			{new double[] {Integer.MAX_VALUE, 1.0}, Integer.MAX_VALUE},
			{new double[] {1.0, Integer.MAX_VALUE}, Integer.MAX_VALUE}};
	}

	@Test(dataProvider = "DataForArea")
	public void testAreaCalculation(double[] ab, double c) {
		rectangle.setLength(ab[0]);
		rectangle.setWidth(ab[1]);
		double actual = rectangleService.doCalculation(rectangle);
		double expected = c;
		assertEquals(actual, expected);
	}

	@AfterClass
	public void tierDown() {
		rectangleService = null;
		rectangle = null;
	}
}