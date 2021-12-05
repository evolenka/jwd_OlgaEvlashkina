package test.jwd.task01basic.service;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import by.jwd.task01basic.entity.NumberData;
import by.jwd.task01basic.service.FunctionValueService;
import by.jwd.task01basic.service.impl.FunctionValueServiceImpl;

public class FunctionValueTest {

	FunctionValueService service = new FunctionValueServiceImpl();

	@Test(description = "FunctionValueTest1", groups = { "service" })
	public void test1FunctionValue() {

		double[] ab = { -5.0, 5.0, 2.0 };

		NumberData<Double> numberdata = new NumberData<>();
		numberdata.addNumberData(ab[0]);
		numberdata.addNumberData(ab[1]);
		numberdata.addNumberData(ab[2]);

		double[] c = { 5.0, 3.0, 1.0, -1.0, 3.0, 5.0 };

		NumberData<Double> result = new NumberData<>();
		for (int i = 0; i < c.length; i++) {
			result.addNumberData(c[i]);
		}

		NumberData<Double> actual = service.findFunctionValue(numberdata);
		NumberData<Double> expected = result;
		assertEquals(actual, expected);
	}

	@Test(description = "FunctionValueTest2", groups = { "service" })
	public void test2FunctionValue() {

		double[] ab = { -2.0, 3.0, 1.0 };

		NumberData<Double> numberdata = new NumberData<>();
		numberdata.addNumberData(ab[0]);
		numberdata.addNumberData(ab[1]);
		numberdata.addNumberData(ab[2]);

		double[] c = { 2.0, 1.0, 0.0, -1.0, -2.0, 3.0 };

		NumberData<Double> result = new NumberData<>();
		for (int i = 0; i < c.length; i++) {
			result.addNumberData(c[i]);
		}

		NumberData<Double> actual = service.findFunctionValue(numberdata);
		NumberData<Double> expected = result;
		assertEquals(actual, expected);
	}

	@Test(description = "FunctionValueTest3", groups = { "service" })
	public void test3FunctionValue() {

		double[] ab = { 0.0, 0.0, 1.0 };

		NumberData<Double> numberdata = new NumberData<>();
		numberdata.addNumberData(ab[0]);
		numberdata.addNumberData(ab[1]);
		numberdata.addNumberData(ab[2]);

		double[] c = { 0.0 };

		NumberData<Double> result = new NumberData<>();
		for (int i = 0; i < c.length; i++) {
			result.addNumberData(c[i]);
		}

		NumberData<Double> actual = service.findFunctionValue(numberdata);
		NumberData<Double> expected = result;
		assertEquals(actual, expected);
	}
}