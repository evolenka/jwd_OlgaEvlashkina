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
import by.jwd.finaltaskweb.controller.MessageManager;
import by.jwd.finaltaskweb.entity.DanceClass;
import by.jwd.finaltaskweb.entity.Group;
import by.jwd.finaltaskweb.entity.Membership;
import by.jwd.finaltaskweb.service.ServiceException;
import by.jwd.finaltaskweb.service.ServiceFactory;

public class ConfirmVisitCommandImpl implements Command {

	private static Logger logger = LogManager.getLogger(ConfirmVisitCommandImpl.class);

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

		try {

			if (session.getAttribute("danceClassId") == null || session.getAttribute("group") == null) {
				session.setAttribute("noSession", manager.getProperty("noSession"));
			} else {

				Integer membershipId = Integer.parseInt(request.getParameter("membershipId"));

				Membership membership = factory.getMembershipService().readEntityById(membershipId);
				session.setAttribute("membership", membership);

			}
			page = ConfigurationManager.getProperty("path.page.enrollment3");
		} catch (ServiceException e) {
			logger.error(e);
		}
		return page;
	}
}