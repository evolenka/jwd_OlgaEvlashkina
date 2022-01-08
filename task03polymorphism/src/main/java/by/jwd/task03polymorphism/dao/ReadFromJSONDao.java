package by.jwd.task03polymorphism.dao;

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

import by.jwd.task03polymorphism.entity.CoffeeBean;
import by.jwd.task03polymorphism.entity.GroundCoffee;
import by.jwd.task03polymorphism.entity.InstantCoffee;
import by.jwd.task03polymorphism.entity.ItemOfCoffee;
import by.jwd.task03polymorphism.entity.Packing;
import by.jwd.task03polymorphism.service.impl.FindByGrindingDegreeServiceImpl;

	/**
	 * Read data from json file
	 * 
	 * @author evlashkina
	 * @version 1
	 * @param filename
	 * @return List<ItemOfCoffee>
	 * @exception DaoException
	 */
	public class ReadFromJSONDao {
		
	static Logger logger = LogManager.getLogger(ReadFromJSONDao.class);
	
	public List<ItemOfCoffee> readDataFromFile(String fileName) throws DaoException {

		List<ItemOfCoffee> assortment = new ArrayList<>();

		File file;
		try {
			URL res = getClass().getClassLoader().getResource(fileName);
			file = Paths.get(res.toURI()).toFile();
		} catch (URISyntaxException | NullPointerException e) {
			throw new DaoException();
		}

		JSONParser parser = new JSONParser();

		try {
			logger.debug("start parsing");

			Object obj = parser.parse(new FileReader(file));

			JSONArray jsonObjects = (JSONArray) obj;

			for (Object o : jsonObjects) {

				JSONObject item = (JSONObject) o;
				
				logger.debug("parse coffeeItem");
				JSONObject coffeeItem = (JSONObject) item.get("coffee");

				CoffeeBean coffee = null;

				String title = (String) coffeeItem.get("title");
				String trademark = (String) coffeeItem.get("trademark");
				String sort = (String) coffeeItem.get("sort");
				String roastDegree = (String) coffeeItem.get("roastDegree");
				Double pricePerKg = (Double) coffeeItem.get("pricePerKg");
				int netWeight = (int) (long) coffeeItem.get("netWeight");

				if (title.equals("молотый")) {
					String grindingDegree = (String) coffeeItem.get("grindingDegree");
					coffee = new GroundCoffee(sort, trademark, roastDegree, pricePerKg, netWeight, grindingDegree);
				}

				else if (title.equals("растворимый")) {
					String shape = (String) coffeeItem.get("shape");
					coffee = new InstantCoffee(sort, trademark, roastDegree, pricePerKg, netWeight, shape);
				}

				else {
					coffee = new CoffeeBean(sort, trademark, roastDegree, pricePerKg, netWeight);
				}

				logger.debug("parse packing");
				
				JSONObject pack = (JSONObject) item.get("packing");
				Packing packing = null;

				String type = (String) pack.get("type");
				Double price = (Double) pack.get("price");
				Double volume = (Double) pack.get("volume");
				int weight = (int) (long) pack.get("weight");

				packing = new Packing(type, price, volume, weight);

				assortment.add(new ItemOfCoffee(coffee, packing));
			}

			return assortment;
		} catch (IOException | ParseException e) {
			throw new DaoException();
		}
	}
}
