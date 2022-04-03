package by.jwd.finaltaskweb.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.finaltaskweb.dao.impl.DanceClassDaoImpl;
import by.jwd.finaltaskweb.dao.impl.GroupDaoImpl;
import by.jwd.finaltaskweb.dao.impl.MembershipDaoImpl;
import by.jwd.finaltaskweb.dao.impl.ScheduleDaoImpl;
import by.jwd.finaltaskweb.dao.impl.UserDaoImpl;
import by.jwd.finaltaskweb.dao.impl.VisitDaoImpl;

public class DaoFactory {

	static Logger logger = LogManager.getLogger(DaoFactory.class);

	private static final DaoFactory instance = new DaoFactory();

	private UserDao userDao = new UserDaoImpl();
	private GroupDao groupDao = new GroupDaoImpl();
	private MembershipDao membershipDao = new MembershipDaoImpl();
	private ScheduleDao scheduleDao = new ScheduleDaoImpl();
	private DanceClassDao danceClassDao = new DanceClassDaoImpl();
	private VisitDao visitDao = new VisitDaoImpl();
	

	private DaoFactory() {
	}

	public static DaoFactory getInstance() {
		return instance;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public GroupDao getGroupDao() {
		return groupDao;
	}

	public void setGroupDao(GroupDao groupDao) {
		this.groupDao = groupDao;
	}

	public MembershipDao getMembershipDao() {
		return membershipDao;
	}

	public void setMembershipDao(MembershipDao membershipDao) {
		this.membershipDao = membershipDao;
	}

	public ScheduleDao getScheduleDao() {
		return scheduleDao;
	}

	public void setScheduleDao(ScheduleDao scheduleDao) {
		this.scheduleDao = scheduleDao;
	}

	public DanceClassDao getDanceClassDao() {
		return danceClassDao;
	}

	public void setDanceClassDao(DanceClassDao danceClassDao) {
		this.danceClassDao = danceClassDao;
	}

	public VisitDao getVisitDao() {
		return visitDao;
	}

	public void setVisitDao(VisitDao visitDao) {
		this.visitDao = visitDao;
	}
	
}