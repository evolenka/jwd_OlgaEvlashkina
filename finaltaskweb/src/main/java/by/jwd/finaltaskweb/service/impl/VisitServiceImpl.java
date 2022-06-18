package by.jwd.finaltaskweb.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.finaltaskweb.dao.DaoException;
import by.jwd.finaltaskweb.dao.DaoFactory;

import by.jwd.finaltaskweb.entity.DanceClass;
import by.jwd.finaltaskweb.entity.Group;
import by.jwd.finaltaskweb.entity.Membership;
import by.jwd.finaltaskweb.entity.Schedule;
import by.jwd.finaltaskweb.entity.Status;
import by.jwd.finaltaskweb.entity.Teacher;
import by.jwd.finaltaskweb.entity.Type;
import by.jwd.finaltaskweb.entity.Visit;
import by.jwd.finaltaskweb.service.ServiceException;
import by.jwd.finaltaskweb.service.StudioServiceImpl;
import by.jwd.finaltaskweb.service.VisitService;

public class VisitServiceImpl extends StudioServiceImpl implements VisitService {

	private static Logger logger = LogManager.getLogger(VisitServiceImpl.class);

	private DaoFactory factory = DaoFactory.getInstance();

	@Override
	public List<Visit> readAll() throws ServiceException {

		List<Visit> visits = new ArrayList<>();

		try {
			visits = factory.getVisitDao(transaction).readAll();
			transaction.close();

		} catch (DaoException e) {
			throw new ServiceException();
		}
		return visits;
	}

	@Override
	public Visit readEntityById(Integer id) throws ServiceException {
		Visit visit = null;
		try {
			visit = factory.getVisitDao(transaction).readEntityById(id);
			transaction.close();

		} catch (DaoException e) {
			throw new ServiceException();
		}
		return visit;
	}

	@Override
	public boolean delete(Integer id) throws ServiceException {

		try {
			factory.getVisitDao(transaction).delete(id);
			transaction.close();

		} catch (DaoException e) {
			throw new ServiceException();
		}
		return true;
	}

	@Override
	public boolean create(Visit visit) throws ServiceException {
		try {
			factory.getVisitDao(transaction).create(visit);
			transaction.close();

		} catch (DaoException e) {
			throw new ServiceException();
		}
		return true;
	}

	@Override
	public boolean update(Visit visit) throws ServiceException {
		try {
			factory.getVisitDao(transaction).update(visit);
			transaction.close();

		} catch (DaoException e) {
			throw new ServiceException();
		}
		return true;
	}

	@Override
	public List<Visit> readPlannedByClient(Integer clientId) throws ServiceException {

		List<Visit> visits = new ArrayList<>();

		try {

			List<Membership> memberships = factory.getMembershipDao(transaction).readValidByClient(clientId);

			for (Membership membership : memberships) {

				List<Visit> visitByMembership = factory.getVisitDao(transaction).readPlannedByMembership(membership);

				membership = factory.getMembershipDao(transaction).readEntityById(membership.getId());

				for (Visit visit : visitByMembership) {
					visit.setMembership(membership);

					DanceClass danceClass = factory.getDanceClassDao(transaction)
							.readEntityById(visit.getDanceClass().getId());

					Schedule schedule = factory.getScheduleDao(transaction)
							.readEntityById(danceClass.getSchedule().getId());

					Group group = factory.getGroupDao(transaction).readEntityById(schedule.getGroup().getId());

					Teacher teacher = (Teacher) factory.getUserDao(transaction)
							.readEntityById(group.getTeacher().getId());

					group.setTeacher(teacher);
					schedule.setGroup(group);
					danceClass.setSchedule(schedule);
					visit.setDanceClass(danceClass);

					visits.add(visit);
				}
			}
			transaction.close();
		} catch (DaoException e) {
			throw new ServiceException();
		}
		logger.debug("visits {}", visits);
		return visits;
	}

	@Override
	public List<Visit> readPlannedByTeacher(Integer teacherId) throws ServiceException {

		List<Visit> visits = new ArrayList<>();

		try {
			List<Group> groups = factory.getGroupDao(transaction).readByTeacherId(teacherId);

			for (Group group : groups) {
				List<Schedule> schedules = factory.getScheduleDao(transaction).readByGroup(group.getId());
				for (Schedule schedule : schedules) {

					List<DanceClass> danceClasses = factory.getDanceClassDao(transaction).readBySchedule(schedule);

					for (DanceClass danceClass : danceClasses) {

						if (isPlanned(danceClass)) {

							visits.add(factory.getVisitDao(transaction).readByDanceClass(danceClass));
						}
					}
				}
			}
			transaction.close();
		} catch (DaoException e) {
			throw new ServiceException();
		}
		return visits;
	}

