package test.jwd.task01basic.service;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import by.jwd.task01basic.entity.NumberData;
import by.jwd.task01basic.service.impl.SwapExtraTaskService;

public class SwapExtraTaskTest {

	SwapExtraTaskService service = new SwapExtraTaskService();

	NumberData<Integer> numberdata = new NumberData<>();
	NumberData<Integer> result = new NumberData<>();

	@Test(description = "SwapExtraTaskTest1", groups = { "service" })
	public void testSwapExtraTask1() {

		numberdata = new NumberData<>();
		numberdata.addNumberData(3);
		numberdata.addNumberData(6);

		result = new NumberData<>();
		result.addNumberData(6);
		result.addNumberData(3);

		NumberData<Integer> actual = service.swapFirstMethod(numberdata);
		NumberData<Integer> expected = result;
		assertEquals(actual, expected);
	}

	@Test(description = "SwapExtraTaskTest2", groups = { "service" })
	public void testSwapExtraTask2() {

		numberdata = new NumberData<>();
		numberdata.addNumberData(-3);
		numberdata.addNumberData(6);

		result = new NumberData<>();
		result.addNumberData(6);
		result.addNumberData(-3);

		NumberData<Integer> actual = service.swapSecondMethod(numberdata);
		NumberData<Integer> expected = result;
		assertEquals(actual, expected);
	}

	@Test(description = "SwapExtraTaskTest3", groups = { "service" })
	public void testSwapExtraTask3() {

		numberdata = new NumberData<>();
		numberdata.addNumberData(5);
		numberdata.addNumberData(2);

		result = new NumberData<>();
		result.addNumberData(2);
		result.addNumberData(5);

		NumberData<Integer> actual = service.swapThirdMethod(numberdata);
		NumberData<Integer> expected = result;
		assertEquals(actual, expected);
	}
}
