package by.jwd.finaltaskweb.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;

import by.jwd.finaltaskweb.dao.ConnectionPool;


import by.jwd.finaltaskweb.dao.DaoException;
import by.jwd.finaltaskweb.dao.DaoFactory;
import by.jwd.finaltaskweb.entity.Client;
import by.jwd.finaltaskweb.entity.Group;
import by.jwd.finaltaskweb.entity.Level;
import by.jwd.finaltaskweb.entity.Teacher;
import by.jwd.finaltaskweb.service.PasswordHashGenerator;
import by.jwd.finaltaskweb.service.ServiceException;

public class Runner {

	public static void main(String[] args) {
		
		
		
	String	driverClass = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/dancestudio_db";
	String user = "root";
	String password = "1111";
	int startSize = 1;
	int maxSize = 100;
	int checkConnectionTimeout = 0;
	
	try {
		ConnectionPool.getInstance().init(driverClass, url, user, password, startSize, maxSize, checkConnectionTimeout);
	} catch (DaoException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
		

//		PasswordHashGenerator generator = PasswordHashGenerator.getInstance();
//		String pass1 = null;
//		String pass2 = null;
//		String pass3 = null;
//		String pass4 = null;
//		String pass5 = null;
//		try {
//			pass1 = generator.generate("12345");
//		
//		 pass2 = generator.generate("gh7845");
//		pass3 = generator.generate("5Yh12385");
//		pass4 = generator.generate("$y12345");
//		 pass5 = generator.generate("89812345");
//	} catch (ServiceException e1) {
//		// TODO Auto-generated catch block
//		e1.printStackTrace();
//	}
//		System.out.println("pass1:" + pass1);
//		System.out.println("pass2:" + pass2);
//		System.out.println("pass3:" + pass3);
//		System.out.println("pass4:" + pass4);
//		System.out.println("pass5:" + pass5);

		DaoFactory factory = DaoFactory.getInstance();

		// List<Teacher> teachers = new ArrayList<>();
		// User user = null;
		// List<String> dancestyles = new ArrayList<>();
		// Client client = new Client();

		/* List<T> readAll() throws DaoException; */

//		List<User> users = null;
//		try {
//			users = factory.getUserDao().readAll();
//		} catch (DaoException e1) {
//			e1.printStackTrace();
//		}
//		System.out.println("Список всех пользователей:\n" + users);

		// dancestyles = factory.getTeacherDao().readAllDanceStyle();
		// } catch (DaoException e) {

		// e.printStackTrace();
		// }
		// System.out.println("Список всех пользователей:\n" + scopeOfUsers);
		// System.out.println("Список всех направлений:\n" + dancestyles);

		/* List<Client> readAllClient() throws DaoException; */

		List<Client> clients = null;
		try {
			clients = factory.getUserDao().readAllClient();
		} catch (DaoException e) {
			e.printStackTrace();
		}
		System.out.println("Список всех клиентов:\n" + clients);
//
//		/* List<Teacher> readAllTeacher() throws DaoException; */
//		List<Teacher> teachers = null;
//		try {
//			teachers = factory.getUserDao().readAllTeacher();
//		} catch (DaoException e) {
//			e.printStackTrace();
//		}
//		System.out.println("Список всех педагогов:\n" + teachers);
//
//		/* T readEntityById(K id) throws DaoException */;
//		User user1 = null;
//		User user2 = null;
//		User user3 = null;
//		try {
//			user1 = factory.getUserDao().readEntityById(1);
//			user2 = factory.getUserDao().readEntityById(3);
//			user3 = factory.getUserDao().readEntityById(7);
//		} catch (DaoException e) {
//			e.printStackTrace();
//		}
//		System.out.println("Искомый пользователь по id: " + user1);
//		System.out.println("Искомый пользователь по id: " + user2);
//		System.out.println("Искомый пользователь по id: " + user3);
//
//		/* User readByLogin(String login) throws DaoException */;
//
//		User user4 = null;
//		User user5 = null;
//		User user6 = null;
//		try {
//			user4 = factory.getUserDao().readByLogin("tpavlova");
//			user5 = factory.getUserDao().readByLogin("MARKOVA");
//			user6 = factory.getUserDao().readByLogin("admin");
//		} catch (DaoException e) {
//			e.printStackTrace();
//		}
//		System.out.println("Искомый пользователь по логину: " + user4);
//		System.out.println("Искомый пользователь по логину: " + user5);
//		System.out.println("Искомый пользователь по логину: " + user6);
//
//		/* List<User> readBySurname(String surname) throws DaoException; */
//
//		List<User> user7 = null;
//		List<User> user8 = null;
//
//		try {
//			user7 = factory.getUserDao().readBySurname("Степнов");
//			user8 = factory.getUserDao().readBySurname("Лесная");
//		} catch (DaoException e) {
//			e.printStackTrace();
//		}
//		System.out.println("Искомый пользователь по фамилии: " + user7);
//		System.out.println("Искомый пользователь по фамилии: " + user8);
//
//		/* List<Teacher> readByDanceStyle(String danceStyle) throws DaoException; */
//
//		List<Teacher> user9 = null;
//		List<Teacher> user10 = null;
//
//		try {
//			user9 = factory.getUserDao().readByDanceStyle("vogue");
//			user10 = factory.getUserDao().readByDanceStyle("contemprorary");
//		} catch (DaoException e) {
//			e.printStackTrace();
//		}
//		System.out.println("Искомый педагог по стилю танца: " + user9);
//		System.out.println("Искомый педадог по стилю танца:  " + user10);
//
//		/* List<String> readAllDanceStyle() throws DaoException; */
//		List<String> dancestyles = null;
//
//		try {
//			dancestyles = factory.getUserDao().readAllDanceStyle();
//
//		} catch (DaoException e) {
//			e.printStackTrace();
//		}
//		System.out.println("Все танцевальные направления: " + dancestyles);
//
//		/* boolean create(T t) throws DaoException */
//
//		Client client = new Client();
//		client.setLogin("login1");
//		client.setPassword("password1");
//		client.setName("clientname");
//		client.setSurname("clientsurname");
//		client.setPatronymic("patronymic");
//		client.setPhone("+375(44)874-15-98");
//		client.setEmail("client@mail.ru");
//		
//		Teacher teacher = new Teacher();
//		teacher.setLogin("login2");
//		teacher.setPassword("password2");
//		teacher.setName("name");
//		teacher.setSurname("surname");
//		teacher.setDanceStyle("hip");
//		
//		try {
//			factory.getUserDao().create(teacher);
//			teachers = factory.getUserDao().readAllTeacher();
//		} catch (DaoException e) {
//			e.printStackTrace();
//		}
//		System.out.println("Педагог создан: " + teachers);
//
//		/* boolean update(T t) throws DaoException; */
//		Client client2 = new Client(11);
//		client2.setLogin("login2");
//		client2.setPassword("password2");
//		client2.setName("clientname2");
//		client2.setSurname("clientsurname2");
//		client2.setPatronymic("patronymic2");
//		client2.setPhone("+375(29)874-15-98");
//		client2.setEmail("client2@mail.ru");
//		try {
//			factory.getUserDao().update(client2);
//			clients = factory.getUserDao().readAllClient();
//		} catch (DaoException e) {
//			e.printStackTrace();
//		}
//		System.out.println("Клиент11 обновлен: " + clients);
//
//		/* boolean delete(K id) throws DaoException; */
//		try {
//			factory.getUserDao().delete(11);
//			clients = factory.getUserDao().readAllClient();
//		} catch (DaoException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("Клиенты после удаления: " + clients);

		/* boolean create(T t) throws DaoException; */
//		Group group1 = new Group();
//		group1.setLevel(Level.BEG);
//		group1.setTitle("titlegroup");
//		group1.setTeacher(new Teacher(2));
//		Group group2 = new Group();
//		group2.setLevel(Level.PRO);
//		group2.setTitle("titlegroup2");
//		group2.setTeacher(new Teacher(3));
//		try {
//			factory.getGroupDao().create(group1);
//
//			factory.getGroupDao().create(group2);
//
//			/* List<T> readAll() throws DaoException; */
//			List<Group> groups = new ArrayList<>();
//			groups = factory.getGroupDao().readAll();
//
//			System.out.println("Все группы: " + groups);
//		} catch (DaoException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		// T readEntityById(K id) throws DaoException;

		// boolean delete(K id) throws DaoException;

		// boolean create(T t) throws DaoException;

		// boolean update(T t) throws DaoException;

		/* List<Group> readByLevel(Level level) throws DaoException; */

		// List<Group> readByTeacherId(int id) throws DaoException;

	}
}

// Teacher teacher = new Teacher ();
// teacher.setLogin("logИгорь");
// teacher.setPassword("passwИгорл");
// teacher.setName("Тгорь");
// teacher.setSurname("Игорь");
// teacher.setDanceStyle("contemprorary");

// try {
// factory.getTeacherDao().create(teacher);
// scopeOfUsers = factory.getTeacherDao().readAll();
// dancestyles = factory.getTeacherDao().readAllDanceStyle();
// } catch (DaoException e) {
// TODO Auto-generated catch block
// e.printStackTrace();
// }
// System.out.println("Список всех пользователей:\n" + scopeOfUsers);
// System.out.println("Список всех направлений:\n" + dancestyles);

// Client client2 = new Client ("Дмитр", "Петровна", "Крара", "mа4ail.ru",
// "375289852895", "l15gnew6", "p15assnew", Role.CLIENT);

// scopeOfUsers = factory.getClientDao().readBySurname ("Петровна");
// System.out.println(client);
// scopeOfUsers = factory.getClientDao().readAll();

// System.out.println("Список всех пользователей после корректировки:\n" +
// scopeOfUsers);
// System.out.println("Пользователь коррекц:\n" + userr);

// User user1 = new User (0,"login1", "pass", Role.USER);

// factory.getUser().create (user1);

// scopeOfUsers = factory.getUser().readAll();

// System.out.println("Список всех пользователей после добавления нового:\n" +
// scopeOfUsers);

// factory.getUser().delete (3);

// scopeOfUsers = factory.getUser().readAll();

// System.out.println("Список всех пользователей после удаления:\n" +
// scopeOfUsers);
// } catch (DaoException e) {
// TODO Auto-generated catch block
// e.printStackTrace();
// }

//		
//		boolean delete(K id) throws DaoException;
//
//		boolean create(T t) throws DaoException;
//
//		T update(T t) throws DaoException;
//		
//		 readByLogin
