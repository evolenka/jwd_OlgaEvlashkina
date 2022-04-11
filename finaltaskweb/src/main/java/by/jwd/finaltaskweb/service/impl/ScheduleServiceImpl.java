package by.jwd.finaltaskweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.finaltaskweb.dao.DaoException;
import by.jwd.finaltaskweb.dao.DaoFactory;
import by.jwd.finaltaskweb.dao.impl.UserDaoImpl;
import by.jwd.finaltaskweb.entity.Group;
import by.jwd.finaltaskweb.entity.Schedule;
import by.jwd.finaltaskweb.service.ServiceException;
import by.jwd.finaltaskweb.service.StudioService;
import by.jwd.finaltaskweb.service.StudioServiceImpl;

public class ScheduleServiceImpl extends StudioServiceImpl implements StudioService<Integer, Schedule> {
	
	private static Logger logger = LogManager.getLogger(ScheduleServiceImpl.class);
	
	private DaoFactory factory = DaoFactory.getInstance();

	@Override
	public List<Schedule> readAll() throws ServiceException {

		List<Schedule> schedules = new ArrayList<>();
		try {
			schedules = factory.getScheduleDao(transaction).readAll();
			for (Schedule schedule : schedules) {
				Group group = factory.getGroupDao(transaction).readEntityById(schedule.getGroup().getId());
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
			schedule = factory.getScheduleDao(transaction).readEntityById(id);
			transaction.close();

		} catch (DaoException e) {
			throw new ServiceException();
		}
		return schedule;
	}

	@Override
	public boolean create(Schedule schedule) throws ServiceException {
		try {
			factory.getScheduleDao(transaction).create(schedule);
			transaction.close();
		} catch (DaoException e) {
			throw new ServiceException();
		}
		return false;
	}

	@Override
	public boolean update(Schedule schedule) throws ServiceException {
		try {
			factory.getScheduleDao(transaction).update(schedule);
			transaction.close();

		} catch (DaoException e) {
			throw new ServiceException();
		}
		return false;
	}

	@Override
	public boolean delete(Integer id) throws ServiceException {
		try {
			factory.getScheduleDao(transaction).delete(id);
			transaction.close();

		} catch (DaoException e) {
			throw new ServiceException();
		}
		return false;
	}
}