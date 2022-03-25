package by.jwd.task04repository.service.specification;

import by.jwd.task04repository.service.ServiceException;

public interface FindSpecification<T>{
	
	public abstract boolean isSpecified(T entity) throws ServiceException;

	public FindSpecification<T> and(FindSpecification<T> other);

	public FindSpecification<T> or(FindSpecification<T> other);

	public FindSpecification<T> not();
}