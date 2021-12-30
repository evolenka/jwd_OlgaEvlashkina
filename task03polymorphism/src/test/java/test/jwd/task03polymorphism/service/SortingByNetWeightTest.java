package test.jwd.task03polymorphism.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

import by.jwd.task03polymorphism.entity.CoffeeBean;
import by.jwd.task03polymorphism.entity.GroundCoffee;
import by.jwd.task03polymorphism.entity.InstantCoffee;
import by.jwd.task03polymorphism.entity.ItemOfCoffee;
import by.jwd.task03polymorphism.entity.Packing;
import by.jwd.task03polymorphism.entity.VanOfCoffee;
import by.jwd.task03polymorphism.service.ServiceException;
import by.jwd.task03polymorphism.service.SortingService;
import by.jwd.task03polymorphism.service.impl.SortingByNetWeightServiceImpl;

@RunWith(JUnitPlatform.class)
@SelectPackages({ "test.jwd.task03polymorphism.service", "test.jwd.task03polymorphism.dao" })

class SortingByNetWeightTest {

	SortingService service = new SortingByNetWeightServiceImpl();

	List<ItemOfCoffee> assortment = new ArrayList<>();
	List<ItemOfCoffee> sortedAssortment = new ArrayList<>();
	VanOfCoffee van;

	@Test
	void testSortingByNetWeight() throws ServiceException {

		CoffeeBean coffeeBean = new CoffeeBean("арабика", "Lavazza", "средняя", 70.5, 300);
		Packing pack1 = new Packing("пластиковая банка", 5.0, 0.500, 5);
		ItemOfCoffee item1 = new ItemOfCoffee(coffeeBean, pack1);

		GroundCoffee ground = new GroundCoffee("робуста", "Lavazza", "темная", 60.0, 500, "крупный");
		Packing pack2 = new Packing("пресованная пачка", 3.0, 0.500, 2);
		ItemOfCoffee item2 = new ItemOfCoffee(ground, pack2);

		InstantCoffee instant = new InstantCoffee("робуста", "Nescafe", "средняя", 40.5, 250, "порошковый");
		Packing pack3 = new Packing("стеклянная банка", 5.0, 0.250, 7);
		ItemOfCoffee item3 = new ItemOfCoffee(instant, pack3);

		InstantCoffee instant2 = new InstantCoffee("либерика", "Lavazza", "cветлая", 50.5, 500, "гранулированный");
		Packing pack4 = new Packing("пластиковая банка", 5.0, 0.250, 7);
		ItemOfCoffee item4 = new ItemOfCoffee(instant2, pack4);

		GroundCoffee ground2 = new GroundCoffee("робуста", "Nescafe", "темная", 68.5, 1000, "мелкий");
		Packing pack5 = new Packing("стеклянная банка", 5.0, 0.250, 7);
		ItemOfCoffee item5 = new ItemOfCoffee(ground2, pack5);

		CoffeeBean coffeeBean2 = new CoffeeBean("арабика", "Pauling", "средняя", 80.5, 100);
		Packing pack6 = new Packing("чалды", 5.0, 0.01, 1);
		ItemOfCoffee item6 = new ItemOfCoffee(coffeeBean2, pack6);

		assortment.add(item1);
		assortment.add(item2);
		assortment.add(item3);
		assortment.add(item4);
		assortment.add(item5);
		assortment.add(item6);

		van = new VanOfCoffee(assortment);

		sortedAssortment.add(item6);
		sortedAssortment.add(item3);
		sortedAssortment.add(item1);
		sortedAssortment.add(item2);
		sortedAssortment.add(item4);
		sortedAssortment.add(item5);

		List<ItemOfCoffee> actual = service.sort(van);
		List<ItemOfCoffee> expected2 = sortedAssortment;
		Assertions.assertEquals(actual, expected2);
	}

}