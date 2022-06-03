package by.jwd.finaltaskweb.controller.impl;

import java.util.ArrayList;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.finaltaskweb.controller.Command;
import by.jwd.finaltaskweb.controller.ConfigurationManager;
import by.jwd.finaltaskweb.entity.Group;
import by.jwd.finaltaskweb.entity.WeekDay;
import by.jwd.finaltaskweb.service.ServiceException;
import by.jwd.finaltaskweb.service.ServiceFactory;

/**
 * ReadGroupByScheduleCommandImpl implements command for viewing all groups
 * filtered by chosen week day(s) on the enrollment page
 * 
 * @author Evlashkina
 *
 */
public class ReadGroupByScheduleCommandImpl implements Command {

	private static Logger logger = LogManager.getLogger(ReadGroupByScheduleCommandImpl.class);

	private ServiceFactory factory = ServiceFactory.getInstance();

	@Override
	public String execute(HttpServletRequest request) {

		String page = null;
		HttpSession session = request.getSession(true);
		String language = (String) session.getAttribute("language");
		logger.debug("language {}", language);

		
		String [] days = request.getParameterValues("weekday");
		logger.debug(days.toString());
		
		List <WeekDay> weekdays = new ArrayList <>();
		
		for (String day:days) {
			weekdays.add (WeekDay.valueOf(day));
		}
		
		try {
			List<Group> groups = factory.getGroupService().readByWeekDay(weekdays);
			request.setAttribute("groups", groups);
			page = ConfigurationManager.getProperty("path.page.enrollment2");
		} catch (ServiceException e) {
			logger.error(e);
		}
		return page;
	}
}