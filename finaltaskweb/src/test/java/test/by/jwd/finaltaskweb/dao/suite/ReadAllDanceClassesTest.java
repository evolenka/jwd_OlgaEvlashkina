package test.by.jwd.finaltaskweb.dao.suite;

import static org.testng.Assert.assertEquals;

import java.sql.Connection;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import by.jwd.finaltaskweb.dao.DaoException;
import by.jwd.finaltaskweb.dao.DaoFactory;
import by.jwd.finaltaskweb.dao.pool.ConnectionPool;
import by.jwd.finaltaskweb.entity.DanceClass;
import by.jwd.finaltaskweb.entity.Schedule;


public class ReadAllDanceClassesTest {
	
	static Logger logger = LogManager.getLogger(ReadAllDanceClassesTest.class);

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

	@Test(description = "readAllDanceClass", groups = { "dao" })
	
	public void testReadAllDanceClass() throws DaoException {
		
		List <DanceClass> expected = new ArrayList<>();
		
		DanceClass danceClass1 = new DanceClass (1);
		danceClass1.setSchedule(new Schedule(4));
		danceClass1.setDate(LocalDate.of(2022, Month.MARCH, 01));
		danceClass1.setActive(false);
		
		DanceClass danceClass2 = new DanceClass (2);
		danceClass2.setSchedule(new Schedule(5));
		danceClass2.setDate(LocalDate.of(2022, Month.MARCH, 01));
		danceClass2.setActive(false);
		
		DanceClass danceClass3 = new DanceClass (3);
		danceClass3.setSchedule(new Schedule(6));
		danceClass3.setDate(LocalDate.of(2022, Month.MARCH, 01));
		danceClass3.setActive(false);
				
		DanceClass danceClass4 = new DanceClass (4);
		danceClass4.setSchedule(new Schedule(7));
		danceClass4.setDate(LocalDate.of(2022, Month.MARCH, 02));
		danceClass4.setActive(false);
		
		DanceClass danceClass5 = new DanceClass (5);
		danceClass5.setSchedule(new Schedule(8));
		danceClass5.setDate(LocalDate.of(2022, Month.MARCH, 02));
		danceClass5.setActive(false);
		
		DanceClass danceClass6 = new DanceClass (6);
		danceClass6.setSchedule(new Schedule(7));
		danceClass6.setDate(LocalDate.of(2022, Month.MARCH, 9));
		danceClass6.setActive(false);
		
		DanceClass danceClass7 = new DanceClass (8);
		danceClass7.setSchedule(new Schedule(1));
		danceClass7.setDate(LocalDate.of(2022, Month.MARCH, 14));
		danceClass7.setActive(false);
		
		DanceClass danceClass8 = new DanceClass (9);
		danceClass8.setSchedule(new Schedule(3));
		danceClass8.setDate(LocalDate.of(2022, Month.MARCH, 14));
		danceClass8.setActive(false);
		
		DanceClass danceClass9 = new DanceClass (10);
		danceClass9.setSchedule(new Schedule(4));
		danceClass9.setDate(LocalDate.of(2022, Month.MARCH, 15));
		danceClass9.setActive(false);
		
		DanceClass danceClass10 = new DanceClass (11);
		danceClass10.setSchedule(new Schedule(5));
		danceClass10.setDate(LocalDate.of(2022, Month.MARCH, 15));
		danceClass10.setActive(false);
		
		DanceClass danceClass11 = new DanceClass (12);
		danceClass11.setSchedule(new Schedule(1));
		danceClass11.setDate(LocalDate.of(2022, Month.APRIL, 11));
		danceClass11.setActive(true);
		
		DanceClass danceClass12 = new DanceClass (14);
		danceClass12.setSchedule(new Schedule(3));
		danceClass12.setDate(LocalDate.of(2022, Month.APRIL, 11));
		danceClass12.setActive(true);
		
		DanceClass danceClass13 = new DanceClass (15);
		danceClass13.setSchedule(new Schedule(4));
		danceClass13.setDate(LocalDate.of(2022, Month.APRIL, 12));
		danceClass13.setActive(true);	
		
		DanceClass danceClass14 = new DanceClass (16);
		danceClass14.setSchedule(new Schedule(5));
		danceClass14.setDate(LocalDate.of(2022, Month.APRIL, 12));
		danceClass14.setActive(true);	
		
		DanceClass danceClass15 = new DanceClass (17);
		danceClass15.setSchedule(new Schedule(6));
		danceClass15.setDate(LocalDate.of(2022, Month.APRIL, 12));
		danceClass15.setActive(true);	
	
		expected.add(danceClass1);
		expected.add(danceClass2);
		expected.add(danceClass3);
		expected.add(danceClass4);
		expected.add(danceClass5);
		expected.add(danceClass6);
		expected.add(danceClass7);
		expected.add(danceClass8);
		expected.add(danceClass9);
		expected.add(danceClass10);
		expected.add(danceClass11);
		expected.add(danceClass12);
		expected.add(danceClass13);
		expected.add(danceClass14);
		expected.add(danceClass15);
			
		Connection connection = ConnectionPool.getInstance().getConnection();
		DaoFactory factory = new DaoFactory (connection);
		List <DanceClass> actual = factory.getDanceClassDao().readAll();
		assertEquals(actual, expected);
	}
}