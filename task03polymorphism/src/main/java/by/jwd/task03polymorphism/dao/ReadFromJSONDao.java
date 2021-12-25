package by.jwd.task03polymorphism.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import by.jwd.task03polymorphism.entity.CoffeeBean;
import by.jwd.task03polymorphism.entity.GroundCoffee;
import by.jwd.task03polymorphism.entity.InstantCoffee;
import by.jwd.task03polymorphism.entity.ItemOfCoffee;
import by.jwd.task03polymorphism.entity.Packing;

public class ReadFromJSONDao {

	/**
	 * @return
	 * @throws DaoException
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws CoffeeBean            coffee
	 */

	public List<ItemOfCoffee> readDataFromFile() throws DaoException {

		List<ItemOfCoffee> assortment = new ArrayList<>();

		File file;
		try {
			URL res = getClass().getClassLoader().getResource("r.json");
			file = Paths.get(res.toURI()).toFile();
		} catch (URISyntaxException e) {
			throw new DaoException();
		}

		JSONParser parser = new JSONParser();

		try {
			JSONArray arr = (JSONArray) parser.parse(new FileReader(file));
			
			CoffeeBean coffee = null;
			Packing packing = null;

			for (Object o : arr) {

				JSONObject item = (JSONObject) o;

				String title = (String) item.get("title");
				String trademark = (String) item.get("trademark");
				String sort = (String) item.get("sort");
				String roastDegree = (String) item.get("roastDegree");
				Double pricePerKg = (Double) item.get("pricePerKg");
				int netWeight = Integer.parseInt((String) item.get("netWeight"));

				if (title.equals("молотый")) {
					String grindingDegree = (String) item.get("grindingDegree");
					coffee = new GroundCoffee(sort, trademark, roastDegree, pricePerKg, netWeight, grindingDegree);
				}

				else if(title.equals("растворимый")) {
					String shape = (String) item.get("shape");
					coffee = new InstantCoffee(sort, trademark,roastDegree, pricePerKg, netWeight, shape);
				}

				else {
					coffee = new CoffeeBean(sort, trademark, roastDegree, pricePerKg, netWeight);
				}

				JSONArray pack = (JSONArray) item.get("packing");

				for (Object p : pack) {
					JSONObject packingObj = (JSONObject) p;

					String type = (String) packingObj.get("type");
					Double price = (Double) packingObj.get("price");
					Double volume = (Double) packingObj.get("volume");
					int weight = Integer.parseInt((String) packingObj.get("weight"));

					packing = new Packing(type, price, volume, weight);
				}

				assortment.add(new ItemOfCoffee(coffee, packing));

			}
			return assortment;

		} catch (IOException | ParseException e) {
			throw new DaoException();
		}
	}
}
