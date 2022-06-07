package by.jwd.finaltaskweb.controller.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.finaltaskweb.controller.Command;
import by.jwd.finaltaskweb.controller.ConfigurationManager;
import by.jwd.finaltaskweb.controller.MessageManager;
import by.jwd.finaltaskweb.entity.DanceClass;
import by.jwd.finaltaskweb.entity.Group;
import by.jwd.finaltaskweb.entity.Membership;
import by.jwd.finaltaskweb.service.ServiceException;
import by.jwd.finaltaskweb.service.ServiceFactory;

public class ReadValidMembershipsByClientCommandImpl implements Command {

	private static Logger logger = LogManager.getLogger(ReadValidMembershipsByClientCommandImpl.class);

	private ServiceFactory factory = ServiceFactory.getInstance();

	@Override
	public String execute(HttpServletRequest request) {

		String page = null;
		List<Membership> validMemberships;

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

		Integer id = (Integer) session.getAttribute("clientId");
		logger.debug("client id {}", id);

			try {

				if (session.getAttribute("date") == null || id == null) {
					session.setAttribute("noSession", manager.getProperty("noSession"));
				} else {
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
					LocalDate date = LocalDate.parse((String) session.getAttribute("date"), formatter);

					Integer groupId = Integer.parseInt(request.getParameter("groupId"));

					DanceClass danceClass = factory.getDanceClassService().readByDateAndGroup(date, groupId);
					session.setAttribute("danceClassId", danceClass.getId());
					logger.debug("danceClassId {}", danceClass.getId());
					
					Group group = factory.getGroupService().readEntityById(groupId);
					session.setAttribute("group", group);
					logger.debug("group {}", group);
							
				validMemberships = factory.getMembershipService().readValidByClient(id);
				logger.debug("valid memberships {}", validMemberships);
				
				if (validMemberships.isEmpty()) {
					logger.debug("no valid memberships");
					session.setAttribute("noMembership", manager.getProperty("noMembership"));
				} else {
					session.setAttribute("validMemberships", validMemberships);
									
				}
			}
			page = ConfigurationManager.getProperty("path.page.enrollment2");
		} catch (ServiceException e) {
			logger.error(e);
		}
		return page;
	}
}