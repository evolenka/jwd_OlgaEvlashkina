package by.jwd.finaltaskweb.controller.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.finaltaskweb.controller.Command;
import by.jwd.finaltaskweb.controller.ConfigurationManager;
import by.jwd.finaltaskweb.entity.Group;
import by.jwd.finaltaskweb.entity.Level;
import by.jwd.finaltaskweb.service.ServiceException;
import by.jwd.finaltaskweb.service.ServiceFactory;

/**
 * ReadGroupByLevelCommandImpl implements command for viewing all groups
 * filtered by chosen level by client while picking up the dance class
 * 
 * @author Evlashkina
 *
 */

public class ReadGroupByLevelCommandImpl implements Command {

	private static Logger logger = LogManager.getLogger(ReadGroupByLevelCommandImpl.class);

	private ServiceFactory factory = ServiceFactory.getInstance();

	@Override
	public String execute(HttpServletRequest request) {

		String page = null;
		HttpSession session = request.getSession(true);
		String language = (String) session.getAttribute("language");
		logger.debug("language {}", language);

		Level level = Level.valueOf(request.getParameter("level"));

		try {
			List<Group> groups = factory.getGroupService().readByLevel(level);
			request.setAttribute("groups", groups);
			page = ConfigurationManager.getProperty("path.page.chooseGroupByLevel");
		} catch (ServiceException e) {
			logger.error(e);
		}
		return page;
	}
}