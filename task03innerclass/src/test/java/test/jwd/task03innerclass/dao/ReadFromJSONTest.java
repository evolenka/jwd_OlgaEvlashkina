package test.jwd.task03innerclass.dao;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

import by.jwd.task03innerclass.dao.DaoException;
import by.jwd.task03innerclass.dao.ReadFromJSONDao;
import by.jwd.task03innerclass.entity.Good;
import by.jwd.task03innerclass.entity.Shop;
import by.jwd.task03innerclass.entity.Shop.Department;

@RunWith(JUnitPlatform.class)
@SelectPackages({ "test.jwd.task03innerclass.service", "test.jwd.task03innerclass.dao" })

class ReadFromJSONTest {
	ReadFromJSONDao dao = new ReadFromJSONDao();

	@Test
	void testReadFromJSONPositive() throws DaoException {

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

		Shop actual = dao.readDataFromFile("dataTest.json");
		Shop expected = shop;
		Assertions.assertEquals(actual, expected);
	}

	@Test
	void testReadFromJSONNegative() throws DaoException {

		assertThrows(DaoException.class, () -> {
			dao.readDataFromFile("FileNotExist.json");
		});
	}
}