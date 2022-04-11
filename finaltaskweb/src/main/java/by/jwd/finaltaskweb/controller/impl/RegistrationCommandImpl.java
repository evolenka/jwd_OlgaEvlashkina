package by.jwd.finaltaskweb.controller.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.finaltaskweb.controller.Command;
import by.jwd.finaltaskweb.controller.ConfigurationManager;
import by.jwd.finaltaskweb.controller.MessageManager;
import by.jwd.finaltaskweb.entity.Client;
import by.jwd.finaltaskweb.entity.User;
import by.jwd.finaltaskweb.service.ServiceException;
import by.jwd.finaltaskweb.service.ServiceFactory;

public class RegistrationCommandImpl implements Command {

	private static Logger logger = LogManager.getLogger(RegistrationCommandImpl.class);

	private ServiceFactory factory = ServiceFactory.getInstance();

	@Override
	public String execute(HttpServletRequest request) {

		String page = null;
		
		HttpSession session = request.getSession(true);
		String language = "en";
				//(String) session.getAttribute("language");//to do
		
		logger.debug("language {}", language);
		
		MessageManager manager = MessageManager.EN;

		switch (language) {
			case "en":
				manager = MessageManager.EN;
				break;
			case "ru":
				manager = MessageManager.RU;
				break;
			case "be":
				manager = MessageManager.BY;
			default:
				manager = MessageManager.EN;
			}

		String login = request.getParameter("login");
		logger.debug("login {}", login);
		String password = request.getParameter("password");
		logger.debug("password {}", password);
		String password2 = request.getParameter("confirmPassword");
		logger.debug("password2 {}", password2);
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
			if (login == null || password == null || password2 == null || surname == null || name == null
					|| patronymic == null || email == null) {
				request.setAttribute("errorRequiredFieldRegMessage",
						manager.getProperty("errorRequiredFieldRegMessage"));
				page = ConfigurationManager.getProperty("path.page.registration");
			} 
			 if (!(password.equals(password2))) {
				request.setAttribute("errorPassRegMessage", manager.getProperty("errorPassRegMessage"));
				page = ConfigurationManager.getProperty("path.page.registration");
			} 
			 User user = factory.getUserService().readByLogin(login);
			 logger.debug(user);
			 if (user != null) {
				request.setAttribute("errorLoginMessage", manager.getProperty("errorLoginMessage"));
				page = ConfigurationManager.getProperty("path.page.registration");
				logger.debug(factory.getUserService().readByLogin(login));;
			}
			 
				Client client = factory.getClientBuilder().buildClient(login, password, surname, name, patronymic,
						phone, email);
				logger.debug(factory.getUserService().create(client));
				if (factory.getUserService().create(client)) {
					request.setAttribute("successRegMessage", manager.getProperty("successRegMessage"));
					page = ConfigurationManager.getProperty("path.page.index");
				}
			
		} catch (ServiceException e) {
			request.setAttribute("errorRegMessage", manager.getProperty("errorRegMessage"));
			page = ConfigurationManager.getProperty("path.page.registration");
		}
		return page;
	}
}