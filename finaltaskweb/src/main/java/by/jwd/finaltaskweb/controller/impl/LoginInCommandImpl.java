package by.jwd.finaltaskweb.controller.impl;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.finaltaskweb.service.ServiceFactory;

public class LoginInCommandImpl {
	
//	static Logger logger = LogManager.getLogger(ReadAllClientCommandImpl.class);
//
//	 private static final String PARAM_NAME_LOGIN = "login";
//	 private static final String PARAM_NAME_PASSWORD = "password";
//
//	@Override
//	public String execute(HttpServletRequest request) {
//
//		ServiceFactory servicefactory = ServiceFactory.getInstance();
//
//			 String page = null;
//			 // извлечение из запроса логина и пароля
//			 String login = request.getParameter(PARAM_NAME_LOGIN);
//			 String pass = request.getParameter(PARAM_NAME_PASSWORD);
//			 // проверка логина и пароля
//			 if (LoginLogic.checkLogin(login, pass)) {
//			 request.setAttribute("user", login);
//			 // определение пути к main.jsp
//			 page = ConfigurationManager.getProperty("path.page.main");
//			 } else {
//			 request.setAttribute("errorLoginPassMessage",
//			 MessageManager.getProperty("message.loginerror"));
//			 page = ConfigurationManager.getProperty("path.page.login");
//			 }
//			 return page;
//			 }
//			 }

}
