package by.jwd.task07xmlparser.service.impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
import by.jwd.task07xmlparser.service.VisitXmlTag;
import by.jwd.task07xmlparser.service.XMLValidation;

/**
 * Parsing of xml file by STAX parser
 * 
 * @author Evlashkina
 */
public class StaxParserImpl extends BaseBuilder {

	static Logger logger = LogManager.getLogger(StaxParserImpl.class);

	private XMLInputFactory inputFactory;

	public StaxParserImpl() {
		inputFactory = XMLInputFactory.newInstance();
		visits = new HashSet<>();
	}

	@Override
	public void buildSetVisits(String filename, String xsdFile) {

		XMLValidation validation = new XMLValidation();

		validation.isValid(filename, xsdFile);

		XMLStreamReader reader;
		String name;

		try {
			FileInputStream inputStream = new FileInputStream(filename);

			reader = inputFactory.createXMLStreamReader(inputStream);

			while (reader.hasNext()) {
				int type = reader.next();
				if (type == XMLStreamConstants.START_ELEMENT) {
					name = reader.getLocalName();
					if (name.equals(VisitXmlTag.VISIT.getValue())) {
						Visit visit = buildVisit(reader);
						visits.add(visit);
						logger.debug("visit has been added to visits");
					}
				}
			}
		} catch (XMLStreamException | IOException e) {
			logger.debug("XMLStreamExceptionvisit or IOException has been catched");
		}

		visits = getVisits();
	}

	private Visit buildVisit(XMLStreamReader reader) throws XMLStreamException {
		Visit visit = new Visit();
		visit.setId(Integer.parseInt(reader.getAttributeValue(null, "id")));
		if (reader.getAttributeValue(null, "status") != null) {
			visit.setStatus(Status.valueOf(reader.getAttributeValue(null, "status")));
		}
		String name;

		while (reader.hasNext()) {
			int type = reader.next();
			if (type == XMLStreamConstants.START_ELEMENT) {
				name = reader.getLocalName();
				switch (VisitXmlTag.valueOf(name.toUpperCase())) {
				case CLIENT -> visit.setClient(buildClient(reader));
				case DANCECLASS -> visit.setDanceClass(buildDanceClass(reader));
				default -> throw new IllegalArgumentException(
						"Unexpected value: " + VisitXmlTag.valueOf(name.toUpperCase()));
				}
			}

			else if (type == XMLStreamConstants.END_ELEMENT) {
				name = reader.getLocalName();
				if (VisitXmlTag.valueOf(name.toUpperCase()) == VisitXmlTag.VISIT) {
					logger.debug("visit element has been parsed {}", visit);
					return visit;
				}
			}
		}
		throw new XMLStreamException("Unknown element in tag <visit>");
	}

	private Client buildClient(XMLStreamReader reader) throws XMLStreamException {
		Client client = new Client();
		client.setId(Integer.parseInt(reader.getAttributeValue(null, "id")));
		client.setLogin(reader.getAttributeValue(null, "login"));
		client.setRole(Role.valueOf(reader.getAttributeValue(null, "role")));
		if (reader.getAttributeValue(null, "phone") != null) {
			client.setPhone(reader.getAttributeValue(null, "phone"));
		}
		if (reader.getAttributeValue(null, "email") != null) {
			client.setEmail(reader.getAttributeValue(null, "email"));
		}

		String name;
		while (reader.hasNext()) {
			int type = reader.next();
			if (type == XMLStreamConstants.START_ELEMENT) {
				name = reader.getLocalName();
				switch (VisitXmlTag.valueOf(name.toUpperCase())) {
				case NAME -> client.setName(getXMLText(reader));
				case SURNAME -> client.setSurname(getXMLText(reader));
				case PATRONYMIC -> client.setPatronymic(getXMLText(reader));
				case PASSWORD -> client.setPassword(getXMLText(reader));
				default -> throw new IllegalArgumentException(
						"Unexpected value: " + VisitXmlTag.valueOf(name.toUpperCase()));
				}
			}

			else if (type == XMLStreamConstants.END_ELEMENT) {
				name = reader.getLocalName();
				if (VisitXmlTag.valueOf(name.toUpperCase()) == VisitXmlTag.CLIENT) {
					logger.debug("client element has been parsed {}", client);
					return client;
				}
			}
		}
		throw new XMLStreamException("Unknown element in tag <visit>");
	}

