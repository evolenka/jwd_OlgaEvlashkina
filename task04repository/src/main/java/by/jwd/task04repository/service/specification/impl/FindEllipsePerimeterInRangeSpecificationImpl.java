package by.jwd.task04repository.service.specification.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task04repository.entity.EllipseRegistrator;
import by.jwd.task04repository.entity.IEllipse;
import by.jwd.task04repository.service.ServiceException;
import by.jwd.task04repository.service.repository.EllipseRepository;
import by.jwd.task04repository.service.specification.CompositeSpecification;

/**
 * Specifies whether the perimeter of the enity <T extends IEllipse> is in the
 * given range
 * 
 * @author Evlashkina
 */
public class FindEllipsePerimeterInRangeSpecificationImpl<T extends IEllipse> extends CompositeSpecification<T> {

	static Logger logger = LogManager.getLogger(FindEllipsePerimeterInRangeSpecificationImpl.class);

	EllipseRepository<IEllipse> repository = EllipseRepository.getInstance();

	private double[] range;

	public FindEllipsePerimeterInRangeSpecificationImpl(double[] range) {
		super();
		this.range = range;
	}

	@Override
	public boolean isSpecified(T ellipse) throws ServiceException {
		if (range.length == 2) {
			EllipseRegistrator registrator = repository.readRegistratorById(ellipse.getId());
			logger.debug("ellipse id {}", registrator);

			return (registrator.getPerimeter() >= range[0] && registrator.getPerimeter() <= range[1]);
		} else
			throw new ServiceException();
	}
}