	@Override
	public List<Visit> readByClientAndPeriod(Integer clientId, LocalDate startDate, LocalDate endDate)
			throws ServiceException {

		List<Visit> visits = new ArrayList<>();

		try {

			List<Membership> memberships = factory.getMembershipDao(transaction).readValidByClient(clientId);

			List<DanceClass> danceClasses = factory.getDanceClassDao(transaction).readByPeriod(startDate, endDate);

			for (Membership membership : memberships) {

				for (DanceClass danceClass : danceClasses) {

					Visit visit = factory.getVisitDao(transaction).readByMembershipAndDanceClass(membership,
							danceClass);

					if (visit != null) {
					
						membership = factory.getMembershipDao(transaction).readEntityById(membership.getId());
						visit.setMembership(membership);

						danceClass = factory.getDanceClassDao(transaction).readEntityById(danceClass.getId());

						Schedule schedule = factory.getScheduleDao(transaction)
								.readEntityById(danceClass.getSchedule().getId());

						Group group = factory.getGroupDao(transaction).readEntityById(schedule.getGroup().getId());

						Teacher teacher = (Teacher) factory.getUserDao(transaction)
								.readEntityById(group.getTeacher().getId());

						group.setTeacher(teacher);
						schedule.setGroup(group);
						danceClass.setSchedule(schedule);
						visit.setDanceClass(danceClass);

						visits.add(visit);
					}
				}
			}

			transaction.close();
		} catch (

		DaoException e) {
			throw new ServiceException();
		}
		logger.debug("visits {}", visits);
		return visits;
	}

	@Override
	public List<Visit> readByGroupAndPeriod(Integer groupId, LocalDate startDate, LocalDate endDate)
			throws ServiceException {

		List<Visit> visits = new ArrayList<>();
		try {
			List<DanceClass> danceClasses = factory.getDanceClassDao(transaction).readByPeriod(startDate, endDate);

			for (DanceClass danceClass : danceClasses) {

				if (danceClass.getSchedule().getGroup().getId() == groupId) {

					visits.add(factory.getVisitDao(transaction).readByDanceClass(danceClass));
				}
			}
			transaction.close();
		} catch (DaoException e) {
			throw new ServiceException();
		}

		return visits;
	}

	@Override
	public Map<Group, Integer> countVisitsForPeriodByGroups(LocalDate startDate, LocalDate endDate)
			throws ServiceException {

		Map<Group, Integer> visits = new HashMap<>();
		try {
			List<Group> groups = factory.getGroupDao(transaction).readAll();

			for (Group group : groups) {
				int quantity = this.readByGroupAndPeriod(group.getId(), startDate, endDate).size();
				visits.put(group, quantity);
			}
			transaction.close();
		} catch (DaoException e) {
			throw new ServiceException();
		}

		return visits;
	}

	@Override
	public boolean isPlanned(DanceClass danceClass) throws ServiceException {
		Visit visit;
		try {
			visit = factory.getVisitDao(transaction).readByDanceClass(danceClass);
			transaction.close();
		} catch (DaoException e) {
			throw new ServiceException();
		}
		return (Status.PLANNED == visit.getStatus() ? true : false);
	}

	@Override
	public boolean markPresence(Visit visit, Status status) throws ServiceException {
		boolean result = false;
		try {
			/* additional check whether the client membership is valid */
			if ((Status.ATTENDED == status) && (visit.getMembership().getBalanceClassQuantity() == 0)) {
				logger.debug("membership is not valid");
				result = false;
			} else if ((visit.getStatus() != Status.PLANNED)) {
				logger.debug("visit status is not valid for marking presence");
				result = false;
			} else {
				transaction.setAutoCommit(false);
				factory.getVisitDao(transaction).updateStatus(visit, status);

				if ((Status.ATTENDED == status) || !(visit.getMembership().getType().getTitle().equals(Type.UNLIM))) {
					factory.getMembershipDao(transaction).decreasebalanceClassQuantity(visit.getMembership().getId());
					logger.debug("membership balance quantity has been decreased");
				}
				transaction.commit();
				logger.debug("precense has been marked successfully");
				transaction.close();
				result = true;
			}

		} catch (DaoException e) {
			try {
				transaction.rollback();
			} catch (DaoException e1) {
				logger.debug("rollback error");
				throw new ServiceException();
			}
		} finally {
			try {
				transaction.setAutoCommit(true);
			} catch (DaoException e1) {
				logger.debug("setAutoCommit error");
			}
		}
		return result;
	}

	@Override
	public boolean cancelMarkPresence(Visit visit) throws ServiceException {
		boolean result = false;
		try {
			Status current = visit.getStatus();
			if (current != Status.PLANNED) {
				transaction.setAutoCommit(false);
				factory.getVisitDao(transaction).cancelUpdateStatus(visit);

				if (Status.ATTENDED == current) {
					factory.getMembershipDao(transaction).increasebalanceClassQuantity(visit.getMembership().getId());
					logger.debug("membership balance quantity has been increased");
				}
				transaction.commit();
				logger.debug("precense has been cancelled");
				transaction.close();

				result = true;
			}
		} catch (DaoException e) {
			try {
				transaction.rollback();
			} catch (DaoException e1) {
				logger.debug("rollback error");
				throw new ServiceException();
			}
		} finally {
			try {
				transaction.setAutoCommit(true);
			} catch (DaoException e1) {
				logger.debug("setAutoCommit error");
			}

		}
		return result;
	}
}