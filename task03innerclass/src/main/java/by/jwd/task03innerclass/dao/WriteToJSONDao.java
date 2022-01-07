package by.jwd.task03innerclass.dao;

import java.util.List;

public interface WriteToJSONDao <T>{
	
	public void writeDataToJSONFile(List<T> searchResult, String fileName) throws DaoException;
}