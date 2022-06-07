
package by.jwd.finaltaskweb.controller.impl;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.finaltaskweb.controller.Command;
import by.jwd.finaltaskweb.controller.ConfigurationManager;
import by.jwd.finaltaskweb.entity.Group;
import by.jwd.finaltaskweb.service.ServiceException;
import by.jwd.finaltaskweb.service.ServiceFactory;

/**
 * ReadGroupByStyleCommandImpl implements command for viewing all groups
 * filtered by chosen dance style by client while picking up the dance class
 * 
 * @author Evlashkina
 *
 */
public class ReadGroupByStyleCommandImpl implements Command {

	private static Logger logger = LogManager.getLogger(ReadGroupByStyleCommandImpl.class);

	private ServiceFactory factory = ServiceFactory.getInstance();

	@Override
	public String execute(HttpServletRequest request) {

		String page = null;
		HttpSession session = request.getSession(true);
		String language = (String) session.getAttribute("language");
		logger.debug("language {}", language);


		String style = request.getParameter("style");
		/*Enumeration<String> params = request.getParameterNames();
		while (params.hasMoreElements()) {
			logger.debug(params.nextElement());
		}
			*/	
		logger.debug("style {}",style);

		try {
			List<Group> groups = factory.getGroupService().readByDanceStyle(style);
			request.setAttribute("groups", groups);
			page = ConfigurationManager.getProperty("path.page.chooseGroupByStyle");
		} catch (ServiceException e) {
			logger.error(e);
		}
		return page;
	}
}