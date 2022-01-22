package by.jwd.task04repository.service.specification.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import by.jwd.task04repository.entity.IEllipse;
import by.jwd.task04repository.service.specification.CompositeSpecification;

/**
 * Specifies whether the enity <T extends IEllipse> is in the first quadrant of
 * the Cartesian coordinate system
 * 
 * @author Evlashkina
 */
public class FindFirstQuadrantEllipseSpecificationImpl<T extends IEllipse> extends CompositeSpecification<T> {

	static Logger logger = LogManager.getLogger(FindFirstQuadrantEllipseSpecificationImpl.class);

	@Override
	public boolean isSpecified(T ellipse) {
		return (ellipse.getFirstPoint().getX() >= 0 && ellipse.getFirstPoint().getY() >= 0
				&& (ellipse.getSecondPoint().getX() >= 0 && ellipse.getSecondPoint().getY() >= 0));
	}
}