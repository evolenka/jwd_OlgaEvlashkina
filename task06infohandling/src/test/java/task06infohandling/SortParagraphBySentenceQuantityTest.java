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
import by.jwd.task06infohandling.service.impl.SortParagraphBySentenceQuantityImpl;

public class SortParagraphBySentenceQuantityTest {

	@DataProvider(name = "DataForSortingParagraphBySentenceQuantity")
	public Object[][] createDataForSorting() {

		return new Object[][] { {
				"They thought Mary was not listening because she was standing a little apart from them at the window of the private hotel they had gone to. Bye.\r\n"
						+ "She was watching the passing buses and cabs and people, but she heard quite well and was made very curious about her uncle and the place he lived in. What sort of a place was it, and what would he be like? What was a hunchback? She had never seen one.\r\n"
						+ "Perhaps there were none in India.",
				"[Perhaps there were none in India., "
						+ "They thought Mary was not listening because she was standing a little apart from them at the window of the private hotel they had gone to. Bye., "
						+ "She was watching the passing buses and cabs and people, but she heard quite well and was made very curious about her uncle and the place he lived in. What sort of a place was it, and what would he be like? What was a hunchback? She had never seen one.]" },
				{"Hello word. Hello.\r\n", "[Hello word. Hello.]"} };
	}

	@Test(groups = { "infoHandler" }, dataProvider = "DataForSortingParagraphBySentenceQuantity")
	public void testSortingParagraphBySentenceQuantity(String text, String sortedText) {
		TextSorting sortService = new SortParagraphBySentenceQuantityImpl();
		Handler parser = new ParserToParagraph(
				new ParserToSentence(new ParserToLexeme(new ParserToWord(new ParserToSymbol(null)))));

		String actual = sortService.sort(parser.parse(text)).toString();
		String expected = sortedText.toString();
		assertEquals(actual, expected);
	}
}