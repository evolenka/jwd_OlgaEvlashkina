package by.jwd.finaltaskweb.controller;

import javax.servlet.http.HttpServletRequest;

public class EmptyCommand implements Command {
	@Override
	public String execute(HttpServletRequest request) {
		/*
		 * в случае ошибки или прямого обращения к контроллеру переадресация на страницу
		 * ввода логина
		 */
		String page = ConfigurationManager.getProperty("path.page.login");
		return page;
	}
}