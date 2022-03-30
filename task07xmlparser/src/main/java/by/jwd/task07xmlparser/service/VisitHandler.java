package by.jwd.task07xmlparser.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

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

/**
 * Parsing of xml file with dance studio visits data by SAX parser
 * 
 * @author Evlashkina
 */

public class VisitHandler extends DefaultHandler {

	static Logger logger = LogManager.getLogger(VisitHandler.class);

	private Set<Visit> visits;
	private Visit currentVisit;
	private Client currentClient;
	private DanceClass currentDanceClass;
	private Group currentGroup;
	private Schedule currentSchedule;
	private Teacher currentTeacher;
	private VisitXmlTag currentXmlTag;

	private StringBuilder data = new StringBuilder();

	public VisitHandler() {
		visits = new HashSet<>();
	}

	public Set<Visit> getVisits() {

		return visits;
	}

	@Override
	public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attrs)
			throws SAXException {

		super.startElement(uri, localName, qName, attrs);
		currentXmlTag = VisitXmlTag.valueOf(qName.toUpperCase());

		switch (currentXmlTag) {
		case VISIT -> {
			logger.debug("start parsing of visit element");

			currentVisit = new Visit();
			currentVisit.setId(Integer.parseInt(attrs.getValue("id")));
			currentVisit.setStatus(Status.valueOf(attrs.getValue("status")));
		}
		case CLIENT -> {
			logger.debug("start parsing of client element");

			currentClient = new Client();
			currentClient.setId(Integer.parseInt(attrs.getValue("id")));
			currentClient.setLogin(attrs.getValue("login"));
			currentClient.setRole(Role.valueOf(attrs.getValue("role")));
			currentClient.setPhone(attrs.getValue("phone"));
			currentClient.setEmail(attrs.getValue("email"));
		}
		case DANCECLASS -> {
			logger.debug("start parsing of danceClass element");

			currentDanceClass = new DanceClass();
			currentDanceClass.setId(Integer.parseInt(attrs.getValue("id")));
		}
		case SCHEDULE -> {
			logger.debug("start parsing of schedule element");

			currentSchedule = new Schedule();
			currentSchedule.setId(Integer.parseInt(attrs.getValue("id")));
			currentSchedule.setWeekDay(WeekDay.valueOf(attrs.getValue("weekDay")));
		}
		case GROUP -> {
			logger.debug("start parsing of group element");

			currentGroup = new Group();
			currentGroup.setId(Integer.parseInt(attrs.getValue("id")));
			currentGroup.setLevel(Level.valueOf(attrs.getValue("level")));

		}
		case TEACHER -> {
			logger.debug("start parsing of teacher element");

			currentTeacher = new Teacher();
			currentTeacher.setId(Integer.parseInt(attrs.getValue("id")));
			currentTeacher.setLogin(attrs.getValue("login"));
			currentTeacher.setRole(Role.valueOf(attrs.getValue("role")));
		}
		case PASSWORD -> {
			logger.debug("start parsing of password element");
			data = new StringBuilder();
		}
		case NAME -> {
			logger.debug("start parsing of name element");
			data = new StringBuilder();
		}
		case SURNAME -> {
			logger.debug("start parsing of surname element");
			data = new StringBuilder();
		}
		case PATRONYMIC -> {
			logger.debug("start parsing of patronymic element");
			data = new StringBuilder();
		}
		case TIME -> {
			logger.debug("start parsing of time element");
			data = new StringBuilder();
		}
		case DATE -> {
			logger.debug("start parsing of date element");
			data = new StringBuilder();
		}
		case DURATION -> {
			logger.debug("start parsing of duration element");
			data = new StringBuilder();
		}
		case TITLE -> {
			logger.debug("start parsing of title element");
			data = new StringBuilder();
		}
		case DANCESTYLE -> {
			logger.debug("start parsing of dancestyle element");
			data = new StringBuilder();
		}
		default -> {
			currentXmlTag = VisitXmlTag.valueOf(qName.toUpperCase());
			logger.debug("default {}, currentXmlTag");
		}
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) {
		currentXmlTag = VisitXmlTag.valueOf(qName.toUpperCase());

		if (currentXmlTag != null) {
			switch (currentXmlTag) {

			case VISIT -> {
				visits.add(currentVisit);
				logger.debug("parsing of visit element has been completed{}", currentVisit);
				currentVisit = null;

			}
			case CLIENT -> {
				currentVisit.setClient(currentClient);
				logger.debug("parsing of client element has been completed{}", currentClient);
				currentClient = null;

			}
			case DANCECLASS -> {
				currentVisit.setDanceClass(currentDanceClass);
				logger.debug("parsing of danceClass element has been completed{}", currentDanceClass);
				currentDanceClass = null;
			}
			case SCHEDULE -> {
				currentDanceClass.setSchedule(currentSchedule);
				logger.debug("parsing of schedule element has been completed {}", currentSchedule);
				currentSchedule = null;
			}
			case GROUP -> {
				currentSchedule.setGroup(currentGroup);
				logger.debug("parsing of group element has been completed {}", currentGroup);
				currentGroup = null;
			}
			case TEACHER -> {
				currentGroup.setTeacher(currentTeacher);
				logger.debug("parsing of teacher element has been completed {}", currentTeacher);
				currentTeacher = null;
			}
			case PASSWORD -> {
				if (currentClient != null) {
					currentClient.setPassword(data.toString());
					logger.debug("parsing of password element for client has been completed {}", currentClient);
				} else {
					currentTeacher.setPassword(data.toString());
					logger.debug("parsing of password element for teacher has been completed {}", currentTeacher);
				}
			}
			case NAME -> {
				if (currentClient != null) {
					currentClient.setName(data.toString());
					logger.debug("parsing of name element for client has been completed {}", currentClient);
				} else {
					currentTeacher.setName(data.toString());
					logger.debug("parsing of name element for teacher has been completed {}", currentTeacher);
				}
			}
			case SURNAME -> {
				if (currentClient != null) {
					currentClient.setSurname(data.toString());
					logger.debug("parsing of surname element for client has been completed {}", currentClient);
				} else {
					currentTeacher.setSurname(data.toString());
					logger.debug("parsing of surname element for teacher has been completed {}", currentTeacher);
				}
			}
			case PATRONYMIC -> {
				currentClient.setPatronymic(data.toString());
				logger.debug("parsing of patronymic element has been completed {}", currentClient);
			}
			case TIME -> {
				try {
					currentSchedule.setTime(new SimpleDateFormat("HH:mm").parse(data.toString()));
					logger.debug("parsing of time element has been completed {}", currentSchedule);
				} catch (ParseException e) {
					logger.debug("error parsing of the time");
				}
			}
			case DATE -> {
				try {
					currentDanceClass.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(data.toString()));
					logger.debug("tag content has been parsed {}", currentDanceClass);
				} catch (ParseException e) {
					logger.debug("error parsing of the time");
				}
			}
			case DURATION -> {
				currentSchedule.setDuration(Integer.parseInt(data.toString()));
				logger.debug("parsing of duration element has been completed {}", currentSchedule);

			}
			case TITLE -> {
				currentGroup.setTitle(data.toString());
				logger.debug("parsing of title element has been completed {}", currentGroup);

			}
			case DANCESTYLE -> {
				currentTeacher.setDanceStyle(data.toString());
				logger.debug("parsing of dancestyle element has been completed {}", currentTeacher);

			}
			default -> {
				currentXmlTag = VisitXmlTag.valueOf(qName.toUpperCase());
				logger.debug("default end {}", currentXmlTag);
			}
			}
		}
		currentXmlTag = null;
	}

	@Override
	public void characters(char[] ch, int start, int length) {
		data.append(ch, start, length);
	}
}