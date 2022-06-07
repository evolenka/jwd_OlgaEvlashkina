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
			Integer danceClassId =  (Integer) session.getAttribute("danceClassId");
			logger.debug("danceClassId {}", danceClassId);
			
			Integer membershipId =  Integer.parseInt(request.getParameter("membershipId"));
			logger.debug("membershipId {}", membershipId);
			
			if (danceClassId == null) {
				session.setAttribute("noSession", manager.getProperty("noSession"));
			} else {
				
				Membership membership = factory.getMembershipService().readEntityById(membershipId);

				DanceClass danceClass = factory.getDanceClassService().readEntityById(danceClassId);
				Visit visit = factory.getVisitbuilder().buildVisit(membership, danceClass);

				if (factory.getVisitService().create(visit)) {
					request.setAttribute("successVisitMessage", manager.getProperty("successVisitMessage"));
					logger.debug("visit has been created");
				} else {
					request.setAttribute("errorVisitMessage", manager.getProperty("errorVisitMessage"));
				}
			}
			page = ConfigurationManager.getProperty("path.page.enrollment3");
		} catch (ServiceException e) {
			page = ConfigurationManager.getProperty("path.page.error");
			request.getSession().setAttribute("errorMessage", manager.getProperty("errorMessage"));
			logger.error(e);
		}

		return page;
	}
}