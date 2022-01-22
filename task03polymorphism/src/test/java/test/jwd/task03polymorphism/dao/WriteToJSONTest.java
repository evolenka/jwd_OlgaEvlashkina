package test.jwd.task03polymorphism.dao;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

import by.jwd.task03polymorphism.dao.DaoException;
import by.jwd.task03polymorphism.dao.WriteToJSONDao;
import by.jwd.task03polymorphism.entity.BeanCoffee;
import by.jwd.task03polymorphism.entity.GroundCoffee;
import by.jwd.task03polymorphism.entity.ItemOfCoffee;
import by.jwd.task03polymorphism.entity.Packing;
import by.jwd.task03polymorphism.service.GrossWeightCalculation;
import by.jwd.task03polymorphism.service.TotalPriceCalculation;

@RunWith(JUnitPlatform.class)
@SelectPackages({ "test.jwd.task03polymorphism.service", "test.jwd.task03polymorphism.dao" })

class WriteToJSONTest {

	WriteToJSONDao write = new WriteToJSONDao();

	@Test
	void testWriteToJSON() throws DaoException, IOException, JSONException {

		List<ItemOfCoffee> assortment = new ArrayList<>();
		TotalPriceCalculation priceCalc = new TotalPriceCalculation();
		GrossWeightCalculation weightCalc = new GrossWeightCalculation();

		BeanCoffee coffeeBean1 = new BeanCoffee("арабика", "Lavazza", "средняя", 70.5, 500);
		Packing pack1 = new Packing("пластиковая банка", 5.5, 0.500, 10);
		ItemOfCoffee item1 = new ItemOfCoffee(coffeeBean1, pack1, priceCalc.calculate(coffeeBean1),
				weightCalc.calculate(coffeeBean1, pack1));

		GroundCoffee ground2 = new GroundCoffee("робуста", "Jardin", "темная", 38.0, 500, "мелкий");
		Packing pack2 = new Packing("пресованная пачка", 3.75, 0.50, 3);
		ItemOfCoffee item2 = new ItemOfCoffee(ground2, pack2, priceCalc.calculate(ground2),
				weightCalc.calculate(ground2, pack2));

		assortment.add(item1);
		assortment.add(item2);

		write.writeDataToJSONFile(assortment, "resultDataTest.json");

		String actual = FileUtils.readFileToString(new File("D:\\jwd\\task03polymorphism\\" + "resultDataTest.json"));
		String expected = "{\"coffee\":{\"title\":\"BEAN\",\"sort\":\"арабика\",\"trademark\":\"Lavazza\",\"roastDegree\":\"средняя\",\"pricePerKg\":70.5,\"netWeight\":500},\"packing\":{\"type\":\"пластиковая банка\",\"price\":5.5,\"volume\":0.5,\"weight\":10},\"totalPrice\":35.25,\"grossWeight\":510}{\"coffee\":{\"grindingDegree\":\"мелкий\",\"title\":\"молотый\",\"sort\":\"робуста\",\"trademark\":\"Jardin\",\"roastDegree\":\"темная\",\"pricePerKg\":38.0,\"netWeight\":500},\"packing\":{\"type\":\"пресованная пачка\",\"price\":3.75,\"volume\":0.5,\"weight\":3},\"totalPrice\":19.0,\"grossWeight\":503}";
		JSONAssert.assertEquals(actual, expected, JSONCompareMode.STRICT);
	}
}
