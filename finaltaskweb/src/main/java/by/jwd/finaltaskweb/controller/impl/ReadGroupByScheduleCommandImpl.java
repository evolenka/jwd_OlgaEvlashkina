package by.jwd.finaltaskweb.controller.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.finaltaskweb.controller.Command;
import by.jwd.finaltaskweb.controller.ConfigurationManager;
import by.jwd.finaltaskweb.controller.MessageManager;
import by.jwd.finaltaskweb.entity.Group;
import by.jwd.finaltaskweb.entity.WeekDay;
import by.jwd.finaltaskweb.service.ServiceException;
import by.jwd.finaltaskweb.service.ServiceFactory;

public class ReadGroupByScheduleCommandImpl implements Command {

	private static Logger logger = LogManager.getLogger(ReadGroupByScheduleCommandImpl.class);

	private ServiceFactory factory = ServiceFactory.getInstance();

	@Override
	public String execute(HttpServletRequest request) {

		String page = null;
		HttpSession session = request.getSession(true);
		String language = (String) session.getAttribute("language");
		logger.debug("language {}", language);

		MessageManager manager;

		switch (language) {
		case "en":
			manager = MessageManager.EN;
			break;
		case "ru":
			manager = MessageManager.RU;
			break;
		case "be":
			manager = MessageManager.BY;
			break;
		default:
			manager = MessageManager.EN;
		}

		
		String [] days = request.getParameterValues("weekdays");
		List <WeekDay> weekdays = new ArrayList <>();
		
		for (String day:days) {
			weekdays.add (WeekDay.valueOf(day));
		}
		
		try {
			List<Group> groups = factory.getGroupService().readByWeekDay(weekdays);
			request.setAttribute("groups", groups);
			page = ConfigurationManager.getProperty("path.page.groups");
		} catch (ServiceException e) {
			request.setAttribute("errorMessage", manager.getProperty("errorMessage"));
			page = ConfigurationManager.getProperty("path.page.groups");
			logger.error(" request has been failed");
		}
		return page;
	}
}