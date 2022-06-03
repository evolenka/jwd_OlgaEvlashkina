package by.jwd.finaltaskweb.controller.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.finaltaskweb.controller.Command;
import by.jwd.finaltaskweb.controller.ConfigurationManager;
import by.jwd.finaltaskweb.controller.MessageManager;
import by.jwd.finaltaskweb.entity.DanceClass;
import by.jwd.finaltaskweb.service.ServiceException;
import by.jwd.finaltaskweb.service.ServiceFactory;

public class ReadPlannedClassesByGroupCommandImpl implements Command {
	
	private static Logger logger = LogManager.getLogger(ReadPlannedClassesByGroupCommandImpl.class);

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
			
			Integer groupId = Integer.valueOf(request.getParameter("groupId"));
			
			try {
						 
			 String [] dates = request.getParameterValues("dates");
			 List <LocalDate> availiableDates = new ArrayList <>();
			 for (String date : dates) {
				 availiableDates.add(LocalDate.parse(date));
			 }
			
			 
			 List <DanceClass> classes = factory.getDanceClassService().readByDateAndGroup(availiableDates, groupId);

					request.setAttribute("classes", classes);
					request.setAttribute("userName", session.getAttribute("userName"));
					page = ConfigurationManager.getProperty("path.page.enrolment");
				
			} catch (ServiceException e) {
				request.setAttribute("errorMessage", manager.getProperty("errorMessage"));
				page = ConfigurationManager.getProperty("path.page.myMemberships");
				logger.error(" request has been failed");
			}
			return page;
		}
	}