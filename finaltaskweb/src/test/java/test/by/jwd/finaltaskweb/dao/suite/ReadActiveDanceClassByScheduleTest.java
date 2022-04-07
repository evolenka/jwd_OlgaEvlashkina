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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.jwd.finaltaskweb.dao.DaoException;
import by.jwd.finaltaskweb.dao.DaoFactory;
import by.jwd.finaltaskweb.dao.pool.ConnectionPool;
import by.jwd.finaltaskweb.entity.DanceClass;
import by.jwd.finaltaskweb.entity.Schedule;

public class ReadActiveDanceClassByScheduleTest {
	
	static Logger logger = LogManager.getLogger(ReadActiveDanceClassByScheduleTest.class);

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

	@DataProvider(name = "ReadActiveBySchedule")
	public Object[][] createDataForReadActiveBySchedule() {
		
	List <DanceClass> expected1 = new ArrayList<>();
	List <DanceClass> expected2 = new ArrayList<>();
		
				
		DanceClass danceClass13 = new DanceClass (15);
		danceClass13.setSchedule(new Schedule(4));
		danceClass13.setDate(LocalDate.of(2022, Month.APRIL, 12));
		danceClass13.setActive(true);	
		
		DanceClass danceClass11 = new DanceClass (12);
		danceClass11.setSchedule(new Schedule(1));
		danceClass11.setDate(LocalDate.of(2022, Month.APRIL, 11));
		danceClass11.setActive(true);
			
		expected1.add(danceClass13);
		expected2.add(danceClass11);
			
		return new Object[][] { { new Schedule(4), expected1 }, { new Schedule(1), expected2 }};
	}

	@Test(groups = { "dao" }, dataProvider = "ReadActiveBySchedule")

	public void testReadActiveBySchedule(Schedule schedule, List <DanceClass> expected) throws DaoException {

		Connection connection = ConnectionPool.getInstance().getConnection();
		DaoFactory factory = new DaoFactory (connection);
		List <DanceClass>  actual = factory.getDanceClassDao().readActiveBySchedule (schedule);
		assertEquals(actual, expected);
	}
}