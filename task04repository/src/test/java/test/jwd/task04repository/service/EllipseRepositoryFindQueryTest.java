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

import by.jwd.task04repository.entity.FigureType;
import by.jwd.task04repository.entity.IEllipse;
import by.jwd.task04repository.service.ServiceException;
import by.jwd.task04repository.service.repository.EllipseRepository;
import by.jwd.task04repository.service.specification.FindSpecification;
import by.jwd.task04repository.service.specification.impl.FindByNameSpecificationImpl;
import by.jwd.task04repository.service.specification.impl.FindEllipsePerimeterInRangeSpecificationImpl;
import by.jwd.task04repository.service.specification.impl.FindEllipseSquareInRangeSpecificationImpl;
import by.jwd.task04repository.service.specification.impl.FindFirstQuadrantEllipseSpecificationImpl;

@RunWith(JUnitPlatform.class)
@SelectPackages("test.jwd.task04repository.service")

class EllipseRepositoryFindQueryTest {

	static EllipseRepository<IEllipse> repository;
	static List<IEllipse> expectedList;

	@BeforeAll
	public static void setUp() throws ServiceException {
		repository = RepositoryCreatorTest.repository;
		expectedList = ResultListEllipse.listOfEllipse;
	}

	@ParameterizedTest
	@MethodSource("dataProvider")
	void testFindBySeveralCriteria(List<IEllipse> actual, List<IEllipse> expected) {
		Assertions.assertEquals(actual, expected);
	}

	static Stream<Arguments> dataProvider() throws ServiceException {

		FindSpecification<IEllipse> specification1 = new FindFirstQuadrantEllipseSpecificationImpl<>();
		double[] range1 = { 15.0, 20.0 };
		FindSpecification<IEllipse> specification2 = new FindEllipsePerimeterInRangeSpecificationImpl<>(range1);
		double[] range2 = { 2.0, 5.0 };
		FindSpecification<IEllipse> specification3 = new FindEllipseSquareInRangeSpecificationImpl<>(range2);
		FindSpecification<IEllipse> specification4 = new FindByNameSpecificationImpl<>(FigureType.CIRCLE);
		FindSpecification<IEllipse> specification5 = new FindByNameSpecificationImpl<>(FigureType.ELLIPSE);

		List<IEllipse> actual1 = repository.findQuery(specification1.and(specification2));
		List<IEllipse> actual2 = repository.findQuery(specification1.and(specification2).and(specification4.not()));
		List<IEllipse> actual3 = repository.findQuery(specification1.or(specification3));
		List<IEllipse> actual4 = repository.findQuery(specification5.not());

		List<IEllipse> expected1 = new ArrayList<>();
		expected1.add(expectedList.get(2));
		expected1.add(expectedList.get(3));
		
		List<IEllipse> expected2 = new ArrayList<>();
		expected2.add(expectedList.get(3));
		
		List<IEllipse> expected3 = new ArrayList<>();
		expected3.add(expectedList.get(1));
		expected3.add(expectedList.get(2));
		expected3.add(expectedList.get(3));
		expected3.add(expectedList.get(4));
		expected3.add(expectedList.get(5));
		expected3.add(expectedList.get(8));
		expected3.add(expectedList.get(9));

		List<IEllipse> expected4 = new ArrayList<>();
		expected4.add(expectedList.get(2));
		expected4.add(expectedList.get(7));
		expected4.add(expectedList.get(8));
		
		return Stream.of(Arguments.of(actual1, expected1),
				Arguments.of(actual2, expected2, Arguments.of(actual3, expected3), Arguments.of(actual4, expected4)));
	}

	@AfterAll
	public static void tearDown() {
		repository = null;
	}
}