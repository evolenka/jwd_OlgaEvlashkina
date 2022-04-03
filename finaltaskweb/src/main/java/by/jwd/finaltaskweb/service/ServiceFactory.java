package by.jwd.finaltaskweb.service;

import by.jwd.finaltaskweb.entity.Schedule;
import by.jwd.finaltaskweb.service.impl.DanceClassServiceImpl;
import by.jwd.finaltaskweb.service.impl.GroupServiceImpl;
import by.jwd.finaltaskweb.service.impl.MembershipServiceImpl;
import by.jwd.finaltaskweb.service.impl.ScheduleServiceImpl;
import by.jwd.finaltaskweb.service.impl.UserServiceImpl;
import by.jwd.finaltaskweb.service.impl.VisitServiceImpl;

public class ServiceFactory {
	private static final ServiceFactory instance = new ServiceFactory();

	private UserService userService = new UserServiceImpl();
	private MembershipService membershipService = new MembershipServiceImpl();
	private DanceClassService danceClassService = new DanceClassServiceImpl();
	private VisitService visitservice = new VisitServiceImpl();
	private GroupService groupService = new GroupServiceImpl();
	private StudioService <Integer, Schedule> scheduleService = new ScheduleServiceImpl();

	private ServiceFactory() {
	}

	public static ServiceFactory getInstance() {
		return instance;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public MembershipService getMembershipService() {
		return membershipService;
	}

	public void setMembershipService(MembershipService membershipService) {
		this.membershipService = membershipService;
	}

	public DanceClassService getDanceClassService() {
		return danceClassService;
	}

	public void setDanceClassService(DanceClassService danceClassService) {
		this.danceClassService = danceClassService;
	}

	public VisitService getVisitservice() {
		return visitservice;
	}

	public void setVisitservice(VisitService visitservice) {
		this.visitservice = visitservice;
	}

	public GroupService getGroupService() {
		return groupService;
	}

	public void setGroupService(GroupService groupService) {
		this.groupService = groupService;
	}

	public StudioService <Integer, Schedule> getScheduleService() {
		return scheduleService;
	}

	public void setScheduleService(StudioService <Integer, Schedule> scheduleService) {
		this.scheduleService = scheduleService;
	}

}