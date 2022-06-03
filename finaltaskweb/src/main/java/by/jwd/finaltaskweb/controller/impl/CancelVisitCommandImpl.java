
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
			Integer visitId = Integer.parseInt(request.getParameter("visit"));
			logger.debug("visit id{}", visitId);

			if (factory.getVisitService().delete(visitId)) {
				request.setAttribute("successCancelMessage", manager.getProperty("successCancelMessage"));
			} else {
				request.setAttribute("errorCancelMessage", manager.getProperty("errorCancelMessage"));
			}

		} catch (ServiceException e) {
			request.setAttribute("errorCancelMessage", manager.getProperty("errorCancelMessage"));
			logger.error(e);
		}
		page = ConfigurationManager.getProperty("path.page.myPlannedVisits");
		return page;
	}
}