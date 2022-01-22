package test.jwd.task04repository.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

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
import by.jwd.task04repository.service.TwoDShapeLogic;
import by.jwd.task04repository.service.impl.EllipseOrCircle;

@RunWith(JUnitPlatform.class)
@SelectPackages("test.jwd.task04repository.service")

class EllipseOrCircleTest {

	static TwoDShapeLogic<IEllipse> service = new EllipseOrCircle<>();

	@ParameterizedTest
	@MethodSource("dataProvider")
	void testEllipseOrCirclePositive(boolean actual, boolean expected) {
		Assertions.assertEquals(actual, expected);
	}

	static Stream<Arguments> dataProvider() throws ServiceException {

		Ellipse ellipse1 = new Ellipse(new Point(1.0, 3.0), new Point(2.0, 2.0));

		Ellipse ellipse2 = new Ellipse(new Point(-1.0, 1.0), new Point(1.0, 5.0));

		Ellipse ellipse3 = new Ellipse(new Point(5.0, 2.0), new Point(-5.0, 0.0));

		Ellipse ellipse4 = new Ellipse(new Point(2.0, 3.0), new Point(5.0, 0.0));

		Ellipse ellipse5 = new Ellipse(new Point(-3.0, 2.0), new Point(-2.5, 0.0));

		boolean actual1 = service.isTrue(ellipse1);
		boolean actual2 = service.isTrue(ellipse2);
		boolean actual3 = service.isTrue(ellipse3);
		boolean actual4 = service.isTrue(ellipse4);
		boolean actual5 = service.isTrue(ellipse5);

		boolean expected1 = true;
		boolean expected2 = false;
		boolean expected3 = false;
		boolean expected4 = true;
		boolean expected5 = false;

		return Stream.of(Arguments.of(actual1, expected1), Arguments.of(actual2, expected2),
				Arguments.of(actual3, expected3), Arguments.of(actual4, expected4), Arguments.of(actual5, expected5));
	}

	@Test
	void EllipseOrCircleNegative() throws ServiceException {

		Ellipse ellipse1 = new Ellipse(new Point(1.0, 3.0), new Point(2.0, 3.0));

		assertThrows(ServiceException.class, () -> {
			service.isTrue(ellipse1);
		});
	}
}