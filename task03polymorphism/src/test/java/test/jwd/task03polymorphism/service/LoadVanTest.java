package test.jwd.task03polymorphism.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

import by.jwd.task03polymorphism.entity.CoffeeBean;
import by.jwd.task03polymorphism.entity.ItemOfCoffee;
import by.jwd.task03polymorphism.entity.Packing;
import by.jwd.task03polymorphism.entity.VanException;
import by.jwd.task03polymorphism.entity.VanOfCoffee;
import by.jwd.task03polymorphism.service.LoadVanService;
import by.jwd.task03polymorphism.service.ServiceException;

@RunWith(JUnitPlatform.class)
@SelectPackages({ "test.jwd.task03polymorphism.service", "test.jwd.task03polymorphism.dao" })

class LoadVanTest {

	LoadVanService service = new LoadVanService();

	List<ItemOfCoffee> resultAssortment = new ArrayList<>();
	VanOfCoffee van = new VanOfCoffee();

	@Test
	void testLoadVanPositiveTest() throws ServiceException, VanException {

		CoffeeBean coffeeBean1 = new CoffeeBean("арабика", "Lavazza", "средняя", 70.5, 500);
		Packing pack1 = new Packing("пластиковая банка", 5.5, 0.500, 10);
		ItemOfCoffee item1 = new ItemOfCoffee(coffeeBean1, pack1);

		CoffeeBean coffeeBean2 = new CoffeeBean("арабика", "Lavazza", "темная", 69.0, 1000);
		Packing pack2 = new Packing("бумажный пакет", 2.5, 1.1, 2);
		ItemOfCoffee item2 = new ItemOfCoffee(coffeeBean2, pack2);

		resultAssortment.add(item1);
		resultAssortment.add(item2);
		van = new VanOfCoffee(10, resultAssortment);

		VanOfCoffee actual = service.loadVan(10, 115, "dataTest.json");
		VanOfCoffee expected = van;
		Assertions.assertEquals(actual, expected);
	}

	@Test
	void testLoadVanNegativeTest1() throws ServiceException {

		assertThrows(ServiceException.class, () -> {
			service.loadVan(-10, 115, "dataTest.json");
		});
	}
}