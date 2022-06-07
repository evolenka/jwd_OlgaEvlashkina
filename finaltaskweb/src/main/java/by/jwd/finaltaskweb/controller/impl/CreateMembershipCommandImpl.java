package by.jwd.finaltaskweb.controller.impl;

import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.finaltaskweb.controller.Command;
import by.jwd.finaltaskweb.controller.ConfigurationManager;
import by.jwd.finaltaskweb.controller.MessageManager;
import by.jwd.finaltaskweb.entity.Client;
import by.jwd.finaltaskweb.entity.Membership;
import by.jwd.finaltaskweb.entity.MembershipType;
import by.jwd.finaltaskweb.service.ServiceException;
import by.jwd.finaltaskweb.service.ServiceFactory;

/**
 * CreateMembershipCommandImpl implements command to buy membership by client
 * 
 * @author Evlashkina
 *
 */
public class CreateMembershipCommandImpl implements Command {

	private static Logger logger = LogManager.getLogger(CreateMembershipCommandImpl.class);

	private ServiceFactory factory = ServiceFactory.getInstance();

	@Override
	public String execute(HttpServletRequest request) {

		String page;

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

		Integer clientId = (Integer) session.getAttribute("clientId");

		Integer membershipTypeId = Integer.valueOf(request.getParameter("membershipTypeId"));
		logger.debug("membershipTypeId {}", membershipTypeId);

		LocalDate startDate = LocalDate.parse(request.getParameter("startDate"));

		try {
			if (clientId == null) {
				session.setAttribute("noSession", manager.getProperty("noSession"));
				logger.debug("session timed out");

			} else {
				Client client = (Client) factory.getUserService().readEntityById(clientId);
				MembershipType type = factory.getMembershipService().readTypeById(membershipTypeId);

				Membership membership = factory.getMembershipBuilder().buildMembership(client, type, startDate);

				if (factory.getMembershipService().create(membership)) {
					request.setAttribute("membership", membership);
					request.setAttribute("successPurchaseMessage", manager.getProperty("successPurchaseMessage"));
				} else {
					request.setAttribute("errorPurchaseMessage", manager.getProperty("errorPurchaseMessage"));
				}
			}
				page = ConfigurationManager.getProperty("path.page.purchaseMembership");
			
		} catch (ServiceException e) {
			page = ConfigurationManager.getProperty("path.page.error");
			request.getSession().setAttribute("errorMessage", manager.getProperty("errorMessage"));
			logger.error(e);
		}

		return page;
	}
}