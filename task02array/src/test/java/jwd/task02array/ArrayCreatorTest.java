package jwd.task02array;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.jwd.task02array.entity.Array;
import by.jwd.task02array.service.ArrayCreator;
import by.jwd.task02array.service.ServiceException;

public class ArrayCreatorTest {

	ArrayCreator service = new ArrayCreator();

	@DataProvider(name = "DataForArrayCreating")
	public Object[][] createDataForArrayCreating() {
		return new Object[][] { { "dataTest1.txt", new Double[] { 1.0 } },
				{ "dataTest2.txt", new Double[] { 0.0, 0.0, 0.0, 0.0, 0.0 } },
				{ "dataTest3.txt", new Double[] { 10.0, -8.0, 0.0, 10.0, 7.0 } }, { "dataTest4.txt", new Double[] { 1.0, 2.0 } } };
	}

	@Test(groups = { "service" }, dataProvider = "DataForArrayCreating")
	public void testDataForArrayCreating(String a, Double[] b) throws ServiceException {
		String fileName = a;
		Array<Double> array = new Array<>(b);

		Array<Double> actual = service.createArrayFromFile(fileName);
		Array<Double> expected = array;
		assertEquals(actual, expected);
	}
}