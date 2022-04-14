package by.jwd.finaltaskweb.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.finaltaskweb.dao.DaoException;
import by.jwd.finaltaskweb.dao.DaoFactory;
import by.jwd.finaltaskweb.entity.DanceClass;
import by.jwd.finaltaskweb.entity.Schedule;
import by.jwd.finaltaskweb.service.DanceClassService;
import by.jwd.finaltaskweb.service.ServiceException;
import by.jwd.finaltaskweb.service.StudioServiceImpl;

public class DanceClassServiceImpl extends StudioServiceImpl implements DanceClassService {
	
	private static Logger logger = LogManager.getLogger(DanceClassServiceImpl.class);
	
	private DaoFactory factory = DaoFactory.getInstance();

	@Override
	public List<DanceClass> readAll() throws ServiceException {

		List<DanceClass> danceClasses = null;

		try {
			danceClasses = factory.getDanceClassDao(transaction).readAll();
			transaction.close();

		} catch (DaoException e) {
			throw new ServiceException();
		}
		return danceClasses;
	}

	@Override
	public DanceClass readEntityById(Integer id) throws ServiceException {
		DanceClass danceClass = null;

		try {
			danceClass = factory.getDanceClassDao(transaction).readEntityById(id);
			transaction.close();

		} catch (DaoException e) {
			throw new ServiceException();
		}
		return danceClass;
	}

	@Override
	public boolean delete(Integer id) throws ServiceException {
		try {
			factory.getDanceClassDao(transaction).delete(id);
			transaction.close();
		} catch (DaoException e) {
			throw new ServiceException();
		}
		return false;
	}

	@Override
	public boolean create(DanceClass danceClass) throws ServiceException {
		try {
			factory.getDanceClassDao(transaction).create(danceClass);
			transaction.close();
		} catch (DaoException e) {
			throw new ServiceException();
		}
		return false;
	}

	@Override
	public boolean update(DanceClass danceClass) throws ServiceException {
		try {
			factory.getDanceClassDao(transaction).update(danceClass);
			transaction.close();
		} catch (DaoException e) {
			throw new ServiceException();
		}
		return false;
	}

	@Override
	public List<DanceClass> readByDateAndGroup(List<LocalDate> availiableDates, Integer groupId)
			throws ServiceException {

		List<DanceClass> danceClasses = new ArrayList<>();

		try {
			List<Schedule> schedules = factory.getScheduleDao(transaction).readByGroup(groupId);

			for (LocalDate date : availiableDates) {
				for (Schedule schedule : schedules) {
					danceClasses.add(
							factory.getDanceClassDao(transaction).readByDateAndSchedule(date, schedule));
				}
			}
			transaction.close();
		} catch (DaoException e) {
			throw new ServiceException();
		}

		return danceClasses;
	}

	@Override
	public List<LocalDate> readAvailiableDates(Integer groupId) throws ServiceException {

		List<LocalDate> availiableDates = new ArrayList<>();

		try {
			List<Schedule> schedules = factory.getScheduleDao(transaction).readByGroup(groupId);

			for (Schedule schedule : schedules) {
				List<DanceClass> danceClasses = factory.getDanceClassDao(transaction)
						.readActiveBySchedule(schedule);

				for (DanceClass danceClass : danceClasses) {
					availiableDates.add(danceClass.getDate());
				}
			}
			transaction.close();
		} catch (DaoException e) {
			throw new ServiceException();
		}

		return availiableDates;
	}

	@Override
	public List<DanceClass> readByGroup(Integer groupId) throws ServiceException {

		List<DanceClass> danceClasses = new ArrayList<>();

		try {
			List<Schedule> schedules = factory.getScheduleDao(transaction).readByGroup(groupId);
			for (Schedule schedule : schedules) {
				List<DanceClass> danceClassesBySchedule = factory.getDanceClassDao(transaction)
						.readBySchedule(schedule);

				for (DanceClass danceClass : danceClassesBySchedule) {
					danceClasses.add(danceClass);
				}
			}
			transaction.close();
		} catch (DaoException e) {
			throw new ServiceException();
		}

		return danceClasses;
	}
}