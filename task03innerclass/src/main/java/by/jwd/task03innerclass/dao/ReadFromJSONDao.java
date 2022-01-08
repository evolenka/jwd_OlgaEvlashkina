package by.jwd.task03innerclass.dao;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import by.jwd.task03innerclass.entity.Good;
import by.jwd.task03innerclass.entity.Shop;
import by.jwd.task03innerclass.entity.Shop.Department;

/**
 * Read data from json file
 * 
 * @author evlashkina
 * @version 1
 * @param filename
 * @return Shop
 * @exception DaoException
 */

public class ReadFromJSONDao {
	
	static Logger logger = LogManager.getLogger(ReadFromJSONDao.class);

	public Shop readDataFromJSON(String fileName) throws DaoException {
		
		
		List<Department> listOfDepartment = new ArrayList<>();
		Shop shop = new Shop(listOfDepartment);

		File file;

		try {
			URL res = getClass().getClassLoader().getResource(fileName);
			file = Paths.get(res.toURI()).toFile();
		} catch (URISyntaxException | NullPointerException e) {
			throw new DaoException();
		}

		JSONParser parser = new JSONParser();

		try {
            logger.debug("start parse");
			Object obj = parser.parse(new FileReader(file));

			JSONArray jsonObjects = (JSONArray) obj;
			
			logger.debug("parse department object");
			for (int i = 0; i < jsonObjects.size(); i++) {

				List<Good> assortment = new ArrayList<>();

				JSONObject departmentObject = (JSONObject) jsonObjects.get(i);

				String name = (String) departmentObject.get("name");

				JSONArray assortmentObject = (JSONArray) departmentObject.get("assortment");
				
				logger.debug("parse assortment");
				for (int j = 0; j < assortmentObject.size(); j++) {

					JSONObject goodObject = (JSONObject) assortmentObject.get(j);

					String title = (String) goodObject.get("title");
					String trademark = (String) goodObject.get("trademark");
					Double price = (Double) goodObject.get("price");
					int quantity = (int) (long) goodObject.get("quantity");

					Good good = new Good(title, trademark, price, quantity);
					assortment.add(good);

				}
				logger.debug("create department");
				Shop.Department department = shop.new Department(name, assortment);
				listOfDepartment.add(department);
			}
			
			return shop;
		} catch (IOException | ParseException e) {
			throw new DaoException();
		}
	}
}
