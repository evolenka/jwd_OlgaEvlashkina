package by.jwd.finaltaskweb.service;


import java.time.LocalDate;
import java.util.List;

import by.jwd.finaltaskweb.entity.DanceClass;


public interface DanceClassService extends StudioService <Integer, DanceClass>{

	public DanceClass readByDateAndGroup(LocalDate date, Integer groupId) throws ServiceException;
	
	public List <DanceClass> readByGroup(Integer groupId) throws ServiceException;
	
	public List <LocalDate> readAvailiableDatesByGroup (Integer groupId) throws ServiceException;
	
	public List<LocalDate> readAllAvailiableDates() throws ServiceException;
}