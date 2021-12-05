package test.jwd.task01basic.service;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import by.jwd.task01basic.entity.NumberData;
import by.jwd.task01basic.service.impl.SumOfOddNumberServiceImpl;

public class SumOfOddNumberTest {

	SumOfOddNumberServiceImpl service = new SumOfOddNumberServiceImpl();
	NumberData<Integer> numberdata = new NumberData<>();

	@Test(description = "Sum of odd numbers from 1 to 99", groups = { "service" })
	public void testSumOfOddNumber() {

		/* numbers from 1 to 99 (including) */
		for (int i = 0; i < 100; i++) {
			numberdata.addNumberData(i);
		}

		int actual = service.calculate(numberdata);
		int expected = 2500;
		assertEquals(actual, expected);
	}
}