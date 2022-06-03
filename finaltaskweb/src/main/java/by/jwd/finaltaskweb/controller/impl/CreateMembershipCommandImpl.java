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
 * CreateMembershipCommandImpl implements command to buy membership by client in
 * his private account
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

		Integer clientId = (Integer) session.getAttribute("id");

		Integer membershipId = Integer.valueOf(request.getParameter("membership"));

		LocalDate startDate = LocalDate.parse(request.getParameter("startDate"));
		LocalDate endDate = LocalDate.parse(request.getParameter("endDate"));

		try {
			Client client = (Client) factory.getUserService().readEntityById(clientId);
			MembershipType type = factory.getMembershipService().readTypeById(membershipId);

			Membership membership = factory.getMembershipBuilder().buildMembership(client, type, startDate, endDate);

			if (factory.getMembershipService().create(membership)) {
				request.setAttribute("successPurchaseMessage", manager.getProperty("successPurchaseMessage"));
			} else {
				request.setAttribute("errorPurchaseRegMessage", manager.getProperty("errorPurchaseMessage"));
			}
		} catch (ServiceException e) {
			request.setAttribute("errorPurchaseRegMessage", manager.getProperty("errorPurchaseMessage"));
			logger.error(e);
		}
		page = ConfigurationManager.getProperty("path.page.purchaseMembership");
		return page;
	}
}