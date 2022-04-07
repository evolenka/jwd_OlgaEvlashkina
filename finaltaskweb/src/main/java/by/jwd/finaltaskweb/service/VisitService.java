package by.jwd.finaltaskweb.service;

import java.time.LocalDate;

import java.util.List;
import java.util.Map;

import by.jwd.finaltaskweb.entity.DanceClass;
import by.jwd.finaltaskweb.entity.Group;
import by.jwd.finaltaskweb.entity.Status;
import by.jwd.finaltaskweb.entity.Visit;

public interface VisitService extends StudioService<Integer, Visit> {

	public List<Visit> readPlannedByClient(Integer clientId) throws ServiceException;// select all planned visits of the
																						// given client;

	public List<Visit> readPlannedByTeacher(Integer teacherId) throws ServiceException;// select all visits to mark the
																						// presence;

	public List<Visit> readByClientAndPeriod(Integer clientId, LocalDate startDate, LocalDate endDate)
			throws ServiceException;// select all visits of the given client for period

	public List<Visit> readByGroupAndPeriod(Integer groupId, LocalDate startDate, LocalDate endDate)
			throws ServiceException;// select all visits of the given group for period

	public Map<Group, Integer> countVisitsForPeriodByGroups(LocalDate startDate, LocalDate endDate)
			throws ServiceException;// count visits for period by groups

	public boolean isPlanned(DanceClass danceClass) throws ServiceException;

	public boolean markPresence(Visit visit, Status status) throws ServiceException;

	public boolean cancelMarkPresence(Visit visit) throws ServiceException;
}
