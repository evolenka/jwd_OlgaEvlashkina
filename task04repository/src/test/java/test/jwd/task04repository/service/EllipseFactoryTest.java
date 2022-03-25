package test.jwd.task04repository.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
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
import by.jwd.task04repository.entity.EllipseToObserve;
import by.jwd.task04repository.entity.IEllipse;
import by.jwd.task04repository.entity.Point;
import by.jwd.task04repository.service.ServiceException;

import by.jwd.task04repository.service.factory.EllipseFactory;

@RunWith(JUnitPlatform.class)
@SelectPackages("test.jwd.task04repository.service")

class EllipseFactoryTest {

	static EllipseFactory factory = new EllipseFactory();

	@ParameterizedTest
	@MethodSource("dataProvider")
	void testEllipseFactoryPositive(List<IEllipse> actual, List<IEllipse> expected) {
		Assertions.assertEquals(actual, expected);
	}

	static Stream<Arguments> dataProvider() throws ServiceException {

		EllipseFactory factory = new EllipseFactory();

		List<IEllipse> expected = new ArrayList<IEllipse>();

		IEllipse ellipse1 = new EllipseToObserve(new Ellipse(new Point(1.0, 2.0), new Point(-8.0, 5.0)));
		IEllipse ellipse2 = new EllipseToObserve(new Ellipse(new Point(0.0, 2.0), new Point(1.0, 0.0)));
		IEllipse ellipse3 = new EllipseToObserve(new Ellipse(new Point(0.0, 3.0), new Point(3.0, 0.0)));
		IEllipse ellipse4 = new EllipseToObserve(new Ellipse(new Point(0.0, 1.0), new Point(4.0, 0.0)));
		IEllipse ellipse5 = new EllipseToObserve(new Ellipse(new Point(4.0, 3.0), new Point(4.5, 1.5)));
		IEllipse ellipse6 = new EllipseToObserve(new Ellipse(new Point(5.0, 5.0), new Point(8.0, 4.0)));
		IEllipse ellipse7 = new EllipseToObserve(new Ellipse(new Point(1.0, 3.0), new Point(-2.0, 4.0)));
		IEllipse ellipse8 = new EllipseToObserve(new Ellipse(new Point(3.0, 0.5), new Point(-0.5, 4.0)));
		IEllipse ellipse9 = new EllipseToObserve(new Ellipse(new Point(4.0, 6.0), new Point(5.0, 5.0)));
		IEllipse ellipse10 = new EllipseToObserve(new Ellipse(new Point(-3.0, 2.0), new Point(-2.5, 0.0)));
		
		expected.add(ellipse1);
		expected.add(ellipse2);
		expected.add(ellipse3);
		expected.add(ellipse4);
		expected.add(ellipse5);
		expected.add(ellipse6);
		expected.add(ellipse7);
		expected.add(ellipse8);
		expected.add(ellipse9);
		expected.add(ellipse10);

		List<IEllipse> actual1 = factory.createListOfEllipsesFromFile("ellipseDataTest.json");
		List<IEllipse> actual2 = factory.createListOfEllipsesFromFile("ellipseDataTest.txt");

		return Stream.of(Arguments.of(actual1, expected), Arguments.of(actual2, expected));
	}

	@Test
	void testEllipseFactoryNegative() throws ServiceException {
		assertThrows(ServiceException.class, () -> {
			factory.createListOfEllipsesFromFile("fileNotExist.txt");
		});
	}
}