package test.jwd.task04repository.service;


import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
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
import by.jwd.task04repository.service.impl.IsEllipseCrossOneCoordinateAxis;


@RunWith(JUnitPlatform.class)
@SelectPackages("test.jwd.task04repository.service")

class IsEllipseCrossOneCoordinateAxisTest {

	static TwoDShapeLogic<IEllipse> service = new IsEllipseCrossOneCoordinateAxis<>();

	@ParameterizedTest
	@MethodSource("dataProvider")
	void testIsEllipseCrossOneAxis(boolean actual, boolean expected) {
		Assertions.assertEquals(actual, expected);
	}

	static Stream<Arguments> dataProvider() throws ServiceException {

		Ellipse ellipse1 = new Ellipse(new Point(0.0, 2.0), new Point(1.0, 0.0));

		Ellipse ellipse2 = new Ellipse(new Point(6.0, 4.0), new Point(4.0, 5.0));

		Ellipse ellipse3 = new Ellipse(new Point(-2.0, 0.0), new Point(-4.0, 1.0));

		Ellipse ellipse4 = new Ellipse(new Point(0.0, -1.0), new Point(1.0, -3.0));

		boolean actual1 = service.isTrue(ellipse1);
		boolean actual2 = service.isTrue(ellipse2);
		boolean actual3 = service.isTrue(ellipse3);
		boolean actual4 = service.isTrue(ellipse4);
		
		boolean expected1 = false;
		boolean expected2 = false;
		boolean expected3 = true;
		boolean expected4 = true;
		

		return Stream.of(Arguments.of(actual1, expected1), Arguments.of(actual2, expected2),
				Arguments.of(actual3, expected3), Arguments.of(actual4, expected4));
	}
}