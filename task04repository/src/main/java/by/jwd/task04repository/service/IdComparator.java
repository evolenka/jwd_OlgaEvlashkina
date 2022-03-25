package by.jwd.task04repository.service;

import java.util.Comparator;

import by.jwd.task04repository.entity.IEllipse;

/**
 * Compares two entities <T extends IEllipse> by id
 * 
 * @author Evlashkina
 * @param entity1, entity2
 * @return int
 */
public class IdComparator<T extends IEllipse> implements Comparator<T> {

	@Override
	public int compare(IEllipse entity1, IEllipse entity2) {
		return Long.compare(entity1.getId(), entity2.getId());
	}
}