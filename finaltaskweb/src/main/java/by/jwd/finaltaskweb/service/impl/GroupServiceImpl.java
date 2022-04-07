package by.jwd.finaltaskweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import by.jwd.finaltaskweb.dao.DaoException;
import by.jwd.finaltaskweb.entity.Group;
import by.jwd.finaltaskweb.entity.Level;
import by.jwd.finaltaskweb.entity.Schedule;
import by.jwd.finaltaskweb.entity.Teacher;
import by.jwd.finaltaskweb.entity.WeekDay;
import by.jwd.finaltaskweb.service.GroupService;
import by.jwd.finaltaskweb.service.ServiceException;
import by.jwd.finaltaskweb.service.StudioServiceImpl;

public class GroupServiceImpl extends StudioServiceImpl implements GroupService {

	@Override
	public List<Group> readAll() throws ServiceException {

		List<Group> groups = null;

		try {
			groups = transaction.createDaoFactory().getGroupDao().readAll();
			transaction.close();

		} catch (DaoException e) {
			throw new ServiceException();
		}
		return groups;
	}

	@Override
	public Group readEntityById(Integer id) throws ServiceException {

		Group group = null;

		try {
			group = transaction.createDaoFactory().getGroupDao().readEntityById(id);
			transaction.close();

		} catch (DaoException e) {
			throw new ServiceException();
		}
		return group;
	}

	@Override
	public boolean delete(Integer id) throws ServiceException {
		try {
			transaction.createDaoFactory().getGroupDao().delete(id);
			transaction.close();

		} catch (DaoException e) {
			throw new ServiceException();
		}
		return false;
	}

	@Override
	public boolean create(Group group) throws ServiceException {
		try {
			transaction.createDaoFactory().getGroupDao().create(group);
			transaction.close();

		} catch (DaoException e) {
			throw new ServiceException();
		}
		return false;
	}

	@Override
	public boolean update(Group group) throws ServiceException {
		try {
			transaction.createDaoFactory().getGroupDao().update(group);
			transaction.close();

		} catch (DaoException e) {
			throw new ServiceException();
		}
		return false;
	}

	@Override
	public List<Group> readByLevel(Level level) throws ServiceException {
		List<Group> groups = null;

		try {
			groups = transaction.createDaoFactory().getGroupDao().readByLevel(level);
			transaction.close();

		} catch (DaoException e) {
			throw new ServiceException();
		}
		return groups;
	}

	@Override
	public List<Group> readByWeekDay(List<WeekDay> weekDays) throws ServiceException {
		List<Group> groups = new ArrayList<>();
		try {
			for (WeekDay day : weekDays) {
				List<Schedule> schedules = transaction.createDaoFactory().getScheduleDao().readByWeekDay(day);
				for (Schedule schedule : schedules) {
					groups.add(schedule.getGroup());
				}
			}
			transaction.close();
		} catch (DaoException e) {
			throw new ServiceException();
		}

		return groups;

	}

	@Override
	public List<Group> readByDanceStyle(String dancestyle) throws ServiceException {

		List<Group> teachersGroup = new ArrayList<>();
		List<Group> groups = new ArrayList<>();
		try {
			List<Teacher> teachers = transaction.createDaoFactory().getUserDao().readByDanceStyle(dancestyle);

			for (Teacher teacher : teachers) {
				teachersGroup = readByTeacher(teacher.getId());

				for (Group group : teachersGroup) {
					groups.add(group);
				}
			}
			transaction.close();

		} catch (DaoException e) {
			throw new ServiceException();
		}
		return groups;
	}

	@Override
	public List<Group> readByTeacher(Integer teacherId) throws ServiceException {

		List<Group> groups = new ArrayList<>();
		try {
			groups = transaction.createDaoFactory().getGroupDao().readByTeacherId(teacherId);
			transaction.close();

		} catch (DaoException e) {
			throw new ServiceException();
		}
		return groups;
	}
}