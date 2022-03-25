package by.jwd.task04repository.service.specification;

public abstract class CompositeSpecification<T> implements FindSpecification<T> {

	@Override
	public FindSpecification<T> and(FindSpecification<T> other) {
		return new AndSpecification<>(this, other);
	}

	@Override
	public FindSpecification<T> or(FindSpecification<T> other) {
		return new OrSpecification<>(this, other);
	}

	@Override
	public FindSpecification<T> not() {
		return new NotSpecification<>(this);
	}
}
