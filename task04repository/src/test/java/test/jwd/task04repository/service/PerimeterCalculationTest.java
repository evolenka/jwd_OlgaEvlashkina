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
import by.jwd.task04repository.service.impl.EllipsePerimeterCalculationImpl;

@RunWith(JUnitPlatform.class)
@SelectPackages("test.jwd.task04repository.service")

class PerimeterCalculationTest {

	static TwoDShapeCalculation<IEllipse> service = new EllipsePerimeterCalculationImpl<>();

	@ParameterizedTest
	@MethodSource("dataProvider")
	void testEllipsePerimeterPositive(double actual, double expected) {
		Assertions.assertEquals(actual, expected);
	}

	static Stream<Arguments> dataProvider() throws ServiceException {

		Ellipse ellipse1 = new Ellipse(new Point(1.0, 3.0), new Point(2.0, 2.0));

		Ellipse ellipse2 = new Ellipse(new Point(-1.0, 1.0), new Point(1.0, 5.0));

		Ellipse ellipse3 = new Ellipse(new Point(5.0, 2.0), new Point(-5.0, 0.0));

		Ellipse ellipse4 = new Ellipse(new Point(1.0, 3.0), new Point(5.0, 2.0));

		Ellipse ellipse5 = new Ellipse(new Point(-3.0, 2.0), new Point(-2.5, 0.0));

		double actual1 = new BigDecimal(service.calculate(ellipse1)).setScale(9, RoundingMode.HALF_UP).doubleValue();
		double expected1 = 6.283185307;
		double actual2 = new BigDecimal(service.calculate(ellipse2)).setScale(9, RoundingMode.HALF_UP).doubleValue();
		double expected2 = 19.421827486;
		double actual3 = new BigDecimal(service.calculate(ellipse3)).setScale(9, RoundingMode.HALF_UP).doubleValue();
		double expected3 = 42.277284357;
		double actual4 = new BigDecimal(service.calculate(ellipse4)).setScale(9, RoundingMode.HALF_UP).doubleValue();
		double expected4 = 17.253096491;
		double actual5 = new BigDecimal(service.calculate(ellipse5)).setScale(9, RoundingMode.HALF_UP).doubleValue();
		double expected5 = 8.626548246;

		return Stream.of(Arguments.of(actual1, expected1), Arguments.of(actual2, expected2),
				Arguments.of(actual3, expected3), Arguments.of(actual4, expected4), Arguments.of(actual5, expected5));
	}

	@Test
	void EllipsePerimeterNegative() throws ServiceException {

		Ellipse ellipse1 = new Ellipse(new Point(1.0, 3.0), new Point(2.0, 3.0));

		assertThrows(ServiceException.class, () -> {
			service.calculate(ellipse1);
		});
	}
}