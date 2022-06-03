package by.jwd.finaltaskweb.controller.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.finaltaskweb.controller.Command;
import by.jwd.finaltaskweb.controller.ConfigurationManager;
import by.jwd.finaltaskweb.entity.Client;
import by.jwd.finaltaskweb.service.ServiceException;
import by.jwd.finaltaskweb.service.ServiceFactory;

/**
 * 
 * 
 * @author Evlashkina
 *
 */
public class ReadAllClientCommandImpl implements Command {

static Logger logger = LogManager.getLogger(ReadAllClientCommandImpl.class);
private ServiceFactory factory = ServiceFactory.getInstance();

	@Override
	public String execute(HttpServletRequest request) {
	
		String page = null;
		List<Client> clients;
		
		try {

			clients = factory.getUserService().readAllClient();
			request.setAttribute("clients", clients);
			page = ConfigurationManager.getProperty("path.page.client");
			
			logger.debug("page {}", page);
		} catch (ServiceException e) {
			logger.error(e);
		}
		return page;
	}
}