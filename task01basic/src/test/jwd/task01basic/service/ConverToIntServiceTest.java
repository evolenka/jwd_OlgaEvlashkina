package test.jwd.task01basic.service;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import by.jwd.task01basic.service.ConvertToIntService;
import by.jwd.task01basic.service.impl.ConvertToIntServiceImpl;

public class ConverToIntServiceTest {

	ConvertToIntService convertToInt = new ConvertToIntServiceImpl();

	@DataProvider(name = "DataForConvertToInt")
	public Object[][] createDataForConvertToInt() {
		return new Object[][] { { '[', 91 }, { '!', 33 }, { 'M', 77 }, { '=', 61 }, { 'k', 107 } ,{ ' ', 32 },{ '~', 126 }};
	}

	@Test(dataProvider = "DataForConvertToInt")
	public void testConvertToInt(char ch, int a) {

		int actual = convertToInt.doAction(ch);
		int expected = a;
		assertEquals(actual, expected);
	}
}