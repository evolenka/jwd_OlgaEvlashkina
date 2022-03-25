package task06infohandling;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.jwd.task06infohandling.service.Handler;
import by.jwd.task06infohandling.service.ParserToSymbol;


public class ParserToSymbolTest {
	
	@DataProvider(name = "DataForParserToSymbol")
	public Object[][] createDataForParserToSymbol() {
		return new Object[][] { {
				"They thought Mary was not listening because she was standing a little apart from them at the window of the private hotel they had gone to.\r\n"
						+ "She was watching the passing buses and cabs and people, but she heard quite well and was made very curious about her uncle and the place he lived in. What sort of a place was it, and what would he be like? What was a hunchback? She had never seen one.\r\n"
						+ "Perhaps there were none in India.",
				"They thought Mary was not listening because she was standing a little apart from them at the window of the private hotel they had gone to.\r\n"
						+ "She was watching the passing buses and cabs and people, but she heard quite well and was made very curious about her uncle and the place he lived in. What sort of a place was it, and what would he be like? What was a hunchback? She had never seen one.\r\n"
						+ "Perhaps there were none in India." },
				{ "Hello word.", "Hello word." } };
	}

	@Test(groups = { "infoHandler" }, dataProvider = "DataForParserToSymbol")
	public void testParserToSymbol(String text, String parsedText) {

		Handler parser = new ParserToSymbol(null);
		String actual = parser.parse(text).toString();
		String expected = parsedText;
		assertEquals(actual, expected);
	}
}