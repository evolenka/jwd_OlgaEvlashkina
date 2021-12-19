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
		return new Object[][] { { "dataTest1.txt", new Integer[] { 1 } },
				{ "dataTest2.txt", new Integer[] { 0, 0, 0, 0, 0 } },
				{ "dataTest3.txt", new Integer[] { 10, -8, 0, 10, 7 } }, { "dataTest4.txt", new Integer[] { 1, 2 } } };
	}

	@Test(groups = { "service" }, dataProvider = "DataForArrayCreating")
	public void testDataForArrayCreating(String a, Integer[] b) throws ServiceException {
		String fileName = a;
		Array<Integer> array = new Array<>(b);

		Array<Integer> actual = service.createArrayFromFile(fileName);
		Array<Integer> expected = array;
		assertEquals(actual, expected);
	}
}