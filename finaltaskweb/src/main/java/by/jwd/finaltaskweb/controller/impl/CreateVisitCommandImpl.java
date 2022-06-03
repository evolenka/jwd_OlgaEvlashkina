package by.jwd.finaltaskweb.controller.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.finaltaskweb.controller.Command;
import by.jwd.finaltaskweb.controller.ConfigurationManager;
import by.jwd.finaltaskweb.controller.MessageManager;
import by.jwd.finaltaskweb.entity.DanceClass;
import by.jwd.finaltaskweb.entity.Membership;
import by.jwd.finaltaskweb.entity.Visit;
import by.jwd.finaltaskweb.service.ServiceException;
import by.jwd.finaltaskweb.service.ServiceFactory;

/**
 * CreateVisitCommandImpl implements command to make enrollment for dance
 * classes by client
 * 
 * @author Evlashkina
 *
 */
public class CreateVisitCommandImpl implements Command {

	private static Logger logger = LogManager.getLogger(CreateVisitCommandImpl.class);

	private ServiceFactory factory = ServiceFactory.getInstance();

	@Override
	public String execute(HttpServletRequest request) {

		String page;
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
			String classId = (request.getParameter("class"));
			logger.debug("class id{}", classId);
			Integer membershipId = Integer.parseInt(request.getParameter("membership"));
			logger.debug("membership id {}", membershipId);

			Membership membership = factory.getMembershipService().readEntityById(membershipId);

			DanceClass danceClass = factory.getDanceClassService().readEntityById(Integer.parseInt(classId));
			Visit visit = factory.getVisitbuilder().buildVisit(membership, danceClass);
			
			if (factory.getVisitService().create(visit)) {
				request.setAttribute("successVisitMessage", manager.getProperty("successVisitMessage"));
			} else {
				request.setAttribute("errorVisitMessage", manager.getProperty("errorVisitMessage"));
			}
		} catch (ServiceException e) {
			request.setAttribute("errorVisitMessage", manager.getProperty("errorVisitMessage"));
			logger.error(e);
		}
		page = ConfigurationManager.getProperty("path.page.enrollment");
		return page;
	}
}