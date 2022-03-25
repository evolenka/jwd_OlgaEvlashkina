package by.jwd.task04repository.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;
import javax.json.stream.JsonParser;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task04repository.entity.EllipseToObserve;
import by.jwd.task04repository.entity.IEllipse;
import by.jwd.task04repository.entity.Point;
import by.jwd.task04repository.service.ServiceException;
import by.jwd.task04repository.service.factory.EllipseCreator;

/**
 * Implements inteface ReadFromFile, reads json file and returns java objects as
 * List<IEllipse>
 * 
 * @author Evlashkina
 * @param fileName
 * @return List<IEllipse>
 * @throws DaoException if file is not found or does not validate json format
 */

public class ReadFromJsonFileImpl implements ReadFromFile<IEllipse> {

	static Logger logger = LogManager.getLogger(ReadFromJsonFileImpl.class);

	@Override
	public List<IEllipse> read(String fileName) throws DaoException, ServiceException {

		List<IEllipse> allEllipse = new ArrayList<>();

		try {
			URL res = getClass().getClassLoader().getResource(fileName);

			try (JsonParser parser = Json.createParser(new FileReader(Paths.get(res.toURI()).toFile()))) {

				logger.debug("start parsing json file");

				parser.next();

				JsonArray objects = parser.getArray();

				logger.debug("start invoke ellipse");

				for (JsonValue o : objects) {

					JsonObject tryEllipse = (JsonObject) o;

					logger.debug("start invoke points");
					JsonObject point1 = (JsonObject) tryEllipse.get("firstPoint");
					JsonObject point2 = (JsonObject) tryEllipse.get("secondPoint");

					if (!(tryParseDouble(point1.get("x").toString())) || !(tryParseDouble(point1.get("y").toString()))
							|| !(tryParseDouble(point2.get("x").toString()))
							|| !(tryParseDouble(point2.get("y").toString()))) {
						logger.error("wrong data format of point coordinates");
						continue;
					}

					Double x1 = Double.parseDouble(point1.get("x").toString());
					logger.debug("x1 {} ", x1);

					Double y1 = Double.parseDouble(point1.get("y").toString());
					logger.debug("y1 {}", y1);

					Point firstPoint = new Point(x1, y1);
					logger.debug("firstPoint is created");

					Double x2 = Double.parseDouble(point2.get("x").toString());
					logger.debug("x2 {} ", x2);

					Double y2 = Double.parseDouble(point2.get("y").toString());
					logger.debug("y2 {} ", y2);

					Point secondPoint = new Point(x2, y2);

					EllipseCreator creator = new EllipseCreator();
					IEllipse ellipse = creator.createEllipse(firstPoint, secondPoint);
					logger.debug("ellipse is created");

					if (ellipse != null) {
						IEllipse ellipseToObserve = new EllipseToObserve(ellipse);
						logger.debug("ellipseToObserve is created");
						allEllipse.add(ellipseToObserve);
					}
				}
			}

		} catch (URISyntaxException | NullPointerException | FileNotFoundException e) {
			throw new DaoException();
		}

		return allEllipse;
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