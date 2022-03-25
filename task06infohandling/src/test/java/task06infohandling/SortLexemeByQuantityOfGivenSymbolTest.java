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
import by.jwd.task06infohandling.service.impl.SortLexemeByQuantityOfGivenSymbolImpl;

public class SortLexemeByQuantityOfGivenSymbolTest {

	@DataProvider(name = "DataForSortingLexemeByQuantityOfGivenSymbol")
	public Object[][] createDataForSorting() {

		return new Object[][] {
				{ "[Mary, was, listening., not, They, thought]", new String[] { "a", "They thought Mary was not listening." } },
				{ "[hunchback?, had, She, What, a, never, one., seen, was]", new String[] { "h", "What was a hunchback? She had never seen one." } } ,
				{ "[none;, Perhaps;, Bye., in, India., there, were]", new String[]{";", "Bye.\r\n Perhaps; there were none; in India."}}};
	}

	@Test(groups = { "infoHandler" }, dataProvider = "DataForSortingLexemeByQuantityOfGivenSymbol")
	public void testSortingLexemeByQuantityOfGivenSymbol(String sortedText, String[] param) {
		TextSorting sortService = new SortLexemeByQuantityOfGivenSymbolImpl(param[0].charAt(0));

		Handler parser = new ParserToParagraph(
				new ParserToSentence(new ParserToLexeme(new ParserToWord(new ParserToSymbol(null)))));

		String actual = sortService.sort(parser.parse(param[1])).toString();
		String expected = sortedText.toString();
		assertEquals(actual, expected);
	}
}