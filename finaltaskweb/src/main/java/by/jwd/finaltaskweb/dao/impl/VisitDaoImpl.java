package by.jwd.finaltaskweb.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.finaltaskweb.dao.DaoException;
import by.jwd.finaltaskweb.dao.StudioDaoImpl;
import by.jwd.finaltaskweb.dao.VisitDao;

import by.jwd.finaltaskweb.entity.DanceClass;
import by.jwd.finaltaskweb.entity.Membership;

import by.jwd.finaltaskweb.entity.Status;
import by.jwd.finaltaskweb.entity.Visit;

public class VisitDaoImpl extends StudioDaoImpl implements VisitDao {

	static Logger logger = LogManager.getLogger(VisitDaoImpl.class);

	private static final String SQL_SELECT_ALL_VISIT = "SELECT visit.id, visit.membership_id, visit.danceclass_id, visit.status FROM `visit`";

	private static final String SQL_SELECT_BY_ID = "SELECT visit.membership_id, visit.danceclass_id, visit.status FROM `visit` WHERE visit.id = ?";
	private static final String SQL_SELECT_BY_MEMBERSHIP_AND_DANCECLASS = "SELECT visit.id, visit.status FROM `visit` WHERE visit.membership_id = ? AND visit.danceclass_id = ? ";
	private static final String SQL_SELECT_BY_DANCECLASS = "SELECT visit.id, visit.membership_id, visit.status FROM `visit` WHERE visit.danceclass_id = ? ";
	private static final String SQL_SELECT_PLANNED_BY_MEMBERSHIP = "SELECT visit.id, visit.status FROM `visit` WHERE visit.membership_id = ? AND visit.status = 'PLANNED'";

	private static final String SQL_INSERT_VISIT = "INSERT INTO visit(membership_id, danceclass_id) VALUES (?, ?)";

	private static final String SQL_DELETE_BY_ID = "DELETE FROM visit WHERE id = ?";

	private static final String SQL_UPDATE_VISIT = "UPDATE visit SET membership_id = ?, danceclass_id = ? WHERE id = ?";
	private static final String SQL_UPDATE_VISIT_STATUS = "UPDATE visit SET status = ? WHERE id = ?";
	private static final String SQL_UPDATE_VISIT_STATUS_TO_PLANNED = "UPDATE visit SET status = 'PLANNED' WHERE id = ?";
	private static final String SQL_DECREASE_BALANCE_QUANTITY = "UPDATE membership SET membership.balance_quantity = membership.balance_quantity-1 WHERE membership.id = ?";
	private static final String SQL_INCREASE_BALANCE_QUANTITY = "UPDATE membership SET membership.balance_quantity = membership.balance_quantity+1 WHERE membership.id = ?";

