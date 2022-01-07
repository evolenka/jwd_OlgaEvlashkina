package test.jwd.task03innerclass.service;

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

import by.jwd.task03innerclass.entity.Good;
import by.jwd.task03innerclass.entity.Shop;
import by.jwd.task03innerclass.entity.Shop.Department;
import by.jwd.task03innerclass.service.FindService;
import by.jwd.task03innerclass.service.ServiceException;
import by.jwd.task03innerclass.service.impl.FindAllAvailiableAssortmentServiceImpl;

@RunWith(JUnitPlatform.class)
@SelectPackages({ "test.jwd.task03innerclass.service", "test.jwd.task03innerclass.dao" })

class FindAllAvailiableAssortmentTest {

	static FindService<String> service = new FindAllAvailiableAssortmentServiceImpl();

	@ParameterizedTest
	@MethodSource("dataProvider")
	void testFindAllAssortmentPositive(List<String> actual, List<String> expected) throws ServiceException {
		Assertions.assertEquals(actual, expected);
	}

	static Stream<Arguments> dataProvider() throws ServiceException {

		List<Department> listOfDepartment = new ArrayList<>();

		Shop shop = new Shop(listOfDepartment);

		List<Good> assortment1 = new ArrayList<>();
		List<Good> assortment2 = new ArrayList<>();

		Department department1 = shop.new Department("cosmetics", assortment1);
		Department department2 = shop.new Department("other", assortment2);

		listOfDepartment.add(department1);
		listOfDepartment.add(department2);

		Good good1 = new Good("shampoo", "Schauma", 5.59, 40);
		Good good2 = new Good("shampoo", "Syoss", 10.60, 20);
		Good good3 = new Good("shower gel", "Dove", 5.59, 35);
		Good good4 = new Good("shower gel", "Fa", 4.60, 30);
		Good good5 = new Good("shower gel", "Nivea", 7.30, 25);
		Good good6 = new Good("hair spray", "Taft", 5.4, 35);
		Good good7 = new Good("hair spray", "Loreal", 7.2, 20);
		Good good8 = new Good("toothpaste", "Colgate", 4.3, 25);
		Good good9 = new Good("toothpaste", "Lacalut", 6.9, 25);
		Good good10 = new Good("toothpaste", "Splat", 8.5, 35);

		department1.addGood(good1);
		department1.addGood(good2);
		department1.addGood(good3);
		department1.addGood(good4);
		department1.addGood(good5);

		department2.addGood(good6);
		department2.addGood(good7);
		department2.addGood(good8);
		department2.addGood(good9);
		department2.addGood(good10);

		List<String> actual1 = service.find(shop);
		List<String> expected1 = new ArrayList<>();

		expected1.add("shampoo");
		expected1.add("shower gel");
		expected1.add("hair spray");
		expected1.add("toothpaste");

		List<Department> listOfDepartment2 = new ArrayList<>();
		Shop shop2 = new Shop(listOfDepartment2);

		List<String> actual2 = service.find(shop2);
		List<String> expected2 = new ArrayList<>();

		return Stream.of(Arguments.of(actual1, expected1), Arguments.of(actual2, expected2));
	}

	@Test
	void testFindAllAssortmentNegative() throws ServiceException {

		assertThrows(ServiceException.class, () -> {
			Shop shop = null;
			service.find(shop);
		});
	}
}