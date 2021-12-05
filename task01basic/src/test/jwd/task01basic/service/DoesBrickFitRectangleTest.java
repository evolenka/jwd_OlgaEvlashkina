package test.jwd.task01basic.service;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.jwd.task01basic.entity.NumberData;
import by.jwd.task01basic.entity.Rectangle;
import by.jwd.task01basic.service.RectangleLogicService;
import by.jwd.task01basic.service.ServiceException;
import by.jwd.task01basic.service.impl.DoesBrickFitRectangleServiceImpl;

public class DoesBrickFitRectangleTest {

	RectangleLogicService arithmetic = new DoesBrickFitRectangleServiceImpl();

	@DataProvider(name = "BrickAndRectanglePositive")
	public Object[][] createPositiveDataForBrickAndRectangle() {

		return new Object[][] { { new double[] { 1.0, 1.0, 1.0, 1.0, 1.0 }, false },
				{ new double[] { 3.0, 6.0, 3.0, 2.0, 4.0 }, true }, { new double[] { 3.0, 5.0, 4.0, 4.0, 4.0 }, false },
				{ new double[] { 0.5, 2, Integer.MAX_VALUE, 1, 1 }, false },
				{ new double[] { Integer.MAX_VALUE, 1, 5, 2, 8 }, true } };
	}

	@DataProvider(name = "BrickAndRectangleNegative")
	public Object[][] createNegativeDataForBrickAndRectangle() {

		return new Object[][] { { new double[] { 0.0, 1.0, 1.0, 1.0, 1.0 }, false },
				{ new double[] { 3.0, -6.0, 3.0, 2.0, 4.0 }, false }, { new double[] { -3.0, 5.0, 4.0, 4.0, 4.0 }, false},
				{ new double[] { 0.5, 2, -9, 1, 1 }, false, }, { new double[] { 2, 1, 5, -2, 8 }, false },
				{ new double[] { 3, 2, 9, 6, -9 }, false } };
	}

	@Test(description = "Positive_scenario", groups = { "service" }, dataProvider = "BrickAndRectanglePositive")

	public void testPosBrickAndRectangle(double[] ab, boolean c) throws ServiceException {

		Rectangle rectangle = new Rectangle();
		rectangle.setLength(ab[0]);
		rectangle.setWidth(ab[1]);

		NumberData<Double> numberdata = new NumberData<>();
		numberdata.addNumberData(ab[2]);
		numberdata.addNumberData(ab[3]);
		numberdata.addNumberData(ab[4]);

		boolean actual = arithmetic.doLogic(rectangle, numberdata);
		boolean expected = c;
		assertEquals(actual, expected);
	}

	@Test(description = "Negative_scenario", groups = {
			"service" }, dataProvider = "BrickAndRectangleNegative", expectedExceptions = ServiceException.class)

	public void testNegBrickAndRectangle(double[] ab, boolean c) throws ServiceException {

		Rectangle rectangle = new Rectangle();
		rectangle.setLength(ab[0]);
		rectangle.setWidth(ab[1]);

		NumberData<Double> numberdata = new NumberData<>();
		numberdata.addNumberData(ab[2]);
		numberdata.addNumberData(ab[3]);
		numberdata.addNumberData(ab[4]);

		boolean actual = arithmetic.doLogic(rectangle, numberdata);
		boolean expected = c;
		assertEquals(actual, expected);
	}
}