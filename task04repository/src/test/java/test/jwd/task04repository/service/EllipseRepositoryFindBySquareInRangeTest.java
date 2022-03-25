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
import by.jwd.task04repository.service.specification.impl.FindEllipsePerimeterInRangeSpecificationImpl;
import by.jwd.task04repository.service.specification.impl.FindEllipseSquareInRangeSpecificationImpl;

@RunWith(JUnitPlatform.class)
@SelectPackages("test.jwd.task04repository.service")

class EllipseRepositoryFindBySquareInRangeTest {

	static EllipseRepository<IEllipse> repository;
	static List<IEllipse> expectedList;

	@BeforeAll
	public static void setUp() throws ServiceException {
		repository = EllipseRepositorySaveTest.repository;
		expectedList = ResultListEllipse.listOfEllipse;
	}

	@ParameterizedTest
	@MethodSource("dataProvider")
	void testFindBySquareInRange(List<IEllipse> actual, List<IEllipse> expected) {
		Assertions.assertEquals(actual, expected);
	}

	static Stream<Arguments> dataProvider() throws ServiceException {

		double[] range1 = { 25.0, 40.0 };
		FindSpecification<IEllipse> specification1 = new FindEllipseSquareInRangeSpecificationImpl<>(range1);

		List<IEllipse> actual1 = repository.findQuery(specification1);

		double[] range2 = { 0.0, 5.0 };
		FindSpecification<IEllipse> specification2 = new FindEllipsePerimeterInRangeSpecificationImpl<>(range2);
		List<IEllipse> actual2 = repository.findQuery(specification2);

		double[] range3 = { 40.0, 90.0 };
		FindSpecification<IEllipse> specification3 = new FindEllipsePerimeterInRangeSpecificationImpl<>(range3);
		List<IEllipse> actual3 = repository.findQuery(specification3);

		List<IEllipse> expected1 = new ArrayList<>();
		expected1.add(expectedList.get(2));
		expected1.add(expectedList.get(7));

		List<IEllipse> expected2 = new ArrayList<>();

		List<IEllipse> expected3 = new ArrayList<>();
		expected3.add(expectedList.get(0));

		return Stream.of(Arguments.of(actual1, expected1), Arguments.of(actual2, expected2),
				Arguments.of(actual3, expected3));
	}

	@AfterAll
	public static void tearDown() {
		repository = null;
		expectedList = null;
	}
}