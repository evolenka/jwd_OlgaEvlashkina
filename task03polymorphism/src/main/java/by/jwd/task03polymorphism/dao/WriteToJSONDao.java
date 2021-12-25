package by.jwd.task03polymorphism.dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import by.jwd.task03polymorphism.entity.CoffeeBean;
import by.jwd.task03polymorphism.entity.GroundCoffee;
import by.jwd.task03polymorphism.entity.InstantCoffee;
import by.jwd.task03polymorphism.entity.ItemOfCoffee;
import by.jwd.task03polymorphism.entity.Packing;

public class WriteToJSONDao {

	public void writeDataToJSONFile(List<ItemOfCoffee> assortment, String filename) throws DaoException {
		
		try {
			FileWriter file = new FileWriter(new File(filename));

		
		JSONObject obj = new JSONObject();

		JSONArray Arr = new JSONArray();
for (int i = 0; i <assortment.size(); i++) {
	
		obj.put("title", assortment.get(i).getCoffee().getTitle());
		obj.put("trademark", assortment.get(i).getCoffee().getTrademark());
		obj.put("sort",  assortment.get(i).getCoffee().getSort());
		obj.put("roastDegree",  assortment.get(i).getCoffee().getRoastDegree());
		obj.put("pricePerKg",  assortment.get(i).getCoffee().getPricePerKg());
		obj.put("netWeight",  assortment.get(i).getCoffee().getNetWeight());
		
		if (assortment.get(i).getCoffee().getTitle().equals("молотый")) {
		obj.put("grindingDegree",  ((GroundCoffee) assortment.get(i).getCoffee()).getGrindingDegree());
		}
		
		if (assortment.get(i).getCoffee().getTitle().equals("растворимый")) {
			obj.put("shape",  ((InstantCoffee) assortment.get(i).getCoffee()).getShape());
			}
		
		file.write(obj.toJSONString());
}
		

//		Arr.add("JSON Array List 1");
//		Arr.add("JSON Array List 2");
//		Arr.add("JSON Array List 3");
//
//		obj.put("Remark", Arr);
//		{ "title":"зерновой",
//            "trademark":"Lavazza",
//            "sort":"Arabica",
//            "roastDegree":"средняя",
//            "pricePerKg": 30.50000,
//            "netWeight": "3500",
//            "packing": [{ 
//   			"type" : "jar",
//   			"price": 3.50000,
//   			"volume": 250.000,
//   			"weight": "2"}]
		
	
		
			file.flush();

		} catch (IOException e) {
			throw new DaoException();
		}

	}
}
