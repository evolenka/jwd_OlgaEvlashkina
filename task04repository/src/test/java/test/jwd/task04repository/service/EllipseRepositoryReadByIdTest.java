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

import by.jwd.task04repository.entity.IEllipse;

import by.jwd.task04repository.service.ServiceException;

import by.jwd.task04repository.service.repository.EllipseRepository;

@RunWith(JUnitPlatform.class)
@SelectPackages("test.jwd.task04repository.service")

class EllipseRepositoryReadByIdTest {

	static EllipseRepository<IEllipse> repository;
	static List<IEllipse> expectedList;

	@BeforeAll
	public static void setUp() throws ServiceException {
		repository = EllipseRepositorySaveTest.repository;
		expectedList = ResultListEllipse.listOfEllipse;
	}

	@ParameterizedTest
	@MethodSource("dataProvider")
	void testEllipseRepositoryReadById(IEllipse actual, IEllipse expected) {
		Assertions.assertEquals(actual, expected);
	}

	static Stream<Arguments> dataProvider() throws ServiceException {

		IEllipse actual1 = repository.readById(5L);
		IEllipse actual2 = repository.readById(1L);
		IEllipse actual3 = repository.readById(10L);
		IEllipse actual4 = repository.readById(12L);

		IEllipse expected1 = expectedList.get(4);
		IEllipse expected2 = expectedList.get(0);
		IEllipse expected3 = expectedList.get(9);
		IEllipse expected4 = null;

		return Stream.of(Arguments.of(actual1, expected1), Arguments.of(actual2, expected2),
				Arguments.of(actual2, expected2), Arguments.of(actual3, expected3), Arguments.of(actual4, expected4));
	}

	@AfterAll
	public static void tearDown() {
		repository = null;
		expectedList = null;
	}
}