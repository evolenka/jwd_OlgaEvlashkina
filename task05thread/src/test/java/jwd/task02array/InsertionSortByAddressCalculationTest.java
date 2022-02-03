package jwd.task02array;

import by.jwd.task05thread.entity.Array;
import by.jwd.task05thread.service.ArraySortingService;
import by.jwd.task05thread.service.ServiceException;
import by.jwd.task05thread.service.impl.InsertionSortByAddressCalculationImpl;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class InsertionSortByAddressCalculationTest {

	ArraySortingService service = new InsertionSortByAddressCalculationImpl();

	@DataProvider(name = "DataForArraySorting")
	public Object[][] createDataForArraySorting() {
		return new Object[][] { new Integer[][] { { 1 }, { 1 } }, new Integer[][] { { 0 }, { 0 } },
				new Integer[][] { { 3, 5 }, { 3, 5 } }, new Integer[][] { { 5, 5 }, { 5, 5 } },
				new Integer[][] { { 5, 4 }, { 4, 5 } },
				new Integer[][] { { 5, 6, 7, 8, 9, 10, 11, 12 }, { 5, 6, 7, 8, 9, 10, 11, 12 } },
				new Integer[][] { { -8, 0, -7, -9, -58, -6 }, { -58, -9, -8, -7, -6, 0 } },
				new Integer[][] { { 20, 19, 18, 17, 16, 15, 14, 13, 12, 11 },
						{ 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 } },
				new Integer[][] { { 8, 98, 651, -14, 33, 2, 33, 7, 4 }, { -14, 2, 4, 7, 8, 33, 33, 98, 651 } } };
	}

	@Test(groups = { "service" }, dataProvider = "DataForArraySorting")
	public void testDataForArraySorting(Integer[] a, Integer[] c) throws ServiceException {

		Array<Integer> array = new Array<>(a);
		Array<Integer> sortedArray = new Array<>(c);

		Array<Integer> actual = service.sortArray(array);
		Array<Integer> expected = sortedArray;
		assertEquals(actual, expected);
	}
}
