package by.jwd.task03innerclass.service;

import java.util.List;

import by.jwd.task03innerclass.entity.Shop;

/**
 * Interface with the method FindByParameter() for searching info from the Store
 * object by the parameter inputed by user
 * 
 * @author evlashkina
 * @version 1
 * @param param, store
 * @return List <T>
 * @exception ServiceException
 * @throws ServiceException in case of invalid data or file not found
 */

public interface FindByParameterService<T> {
	public List<T> findByParameter(String param, Shop shop) throws ServiceException;
}