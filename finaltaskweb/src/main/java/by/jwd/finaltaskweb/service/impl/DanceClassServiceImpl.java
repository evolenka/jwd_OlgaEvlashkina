package by.jwd.finaltaskweb.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import by.jwd.finaltaskweb.dao.DaoException;
import by.jwd.finaltaskweb.dao.DaoFactory;
import by.jwd.finaltaskweb.entity.DanceClass;
import by.jwd.finaltaskweb.entity.Schedule;
import by.jwd.finaltaskweb.service.DanceClassService;
import by.jwd.finaltaskweb.service.ServiceException;

public class DanceClassServiceImpl implements DanceClassService {

	private DaoFactory factory = DaoFactory.getInstance();

	@Override
	public List<DanceClass> readAll() throws ServiceException {

		List<DanceClass> danceClasses = null;

		try {
			danceClasses = factory.getDanceClassDao().readAll();

		} catch (DaoException e) {
			throw new ServiceException();
		}
		return danceClasses;
	}

	@Override
	public DanceClass readEntityById(Integer id) throws ServiceException {
		DanceClass danceClass = null;

		try {
			danceClass = factory.getDanceClassDao().readEntityById(id);

		} catch (DaoException e) {
			throw new ServiceException();
		}
		return danceClass;
	}

	@Override
	public boolean delete(Integer id) throws ServiceException {
		try {
			factory.getDanceClassDao().delete(id);
		} catch (DaoException e) {
			throw new ServiceException();
		}
		return false;
	}

	@Override
	public boolean create(DanceClass danceClass) throws ServiceException {
		try {
			factory.getDanceClassDao().create(danceClass);
		} catch (DaoException e) {
			throw new ServiceException();
		}
		return false;
	}

	@Override
	public boolean update(DanceClass danceClass) throws ServiceException {
		try {
			factory.getDanceClassDao().update(danceClass);
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
			List<Schedule> schedules = factory.getScheduleDao().readByGroup(groupId);

			for (LocalDate date : availiableDates) {
				for (Schedule schedule : schedules) {
					danceClasses.add(factory.getDanceClassDao().readByDateAndSchedule(date, schedule.getId()));
				}
			}
		} catch (DaoException e) {
			throw new ServiceException();
		}

		return danceClasses;
	}

	@Override
	public List<LocalDate> findAvailiableDates(Integer groupId) throws ServiceException {

		List<LocalDate> availiableDates = new ArrayList<>();

		try {
			List<Schedule> schedules = factory.getScheduleDao().readByGroup(groupId);

			for (Schedule schedule : schedules) {
				List<DanceClass> danceClasses = factory.getDanceClassDao().readActiveBySchedule(schedule.getId());

				for (DanceClass danceClass : danceClasses) {
					availiableDates.add(danceClass.getDate());
				}
			}
		} catch (DaoException e) {
			throw new ServiceException();
		}

		return availiableDates;
	}

	@Override
	public List<DanceClass> readByGroup(Integer groupId) throws ServiceException {
		
		List<DanceClass> danceClasses = new ArrayList<>();

		try {
			List<Schedule> schedules = factory.getScheduleDao().readByGroup(groupId);
			for (Schedule schedule : schedules) {
			List<DanceClass> danceClassesBySchedule = factory.getDanceClassDao().readBySchedule(schedule.getId());

			for (DanceClass danceClass : danceClassesBySchedule) {
					danceClasses.add(danceClass);
				}
			}
		} catch (DaoException e) {
			throw new ServiceException();
		}

		return danceClasses;
	}
}