package by.jwd.finaltaskweb.dao;

import java.util.List;

import by.jwd.finaltaskweb.entity.Client;
import by.jwd.finaltaskweb.entity.Teacher;
import by.jwd.finaltaskweb.entity.User;


public interface UserDao extends StudioDao<Integer, User> {

	public List<Client> readAllClient() throws DaoException;//select all clients

	public List<Teacher> readAllTeacher() throws DaoException;//select all teachers

	public User readByLogin(String login) throws DaoException;

	public List<User> readBySurname(String surname) throws DaoException;

	public List<Teacher> readByDanceStyle(String danceStyle) throws DaoException;

	public List<String> readAllDanceStyle() throws DaoException;

	public boolean authorization(String login, String password) throws DaoException;

}