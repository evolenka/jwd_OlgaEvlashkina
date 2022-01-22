package test.jwd.task04repository.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import by.jwd.task04repository.entity.Ellipse;
import by.jwd.task04repository.entity.EllipseToObserve;
import by.jwd.task04repository.entity.IEllipse;
import by.jwd.task04repository.entity.Point;
import by.jwd.task04repository.service.ServiceException;
import by.jwd.task04repository.service.factory.EllipseFactory;
import by.jwd.task04repository.service.repository.EllipseRepository;

public class RepositoryCreatorTest {

	public static EllipseRepository<IEllipse> repository = createRepository();

	public static EllipseRepository<IEllipse> createRepository() {
		repository = EllipseRepository.getInstance();
		EllipseFactory factory = new EllipseFactory();
		List<IEllipse> listOfEllipse;
		try {
			listOfEllipse = factory.createListOfEllipsesFromFile("ellipseDataTest.json");
			for (IEllipse e : listOfEllipse) {
				repository.save(e);
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return repository;
	}

	@ParameterizedTest
	@MethodSource("dataProvider")
	void testEllipseRepositorySavePositive(int actual, int expected) {
		Assertions.assertEquals(actual, expected);
	}

	static Stream<Arguments> dataProvider() throws ServiceException {

		int actual1 = repository.readAll().size();
		int expected1 = 10;

		IEllipse ellipse11 = new EllipseToObserve(new Ellipse(new Point(1.8, 5.0), new Point(4.0, 0.0)));
		repository.save(ellipse11);

		int actual2 = repository.readAll().size();
		int expected2 = 11;

		IEllipse ellipse6 = repository.readById(6L);
		ellipse6.setFirstPoint(new Point(3.0, 2.0));
		repository.save(ellipse6);

		int actual3 = repository.readAll().size();
		int expected3 = 11;

		return Stream.of(Arguments.of(actual1, expected1), Arguments.of(actual2, expected2),
				Arguments.of(actual3, expected3));
	}

	@Test
	void testEllipseFactoryNegative() throws ServiceException {
		assertThrows(ServiceException.class, () -> {
			IEllipse ellipse = new EllipseToObserve(new Ellipse(new Point(1.0, 5.0), new Point(1.0, 5.0)));
			repository.save(ellipse);
		});
	}
}
