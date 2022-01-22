package by.jwd.task04repository.service.specification;


public class AndSpecification<T> extends CompositeSpecification<T> {

	private FindSpecification<T> left;
	private FindSpecification<T> right;

	public AndSpecification(FindSpecification<T> left, FindSpecification<T> right) {
		super();
		this.left = left;
		this.right = right;
	}

	@Override
	public boolean isSpecified(T entity) {
		return left.isSpecified(entity) && right.isSpecified(entity);
	}
}