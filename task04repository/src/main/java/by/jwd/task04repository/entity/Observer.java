package by.jwd.task04repository.entity;

import by.jwd.task04repository.service.ServiceException;

public interface Observer {

	/**
	 * Provides method to update parameters of the observer which are depended on
	 * the parameters of the observed subject
	 * 
	 * @author Evlashkina
	 * @throws ServiceException 
	 * 
	 */

	public void update(IEllipse entity) throws ServiceException;
}
