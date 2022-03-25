package by.jwd.task04repository.service.specification.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task04repository.entity.FigureType;
import by.jwd.task04repository.entity.IEllipse;
import by.jwd.task04repository.service.specification.CompositeSpecification;

/**
 * Specifies whether the id of the enity <T extends IEllipse> matches the given id 
 *   
 * @author Evlashkina
 */

public class FindByNameSpecificationImpl<T extends IEllipse> extends CompositeSpecification<T> {

	static Logger logger = LogManager.getLogger(FindByNameSpecificationImpl.class);

	private FigureType name;

	public FindByNameSpecificationImpl(FigureType name) {
		super();
		this.name = name;
	}

	@Override
	public boolean isSpecified(T ellipse) {
		return ellipse.getName() == name;
	}
}