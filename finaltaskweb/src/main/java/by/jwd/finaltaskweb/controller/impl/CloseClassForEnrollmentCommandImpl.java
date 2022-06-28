package by.jwd.finaltaskweb.controller.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.finaltaskweb.controller.Command;
import by.jwd.finaltaskweb.controller.ConfigurationManager;
import by.jwd.finaltaskweb.controller.MessageManager;
import by.jwd.finaltaskweb.entity.DanceClass;
import by.jwd.finaltaskweb.service.ServiceException;
import by.jwd.finaltaskweb.service.ServiceFactory;

/**
 * CloseClassForEnrollmentCommandImpl implements command for closing enrollment
 * for class by admin
 * 
 * @author Evlashkina
 *
 */

public class CloseClassForEnrollmentCommandImpl implements Command {

	private static Logger logger = LogManager.getLogger(CloseClassForEnrollmentCommandImpl.class);

	private ServiceFactory factory = ServiceFactory.getInstance();

	@Override
	public String execute(HttpServletRequest request) {

		String page = null;

		HttpSession session = request.getSession(true);
		String language = session.getAttribute("language").toString();

		logger.debug("language {}", language);

		MessageManager manager;

		switch (language) {
		case "en", "en_US":
			manager = MessageManager.EN;
			break;
		case "ru", "ru_RU":
			manager = MessageManager.RU;
			break;
		case "be", "be_BY":
			manager = MessageManager.BY;
			break;
		default:
			manager = MessageManager.EN;
		}

		Integer adminId = (Integer) session.getAttribute("adminId");

		try {
			if (adminId == null) {
				request.setAttribute("errorNoSession", manager.getProperty("errorNoSession"));
				logger.debug("session timed out");
			} else {

			}

			if (request.getParameter("danceClassId") != null) {
				session.setAttribute("danceClassId", request.getParameter("danceClassId"));
			}
			logger.debug(request.getParameter("danceClassId"));
			Integer danceClassId = Integer.parseInt((String) session.getAttribute("danceClassId"));

			factory.getDanceClassService().changeForNoActive(danceClassId);
			LocalDate date = LocalDate.parse((String) session.getAttribute("classDate"));

			List<DanceClass> danceClasses = factory.getDanceClassService().readActiveByDate(date);

			if (!danceClasses.isEmpty()) {
				request.setAttribute("danceClasses", danceClasses);
			} else {
				request.setAttribute("noClasses", manager.getProperty("noClasses"));
			}

			page = ConfigurationManager.getProperty("path.page.danceClasses");
		} catch (ServiceException e) {
			request.setAttribute("errorMessage", manager.getProperty("errorMessage"));
			logger.debug("error");
			page = ConfigurationManager.getProperty("path.page.error");
		}
		return page;
	}
}
