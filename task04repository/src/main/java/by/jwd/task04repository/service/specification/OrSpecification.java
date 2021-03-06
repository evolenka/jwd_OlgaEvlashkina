package by.jwd.task04repository.service.specification;

import by.jwd.task04repository.service.ServiceException;

public class OrSpecification <T> extends CompositeSpecification<T> {

	private FindSpecification<T> left;
	private FindSpecification<T> right;

	public OrSpecification(FindSpecification<T> left, FindSpecification<T> right) {
		super();
		this.left = left;
		this.right = right;
	}

	@Override
	public boolean isSpecified(T entity) throws ServiceException {
		return left.isSpecified(entity) || right.isSpecified(entity);
	}
}