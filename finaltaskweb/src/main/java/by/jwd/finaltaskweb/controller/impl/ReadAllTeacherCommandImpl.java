package by.jwd.finaltaskweb.controller.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.finaltaskweb.controller.Command;
import by.jwd.finaltaskweb.controller.ConfigurationManager;
import by.jwd.finaltaskweb.entity.Teacher;
import by.jwd.finaltaskweb.service.ServiceException;
import by.jwd.finaltaskweb.service.ServiceFactory;

public class ReadAllTeacherCommandImpl implements Command {

	static Logger logger = LogManager.getLogger(ReadAllTeacherCommandImpl.class);

	ServiceFactory servicefactory = ServiceFactory.getInstance();

	@Override
	public String execute(HttpServletRequest request) {

		String page = null;

		List<Teacher> teachers ;
		try {
			teachers = servicefactory.getUserService().readAllTeacher();
			request.setAttribute("teachers", teachers);
			page = ConfigurationManager.getProperty("path.page.teacher");
			logger.debug("page {}", page);
		} catch (ServiceException e) {
			logger.error("error");
		}
		return page;

	}
} 
