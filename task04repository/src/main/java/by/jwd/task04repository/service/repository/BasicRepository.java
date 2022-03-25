package by.jwd.task04repository.service.repository;

import java.util.List;

import by.jwd.task04repository.entity.ITwoDShape;
import by.jwd.task04repository.service.ServiceException;
import by.jwd.task04repository.service.specification.FindSpecification;
import by.jwd.task04repository.service.specification.SortSpecification;

/**
 * Provides methods for basic operations over repository which contains enities <T extends
 * ITwoDShape> 
 * 
 * @author Evlashkina
 */

public interface BasicRepository<T extends ITwoDShape> {

	public boolean save(T entity) throws ServiceException;

	public boolean remove(T entity);

	public List<T> readAll();

	public T readById(Long id);

	public List<T> findQuery(FindSpecification<T> specification) throws ServiceException;

	public List<T> sortQuery(SortSpecification<T> specification);
}
