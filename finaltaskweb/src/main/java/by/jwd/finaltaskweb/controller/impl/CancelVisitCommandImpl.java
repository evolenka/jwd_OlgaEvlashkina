
package by.jwd.finaltaskweb.controller.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.finaltaskweb.controller.Command;
import by.jwd.finaltaskweb.controller.ConfigurationManager;
import by.jwd.finaltaskweb.controller.MessageManager;
import by.jwd.finaltaskweb.service.ServiceException;
import by.jwd.finaltaskweb.service.ServiceFactory;

/**
 * CancelVisitCommandImpl implements command to cancel planned visit by client
 * in his private account
 * 
 * @author Evlashkina
 *
 */
public class CancelVisitCommandImpl implements Command {

	private static Logger logger = LogManager.getLogger(CancelVisitCommandImpl.class);

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
		case "be","be_BY":
			manager = MessageManager.BY;
			break;
		default:
			manager = MessageManager.EN;
		}
		
		Integer clientId = (Integer) session.getAttribute("clientId");

		try {
			if (clientId == null) {
				request.setAttribute("errorNoSession", manager.getProperty("errorNoSession"));
				logger.debug("session timed out");

			} else {

				if (request.getParameter("plannedvisitId") != null) {
					session.setAttribute("plannedvisitId", request.getParameter("plannedvisitId"));
				}
		
			Integer visitId = Integer.parseInt((String)session.getAttribute("plannedvisitId"));
			logger.debug("planned visit id{}", visitId);

			if (factory.getVisitService().delete(visitId)) {
				request.setAttribute("successCancelMessage", manager.getProperty("successCancelMessage"));
			} else {
				request.setAttribute("errorCancelMessage", manager.getProperty("errorCancelMessage"));
			}
				}
				page = ConfigurationManager.getProperty("path.page.myPlannedVisits");
		} catch (ServiceException e) {
			request.setAttribute("errorCancelMessage", manager.getProperty("errorCancelMessage"));
		}
		
		return page;
	}
}