package by.jwd.task07xmlparser.service.impl;

import java.io.File;
import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

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
import by.jwd.task07xmlparser.service.XMLValidation;

/**
 * Parsing of xml file with dance studio visits data by DOM parser
 * 
 * @author Evlashkina
 */

public class DomParserImpl extends BaseBuilder {

	static Logger logger = LogManager.getLogger(DomParserImpl.class);

	private DocumentBuilder docBuilder;

	public DomParserImpl() {
		visits = new HashSet<>();
	}

	public DomParserImpl(Set<Visit> visits) {
		super(visits);
	}

	@Override
	public void buildSetVisits(String filename, String xsdFile) {

		XMLValidation validation = new XMLValidation();
		validation.isValid(filename, xsdFile);

		String constant = XMLConstants.W3C_XML_SCHEMA_NS_URI;
		SchemaFactory xsdFactory = SchemaFactory.newInstance(constant);
		Schema schema = null;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		try {
			schema = xsdFactory.newSchema(new File(xsdFile));
			factory.setNamespaceAware(true);
			factory.setValidating(false);
			factory.setSchema(schema);

			docBuilder = factory.newDocumentBuilder();
			Document doc = docBuilder.parse(filename);

			Element root = doc.getDocumentElement();
			// getting a list of <visit> child elements
			NodeList visitList = root.getElementsByTagName("visit");
			for (int i = 0; i < visitList.getLength(); i++) {
				Element visitElement = (Element) visitList.item(i);
				Visit visit = buildVisit(visitElement);
				visits.add(visit);
			}
		} catch (SAXException |

				IOException | ParserConfigurationException e) {
			e.printStackTrace();
		}
	}

	private Visit buildVisit(Element visitElement) {
		Visit visit = new Visit();

		visit.setId(Integer.parseInt(visitElement.getAttribute("id")));
		Element clientElement = (Element) visitElement.getElementsByTagName("client").item(0);
		visit.setClient(buildClient(clientElement));
		Element danceClassElement = (Element) visitElement.getElementsByTagName("danceClass").item(0);
		visit.setDanceClass(buildDanceClass(danceClassElement));

		if (visitElement.hasAttribute("status")) {
			visit.setStatus(Status.valueOf(visitElement.getAttribute("status")));
		}
		return visit;
	}

	private Client buildClient(Element clientElement) {
		Client client = new Client();
		client.setId(Integer.parseInt(clientElement.getAttribute("id")));
		client.setLogin(clientElement.getAttribute("login"));
		client.setPassword(getElementTextContent(clientElement, "password"));
		client.setRole(Role.valueOf(clientElement.getAttribute("role")));
		client.setName(getElementTextContent(clientElement, "name"));
		client.setSurname(getElementTextContent(clientElement, "surname"));
		client.setPatronymic(getElementTextContent(clientElement, "patronymic"));
		if (clientElement.hasAttribute("email")) {
			client.setEmail(clientElement.getAttribute("email"));
		}
		if (clientElement.hasAttribute("phone")) {
			client.setPhone(clientElement.getAttribute("phone"));
		}
		logger.debug(client);
		return client;

	}

	private DanceClass buildDanceClass(Element danceClassElement) {
		DanceClass danceClass = new DanceClass();
		danceClass.setId(Integer.parseInt(danceClassElement.getAttribute("id")));
		Element scheduleElement = (Element) danceClassElement.getElementsByTagName("schedule").item(0);
		danceClass.setSchedule(buildSchedule(scheduleElement));
		Date date;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(getElementTextContent(danceClassElement, "date"));
			danceClass.setDate(date);
		} catch (ParseException e) {
			logger.error("error has bee found while parsing date of the danceClass");
		}
		return danceClass;
	}

	private Schedule buildSchedule(Element scheduleElement) {
		Schedule schedule = new Schedule();
		schedule.setId(Integer.parseInt(scheduleElement.getAttribute("id")));
		schedule.setWeekDay(WeekDay.valueOf(scheduleElement.getAttribute("weekDay")));
		schedule.setDuration(Integer.parseInt(getElementTextContent(scheduleElement, "duration")));
		Date time;
		try {
			time = new SimpleDateFormat("HH:mm").parse(getElementTextContent(scheduleElement, "time"));
			schedule.setTime(time);
		} catch (ParseException e) {
			logger.error("error has bee found while parsing time of the danceClass");
		}
		Element groupElement = (Element) scheduleElement.getElementsByTagName("group").item(0);
		schedule.setGroup(buildGroup(groupElement));
		return schedule;
	}

	private Group buildGroup(Element groupElement) {
		Group group = new Group();
		group.setId(Integer.parseInt(groupElement.getAttribute("id")));
		group.setTitle((getElementTextContent(groupElement, "title")));
		group.setLevel(Level.valueOf(groupElement.getAttribute("level")));
		Element teacherElement = (Element) groupElement.getElementsByTagName("teacher").item(0);
		group.setTeacher(buildTeacher(teacherElement));
		return group;
	}

	private Teacher buildTeacher(Element teacherElement) {
		Teacher teacher = new Teacher();
		teacher.setId(Integer.parseInt(teacherElement.getAttribute("id")));
		teacher.setLogin(teacherElement.getAttribute("login"));
		teacher.setPassword(getElementTextContent(teacherElement, "password"));
		teacher.setRole(Role.valueOf(teacherElement.getAttribute("role")));
		teacher.setName(getElementTextContent(teacherElement, "name"));
		teacher.setSurname(getElementTextContent(teacherElement, "surname"));
		teacher.setDanceStyle(getElementTextContent(teacherElement, "danceStyle"));
		return teacher;
	}

	// get the text content of the tag
	private static String getElementTextContent(Element element, String elementName) {
		NodeList nList = element.getElementsByTagName(elementName);
		Node node = nList.item(0);
		String text = null;
		if (node != null) {
			text = node.getTextContent();
		}
		return text;
	}
}