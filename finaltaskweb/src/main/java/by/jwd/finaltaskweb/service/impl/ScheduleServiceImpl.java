package by.jwd.finaltaskweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import by.jwd.finaltaskweb.dao.DaoException;
import by.jwd.finaltaskweb.dao.DaoFactory;
import by.jwd.finaltaskweb.entity.Schedule;
import by.jwd.finaltaskweb.service.ServiceException;
import by.jwd.finaltaskweb.service.StudioService;

public class ScheduleServiceImpl implements StudioService<Integer, Schedule> {

	private DaoFactory factory = DaoFactory.getInstance();

	@Override
	public List<Schedule> readAll() throws ServiceException {

		List<Schedule> schedules = new ArrayList<>();
		try {
			schedules = factory.getScheduleDao().readAll();

		} catch (DaoException e) {
			throw new ServiceException();
		}
		return schedules;
	}

	@Override
	public Schedule readEntityById(Integer id) throws ServiceException {

		Schedule schedule = new Schedule();
		try {
			schedule = factory.getScheduleDao().readEntityById(id);

		} catch (DaoException e) {
			throw new ServiceException();
		}
		return schedule;
	}

	@Override
	public boolean create(Schedule schedule) throws ServiceException {
		try {
			factory.getScheduleDao().create(schedule);
		} catch (DaoException e) {
			throw new ServiceException();
		}
		return false;
	}

	@Override
	public boolean update(Schedule schedule) throws ServiceException {
		try {
			factory.getScheduleDao().update(schedule);
		} catch (DaoException e) {
			throw new ServiceException();
		}
		return false;
	}

	@Override
	public boolean delete(Integer id) throws ServiceException {
		try {
			factory.getScheduleDao().delete(id);
		} catch (DaoException e) {
			throw new ServiceException();
		}
		return false;
	}
}