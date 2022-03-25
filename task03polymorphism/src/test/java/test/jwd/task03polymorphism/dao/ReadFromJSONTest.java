package test.jwd.task03polymorphism.dao;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

import by.jwd.task03polymorphism.dao.DaoException;
import by.jwd.task03polymorphism.dao.ReadFromJSONDao;
import by.jwd.task03polymorphism.entity.BeanCoffee;
import by.jwd.task03polymorphism.entity.GroundCoffee;
import by.jwd.task03polymorphism.entity.InstantCoffee;
import by.jwd.task03polymorphism.entity.ItemOfCoffee;
import by.jwd.task03polymorphism.entity.Packing;
import by.jwd.task03polymorphism.service.GrossWeightCalculation;
import by.jwd.task03polymorphism.service.TotalPriceCalculation;

@RunWith(JUnitPlatform.class)
@SelectPackages({ "test.jwd.task03polymorphism.service", "test.jwd.task03polymorphism.dao" })

class ReadFromJSONTest {

	ReadFromJSONDao dao = new ReadFromJSONDao();

	List<ItemOfCoffee> assortment = new ArrayList<>();
	TotalPriceCalculation priceCalc = new TotalPriceCalculation();
	GrossWeightCalculation weightCalc = new GrossWeightCalculation();

	@Test
	void testReadFromJSONPositive() throws DaoException {

		BeanCoffee coffee1 = new BeanCoffee("арабика", "Lavazza", "средняя", 70.5, 500);
		Packing pack1 = new Packing("пластиковая банка", 5.5, 0.500, 10);
		ItemOfCoffee item1 = new ItemOfCoffee(coffee1, pack1, priceCalc.calculate(coffee1),
				weightCalc.calculate(coffee1, pack1));

		BeanCoffee coffee2 = new BeanCoffee("арабика", "Lavazza", "темная", 69.0, 1000);
		Packing pack2 = new Packing("бумажный пакет", 2.5, 1.1, 2);
		ItemOfCoffee item2 = new ItemOfCoffee(coffee2, pack2, priceCalc.calculate(coffee2),
				weightCalc.calculate(coffee2, pack2));

		GroundCoffee ground3 = new GroundCoffee("робуста", "Jardin", "темная", 38.0, 500, "мелкий");
		Packing pack3 = new Packing("прессованная пачка", 3.75, 0.50, 3);
		ItemOfCoffee item3 = new ItemOfCoffee(ground3, pack3, priceCalc.calculate(ground3),
				weightCalc.calculate(ground3, pack3));

		GroundCoffee ground4 = new GroundCoffee("либерика", "Jardin", "средняя", 42.0, 250, "средний");
		Packing pack4 = new Packing("прессованная пачка", 3.75, 0.50, 3);
		ItemOfCoffee item4 = new ItemOfCoffee(ground4, pack4, priceCalc.calculate(ground4),
				weightCalc.calculate(ground4, pack4));

		InstantCoffee instant5 = new InstantCoffee("арабика", "Nescafe", "светлая", 25.0, 125, "сублимированный");
		Packing pack5 = new Packing("стеклянная банка", 7.0, 0.150, 10);
		ItemOfCoffee item5 = new ItemOfCoffee(instant5, pack5, priceCalc.calculate(instant5),
				weightCalc.calculate(instant5, pack5));

		assortment.add(item1);
		assortment.add(item2);
		assortment.add(item3);
		assortment.add(item4);
		assortment.add(item5);

		List<ItemOfCoffee> actual = dao.readDataFromFile("dataTest.json");
		List<ItemOfCoffee> expected = assortment;
		Assertions.assertEquals(actual, expected);
	}

	@Test
	void testReadFromJSONNegative() throws DaoException {

		assertThrows(DaoException.class, () -> {
			List<ItemOfCoffee> actual = dao.readDataFromFile("FileNotExist.json");
			List<ItemOfCoffee> expected = assortment;
			Assertions.assertEquals(actual, expected);
		});
	}
}
