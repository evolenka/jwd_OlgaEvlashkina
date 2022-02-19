package task06infohandling;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.jwd.task06infohandling.service.Handler;
import by.jwd.task06infohandling.service.ParserToLexeme;
import by.jwd.task06infohandling.service.ParserToParagraph;
import by.jwd.task06infohandling.service.ParserToSentence;
import by.jwd.task06infohandling.service.ParserToSymbol;
import by.jwd.task06infohandling.service.ParserToWord;
import by.jwd.task06infohandling.service.TextSorting;
import by.jwd.task06infohandling.service.impl.SortWordsByLengthImpl;

public class SortWordByLengthTest {

	@DataProvider(name = "DataForSortingortWordByLength")
	public Object[][] createDataForSorting() {

		return new Object[][] { {
				"They thought Mary was not listening because she was standing a little apart from them at the window of the private hotel they had gone to.",
				"[a at of to was not she was the the had They Mary from them they gone apart hotel little window thought because private standing listening]" } };
	}

	@Test(groups = { "infoHandler" }, dataProvider = "DataForSortingortWordByLength")
	public void testSortingWordByLength(String text, String sortedText) {
		TextSorting sortService = new SortWordsByLengthImpl();

		Handler parser = new ParserToParagraph(
				new ParserToSentence(new ParserToLexeme(new ParserToWord(new ParserToSymbol(null)))));

		String actual = sortService.sort(parser.parse(text)).toString();
		String expected = sortedText.toString();
		assertEquals(actual, expected);
	}
}