	private DanceClass buildDanceClass(XMLStreamReader reader) throws XMLStreamException {
		DanceClass danceClass = new DanceClass();
		danceClass.setId(Integer.parseInt(reader.getAttributeValue(null, "id")));

		String name;

		while (reader.hasNext()) {
			int type = reader.next();
			switch (type) {
			case XMLStreamConstants.START_ELEMENT:
				name = reader.getLocalName();
				switch (VisitXmlTag.valueOf(name.toUpperCase())) {
				case SCHEDULE -> danceClass.setSchedule(buildSchedule(reader));
				case DATE -> {
					try {
						danceClass.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(getXMLText(reader)));
					} catch (ParseException | XMLStreamException e) {
						logger.debug("error parsing of the time");
					}
				}
				default -> throw new IllegalArgumentException(
						"Unexpected value: " + VisitXmlTag.valueOf(name.toUpperCase()));
				}
				break;

			case XMLStreamConstants.END_ELEMENT:
				name = reader.getLocalName();
				if (VisitXmlTag.valueOf(name.toUpperCase()) == VisitXmlTag.DANCECLASS) {
					logger.debug("danceClass element has been parsed {}", danceClass);
					return danceClass;
				}
			}
		}
		throw new XMLStreamException("Unknown element in tag <danceclass>");
	}

	private Schedule buildSchedule(XMLStreamReader reader) throws XMLStreamException {
		Schedule schedule = new Schedule();
		schedule.setId(Integer.parseInt(reader.getAttributeValue(null, "id")));
		schedule.setWeekDay(WeekDay.valueOf(reader.getAttributeValue(null, "weekDay")));

		String name;

		while (reader.hasNext()) {
			int type = reader.next();
			if (type == XMLStreamConstants.START_ELEMENT) {
				name = reader.getLocalName();
				switch (VisitXmlTag.valueOf(name.toUpperCase())) {
				case TIME -> {
					try {
						schedule.setTime(new SimpleDateFormat("HH:mm").parse(getXMLText(reader)));
					} catch (ParseException | XMLStreamException e) {
						logger.debug("error parsing of the time");
					}
				}
				case DURATION -> schedule.setDuration(Integer.parseInt(getXMLText(reader)));
				case GROUP -> schedule.setGroup(buildGroup(reader));
				default -> throw new IllegalArgumentException(
						"Unexpected value: " + VisitXmlTag.valueOf(name.toUpperCase()));
				}
			} else if (type == XMLStreamConstants.END_ELEMENT) {
				name = reader.getLocalName();
				if (VisitXmlTag.valueOf(name.toUpperCase()) == VisitXmlTag.SCHEDULE) {
					logger.debug("schedule element has been parsed {}", schedule);
					return schedule;
				}
			}
		}
		throw new XMLStreamException("Unknown element in tag <schedule>");
	}

	private Group buildGroup(XMLStreamReader reader) throws XMLStreamException {
		Group group = new Group();
		group.setId(Integer.parseInt(reader.getAttributeValue(null, "id")));
		group.setLevel(Level.valueOf(reader.getAttributeValue(null, "level")));

		String name;

		while (reader.hasNext()) {
			int type = reader.next();
			if (type == XMLStreamConstants.START_ELEMENT) {
				name = reader.getLocalName();
				switch (VisitXmlTag.valueOf(name.toUpperCase())) {
				case TITLE -> group.setTitle(getXMLText(reader));
				case TEACHER -> group.setTeacher(buildTeacher(reader));
				default -> throw new IllegalArgumentException(
						"Unexpected value: " + VisitXmlTag.valueOf(name.toUpperCase()));
				}
			} else if (type == XMLStreamConstants.END_ELEMENT) {
				name = reader.getLocalName();
				if (VisitXmlTag.valueOf(name.toUpperCase()) == VisitXmlTag.GROUP) {
					logger.debug("group element has been parsed {}", group);
					return group;
				}
			}
		}
		throw new XMLStreamException("Unknown element in tag <group>");
	}

	private Teacher buildTeacher(XMLStreamReader reader) throws XMLStreamException {
		Teacher teacher = new Teacher();
		teacher.setId(Integer.parseInt(reader.getAttributeValue(null, "id")));
		teacher.setLogin(reader.getAttributeValue(null, "login"));
		teacher.setRole(Role.valueOf(reader.getAttributeValue(null, "role")));

		String name;

		while (reader.hasNext()) {
			int type = reader.next();
			if (type == XMLStreamConstants.START_ELEMENT) {
				name = reader.getLocalName();
				switch (VisitXmlTag.valueOf(name.toUpperCase())) {
				case NAME -> teacher.setName(getXMLText(reader));
				case SURNAME -> teacher.setSurname(getXMLText(reader));
				case DANCESTYLE -> teacher.setDanceStyle(getXMLText(reader));
				case PASSWORD -> teacher.setPassword(getXMLText(reader));
				default -> throw new IllegalArgumentException(
						"Unexpected value: " + VisitXmlTag.valueOf(name.toUpperCase()));
				}
			} else if (type == XMLStreamConstants.END_ELEMENT) {
				name = reader.getLocalName();
				if (VisitXmlTag.valueOf(name.toUpperCase()) == VisitXmlTag.TEACHER) {
					logger.debug("teacher element has been parsed");
					logger.debug(teacher);
					return teacher;
				}
			}
		}
		throw new XMLStreamException("Unknown element in tag <teacher>");
	}

	private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
		String text = null;
		if (reader.hasNext()) {
			reader.next();
			text = reader.getText();
		}
		logger.debug("text content {}", text);
		return text;
	}
}