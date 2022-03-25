package by.jwd.task03innerclass.service;

import java.util.List;

import by.jwd.task03innerclass.entity.Shop;

/**
 * Interface with the method find() for searching info about Store Object
 * 
 * @author evlashkina
 * @version 1
 * @param store
 * @return List <T>
 * @exception ServiceException
 * @throws ServiceException in case of invalid data or file not found
 */

public interface FindService<T> {
	public List<T> find(Shop shop) throws ServiceException;
}