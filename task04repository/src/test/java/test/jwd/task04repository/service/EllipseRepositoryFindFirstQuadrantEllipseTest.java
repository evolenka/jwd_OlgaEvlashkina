package test.jwd.task04repository.service;

import java.util.ArrayList;
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
import by.jwd.task04repository.service.specification.FindSpecification;
import by.jwd.task04repository.service.specification.impl.FindFirstQuadrantEllipseSpecificationImpl;

@RunWith(JUnitPlatform.class)
@SelectPackages("test.jwd.task04repository.service")

class EllipseRepositoryFindFirstQuadrantEllipseTest {
	
	static EllipseRepository<IEllipse> repository;
	static List<IEllipse> expectedList;

	@BeforeAll
	public static void setUp() throws ServiceException {
		repository = RepositoryCreatorTest.repository;
		expectedList = ResultListEllipse.listOfEllipse;
	}

	@ParameterizedTest
	@MethodSource("dataProvider")
	void testFindByFirstQuadrant(List<IEllipse> actual, List<IEllipse> expected) {
		Assertions.assertEquals(actual, expected);
	}

	static Stream<Arguments> dataProvider() throws ServiceException {

		FindSpecification<IEllipse> specification1 = new FindFirstQuadrantEllipseSpecificationImpl<>();
		List<IEllipse> actual = repository.findQuery(specification1);
		
		List<IEllipse> expected = new ArrayList<>();
		expected.add(expectedList.get(1));
		expected.add(expectedList.get(2));
		expected.add(expectedList.get(3));
		expected.add(expectedList.get(4));
		expected.add(expectedList.get(5));
		expected.add(expectedList.get(8));
		
		return Stream.of(Arguments.of(actual, expected));
	}
	@AfterAll
	public static void tearDown() {
		repository = null;
	}
}