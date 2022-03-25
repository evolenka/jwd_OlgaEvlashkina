package by.jwd.task04repository.service.specification;

import java.util.Comparator;

public interface SortSpecification<T> {

	public Comparator<T> findComparator();
}