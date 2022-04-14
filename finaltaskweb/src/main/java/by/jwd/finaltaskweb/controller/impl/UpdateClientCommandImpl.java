package by.jwd.finaltaskweb.controller.impl;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.finaltaskweb.controller.Command;
import by.jwd.finaltaskweb.controller.ConfigurationManager;
import by.jwd.finaltaskweb.controller.MessageManager;
import by.jwd.finaltaskweb.entity.Client;
import by.jwd.finaltaskweb.service.ServiceException;
import by.jwd.finaltaskweb.service.ServiceFactory;

public class UpdateClientCommandImpl implements Command {

	private static Logger logger = LogManager.getLogger(UpdateClientCommandImpl.class);

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
		
		Integer id = (Integer) session.getAttribute("id");
		logger.debug("login {}", id);
		
		String login = request.getParameter("login");
		logger.debug("login {}", login);
		String password = request.getParameter("password");
		logger.debug("password {}", password);
		String surname = request.getParameter("surname");
		logger.debug("surname {}", surname);
		String name = request.getParameter("name");
		logger.debug("name {}", name);
		String patronymic = request.getParameter("patronymic");
		logger.debug("patronymic {}", patronymic);
		String email = request.getParameter("email");
		logger.debug("email {}", email);
		String phone = request.getParameter("phone");
		logger.debug("phone {}", phone);

		try {
			if (id != null) {
				Client client = factory.getClientBuilder().buildClient(id, login, password, surname, name, patronymic,
						email, phone);
				if(factory.getUserService().update(client)) {
					request.setAttribute("successUpdateClientMessage", manager.getProperty("successUpdateClientMessage"));
					page = ConfigurationManager.getProperty("path.page.profile");
				} else {
					request.setAttribute("errorMessage", manager.getProperty("errorMessage"));
					page = ConfigurationManager.getProperty("path.page.profile");
				}
			}
		} catch (ServiceException e) {
			request.setAttribute("errorMessage", manager.getProperty("errorMessage"));
			page = ConfigurationManager.getProperty("path.page.profile");
		}
		return page;
	}
}