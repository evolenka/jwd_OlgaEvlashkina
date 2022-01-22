package by.jwd.task04repository.service.specification.impl;

import java.util.Comparator;
import by.jwd.task04repository.entity.IEllipse;
import by.jwd.task04repository.service.IdComparator;
import by.jwd.task04repository.service.specification.SortSpecification;

/**
 * Returns the IdComparator used in the specification for sorting
 * entities in the EllipseRepository
 * 
 * @author Evlashkina
 * @return Comparator<T>
 */

public class SortByIdSpecificationImpl<T extends IEllipse> implements SortSpecification<T> {

	@Override
	public Comparator<T> findComparator() {
		return new IdComparator<>();
	}
}
