package test.jwd.task01basic.service;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import by.jwd.task01basic.service.ConvertToCharService;
import by.jwd.task01basic.service.impl.ConvertToCharServiceImpl;

public class ConvertToCharTest {

	ConvertToCharService convertToChar = new ConvertToCharServiceImpl();

	@DataProvider(name = "DataForConvertToChar")
	public Object[][] createDataForConvertToChar() {
		return new Object[][] { 
			{ new char[] { '\\', 'Z' }, 91 },
			{ new char[] { '!', '0' }, 32 },
			{ new char[] { 'd', 'b' }, 99 },
			{ new char[] { 'O', 'M' }, 78 },
			{ new char[] { '~', '|' }, 125 },
			{ new char[] { '0', '}' }, 126 }};

	}

	@Test(groups = {"service"}, dataProvider = "DataForConvertToChar")
	public void testConvertToChar(char[] c, int a) {

		char[] actual = convertToChar.convert(a);
		char[] expected = c;
		assertEquals(actual, expected);
	}
}