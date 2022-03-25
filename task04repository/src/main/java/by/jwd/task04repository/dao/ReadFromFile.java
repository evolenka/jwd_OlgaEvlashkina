package by.jwd.task04repository.dao;

import java.util.List;

import by.jwd.task04repository.service.ServiceException;
/**
 * Reads all lines of file and returns them as List<T>
 * 
 * @param fileName
 * @return List<T> containing of contents of the lines from text
 *         file
 * @throws DaoException if file is invalid
 */

public interface ReadFromFile<T> {

	public List<T> read(String fileName) throws DaoException, ServiceException;
}