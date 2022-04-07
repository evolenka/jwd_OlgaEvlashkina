package by.jwd.finaltaskweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import by.jwd.finaltaskweb.dao.DaoException;
import by.jwd.finaltaskweb.entity.Client;
import by.jwd.finaltaskweb.entity.Role;
import by.jwd.finaltaskweb.entity.Teacher;
import by.jwd.finaltaskweb.entity.User;
import by.jwd.finaltaskweb.service.ServiceException;
import by.jwd.finaltaskweb.service.StudioServiceImpl;
import by.jwd.finaltaskweb.service.UserService;

public class UserServiceImpl extends StudioServiceImpl implements UserService {

	@Override
	public List<User> readAll() throws ServiceException {
		List<User> users = null;
		try {
			transaction.createDaoFactory().getUserDao().readAll();
			transaction.close();

		} catch (DaoException e) {
			throw new ServiceException();
		}
		return users;
	}

	@Override
	public List<Client> readAllClient() throws ServiceException {
		List<Client> clients = null;
		try {
			clients = transaction.createDaoFactory().getUserDao().readByRole(Role.CLIENT);
			transaction.close();

		} catch (DaoException e) {
			throw new ServiceException();
		}
		return clients;
	}

	@Override
	public List<Teacher> readAllTeacher() throws ServiceException {
		List<Teacher> teachers = null;
		try {
			teachers = transaction.createDaoFactory().getUserDao().readByRole(Role.TEACHER);
			transaction.close();

		} catch (DaoException e) {
			throw new ServiceException();
		}

		return teachers;
	}

	@Override
	public User readEntityById(Integer id) throws ServiceException {
		User user = null;
		try {
			user = transaction.createDaoFactory().getUserDao().readEntityById(id);
			transaction.close();

		} catch (DaoException e) {
			throw new ServiceException();
		}
		return user;
	}

	@Override
	public User readByLogin(String login) throws ServiceException {
		User user = null;
		try {
			transaction.createDaoFactory().getUserDao().readByLogin(login);
			transaction.close();
		} catch (DaoException e) {
			throw new ServiceException();
		}
		return user;
	}

	public User readByLoginAndPassword(String login, String password) throws ServiceException {
		User user = null;
		try {
			transaction.createDaoFactory().getUserDao().readByLoginAndPassword(login, password);
			transaction.close();
		} catch (DaoException e) {
			throw new ServiceException();
		}
		return user;
	}

	@Override
	public List<Teacher> readByDanceStyle(String danceStyle) throws ServiceException {
		List<Teacher> teachers = new ArrayList<>();
		try {
			transaction.createDaoFactory().getUserDao().readByDanceStyle(danceStyle);
			transaction.close();
		} catch (DaoException e) {
			throw new ServiceException();
		}
		return teachers;
	}

	@Override
	public List<String> readAllDanceStyle() throws ServiceException {
		List<String> danceStyles = new ArrayList<>();
		try {
			transaction.createDaoFactory().getUserDao().readAllDanceStyle();
			transaction.close();
		} catch (DaoException e) {
			throw new ServiceException();
		}
		return danceStyles;
	}

	@Override
	public boolean delete(Integer id) throws ServiceException {
		try {
			transaction.createDaoFactory().getUserDao().delete(id);
			transaction.close();
		} catch (DaoException e) {
			throw new ServiceException();
		}
		return true;
	}

	@Override
	public boolean create(User user) throws ServiceException {
		try {
			transaction.createDaoFactory().getUserDao().create(user);
			transaction.close();
		} catch (DaoException e) {
			throw new ServiceException();
		}
		return true;
	}

	@Override
	public boolean update(User user) throws ServiceException {
		try {
			transaction.createDaoFactory().getUserDao().update(user);
			transaction.close();
		} catch (DaoException e) {
			throw new ServiceException();
		}
		return true;
	}
}