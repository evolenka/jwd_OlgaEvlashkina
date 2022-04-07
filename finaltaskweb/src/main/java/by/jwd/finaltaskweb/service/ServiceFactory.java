package by.jwd.finaltaskweb.service;

import by.jwd.finaltaskweb.dao.DaoException;
import by.jwd.finaltaskweb.dao.TransactionFactoryImpl;
import by.jwd.finaltaskweb.service.impl.DanceClassServiceImpl;
import by.jwd.finaltaskweb.service.impl.GroupServiceImpl;
import by.jwd.finaltaskweb.service.impl.MembershipServiceImpl;
import by.jwd.finaltaskweb.service.impl.ScheduleServiceImpl;
import by.jwd.finaltaskweb.service.impl.UserServiceImpl;
import by.jwd.finaltaskweb.service.impl.VisitServiceImpl;

public class ServiceFactory {

	private static final ServiceFactory instance = new ServiceFactory();

	private static TransactionFactoryImpl factory;

	private ServiceFactory() {
	}

	public static ServiceFactory getInstance() throws ServiceException {
		try {
			factory = TransactionFactoryImpl.getInstance();
		} catch (DaoException e) {
			throw new ServiceException();
		}
		return instance;
	}

	public UserService getUserService() throws ServiceException {
		StudioServiceImpl userservice = new UserServiceImpl();
		try {
			userservice.setTransaction(factory.createTransaction());
		} catch (DaoException e) {
			throw new ServiceException();
		}
		return (UserService) userservice;
	}

	public MembershipService getMembershipService() throws ServiceException {
		StudioServiceImpl membershipService = new MembershipServiceImpl();
		try {
			membershipService.setTransaction(factory.createTransaction());
		} catch (DaoException e) {
			throw new ServiceException();
		}
		return (MembershipService) membershipService;
	}

	public DanceClassService getDanceClassService() throws ServiceException {
		StudioServiceImpl danceClassService = new DanceClassServiceImpl();
		try {
			danceClassService.setTransaction(factory.createTransaction());
		} catch (DaoException e) {
			throw new ServiceException();
		}
		return (DanceClassService) danceClassService;
	}

	public VisitService getVisitservice() throws ServiceException {
		StudioServiceImpl visitService = new VisitServiceImpl();
		try {
			visitService.setTransaction(factory.createTransaction());
		} catch (DaoException e) {
			throw new ServiceException();
		}
		return (VisitService) visitService;
	}

	public GroupService getGroupService() throws ServiceException {
		StudioServiceImpl groupService = new GroupServiceImpl();
		try {
			groupService.setTransaction(factory.createTransaction());
		} catch (DaoException e) {
			throw new ServiceException();
		}
		return (GroupService) groupService;
	}

	public ScheduleServiceImpl getScheduleService() throws ServiceException {
		StudioServiceImpl scheduleService = new ScheduleServiceImpl();
		try {
			scheduleService.setTransaction(factory.createTransaction());
		} catch (DaoException e) {
			throw new ServiceException();
		}
		return (ScheduleServiceImpl) scheduleService;
	}
}