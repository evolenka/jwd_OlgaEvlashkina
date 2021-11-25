package test.jwd.task01basic.service;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import by.jwd.task01basic.entity.NumberData;
import by.jwd.task01basic.service.ArithmeticService;
import by.jwd.task01basic.service.impl.ArithmeticServiceImpl;

public class ArithmeticTest {
	ArithmeticService arithmetic;
	
	@BeforeClass
	 public void setUp() {
		arithmetic = new ArithmeticServiceImpl();
	}
	
	@DataProvider(name = "DataForAverage")
	public Object[][] createDataForCalculationAverage() {
		return new Object[][] { 
			{ new double[] { 0.0, 0.0 }, 0.0 },
			{ new double[] { 1.0, 1.0 }, 1.0 },
			{ new double[] { 4.0, 2.0 }, 3.0 },
			{ new double[] { 8.0, 4.0 }, 6.0 },
			{ new double[] { -3.0, 3.0 }, 0.0 },
			{ new double[] { -6.0, 3.0 }, -1.5 },
			{ new double[] { 6.0, -3.0 }, 1.5 },
			{ new double[] { -6.0, -3.0 }, -4.5 },
			{ new double[] {Integer.MAX_VALUE, Integer.MAX_VALUE}, Integer.MAX_VALUE},
			{ new double[] {-Integer.MAX_VALUE, Integer.MAX_VALUE}, 0},
			{ new double[] {-Integer.MAX_VALUE, -Integer.MAX_VALUE}, -Integer.MAX_VALUE}};
	}

	@Test (dataProvider = "DataForAverage")
	public void testCalculationAverage(double[] ab, double c) {
		NumberData numberdata = new NumberData(); 
		numberdata.addNumberData(ab[0]);
		numberdata.addNumberData(ab[1]);
		double actual = arithmetic.calculate(numberdata);
		double expected = c;
		assertEquals(actual, expected);
	}
	
	@AfterClass
	public void tierDown(){
	arithmetic = null;
    }
}