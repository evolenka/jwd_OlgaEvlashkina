package test.jwd.task03innerclass.dao;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.json.JSONException;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;
import org.junit.jupiter.api.Test;


import by.jwd.task03innerclass.dao.DaoException;
import by.jwd.task03innerclass.dao.WriteToJSONDao;
import by.jwd.task03innerclass.dao.impl.WriteAssortmentToJSONDaoImpl;
import by.jwd.task03innerclass.entity.Good;
import by.jwd.task03innerclass.entity.Shop;
import by.jwd.task03innerclass.entity.Shop.Department;

@RunWith(JUnitPlatform.class)
@SelectPackages({ "test.jwd.task03innerclass.service", "test.jwd.task03innerclass.dao" })

class WriteAssortmentToJSONTest {

	WriteToJSONDao<Good> writeAssortment = new WriteAssortmentToJSONDaoImpl();

	@Test
	void testWriteToJSON() throws DaoException, IOException, JSONException {

		List<Department> listOfDepartment = new ArrayList<>();

		Shop shop = new Shop(listOfDepartment);

		List<Good> assortment1 = new ArrayList<>();

		Department department1 = shop.new Department("cosmetics", assortment1);

		listOfDepartment.add(department1);

		Good good1 = new Good("shampoo", "Schauma", 5.59, 40);
		Good good2 = new Good("shampoo", "Syoss", 10.60, 20);

		department1.addGood(good1);
		department1.addGood(good2);

		writeAssortment.writeDataToJSONFile(assortment1, "resultDataTest.json");
					
		String actual = FileUtils.readFileToString(new File ("D:\\jwd\\task03innerclass\\" + "resultDataTest.json"));
		String expected = "{\"title\":\"shampoo\",\"trademark\":\"Schauma\",\"price\":5.59,\"quantity\":40}{\"title\":\"shampoo\",\"trademark\":\"Syoss\",\"price\":10.6,\"quantity\":20}";
		JSONAssert.assertEquals(actual, expected, JSONCompareMode.STRICT);
	}
}