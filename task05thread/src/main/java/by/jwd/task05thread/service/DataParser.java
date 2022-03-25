package by.jwd.task05thread.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 * Parses parameters from  List<String> fileData to String [] by index of line (= id thread)
 * 
 * @author evlashkina
 * @version 1
 */

public class DataParser {
	
	static Logger logger = LogManager.getLogger(DataParser.class);

	private static final DataParser instance = new DataParser();

	private DataParser() {
	}

	public static DataParser getInstance() {
		return instance;
	}

	public String[] parse(List<String> fileData, int lineIndex) {

		String[] param = fileData.get(lineIndex).split(",");

		logger.debug("params have been parsed successfully: {}", Thread.currentThread().getName());
		return param;
	}
}
