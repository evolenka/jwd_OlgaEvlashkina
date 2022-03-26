package by.jwd.task07xmlparser;

import static org.testng.Assert.assertEquals;

import java.util.Set;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.jwd.task07xmlparser.entity.Visit;
import by.jwd.task07xmlparser.service.BaseBuilder;
import by.jwd.task07xmlparser.service.BuildFactory;

public class StaxParserTest {
	@DataProvider(name = "staxParser")
	public Object[][] createDataStaxParsing() {

		TestStaxProvider provider = new TestStaxProvider();
		Set<Visit> visits = provider.buildVisits();
		
		
		return new Object[][] { { new String[] { "testResourses/visitsTest.xml", "testResourses/visits.xsd" }, visits }

		};
	}

	@Test(groups = { "service" }, dataProvider = "staxParser")
	public void testStaxParser(String[] param, Set<Visit> result) {

		BaseBuilder builder = BuildFactory.createParser("stax");

		builder.buildSetVisits(param[0], param[1]);
		String expected = builder.getVisits().toString();
		String actual = result.toString();
		assertEquals(actual, expected);
	}
}