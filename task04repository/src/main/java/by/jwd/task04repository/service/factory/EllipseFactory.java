package by.jwd.task04repository.service.factory;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task04repository.dao.DaoException;
import by.jwd.task04repository.dao.DaoFactory;
import by.jwd.task04repository.entity.EllipseToObserve;
import by.jwd.task04repository.entity.IEllipse;
import by.jwd.task04repository.entity.Point;
import by.jwd.task04repository.service.ParseDataForEllipse;
import by.jwd.task04repository.service.ServiceException;

/**
 * Creates list of valid ellipses using data from file (".txt" or ".json")
 * 
 * 
 * @author Evlashkina
 * @param fileName
 * @return List<IEllipse>
 */

public class EllipseFactory {

	static Logger logger = LogManager.getLogger(EllipseFactory.class);

	DaoFactory daofactory = DaoFactory.getInstance();

	private static final int COORDINATE_QUANTITY = 4;

	public List<IEllipse> createListOfEllipsesFromFile(String fileName) throws ServiceException {
		List<IEllipse> allEllipse = new ArrayList<>();

		try {
			String[] temp = fileName.split("\\.");

			String fileType = temp[1];
			logger.debug("file type {}", fileType);
			
			if (fileType.equals("json")) {
				logger.debug("start reading json file");
				
				allEllipse = daofactory.getReadFromJson().read(fileName);
				logger.debug("list of ellipses is ready to be saved to repository");
				
			} else if (fileType.equals("txt")) {
				logger.debug("start reading txt file");
				
				List<String> param = daofactory.getReadFromTxt().read(fileName);
				List<Double> coordinates = new ParseDataForEllipse().parseCoordinates(param);
				EllipseCreator creator = new EllipseCreator();

				if (coordinates != null) {
					logger.debug("start creating list of ellipses");

					for (int i = 0; i < coordinates.size(); i += COORDINATE_QUANTITY) {

						Point firstPoint = new Point(coordinates.get(i), coordinates.get(i + 1));
						Point secondPoint = new Point(coordinates.get(i + 2), coordinates.get(i + 3));

						IEllipse ellipse = creator.createEllipse(firstPoint, secondPoint);

						if (ellipse != null) {
							IEllipse ellipseToObserve = new EllipseToObserve(ellipse);
							logger.debug("ellipseToObserve is created");
							allEllipse.add(ellipseToObserve);
						}
					}

				} else {
					logger.error("list of ellipses is null");
					allEllipse = null;
				}
				logger.debug("list of ellipses is ready to be saved to repository");
			} else {
			   	throw new ServiceException("wrong file type");
			}
		} catch (DaoException e) {
			throw new ServiceException();

		}
		return allEllipse;
	}
}