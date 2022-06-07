package by.jwd.finaltaskweb.controller.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.finaltaskweb.controller.Command;
import by.jwd.finaltaskweb.controller.ConfigurationManager;
import by.jwd.finaltaskweb.entity.Group;
import by.jwd.finaltaskweb.entity.Level;
import by.jwd.finaltaskweb.service.ServiceException;
import by.jwd.finaltaskweb.service.ServiceFactory;

/**
 * ReadGroupByDateCommandImpl implements command for viewing all groups
 * filtered by chosen date on the enrollment page
 * 
 * @author Evlashkina
 *
 */

public class ReadGroupByDateCommandImpl implements Command {

	private static Logger logger = LogManager.getLogger(ReadGroupByDateCommandImpl.class);

	private ServiceFactory factory = ServiceFactory.getInstance();

	@Override
	public String execute(HttpServletRequest request) {

		String page = null;
		HttpSession session = request.getSession(true);
		String language = (String) session.getAttribute("language");
		logger.debug("language {}", language);
		
		session.setAttribute("date", request.getParameter("date"));
		logger.debug("date {}", request.getParameter("date"));

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate date = LocalDate.parse(request.getParameter("date"), formatter);

		try {
			List<Group> groups = factory.getGroupService().readByDate(date);
			request.setAttribute("groups", groups);
			page = ConfigurationManager.getProperty("path.page.enrollment");
		} catch (ServiceException e) {
			logger.error(e);
		}
		return page;
	}
}