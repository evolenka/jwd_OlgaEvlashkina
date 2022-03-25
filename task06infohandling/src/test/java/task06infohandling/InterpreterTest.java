package task06infohandling;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import by.jwd.task06infohandling.service.Interpreter;

public class InterpreterTest {
	@DataProvider(name = "DataForInterpreter")
	public Object[][] createDataForSorting() {

		return new Object[][] { { "3&5", 1 }, { "2>>4", 0 }, { "2<<4", 32 }, { "3|4", 7 }, { "~5", -6 },
				{ "5|(1&2&(3|(4&(25^5|6&47)|3)|2)|1)", 5 }, { "8^5", 13 }, { "13<<2", 52 }, { "30>>>3", 3 },
				{ "~6&9|(3&4)", 9 }, { "(~71&(2&3|(3|(2&1>>2|2)&2)|10&2))|78", 78 },
				{ "(8^5|1&2<<(2|5>>2&71))|1200", 1213 } };
	}

	@Test(groups = { "infoHandler" }, dataProvider = "DataForInterpreter")
	public void testInterpreter(String expression, int result) {

		Interpreter interpreter = new Interpreter(expression);

		int actual = interpreter.calculate();
		int expected = result;
		assertEquals(actual, expected);
	}
}