package test.jwd.task03polymorphism.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
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
import by.jwd.task03polymorphism.service.impl.FindBySeveralParametersServiceImpl;

@RunWith(JUnitPlatform.class)
@SelectPackages({ "test.jwd.task03polymorphism.service", "test.jwd.task03polymorphism.dao" })

class FindBySeveralParametersTest {

	static FindByParameterService<String[]> service = new FindBySeveralParametersServiceImpl();

	@ParameterizedTest
	@MethodSource("dataProvider")
	void testFindBySeveralParameters(List<ItemOfCoffee> actual, List<ItemOfCoffee> expected) throws ServiceException {
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
		Packing pack3 = new Packing("прессованная пачка", 3.75, 0.50, 3);
		ItemOfCoffee item3 = new ItemOfCoffee(ground3, pack3);

		GroundCoffee ground4 = new GroundCoffee("либерика", "Jardin", "средняя", 42.0, 250, "средний");
		Packing pack4 = new Packing("прессованная пачка", 3.75, 0.50, 3);
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

		List<ItemOfCoffee> resultAssortment2 = new ArrayList<>();
		resultAssortment2.add(item2);

		List<ItemOfCoffee> resultAssortment3 = new ArrayList<>();
		resultAssortment3.add(item2);
		
		List<ItemOfCoffee> resultAssortment4 = new ArrayList<>();
		resultAssortment4.add(item4);

		String[] param1 = { "", "", "Jardin", "1", "", "", "", "", "", "" };
		String[] param2 = { "", "1", "", "1", "", "", "", "", "", "" };
		String[] param3 = { "", "", "", "1", "", "550", "", "", "", "" };
		String[] param4 = { "", "3", "", "", "", "", "", "", "", "2" };

		List<ItemOfCoffee> actual1 = service.find(param1, van);
		List<ItemOfCoffee> expected1 = resultAssortment1;

		List<ItemOfCoffee> actual2 = service.find(param2, van);
		List<ItemOfCoffee> expected2 = resultAssortment2;

		List<ItemOfCoffee> actual3 = service.find(param3, van);
		List<ItemOfCoffee> expected3 = resultAssortment3;
		
		List<ItemOfCoffee> actual4 = service.find(param4, van);
		List<ItemOfCoffee> expected4 = resultAssortment4;

		return Stream.of(Arguments.of(actual1, expected1), Arguments.of(actual2, expected2),
				Arguments.of(actual3, expected3), Arguments.of(actual4, expected4));
	}

}
