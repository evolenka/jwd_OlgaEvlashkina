package by.jwd.task04repository.service.specification;

public interface FindSpecification<T>{
	
	public abstract boolean isSpecified(T entity);

	public FindSpecification<T> and(FindSpecification<T> other);

	public FindSpecification<T> or(FindSpecification<T> other);

	public FindSpecification<T> not();
}