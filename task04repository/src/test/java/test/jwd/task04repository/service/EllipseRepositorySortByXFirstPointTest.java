package test.jwd.task04repository.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;
import by.jwd.task04repository.entity.IEllipse;
import by.jwd.task04repository.service.ServiceException;
import by.jwd.task04repository.service.repository.EllipseRepository;
import by.jwd.task04repository.service.specification.SortSpecification;
import by.jwd.task04repository.service.specification.impl.SortEllipseByXFirstPointSpecificationImpl;

@RunWith(JUnitPlatform.class)
@SelectPackages("test.jwd.task04repository.service")

class EllipseRepositorySortByXFirstPointTest {

	static EllipseRepository<IEllipse> repository;
	static List<IEllipse> expectedList;

	@BeforeAll
	public static void setUp() throws ServiceException {
		repository = RepositoryCreatorTest.repository;
		expectedList = ResultListEllipse.listOfEllipse;
	}

	@Test
	void testSortByXFirstPoint() throws ServiceException {

		SortSpecification<IEllipse> specification = new SortEllipseByXFirstPointSpecificationImpl<>();

		List<IEllipse> actual = repository.sortQuery(specification);
		
		List<IEllipse> expected = new ArrayList<>();
		
		expected.add(expectedList.get(9));
		expected.add(expectedList.get(1));
		expected.add(expectedList.get(2));
		expected.add(expectedList.get(3));
		expected.add(expectedList.get(0));
		expected.add(expectedList.get(6));
		expected.add(expectedList.get(7));
		expected.add(expectedList.get(4));
		expected.add(expectedList.get(8));
		expected.add(expectedList.get(5));

		Assertions.assertEquals(actual, expected);
	}

	@AfterAll
	public static void tearDown() {
		repository = null;
	}
}
