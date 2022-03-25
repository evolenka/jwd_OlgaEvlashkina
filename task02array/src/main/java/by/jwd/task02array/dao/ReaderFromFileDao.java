package by.jwd.task02array.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

public class ReaderFromFileDao {

	public String[] readDataFromFile(String fileName) throws DaoException {

		File file;
		
		try {
			URL res = getClass().getClassLoader().getResource(fileName);
			file = Paths.get(res.toURI()).toFile();
		} catch (URISyntaxException e) {
			throw new DaoException();
		}
		

		String str = null;
		String[] param = null;

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			while ((str = br.readLine()) != null) {
				param = str.split(",");
			}
			return param;

		} catch (IOException | NullPointerException e) {
			throw new DaoException();
		}
	}
}
