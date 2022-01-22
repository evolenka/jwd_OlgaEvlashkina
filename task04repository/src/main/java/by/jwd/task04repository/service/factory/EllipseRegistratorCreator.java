package by.jwd.task04repository.service.factory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task04repository.entity.EllipseRegistrator;
import by.jwd.task04repository.entity.IEllipse;
import by.jwd.task04repository.service.ServiceException;
import by.jwd.task04repository.service.impl.EllipsePerimeterCalculationImpl;
import by.jwd.task04repository.service.impl.EllipseSquareCalculationImpl;

/**
 * Creates object of EllipseRegistrator, containing the perimeter and the square
 * of the ellipse, which is observed by EllipseRegistrator for updates
 * 
 * @author Evlashkina
 * @param T
 * @return <T extends IEllipse>
 */

public class EllipseRegistratorCreator {

	static Logger logger = LogManager.getLogger(EllipseRegistratorCreator.class);

	public <T extends IEllipse> EllipseRegistrator create(T ellipseToObserve) throws ServiceException {

		double perimeter = new EllipsePerimeterCalculationImpl<>().calculate(ellipseToObserve);
		double square = new EllipseSquareCalculationImpl<>().calculate(ellipseToObserve);
		Long id = ellipseToObserve.getId();

		EllipseRegistrator registrator = new EllipseRegistrator(id, perimeter, square);
		logger.debug("ellipseRegistrator is created");

		return registrator;
	}
}