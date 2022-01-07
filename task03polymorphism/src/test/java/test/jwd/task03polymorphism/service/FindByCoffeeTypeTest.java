package test.jwd.task03polymorphism.service;

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

import by.jwd.task03polymorphism.entity.CoffeeBean;
import by.jwd.task03polymorphism.entity.GroundCoffee;
import by.jwd.task03polymorphism.entity.InstantCoffee;
import by.jwd.task03polymorphism.entity.ItemOfCoffee;
import by.jwd.task03polymorphism.entity.Packing;
import by.jwd.task03polymorphism.entity.VanOfCoffee;
import by.jwd.task03polymorphism.service.FindByParameterService;
import by.jwd.task03polymorphism.service.ServiceException;
import by.jwd.task03polymorphism.service.impl.FindByCoffeeTypeServiceImpl;

@RunWith(JUnitPlatform.class)
@SelectPackages({ "test.jwd.task03polymorphism.service", "test.jwd.task03polymorphism.dao" })

class FindByCoffeeTypeTest {

	static FindByParameterService<String> service = new FindByCoffeeTypeServiceImpl();

	@ParameterizedTest
	@MethodSource("dataProvider")
	void testFindByCoffeeTypePositive(List<ItemOfCoffee> actual, List<ItemOfCoffee> expected) throws ServiceException {
		Assertions.assertEquals(actual, expected);
	}

	static Stream<Arguments> dataProvider() throws ServiceException {

		List<ItemOfCoffee> assortment = new ArrayList<>();
		VanOfCoffee van;

		CoffeeBean coffeeBean1 = new CoffeeBean("арабика", "Lavazza", "средняя", 70.5, 500);
		Packing pack1 = new Packing("пластиковая банка", 5.5, 0.500, 10);
		ItemOfCoffee item1 = new ItemOfCoffee(coffeeBean1, pack1);

		CoffeeBean coffeeBean2 = new CoffeeBean("арабика", "Lavazza", "темная", 69.0, 1000);
		Packing pack2 = new Packing("бумажный пакет", 2.5, 1.1, 2);
		ItemOfCoffee item2 = new ItemOfCoffee(coffeeBean2, pack2);

		GroundCoffee ground3 = new GroundCoffee("робуста", "Jardin", "темная", 38.0, 500, "мелкий");
		Packing pack3 = new Packing("пресованная пачка", 3.75, 0.50, 3);
		ItemOfCoffee item3 = new ItemOfCoffee(ground3, pack3);

		GroundCoffee ground4 = new GroundCoffee("либерика", "Jardin", "средняя", 42.0, 250, "средний");
		Packing pack4 = new Packing("пресованная пачка", 3.75, 0.50, 3);
		ItemOfCoffee item4 = new ItemOfCoffee(ground4, pack4);

		InstantCoffee instant5 = new InstantCoffee("арабика", "Nescafe", "светлая", 25.0, 125, "сублимированный");
		Packing pack5 = new Packing("стеклянная банка", 7.0, 0.150, 10);
		ItemOfCoffee item5 = new ItemOfCoffee(instant5, pack5);

		assortment.add(item1);
		assortment.add(item2);
		assortment.add(item3);
		assortment.add(item4);
		assortment.add(item5);

		van = new VanOfCoffee(assortment);

		List<ItemOfCoffee> resultAssortment1 = new ArrayList<>();
		resultAssortment1.add(item3);
		resultAssortment1.add(item4);

		List<ItemOfCoffee> resultAssortment2 = new ArrayList<>();
		resultAssortment2.add(item1);
		resultAssortment2.add(item2);

		List<ItemOfCoffee> resultAssortment3 = new ArrayList<>();
		resultAssortment3.add(item5);

		List<ItemOfCoffee> resultAssortment4 = new ArrayList<>();
		List<ItemOfCoffee> resultAssortment5 = new ArrayList<>();

		List<ItemOfCoffee> actual1 = service.find("молотый", van);
		List<ItemOfCoffee> expected1 = resultAssortment1;

		List<ItemOfCoffee> actual2 = service.find("зерновой", van);
		List<ItemOfCoffee> expected2 = resultAssortment2;

		List<ItemOfCoffee> actual3 = service.find("растворимый", van);
		List<ItemOfCoffee> expected3 = resultAssortment3;

		List<ItemOfCoffee> actual4 = service.find("", van);
		List<ItemOfCoffee> expected4 = resultAssortment4;

		List<ItemOfCoffee> actual5 = service.find("typeDoesNotExist", van);
		List<ItemOfCoffee> expected5 = resultAssortment5;

		return Stream.of(Arguments.of(actual1, expected1), Arguments.of(actual2, expected2),
				Arguments.of(actual3, expected3), Arguments.of(actual4, expected4), Arguments.of(actual5, expected5));
	}

	@Test
	void testByCoffeeTypeNegative() throws ServiceException {
		assertThrows(ServiceException.class, () -> {
			List<ItemOfCoffee> sortedAssortment = new ArrayList<>();
			CoffeeBean coffeeBean = new CoffeeBean("арабика", "Lavazza", "средняя", 0, 300);
			Packing pack = new Packing("пластиковая банка", 5.0, 0.500, 5);
			ItemOfCoffee item = new ItemOfCoffee(coffeeBean, pack);
			sortedAssortment.add(item);
			VanOfCoffee van = new VanOfCoffee(sortedAssortment);
			service.find("sortDoesNotExist", van);
		});
	}
}