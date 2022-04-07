package by.jwd.finaltaskweb.service;

import java.util.List;

import by.jwd.finaltaskweb.entity.Client;
import by.jwd.finaltaskweb.entity.Teacher;
import by.jwd.finaltaskweb.entity.User;

public interface UserService extends StudioService <Integer, User> {
	
	User readByLogin(String login) throws ServiceException;
	
	User readByLoginAndPassword(String login, String password) throws ServiceException;
	
	List<Client> readAllClient() throws ServiceException;
	
	List<Teacher> readAllTeacher() throws ServiceException;
	
	List<Teacher> readByDanceStyle(String danceStyle) throws ServiceException;

	List<String> readAllDanceStyle() throws ServiceException;
}