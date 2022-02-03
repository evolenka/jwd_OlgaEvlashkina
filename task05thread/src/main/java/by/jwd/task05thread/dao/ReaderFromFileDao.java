package by.jwd.task05thread.dao;

import java.io.BufferedReader;
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

/**
 * Reads all lines of file and returns them as List<T>
 * 
 * @param fileName
 * @return List<T> containing of contents of the lines from text
 *         file
 * @throws DaoException if file is invalid
 */


public class ReaderFromFileDao {
	
	static Logger logger = LogManager.getLogger(ReaderFromFileDao.class);

	public List <String> readDataFromFile(String fileName) throws DaoException {

		File file;
		
		try {
			URL res = getClass().getClassLoader().getResource(fileName);
			file = Paths.get(res.toURI()).toFile();
			logger.debug ("file has been found: {}", Thread.currentThread().getName());
			
		} catch (URISyntaxException e) {
			throw new DaoException();
		}
		

		String str = null;
		List<String> param = new ArrayList <>();

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			while ((str = br.readLine()) != null) {
				param.add(str);
			}
			logger.debug ("file has been read: {}", Thread.currentThread().getName());
			return param;

		} catch (IOException | NullPointerException e) {
			throw new DaoException();
		}
	}
}
