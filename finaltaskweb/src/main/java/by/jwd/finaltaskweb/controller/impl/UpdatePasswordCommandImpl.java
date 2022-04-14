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

public class UpdatePasswordCommandImpl implements Command{

	private static Logger logger = LogManager.getLogger(UpdatePasswordCommandImpl.class);

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

		String login = request.getParameter("login");

		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");

		try {
			if (!(password.equals(confirmPassword))) {
				request.setAttribute("errorPassRegMessage", manager.getProperty("errorPassRegMessage"));
				page = ConfigurationManager.getProperty("path.page.registration");

			} else if (factory.getUserService().readByLogin(login) == null) {
				request.setAttribute("errorNoLoginMessage", manager.getProperty("errorNoLoginMessage"));
				page = ConfigurationManager.getProperty("path.page.registration");
				logger.debug(factory.getUserService().readByLogin(login));

			} else {
				Integer clientId = (factory.getUserService().readByLogin(login).getId());

				if (factory.getUserService().updatePassword(clientId, password)) {
					request.setAttribute("successUpdatePassMessage", manager.getProperty("successUpdatePassMessage"));
					page = ConfigurationManager.getProperty("path.page.login");
				} else {
					request.setAttribute("errorMessage", manager.getProperty("errorMessage"));
					page = ConfigurationManager.getProperty("path.page.login");
				}
			}
		} catch (ServiceException e) {
			request.setAttribute("errorRegMessage", manager.getProperty("errorRegMessage"));
			page = ConfigurationManager.getProperty("path.page.login");
		}
		return page;
	}
}