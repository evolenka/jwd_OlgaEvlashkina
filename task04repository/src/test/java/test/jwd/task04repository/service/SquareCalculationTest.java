package test.jwd.task04repository.service;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

import by.jwd.task04repository.entity.Ellipse;
import by.jwd.task04repository.entity.IEllipse;
import by.jwd.task04repository.entity.Point;
import by.jwd.task04repository.service.ServiceException;
import by.jwd.task04repository.service.TwoDShapeCalculation;
import by.jwd.task04repository.service.impl.EllipseSquareCalculationImpl;

@RunWith(JUnitPlatform.class)
@SelectPackages("test.jwd.task04repository.service")

class SquareCalculationTest {

	static TwoDShapeCalculation<IEllipse> service = new EllipseSquareCalculationImpl<>();

	@ParameterizedTest
	@MethodSource("dataProvider")
	void testEllipseSquarePositive(double actual, double expected) {
		Assertions.assertEquals(actual, expected);
	}

	static Stream<Arguments> dataProvider() throws ServiceException {

		Ellipse ellipse1 = new Ellipse(new Point(1.0, 3.0), new Point(2.0, 2.0));

		Ellipse ellipse2 = new Ellipse(new Point(-1.0, 1.0), new Point(1.0, 5.0));

		Ellipse ellipse3 = new Ellipse(new Point(5.0, 2.0), new Point(-5.0, 0.0));

		Ellipse ellipse4 = new Ellipse(new Point(1.0, 3.0), new Point(5.0, 2.0));

		Ellipse ellipse5 = new Ellipse(new Point(-3.0, 2.0), new Point(-2.5, 0.0));

		double actual1 = new BigDecimal(service.calculate(ellipse1)).setScale(4, RoundingMode.HALF_UP).doubleValue();
		double expected1 = 3.1416;
		double actual2 = new BigDecimal(service.calculate(ellipse2)).setScale(4, RoundingMode.HALF_UP).doubleValue();
		double expected2 = 25.1327;
		double actual3 = new BigDecimal(service.calculate(ellipse3)).setScale(4, RoundingMode.HALF_UP).doubleValue();
		double expected3 = 62.8319;
		double actual4 = new BigDecimal(service.calculate(ellipse4)).setScale(4, RoundingMode.HALF_UP).doubleValue();
		double expected4 = 12.5664;
		double actual5 = new BigDecimal(service.calculate(ellipse5)).setScale(4, RoundingMode.HALF_UP).doubleValue();
		double expected5 = 3.1416;

		return Stream.of(Arguments.of(actual1, expected1), Arguments.of(actual2, expected2),
				Arguments.of(actual3, expected3), Arguments.of(actual4, expected4), Arguments.of(actual5, expected5));
	}

	@Test
	void EllipseSquareNegative() throws ServiceException {
		
		Ellipse ellipse1 = new Ellipse(new Point(0.0, 0.0), new Point(0.0, 0.0));

		assertThrows(ServiceException.class, () -> {
			service.calculate(ellipse1);
		});
	}
}