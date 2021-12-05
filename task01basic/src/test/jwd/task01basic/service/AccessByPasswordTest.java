package test.jwd.task01basic.service;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import by.jwd.task01basic.service.PasswordService;
import by.jwd.task01basic.service.impl.AccessByPasswordServiceImpl;

public class AccessByPasswordTest {

	PasswordService service = new AccessByPasswordServiceImpl();

	@DataProvider(name = "AccessByPassword")
	public Object[][] createDataForAccessByPassword() {
		return new String[][] { { "9583", "Your acess level: bases A,B,C" },
				{ "1748", "Your acess level: bases A,B,C" }, { "3331", "Your acess level: bases B,C" },
				{ "7922", "Your acess level: bases B,C" }, { "9455", "Your acess level: base C" },
				{ "8997", "Your acess level: base C" }, { "45845455", "Invalid password" } };
	}

	@Test(groups = { "service" }, dataProvider = "AccessByPassword")
	public void testAccessByPassword(String password, String result) {

		String actual = service.getInfo(password);
		String expected = result;
		assertEquals(actual, expected);
	}
}