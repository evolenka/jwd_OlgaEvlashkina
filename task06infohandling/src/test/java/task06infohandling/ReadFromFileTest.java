package task06infohandling;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.jwd.task06infohandling.dao.DaoException;
import by.jwd.task06infohandling.dao.ReadFromFile;

public class ReadFromFileTest {

	@DataProvider(name = "FileName")
	public Object[][] createDataReadingFromFile() {
		return new Object[][] { { "data1.txt",
				"They thought Mary was not listening because she was standing a little apart from them at the window of the private hotel they had gone to. She was watching the passing buses and cabs and people, but she heard quite well and was made very curious about her uncle and the place he lived in. What sort of a place was it, and what would he be like? What was a hunchback? She had never seen one. Perhaps there were none in India." },
				{ "data2.txt", "Mr. Craven had said in his short, cold way" }, { "data3.txt", "M" } };

	}

	@Test(groups = { "infoHandler" }, dataProvider = "FileName")
	public void testReadFromFile(String fileName, String result) throws DaoException {

		ReadFromFile reader = new ReadFromFile();

		String actual = reader.read(fileName);
		String expected = result;
		assertEquals(actual, expected);
	}
}
