package by.jwd.task04repository.service.factory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task04repository.entity.Ellipse;
import by.jwd.task04repository.entity.FigureType;
import by.jwd.task04repository.entity.IEllipse;
import by.jwd.task04repository.entity.Point;
import by.jwd.task04repository.service.EllipseValidation;
import by.jwd.task04repository.service.ServiceException;
import by.jwd.task04repository.service.impl.EllipseOrCircle;

/**
 * Creates valid object of Ellipse based on two points, checks whether the
 * ellipse is circle or not, set new name in case it is circle
 * 
 * @author Evlashkina
 * @param firstPoint, secondPoint
 * @return IEllipse
 *
 */
public class EllipseCreator {

	static Logger logger = LogManager.getLogger(EllipseCreator.class);

	EllipseValidation validation = new EllipseValidation();
	EllipseOrCircle<IEllipse> service = new EllipseOrCircle<>();

	public IEllipse createEllipse(Point firstPoint, Point secondPoint) throws ServiceException {

		IEllipse ellipse;

		if (validation.isValid(firstPoint, secondPoint)) {
			ellipse = new Ellipse(firstPoint, secondPoint);
			logger.debug("ellipse is created");

			if (service.isTrue(ellipse)) {
				ellipse.setName(FigureType.CIRCLE);
				logger.debug("the name of ellipse is specified to circle");
			}
		} else {
			logger.error("incorrect points to make ellipse");
			ellipse = null;
		}
		return ellipse;
	}
}