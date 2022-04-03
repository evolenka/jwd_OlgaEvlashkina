package by.jwd.finaltaskweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import by.jwd.finaltaskweb.dao.DaoException;
import by.jwd.finaltaskweb.dao.DaoFactory;
import by.jwd.finaltaskweb.entity.Client;
import by.jwd.finaltaskweb.entity.Teacher;
import by.jwd.finaltaskweb.entity.User;
import by.jwd.finaltaskweb.service.ServiceException;
import by.jwd.finaltaskweb.service.UserService;

public class UserServiceImpl implements UserService {

	private DaoFactory factory = DaoFactory.getInstance();

	@Override
	public User readByLogin(String login) throws ServiceException {

		try {
			return factory.getUserDao().readByLogin(login);
		} catch (DaoException e) {
			throw new ServiceException();
		}
	}

	@Override
	public List<User> readBySurname(String surname) throws ServiceException {

		try {
			return factory.getUserDao().readBySurname(surname);
		} catch (DaoException e) {
			throw new ServiceException();
		}
	}

	@Override
	public List<User> readAll() throws ServiceException {
		try {
			return factory.getUserDao().readAll();
		} catch (DaoException e) {
			throw new ServiceException();
		}
	}

	@Override
	public List<Client> readAllClient() throws ServiceException {
		try {
			return factory.getUserDao().readAllClient();
		} catch (DaoException e) {
			throw new ServiceException();
		}
	}

	@Override
	public List<Teacher> readAllTeacher() throws ServiceException {
		try {
			return factory.getUserDao().readAllTeacher();
		} catch (DaoException e) {
			throw new ServiceException();
		}
	}

	@Override
	public Client readEntityById(Integer id) throws ServiceException {
		try {
			return (Client) factory.getUserDao().readEntityById(id);
		} catch (DaoException e) {
			throw new ServiceException();
		}
	}

	@Override
	public boolean delete(Integer id) throws ServiceException {
		try {
			return factory.getUserDao().delete(id);
		} catch (DaoException e) {
			throw new ServiceException();
		}
	}

	@Override
	public boolean create(User user) throws ServiceException {
		try {
			return factory.getUserDao().create(user);
		} catch (DaoException e) {
			throw new ServiceException();
		}
	}

	@Override
	public boolean update(User user) throws ServiceException {
		try {
			return factory.getUserDao().update(user);
		} catch (DaoException e) {
			throw new ServiceException();
		}
	}

	@Override
	public boolean authorization(String login, String password) throws ServiceException {
		try {
			return factory.getUserDao().authorization(login, password);
		} catch (DaoException e) {
			throw new ServiceException();
		}
	}

	@Override
	public List<Teacher> readByDanceStyle(String danceStyle) throws ServiceException {
		List<Teacher> teachers = new ArrayList<>();
		try {
			factory.getUserDao().readByDanceStyle(danceStyle);
		} catch (DaoException e) {
			throw new ServiceException();
		}
		return teachers;
	}

	@Override
	public List<String> readAllDanceStyle() throws ServiceException {
		List<String> danceStyles = new ArrayList<>();
		try {

			factory.getUserDao().readAllDanceStyle();
		} catch (DaoException e) {
			throw new ServiceException();
		}
		return danceStyles;
	}
}