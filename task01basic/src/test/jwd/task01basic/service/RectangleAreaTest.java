package test.jwd.task01basic.service;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import by.jwd.task01basic.entity.Rectangle;
import by.jwd.task01basic.service.RectangleService;
import by.jwd.task01basic.service.impl.RectangleAreaServiceImpl;
import by.jwd.task01basic.service.impl.ServiceException;

public class RectangleAreaTest {

	RectangleService rectangleService = new RectangleAreaServiceImpl();
	Rectangle rectangle = new Rectangle();

	
	@DataProvider(name = "DataForArea")
	public Object[][] createDataForAreaCalculation() {
		return new Object[][] { { new double[] { 1.0, 0.5 }, 0.5 }, { new double[] { 2.0, 1.0 }, 2.0 },
				{ new double[] { 100.0, 50.0 }, 5000.0 }, { new double[] { Double.MAX_VALUE, 1 }, Double.MAX_VALUE },
				{ new double[] { 1, Double.MAX_VALUE }, Double.MAX_VALUE } };
	}

	@Test(groups = { "service" }, dataProvider = "DataForArea")
	public void testAreaCalculation(double [] ab, double c) throws ServiceException {

		rectangle.setLength(ab[0]);
		rectangle.setWidth(ab[1]);

		double actual = rectangleService.doCalculation(rectangle);
		double expected = c;
		assertEquals(actual, expected);
	}
}