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

import by.jwd.task03polymorphism.entity.Coffee;
import by.jwd.task03polymorphism.entity.ItemOfCoffee;
import by.jwd.task03polymorphism.entity.Packing;
import by.jwd.task03polymorphism.service.CoffeeCreator;
import by.jwd.task03polymorphism.service.GrossWeightCalculation;
import by.jwd.task03polymorphism.service.TotalPriceCalculation;

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
		} catch (URISyntaxException | NullPointerException e1) {
			throw new DaoException();
		}

		JSONParser parser = new JSONParser();

		try {
			logger.debug("start parsing");

			Object obj = parser.parse(new FileReader(file));

			JSONArray jsonObjects = (JSONArray) obj;

			for (Object o : jsonObjects) {

				JSONObject item = (JSONObject) o;

				logger.debug("start invoke coffeeItem");
				JSONObject coffeeItem = (JSONObject) item.get("coffee");

				Coffee coffee = null;
				CoffeeCreator creator = new CoffeeCreator();

				String title = (String) coffeeItem.get("title");
				logger.debug("title{}", title);

				String trademark = (String) coffeeItem.get("trademark");
				logger.debug("trademark {}", trademark);

				String sort = (String) coffeeItem.get("sort");
				logger.debug("sort {}", sort);

				String roastDegree = (String) coffeeItem.get("roastDegree");
				logger.debug("roastDegree {}", roastDegree);

				double pricePerKg = (double) coffeeItem.get("pricePerKg");
				logger.debug("pricePerKg {}", pricePerKg);

				int netWeight = (int) (long) coffeeItem.get("netWeight");
				logger.debug("netWeight {}", netWeight);

				String grindingDegree = (String) coffeeItem.get("grindingDegree");
				logger.debug("grindingDegree {}", grindingDegree);

				String shape = (String) coffeeItem.get("shape");
				logger.debug("shape {}", shape);

				coffee = creator.create(title, sort, trademark, roastDegree, pricePerKg, netWeight, grindingDegree,
						shape);

				logger.debug("invoke packing");

				JSONObject pack = (JSONObject) item.get("packing");
				Packing packing = null;

				String type = (String) pack.get("type");
				double price = (double) pack.get("price");
				double volume = (double) pack.get("volume");
				int weight = (int) (long) pack.get("weight");

				if (price < 0 || weight < 0) {
					throw new IllegalArgumentException();
				}
				packing = new Packing(type, price, volume, weight);

				TotalPriceCalculation priceCalc = new TotalPriceCalculation();
				GrossWeightCalculation weightCalc = new GrossWeightCalculation();

				assortment.add(new ItemOfCoffee(coffee, packing, priceCalc.calculate(coffee),
						weightCalc.calculate(coffee, packing)));
			}

			return assortment;
		} catch (IOException | ParseException | IllegalArgumentException e) {
			throw new DaoException();
		}
	}
}
