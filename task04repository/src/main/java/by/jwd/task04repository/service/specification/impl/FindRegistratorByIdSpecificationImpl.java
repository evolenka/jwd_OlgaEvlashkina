package by.jwd.task04repository.service.specification.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task04repository.entity.EllipseRegistrator;
import by.jwd.task04repository.service.specification.CompositeSpecification;

/**
 * Specifies whether the id of the enity <T extends IEllipseRegistrator> matches
 * the given id
 * 
 * @author Evlashkina
 */
public class FindRegistratorByIdSpecificationImpl<T extends EllipseRegistrator> extends CompositeSpecification<T> {

	static Logger logger = LogManager.getLogger(FindRegistratorByIdSpecificationImpl.class);

	private long id;

	public FindRegistratorByIdSpecificationImpl(long id) {
		super();
		this.id = id;
	}

	@Override
	public boolean isSpecified(T registrator) {
		return registrator.getId() == id;
	}
}