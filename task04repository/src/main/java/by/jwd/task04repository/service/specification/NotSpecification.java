package by.jwd.task04repository.service.specification;

import by.jwd.task04repository.service.ServiceException;

public class NotSpecification<T> extends CompositeSpecification<T> {

	private FindSpecification<T> specification;

	public NotSpecification(FindSpecification<T> specification) {
		super();
		this.specification = specification;
	}

	@Override
	public boolean isSpecified(T entity) throws ServiceException {
		return !specification.isSpecified(entity);
	}
}