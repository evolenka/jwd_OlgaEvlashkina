package by.jwd.finaltaskweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import by.jwd.finaltaskweb.dao.DaoException;
import by.jwd.finaltaskweb.entity.Group;
import by.jwd.finaltaskweb.entity.Schedule;
import by.jwd.finaltaskweb.service.ServiceException;
import by.jwd.finaltaskweb.service.StudioService;
import by.jwd.finaltaskweb.service.StudioServiceImpl;

public class ScheduleServiceImpl extends StudioServiceImpl implements StudioService<Integer, Schedule> {

	@Override
	public List<Schedule> readAll() throws ServiceException {

		List<Schedule> schedules = new ArrayList<>();
		try {
			schedules = transaction.createDaoFactory().getScheduleDao().readAll();
			for (Schedule schedule : schedules) {
				Group group = transaction.createDaoFactory().getGroupDao().readEntityById(schedule.getGroup().getId());
				schedule.setGroup(group);
			}
			transaction.close();
		} catch (DaoException e) {
			throw new ServiceException();
		}
		return schedules;
	}

	@Override
	public Schedule readEntityById(Integer id) throws ServiceException {

		Schedule schedule = new Schedule();
		try {
			schedule = transaction.createDaoFactory().getScheduleDao().readEntityById(id);
			transaction.close();

		} catch (DaoException e) {
			throw new ServiceException();
		}
		return schedule;
	}

	@Override
	public boolean create(Schedule schedule) throws ServiceException {
		try {
			transaction.createDaoFactory().getScheduleDao().create(schedule);
			transaction.close();
		} catch (DaoException e) {
			throw new ServiceException();
		}
		return false;
	}

	@Override
	public boolean update(Schedule schedule) throws ServiceException {
		try {
			transaction.createDaoFactory().getScheduleDao().update(schedule);
			transaction.close();

		} catch (DaoException e) {
			throw new ServiceException();
		}
		return false;
	}

	@Override
	public boolean delete(Integer id) throws ServiceException {
		try {
			transaction.createDaoFactory().getScheduleDao().delete(id);
			transaction.close();

		} catch (DaoException e) {
			throw new ServiceException();
		}
		return false;
	}
}