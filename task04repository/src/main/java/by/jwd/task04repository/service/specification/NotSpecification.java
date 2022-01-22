package by.jwd.task04repository.service.specification;


public class NotSpecification<T> extends CompositeSpecification<T> {

	private FindSpecification<T> specification;

	public NotSpecification(FindSpecification<T> specification) {
		super();
		this.specification = specification;
	}

	@Override
	public boolean isSpecified(T entity) {
		return !specification.isSpecified(entity);
	}
}