package test.by.jwd.finaltaskweb.dao.groupdao;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import by.jwd.finaltaskweb.dao.ConnectionPool;
import by.jwd.finaltaskweb.dao.DaoException;
import by.jwd.finaltaskweb.dao.DaoFactory;
import by.jwd.finaltaskweb.entity.Group;
import by.jwd.finaltaskweb.entity.Level;
import by.jwd.finaltaskweb.entity.Teacher;

public class UpdateTest {
	
	static Logger logger = LogManager.getLogger(CreateAndDeleteTest.class);

	@BeforeTest
	public void beforeTest() {

		ResourceBundle resourceBundle = ResourceBundle.getBundle("testdatabase");

		String driverClass = resourceBundle.getString("db.driver");
		String url = resourceBundle.getString("db.url");
		String user = resourceBundle.getString("user");
		String password = resourceBundle.getString("password");
		int startSize = Integer.parseInt(resourceBundle.getString("startsize"));
		int maxSize = Integer.parseInt(resourceBundle.getString("maxsize"));
		int checkConnectionTimeout = Integer.parseInt(resourceBundle.getString("checkConnectionTimeout"));

		try {
			ConnectionPool.getInstance().init(driverClass, url, user, password, startSize, maxSize,
					checkConnectionTimeout);
		} catch (DaoException e) {
			logger.debug("connection error");
		}
	}

	@Test(description = "update")

	public void testUpdate() throws DaoException {

		List<Group> expected = new ArrayList<>();

		Group group1 = new Group(1);
		group1.setTeacher(new Teacher(2));
		group1.setTitle("group1");
		group1.setLevel(Level.BEG);

		Group group2 = new Group(2);
		group2.setTeacher(new Teacher(2));
		group2.setTitle("group2");
		group2.setLevel(Level.PRO);

		Group group3 = new Group(3);
		group3.setTeacher(new Teacher(3));
		group3.setTitle("group3");
		group3.setLevel(Level.BEG);

		Group group4 = new Group(4);
		group4.setTeacher(new Teacher(3));
		group4.setTitle("group4");
		group4.setLevel(Level.PRO);

		Group group5 = new Group(5);
		group5.setTeacher(new Teacher(4));
		group5.setTitle("group5");
		group5.setLevel(Level.BEG);

		Group group6 = new Group(6);
		group6.setTeacher(new Teacher(4));
		group6.setTitle("group6");
		group6.setLevel(Level.PRO);

		Group group7 = new Group(7);
		group7.setTeacher(new Teacher(5));
		group7.setTitle("group7100");
		group7.setLevel(Level.PRO);

		
		expected.add(group1);
		expected.add(group2);
		expected.add(group3);
		expected.add(group4);
		expected.add(group5);
		expected.add(group6);
		expected.add(group7);
		

		DaoFactory factory = DaoFactory.getInstance();
		factory.getGroupDao().update(group7);
		List<Group> actual = factory.getGroupDao().readAll();
		logger.debug(actual);
		assertEquals(actual, expected);
	}

				
	@Test(dependsOnMethods = "testUpdate")

	public void testUpdate2() throws DaoException {
		List<Group> expected = new ArrayList<>();

		Group group1 = new Group(1);
		group1.setTeacher(new Teacher(2));
		group1.setTitle("group1");
		group1.setLevel(Level.BEG);

		Group group2 = new Group(2);
		group2.setTeacher(new Teacher(2));
		group2.setTitle("group2");
		group2.setLevel(Level.PRO);

		Group group3 = new Group(3);
		group3.setTeacher(new Teacher(3));
		group3.setTitle("group3");
		group3.setLevel(Level.BEG);

		Group group4 = new Group(4);
		group4.setTeacher(new Teacher(3));
		group4.setTitle("group4");
		group4.setLevel(Level.PRO);

		Group group5 = new Group(5);
		group5.setTeacher(new Teacher(4));
		group5.setTitle("group5");
		group5.setLevel(Level.BEG);

		Group group6 = new Group(6);
		group6.setTeacher(new Teacher(4));
		group6.setTitle("group6");
		group6.setLevel(Level.PRO);

		Group group7 = new Group(7);
		group7.setTeacher(new Teacher(5));
		group7.setTitle("group7");
		group7.setLevel(Level.BEG);
		
		expected.add(group1);
		expected.add(group2);
		expected.add(group3);
		expected.add(group4);
		expected.add(group5);
		expected.add(group6);
		expected.add(group7);
		
		DaoFactory factory = DaoFactory.getInstance();
		factory.getGroupDao().update(group7);
		List<Group> actual = factory.getGroupDao().readAll();
		logger.debug(actual);
		assertEquals(actual, expected);
	}
}