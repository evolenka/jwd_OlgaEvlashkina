package by.jwd.task04repository.service;

import java.util.Comparator;

import by.jwd.task04repository.entity.IEllipse;

/**
 * Compares two entities <T extends IEllipse> by second coordinate y of the
 * first point
 * 
 * @author Evlashkina
 * @param entity1, entity2
 * @return int
 */

public class FirstPointYComparator<T extends IEllipse> implements Comparator<T> {

	@Override
	public int compare(IEllipse entity1, IEllipse entity2) {
		return Double.compare(entity1.getFirstPoint().getY(), entity2.getFirstPoint().getY());
	}
}