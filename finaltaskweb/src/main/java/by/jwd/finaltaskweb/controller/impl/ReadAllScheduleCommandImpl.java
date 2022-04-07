package by.jwd.finaltaskweb.controller.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.finaltaskweb.controller.Command;
import by.jwd.finaltaskweb.controller.ConfigurationManager;
import by.jwd.finaltaskweb.entity.Schedule;
import by.jwd.finaltaskweb.service.ServiceException;
import by.jwd.finaltaskweb.service.ServiceFactory;

public class ReadAllScheduleCommandImpl implements Command{
	
	static Logger logger = LogManager.getLogger(ReadAllScheduleCommandImpl.class);

	@Override
	public String execute(HttpServletRequest request) {

		String page = null;

		List<Schedule> schedule;
		try {
			
			schedule = ServiceFactory.getInstance().getScheduleService().readAll();
			
			request.setAttribute("schedule", schedule);
			page = ConfigurationManager.getProperty("path.page.schedule");
			logger.debug("page {}", page);
		} catch (ServiceException e) {
			logger.error("error");
		}
		return page;

	}
}