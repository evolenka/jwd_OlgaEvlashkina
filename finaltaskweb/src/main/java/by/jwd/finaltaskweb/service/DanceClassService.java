package by.jwd.finaltaskweb.service;


import java.time.LocalDate;
import java.util.List;

import by.jwd.finaltaskweb.entity.DanceClass;


public interface DanceClassService extends StudioService <Integer, DanceClass>{

	public List <DanceClass> readByDateAndGroup(List <LocalDate> availiableDates, Integer groupId) throws ServiceException;
	
	public List <DanceClass> readByGroup(Integer groupId) throws ServiceException;
	
	public List <LocalDate> readAvailiableDates (Integer groupId) throws ServiceException;

}