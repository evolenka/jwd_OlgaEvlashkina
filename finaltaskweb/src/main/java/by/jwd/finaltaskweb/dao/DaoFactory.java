package by.jwd.finaltaskweb.dao;

import java.sql.Connection;

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

	private Connection connection;

	public DaoFactory(Connection connection) {
		this.connection = connection;
	}
	public UserDao getUserDao() {
		StudioDaoImpl userDao = new UserDaoImpl();
		userDao.setConnection(connection);
		return (UserDao) userDao;
	}

	public GroupDao getGroupDao() {
		StudioDaoImpl groupDao = new GroupDaoImpl();
		groupDao.setConnection(connection);
		return (GroupDao) groupDao;
	}

	public MembershipDao getMembershipDao() {
		StudioDaoImpl  membershipDao = new MembershipDaoImpl();
		membershipDao.setConnection(connection);
		return (MembershipDao) membershipDao;
	}

	public ScheduleDao getScheduleDao() {
		StudioDaoImpl  scheduleDao = new ScheduleDaoImpl();
		scheduleDao.setConnection(connection);
		return (ScheduleDao) scheduleDao;
	}

	public DanceClassDao getDanceClassDao() {
		StudioDaoImpl danceClassDao = new DanceClassDaoImpl();
		danceClassDao.setConnection(connection);
		return (DanceClassDao) danceClassDao;
	}

	public VisitDao getVisitDao() {
		StudioDaoImpl visitDao = new VisitDaoImpl();
		visitDao.setConnection(connection);
		return (VisitDao) visitDao;
	}
}