	@Override
	public List<Visit> readAll() throws DaoException {

		List<Visit> visits = new ArrayList<>();

		Statement statement = null;

		try {

			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_VISIT);

			while (resultSet.next()) {

				Visit visit = new Visit(resultSet.getInt(1));
				visit.setMembership(new Membership(resultSet.getInt(2)));
				visit.setDanceClass(new DanceClass(resultSet.getInt(3)));
				visit.setStatus(Status.valueOf(resultSet.getString(4)));
				visits.add(visit);
			}
		} catch (SQLException e) {
			throw new DaoException();
		} finally {
			close(statement);
		}
		logger.debug("visits have been read from db");
		return visits;
	}

	@Override
	public Visit readEntityById(Integer id) throws DaoException {

		Visit visit = null;

		PreparedStatement statement = null;

		try {
			statement = connection.prepareStatement(SQL_SELECT_BY_ID);
			statement.setInt(1, id);

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {

				visit = new Visit(id);

				visit.setMembership(new Membership(resultSet.getInt(1)));
				visit.setDanceClass(new DanceClass(resultSet.getInt(2)));
				visit.setStatus(Status.valueOf(resultSet.getString(3)));
				logger.debug("visit has been read by id");
			}

		} catch (SQLException e) {
			throw new DaoException();
		} finally {
			close(statement);
		}
		return visit;
	}

	@Override
	public boolean delete(Integer id) throws DaoException {

		PreparedStatement statement = null;

		try {
			statement = connection.prepareStatement(SQL_DELETE_BY_ID);
			statement.setInt(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException();
		} finally {
			close(statement);
		}

		logger.debug("visit has been deleted");
		return true;
	}

	@Override
	public boolean create(Visit visit) throws DaoException {

		PreparedStatement statement = null;

		try {
			// if(!danceClass.getId()==null) {
			statement = connection.prepareStatement(SQL_INSERT_VISIT);

			statement.setInt(1, visit.getMembership().getId());
			statement.setInt(2, visit.getDanceClass().getId());

			statement.executeUpdate();
			logger.debug("visit has been created");
		} catch (SQLException e) {
			throw new DaoException();
		} finally {
			close(statement);
		}
		return true;
	}

	@Override
	public boolean update(Visit visit) throws DaoException {

		PreparedStatement statement = null;

		try {
			statement = connection.prepareStatement(SQL_UPDATE_VISIT);
			statement.setInt(1, visit.getMembership().getId());
			statement.setInt(2, visit.getDanceClass().getId());

			statement.executeUpdate();
			close(statement);

			logger.debug("visit has been updated");

		} catch (SQLException e) {
			throw new DaoException();
		} finally {
			close(statement);
		}
		return true;
	}

	@Override
	public boolean updateStatus(Visit visit, Status status) throws DaoException {

		PreparedStatement statement = null;

		try {
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(SQL_UPDATE_VISIT_STATUS);
			statement.setString(1, status.toString());
			statement.setInt(2, visit.getId());

			statement.executeUpdate();
			close(statement);

			if (Status.ATTENDED == status) {
				statement = connection.prepareStatement(SQL_DECREASE_BALANCE_QUANTITY);
				statement.setInt(1, visit.getMembership().getId());

				statement.executeUpdate();
				close(statement);
				connection.commit();

				logger.debug("balance quantity in membership has been decreased");
			} else {
				connection.commit();
			}
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				logger.debug("rollback error");
				throw new DaoException();
			}
		} finally {
			try {
				connection.setAutoCommit(true);
			} catch (SQLException e1) {
				logger.debug("setAutoCommit error");
			}
			close(statement);
		}
		logger.debug("status has been updated");
		return true;
	}

	@Override
	public boolean cancelUpdateStatus(Visit visit) throws DaoException {

		PreparedStatement statement = null;

		try {
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(SQL_UPDATE_VISIT_STATUS_TO_PLANNED);
			statement.setInt(1, visit.getId());

			statement.executeUpdate();
			close(statement);

			if (Status.ATTENDED == visit.getStatus()) {
				statement = connection.prepareStatement(SQL_INCREASE_BALANCE_QUANTITY);
				statement.setInt(1, visit.getMembership().getId());

				statement.executeUpdate();
				close(statement);
				connection.commit();

				logger.debug("balance quantity in membership has been increased");
			} else {
				connection.commit();
			}
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				logger.debug("rollback error");
				throw new DaoException();
			}
		} finally {
			try {
				connection.setAutoCommit(true);
			} catch (SQLException e1) {
				logger.debug("setAutoCommit error");
			}
			close(statement);
		}
		logger.debug("status has been restored");
		return true;
	}

	@Override
	public Visit readByMembershipAndDanceClass(Membership membership, DanceClass danceClass) throws DaoException {

		Visit visit = new Visit();

		PreparedStatement statement = null;

		try {
			statement = connection.prepareStatement(SQL_SELECT_BY_MEMBERSHIP_AND_DANCECLASS);

			statement.setInt(1, membership.getId());
			statement.setInt(2, danceClass.getId());

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {

				visit.setId(resultSet.getInt(1));
				visit.setMembership(new Membership(membership.getId()));
				visit.setDanceClass(new DanceClass(danceClass.getId()));
				visit.setStatus(Status.valueOf(resultSet.getString(3)));

				logger.debug("visit has been read by client and by dance class");
			}

		} catch (SQLException e) {
			throw new DaoException();
		} finally {
			close(statement);
		}
		return visit;
	}

	@Override
	public Visit readByDanceClass(DanceClass danceClass) throws DaoException {
		Visit visit = new Visit();

		PreparedStatement statement = null;

		try {
			statement = connection.prepareStatement(SQL_SELECT_BY_DANCECLASS);

			statement.setInt(1, danceClass.getId());

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {

				visit.setId(resultSet.getInt(1));
				visit.setMembership(new Membership(resultSet.getInt(2)));
				visit.setDanceClass(new DanceClass(danceClass.getId()));
				visit.setStatus(Status.valueOf(resultSet.getString(3)));

				logger.debug("visit has been read by client and by dance class");
			}

		} catch (SQLException e) {
			throw new DaoException();
		} finally {
			close(statement);
		}
		return visit;
	}

	@Override
	public List<Visit> readPlannedByMembership(Membership membership) throws DaoException {

		List<Visit> visits = new ArrayList<>();

		PreparedStatement statement = null;

		try {
			statement = connection.prepareStatement(SQL_SELECT_PLANNED_BY_MEMBERSHIP);

			statement.setInt(1, membership.getId());

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {

				Visit visit = new Visit();

				visit.setId(resultSet.getInt(1));
				visit.setMembership(new Membership(membership.getId()));
				visit.setDanceClass(new DanceClass(resultSet.getInt(2)));
				visit.setStatus(Status.valueOf(resultSet.getString(3)));
				visits.add(visit);

				logger.debug("planned visits have been read by memebership id");
			}

		} catch (SQLException e) {
			throw new DaoException();
		} finally {
			close(statement);
		}
		return visits;
	}
}