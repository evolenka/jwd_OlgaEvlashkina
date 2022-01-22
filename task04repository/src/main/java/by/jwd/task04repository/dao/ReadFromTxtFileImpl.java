package by.jwd.task04repository.dao;

import java.util.List;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.nio.file.Files;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Implements inteface ReadFromFile, allows to read all lines of txt file and
 * return them as List<String>
 * 
 * @author Evlashkina
 * @param fileName
 * @return List<String> containing of contents of the lines from text file
 * @throws DaoException if file is invalid
 */

public class ReadFromTxtFileImpl implements ReadFromFile<String> {

	static Logger logger = LogManager.getLogger(ReadFromTxtFileImpl.class);

	@Override
	public List<String> read(String fileName) throws DaoException {

		List<String> param;

		try {
			URL res = getClass().getClassLoader().getResource(fileName);
			param = Files.readAllLines(Paths.get(res.toURI()));
		} catch (URISyntaxException | NullPointerException | IOException e) {
			throw new DaoException();
		}
		logger.debug("File read");
		return param;
	}
}