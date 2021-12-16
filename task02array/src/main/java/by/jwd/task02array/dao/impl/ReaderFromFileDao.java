package by.jwd.task02array.dao.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import by.jwd.task02array.dao.DaoException;


public class ReaderFromFileDao {

	public String[] readDataFromFile(File file) throws DaoException {

		String str = null;
		String[] param = null;

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {

			while ((str = br.readLine()) != null) {
				param = str.split(",");
			}

			return param;
		} catch (IOException e) {
			throw new DaoException();
		}
	}
}