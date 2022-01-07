package by.jwd.task03innerclass.dao.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;

import by.jwd.task03innerclass.dao.DaoException;
import by.jwd.task03innerclass.dao.WriteToJSONDao;


public class WriteDepartmentListToJSONDaoImpl implements WriteToJSONDao<String> {

	@Override
	public void writeDataToJSONFile(List<String> searchResult, String fileName) throws DaoException {


		try (FileWriter fileWriter = new FileWriter(new File(fileName))) {

			for (int j = 0; j < searchResult.size(); j++) {
				Gson gson = new Gson();
				String string = gson.toJson(searchResult.get(j));
				fileWriter.write(string);
			}

		} catch (IOException e) {
			throw new DaoException();
		}
	}
}