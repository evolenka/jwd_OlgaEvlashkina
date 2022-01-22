package by.jwd.task04repository.service.specification.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task04repository.service.specification.CompositeSpecification;
/**
 * Specifies whether the distance which constitutes tid of the enity <T extends IEllipse> matches the given range of distance 
 *   
 * @author Evlashkina
 */
public class FindEllipseDistantFromCoordinatesOriginSpecificationImpl<T>
		extends CompositeSpecification<T> {

	static Logger logger = LogManager.getLogger(FindEllipseDistantFromCoordinatesOriginSpecificationImpl.class);
	private double distance;

	public FindEllipseDistantFromCoordinatesOriginSpecificationImpl(double distance) {
		this.distance = distance;
	}

	@Override
	public boolean isSpecified(T ellipse) {
		//TODO
		return false;
	}
}