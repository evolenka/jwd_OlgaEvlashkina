package by.jwd.finaltaskweb.controller.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.finaltaskweb.controller.Command;
import by.jwd.finaltaskweb.controller.ConfigurationManager;
import by.jwd.finaltaskweb.controller.MessageManager;
import by.jwd.finaltaskweb.entity.Client;
import by.jwd.finaltaskweb.entity.Role;
import by.jwd.finaltaskweb.entity.User;
import by.jwd.finaltaskweb.service.ServiceException;
import by.jwd.finaltaskweb.service.ServiceFactory;

/**
 * LoginationCommandImpl implements command for logging in the private account
 * 
 * @author Evlashkina
 *
 */
public class LoginationCommandImpl implements Command {

	private static Logger logger = LogManager.getLogger(LoginationCommandImpl.class);

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
		logger.debug("login {}", login);
		String pass = request.getParameter("password");
		logger.debug("password {}", pass);

		User user = null;
		try {
			user = factory.getUserService().readByLoginAndPassword(login, pass);
		} catch (ServiceException e) {
			logger.error("data base connection error");
		}
		logger.debug("user {}", user);

		if (user != null) {

			// save user role as session attribute
			session.setAttribute("role", user.getRole());
			session.setAttribute("clientId", user.getId());
			
			StringBuilder userName = new StringBuilder("");
			
			if (Role.CLIENT == user.getRole()) {
				page = ConfigurationManager.getProperty("path.page.clientMain");
				userName.append(user.getName());
				userName.append(" ").append(((Client) user).getPatronymic());
				userName.append(" ").append(user.getSurname());
				
				logger.debug("current user is a client");
				
			} else if (Role.TEACHER == user.getRole()) {
				page = ConfigurationManager.getProperty("path.page.teacherMain");
				userName.append(user.getName());
				userName.append(" ").append(user.getSurname());
				
				logger.debug("current user is a teacher");
				
			} else if (Role.ADMIN == user.getRole()) {
				page = ConfigurationManager.getProperty("path.page.adminMain");
				userName.append(user.getName());
				
				logger.debug("current user is admin");
			}
			request.setAttribute("userName", userName.toString());
			session.setAttribute("userName", userName);
			
		} else {
			request.setAttribute("errorLogInMessage", manager.getProperty("errorlogInMessage"));
			page = ConfigurationManager.getProperty("path.page.login");
		}
		return page;
	}
}