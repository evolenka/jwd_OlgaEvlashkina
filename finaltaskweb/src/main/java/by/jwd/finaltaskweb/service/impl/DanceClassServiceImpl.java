package by.jwd.finaltaskweb.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import by.jwd.finaltaskweb.dao.DaoException;
import by.jwd.finaltaskweb.entity.DanceClass;
import by.jwd.finaltaskweb.entity.Schedule;
import by.jwd.finaltaskweb.service.DanceClassService;
import by.jwd.finaltaskweb.service.ServiceException;
import by.jwd.finaltaskweb.service.StudioServiceImpl;

public class DanceClassServiceImpl extends StudioServiceImpl implements DanceClassService {

	@Override
	public List<DanceClass> readAll() throws ServiceException {

		List<DanceClass> danceClasses = null;

		try {
			danceClasses = transaction.createDaoFactory().getDanceClassDao().readAll();
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
			danceClass = transaction.createDaoFactory().getDanceClassDao().readEntityById(id);
			transaction.close();

		} catch (DaoException e) {
			throw new ServiceException();
		}
		return danceClass;
	}

	@Override
	public boolean delete(Integer id) throws ServiceException {
		try {
			transaction.createDaoFactory().getDanceClassDao().delete(id);
			transaction.close();
		} catch (DaoException e) {
			throw new ServiceException();
		}
		return false;
	}

	@Override
	public boolean create(DanceClass danceClass) throws ServiceException {
		try {
			transaction.createDaoFactory().getDanceClassDao().create(danceClass);
			transaction.close();
		} catch (DaoException e) {
			throw new ServiceException();
		}
		return false;
	}

	@Override
	public boolean update(DanceClass danceClass) throws ServiceException {
		try {
			transaction.createDaoFactory().getDanceClassDao().update(danceClass);
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
			List<Schedule> schedules = transaction.createDaoFactory().getScheduleDao().readByGroup(groupId);

			for (LocalDate date : availiableDates) {
				for (Schedule schedule : schedules) {
					danceClasses.add(
							transaction.createDaoFactory().getDanceClassDao().readByDateAndSchedule(date, schedule));
				}
			}
			transaction.close();
		} catch (DaoException e) {
			throw new ServiceException();
		}

		return danceClasses;
	}

	@Override
	public List<LocalDate> findAvailiableDates(Integer groupId) throws ServiceException {

		List<LocalDate> availiableDates = new ArrayList<>();

		try {
			List<Schedule> schedules = transaction.createDaoFactory().getScheduleDao().readByGroup(groupId);

			for (Schedule schedule : schedules) {
				List<DanceClass> danceClasses = transaction.createDaoFactory().getDanceClassDao()
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
			List<Schedule> schedules = transaction.createDaoFactory().getScheduleDao().readByGroup(groupId);
			for (Schedule schedule : schedules) {
				List<DanceClass> danceClassesBySchedule = transaction.createDaoFactory().getDanceClassDao()
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