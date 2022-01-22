package by.jwd.task04repository.entity;

import by.jwd.task04repository.service.ServiceException;

/**
 * Provides methods to register, remove and notify observers of changes in the
 * observed subject (Pattern "Observer")
 * 
 * @author Evlashkina
 * 
 */

public interface SubjectToObserve {

	public void registerObserver(Observer observer);

	public void removeObserver(Observer observer);

	public void notifyObservers() throws ServiceException;
}