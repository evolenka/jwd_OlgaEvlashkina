package by.jwd.task04repository.service.specification.impl;

import java.util.Comparator;

import by.jwd.task04repository.entity.IEllipse;
import by.jwd.task04repository.service.NameComparator;
import by.jwd.task04repository.service.specification.SortSpecification;

/**
 * Returns the NameComparator used in the specification for sorting entities in
 * the EllipseRepository
 * 
 * @author Evlashkina
 * @return Comparator<T>
 */
public class SortByNameSpecificationImpl<T extends IEllipse> implements SortSpecification<T> {

	@Override
	public Comparator<T> findComparator() {
		return new NameComparator<>();
	}
}