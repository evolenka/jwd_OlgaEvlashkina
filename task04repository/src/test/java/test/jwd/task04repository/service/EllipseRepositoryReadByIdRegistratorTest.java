package test.jwd.task04repository.service;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

import by.jwd.task04repository.entity.EllipseRegistrator;
import by.jwd.task04repository.entity.IEllipse;

import by.jwd.task04repository.service.ServiceException;
import by.jwd.task04repository.service.factory.EllipseRegistratorCreator;
import by.jwd.task04repository.service.repository.EllipseRepository;

@RunWith(JUnitPlatform.class)
@SelectPackages("test.jwd.task04repository.service")

class EllipseRepositoryReadByIdRegistratorTest {

	static EllipseRepository<IEllipse> repository;
	static List<IEllipse> expectedList;

	@BeforeAll
	public static void setUp() throws ServiceException {
		repository = EllipseRepositorySaveTest.repository;
		expectedList = ResultListEllipse.listOfEllipse;
	}

	@ParameterizedTest
	@MethodSource("dataProvider")
	void testEllipseRepositoryReadRegistratorById(EllipseRegistrator actual, EllipseRegistrator expected) {
		Assertions.assertEquals(actual, expected);
	}

	static Stream<Arguments> dataProvider() throws ServiceException {

		EllipseRegistrator actual1 = repository.readRegistratorById(5L);
		EllipseRegistrator actual2 = repository.readRegistratorById(1L);
		EllipseRegistrator actual3 = repository.readRegistratorById(10L);

		EllipseRegistrator expected1 = new EllipseRegistratorCreator().create(expectedList.get(4));
		EllipseRegistrator expected2 = new EllipseRegistratorCreator().create(expectedList.get(0));
		EllipseRegistrator expected3 = new EllipseRegistratorCreator().create(expectedList.get(9));

		return Stream.of(Arguments.of(actual1, expected1), Arguments.of(actual2, expected2),
				Arguments.of(actual2, expected2), Arguments.of(actual3, expected3));
	}

	@AfterAll
	public static void tearDown() {
		repository = null;
		expectedList = null;
	}
}