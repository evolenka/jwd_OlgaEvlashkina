package test.by.jwd.finaltaskweb.dao.suite;

import static org.testng.Assert.assertEquals;

import java.sql.Connection;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.jwd.finaltaskweb.dao.DaoException;
import by.jwd.finaltaskweb.dao.DaoFactory;
import by.jwd.finaltaskweb.dao.pool.ConnectionPool;
import by.jwd.finaltaskweb.entity.Client;
import by.jwd.finaltaskweb.entity.Role;
import by.jwd.finaltaskweb.entity.Teacher;
import by.jwd.finaltaskweb.entity.User;

public class ReadUserByLoginAndPasswordTest {
	

	static Logger logger = LogManager.getLogger(ReadUserByLoginAndPasswordTest.class);

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

	@DataProvider(name = "ReadByLoginAndPassword")
	public Object[][] createDataForReadByLogin() {
		
		Client client3 = new Client();
		client3.setId(8);
		client3.setLogin("vikkra");
		client3.setPassword("pfg78g4XWX8NI4PXz6h+c/vw==");
		client3.setName("Виктория");
		client3.setSurname("Кратова");
		client3.setRole(Role.CLIENT);
		client3.setPatronymic("Петровна");
		client3.setEmail("kratkovavikki@gmail.com");
		client3.setPhone("+375(44)789-41-78");
		
		
		Teacher teacher2 = new Teacher();
		teacher2.setId(3);
		teacher2.setLogin("divanov");
		teacher2.setPassword("rZDdprnLVXNuvafESK0DUA==");
		teacher2.setName("Дмитрий");
		teacher2.setSurname("Иванов");
		teacher2.setRole(Role.TEACHER);
		teacher2.setDanceStyle("hip-hop");
		teacher2.setPortfolio ("В танцах уже 18 лет. Опыт преподавания 6 лет. Постановщик и участник конкурсных программ, ТВ-Шоу, музыкальных клипов, рекламных видеороликов и подтанцовок");
		
	
		
		User user = new User();
		user.setId(1);
		user.setLogin("admin");
		user.setPassword("ACNLVsim8ADv4Su/8w4loeSwTw2yH2R3++Pvrfx5xlDGlx0cDRdQ9t0TLJd1a5pvZw==");
		user.setRole(Role.ADMIN);
		
		
		
		return new Object[][] { { "vikkra", "pfg78g4XWX8NI4PXz6h+c/vw==", client3 }, {"divanov", "rZDdprnLVXNuvafESK0DUA==", teacher2}, {"admin", "ACNLVsim8ADv4Su/8w4loeSwTw2yH2R3++Pvrfx5xlDGlx0cDRdQ9t0TLJd1a5pvZw==", user}};
	}

	@Test(groups = { "dao" }, dataProvider = "ReadByLoginAndPassword")

	public void testReadByLoginAndPassword(String login, String password, User expected) throws DaoException {

	
		Connection connection = ConnectionPool.getInstance().getConnection();
		DaoFactory factory = new DaoFactory (connection);
		User  actual = factory.getUserDao().readByLoginAndPassword (login, password);
		assertEquals(actual, expected);
	}
}