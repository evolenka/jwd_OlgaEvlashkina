package by.jwd.task03polymorphism.dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


import com.google.gson.Gson;

import by.jwd.task03polymorphism.entity.ItemOfCoffee;

public class WriteToJSONDao {
	
	/**
	 * Write data to json file
	 * 
	 * @author evlashkina
	 * @version 1
	 * @param assortment, filename
	 * @return void
	 * @exception DaoException
	 */

	public void writeDataToJSONFile(List<ItemOfCoffee> assortment, String filename) throws DaoException {

		try (FileWriter file = new FileWriter(new File(filename))) {

			for (int i = 0; i < assortment.size(); i++) {
				Gson gson = new Gson();
				String string = gson.toJson(assortment.get(i));
				file.write(string);
			}

		} catch (IOException e) {
			throw new DaoException();
		}
	}
}
