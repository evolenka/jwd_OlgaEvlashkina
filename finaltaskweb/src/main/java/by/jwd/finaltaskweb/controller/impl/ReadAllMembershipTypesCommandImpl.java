package by.jwd.finaltaskweb.controller.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.finaltaskweb.controller.Command;
import by.jwd.finaltaskweb.controller.ConfigurationManager;
import by.jwd.finaltaskweb.entity.MembershipType;
import by.jwd.finaltaskweb.service.ServiceException;
import by.jwd.finaltaskweb.service.ServiceFactory;

public class ReadAllMembershipTypesCommandImpl implements Command {
	
	static Logger logger = LogManager.getLogger(ReadAllMembershipTypesCommandImpl.class);

	@Override
	public String execute(HttpServletRequest request) {

		String page = null;

		List<MembershipType> membershipTypes;
		try {
			
			membershipTypes = ServiceFactory.getInstance().getMembershipService().readAllTypes();
		
			request.setAttribute("membershipTypes", membershipTypes);
			page = ConfigurationManager.getProperty("path.page.membershipTypes");
			logger.debug("page {}", page);
		} catch (ServiceException e) {
			logger.error("error");
		}
		return page;

	}
}