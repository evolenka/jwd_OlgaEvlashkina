package by.jwd.finaltaskweb.controller.impl;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.finaltaskweb.controller.Command;
import by.jwd.finaltaskweb.controller.ConfigurationManager;
import by.jwd.finaltaskweb.controller.MessageManager;
import by.jwd.finaltaskweb.entity.Membership;
import by.jwd.finaltaskweb.service.ServiceException;
import by.jwd.finaltaskweb.service.ServiceFactory;

public class ReadMembershipByClientAndPeriodCommandImpl implements Command {

		private static Logger logger = LogManager.getLogger(ReadValidMembershipsByClientCommandImpl.class);

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
			LocalDate startDate = LocalDate.parse(request.getParameter("startdate"));
			logger.debug("startdate {}", startDate);
			LocalDate endDate = LocalDate.parse(request.getParameter("enddate"));
			logger.debug("enddate {}", endDate);
			
			try {
				if (id != null) {

					List<Membership> memberships = factory.getMembershipService().readByClientAndPeriod(id, startDate, endDate);
					request.setAttribute("memberships", memberships);
					page = ConfigurationManager.getProperty("path.page.myMemberships");
				} else {
					page = ConfigurationManager.getProperty("path.page.login");
				}
			} catch (ServiceException e) {
				request.setAttribute("errorMessage", manager.getProperty("errorMessage"));
				page = ConfigurationManager.getProperty("path.page.myMemberships");
				logger.error(" request has been failed");
			}
			return page;
		}
	}