package by.jwd.task04repository.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Parse valid coordinates of points to make ellipse
 * 
 * @author Evlashkina
 *
 */

public class ParseDataForEllipse {

	static Logger logger = LogManager.getLogger(ParseDataForEllipse.class);

	private static final int COORDINATE_QUANTITY = 4;

	/**
	 * Parse valid double coordinates of points (four coordinates for two points for
	 * one ellipse) from String data
	 * 
	 * @author Evlashkina
	 * @param param
	 * @return List<Double> containing of coordinates of points to make ellipse
	 * 
	 */

	public List<Double> parseCoordinates(List<String> param) {

		List<Double> pointCoordinates = new ArrayList<>();

		String[] temp;

		if (param == null) {
			throw new NullPointerException();
		}

		for (int i = 0; i < param.size(); i++) {
			temp = param.get(i).split(" ");

			if (temp.length < COORDINATE_QUANTITY || temp.length > COORDINATE_QUANTITY) {
				logger.error("wrong quantity of coordinates in the line {}", i);
				continue;
			}

			for (String s : temp) {
				if (!(tryParseDouble(s))) {
					logger.error("wrong data format in the line {}", i);
					break;
				}

				pointCoordinates.add(Double.parseDouble(s));
			}
			logger.debug("coordinates have been read successfully, line {}", i);
		}
		return pointCoordinates;
	}

	boolean tryParseDouble(String s) {
		try {
			Double.parseDouble(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}