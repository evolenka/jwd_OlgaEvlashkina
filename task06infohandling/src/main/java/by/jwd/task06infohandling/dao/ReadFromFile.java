package by.jwd.task06infohandling.dao;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ReadFromFile {

	static Logger logger = LogManager.getLogger(ReadFromFile.class);

	public String read(String fileName) throws DaoException {

		List<String> param;
		StringBuilder result = new StringBuilder();

		try {
			URL res = getClass().getClassLoader().getResource(fileName);
			param = Files.readAllLines(Paths.get(res.toURI()));

		} catch (URISyntaxException | NullPointerException | IOException e) {
			throw new DaoException();
		}
		logger.debug("File has been read");
		
		for (String s : param) {
			result.append(s);
		}
		return result.toString();
	}
}