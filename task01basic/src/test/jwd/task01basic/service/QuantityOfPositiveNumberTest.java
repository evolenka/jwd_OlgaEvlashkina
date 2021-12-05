package test.jwd.task01basic.service;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import by.jwd.task01basic.entity.NumberData;
import by.jwd.task01basic.service.impl.QuantityOfPositiveNumberServiceImpl;

public class QuantityOfPositiveNumberTest {

	QuantityOfPositiveNumberServiceImpl service = new QuantityOfPositiveNumberServiceImpl();

	@DataProvider(name = "DataForQuantityOfPositiveNumber")
	public Object[][] createDataForQuantityOfPositiveNumber() {
		return new Object[][] { { new int[] { 0, 0, 0 }, 0 }, { new int[] { 1, 1, 1 }, 3 },
				{ new int[] { -5, 2, 3 }, 2 }, { new int[] { 2, -9, 5 }, 2 }, { new int[] { 7, 1, -8 }, 2 },
				{ new int[] { -80, -158, 3 }, 1 }, { new int[] { -98752, 9, -89755 }, 1 },
				{ new int[] { 7, -761, -8 }, 1 }, { new int[] { -3, -189, -783 }, 0 },
				{ new int[] { Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE }, 3 },
				{ new int[] { -Integer.MAX_VALUE, 1, -Integer.MAX_VALUE }, 1 } };
	}

	@Test(groups = { "service" }, dataProvider = "DataForQuantityOfPositiveNumber")
	public void testDataForQuantityOfPositiveNumber(int[] ab, int c) {

		NumberData<Integer> numberdata = new NumberData<>();
		numberdata.addNumberData(ab[0]);
		numberdata.addNumberData(ab[1]);
		numberdata.addNumberData(ab[2]);

		int actual = service.calculate(numberdata);
		int expected = c;
		assertEquals(actual, expected);
	}
}