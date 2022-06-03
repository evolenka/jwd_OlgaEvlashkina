package by.jwd.finaltaskweb.controller.impl;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.finaltaskweb.controller.Command;
import by.jwd.finaltaskweb.controller.ConfigurationManager;
import by.jwd.finaltaskweb.service.ServiceException;
import by.jwd.finaltaskweb.service.ServiceFactory;

/**
 * ReadAvailiableDatesByGroupCommandImpl implements command for viewing all
 * available dates for enrollment to the chosen group
 * 
 * @author Evlashkina
 *
 */
public class ReadAvailiableDatesByGroupCommandImpl implements Command {

	private static Logger logger = LogManager.getLogger(ReadAvailiableDatesByGroupCommandImpl.class);

	private ServiceFactory factory = ServiceFactory.getInstance();

	@Override
	public String execute(HttpServletRequest request) {

		String page = null;
		HttpSession session = request.getSession(true);
		String language = (String) session.getAttribute("language");
		logger.debug("language {}", language);

		Integer groupId = Integer.valueOf(request.getParameter("groupId"));
		logger.debug("groupId {}", groupId);

		try {

			List<LocalDate> dates = factory.getDanceClassService().readAvailiableDatesByGroup(groupId);
			request.setAttribute("dates", dates);
			page = ConfigurationManager.getProperty("path.page.enrollment3");
		} catch (ServiceException e) {
			logger.error(e);
		}
		return page;
	}
}