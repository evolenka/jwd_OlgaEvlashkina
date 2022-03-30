package by.jwd.task07xmlparser;

import static org.testng.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.jwd.task07xmlparser.entity.Client;
import by.jwd.task07xmlparser.entity.DanceClass;
import by.jwd.task07xmlparser.entity.Group;
import by.jwd.task07xmlparser.entity.Level;
import by.jwd.task07xmlparser.entity.Role;
import by.jwd.task07xmlparser.entity.Schedule;
import by.jwd.task07xmlparser.entity.Status;
import by.jwd.task07xmlparser.entity.Teacher;
import by.jwd.task07xmlparser.entity.Visit;
import by.jwd.task07xmlparser.entity.WeekDay;
import by.jwd.task07xmlparser.service.BaseBuilder;
import by.jwd.task07xmlparser.service.BuildFactory;
import by.jwd.task07xmlparser.service.ServiceException;


public class DomParserTest {
	
	static Logger logger = LogManager.getLogger(DomParserTest.class);
	
	Set<Visit> visits = new HashSet<>();
	
	@BeforeTest
    public void beforeTest() {
		
		Visit visit1 = new Visit();
		visit1.setStatus(Status.PLANNED);
		visit1.setId(1);

		Client client1 = new Client();
		client1.setId(5);
		client1.setLogin("MARKOVA");
		client1.setPassword("Uas78XWK8NI4PXz6h+b/vw==");
		client1.setName("Мария");
		client1.setSurname("Маркова");
		client1.setRole(Role.CLIENT);
		client1.setPatronymic("Алексеевна");
		client1.setEmail("markovamarialex@gmail.com");
		client1.setPhone("-");

		visit1.setClient(client1);

		DanceClass class1 = new DanceClass();
		class1.setId(1);

		Date date = null;
		try {
			date = new SimpleDateFormat("dd.MM.yyyy").parse("14.03.2022");
		} catch (ParseException e) {
			logger.debug("date parseException has been catched");
		}

		class1.setDate(date);

		Schedule schedule1 = new Schedule();
		schedule1.setId(1);
		schedule1.setWeekDay(WeekDay.MONDAY);

		Date time = new Date();
		try {
			time = new SimpleDateFormat("HH:mm").parse("18:00");
		} catch (ParseException e) {
			logger.debug(" time parseException has been catched");
		}

		schedule1.setTime(time);
		schedule1.setDuration(60);

		Group group1 = new Group();
		group1.setId(1);
		group1.setTitle("group1");
		group1.setLevel(Level.BEG);

		Teacher teacher1 = new Teacher();
		teacher1.setId(2);
		teacher1.setLogin("tpavlova");
		teacher1.setPassword("VLD1B6ane2DpKxt9PkIC9g==");
		teacher1.setName("Татьяна");
		teacher1.setSurname("Павлова");
		teacher1.setRole(Role.TEACHER);
		teacher1.setDanceStyle("contemporary");

		group1.setTeacher(teacher1);
		schedule1.setGroup(group1);
		class1.setSchedule(schedule1);
		visit1.setDanceClass(class1);

		Visit visit2 = new Visit();
		visit2.setStatus(Status.ATTENDED);
		visit2.setId(2);

		Client client2 = new Client();
		client2.setId(6);
		client2.setLogin("nataliana");
		client2.setPassword("U0Tcja4XuTrc4I9sWAIr6w==");
		client2.setName("Наталья");
		client2.setSurname("Андреева");
		client2.setRole(Role.CLIENT);
		client2.setPatronymic("Николаевна");
		client2.setEmail("nnandreeva85@mail.ru");
		client2.setPhone("+375(44)789-41-78");

		visit2.setClient(client2);
		visit2.setDanceClass(class1);
		visits.add(visit2);
		visits.add(visit1);
    }

	@DataProvider(name = "domParser")
	public Object[][] createDataDomParsing() {

	
		return new Object[][] { { new String[] { "testResourses/visitsTest.xml", "testResourses/visits.xsd" }, visits }
		};
	}

	@Test(groups = { "service" }, dataProvider = "domParser")
	public void testDomParser(String[] param, Set<Visit> result) throws ServiceException {

		BaseBuilder builder = BuildFactory.createParser("dom");

		builder.buildSetVisits(param[0], param[1]);
			Set<Visit> expected = builder.getVisits();
		Set<Visit> actual = result;
		assertEquals(actual, expected);
	}
}
