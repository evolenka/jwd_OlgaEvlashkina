package by.jwd.finaltaskweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class ConnectionPool {

	static Logger logger = LogManager.getLogger(ConnectionPool.class);

	private static ConnectionPool instance = new ConnectionPool();

	private String url;
	private String user;
	private String password;
	private int maxSize;
	private int checkConnectionTimeout;

	private BlockingQueue<PooledConnection> freeConnections = new LinkedBlockingQueue<>();
	private Set<PooledConnection> usedConnections = new ConcurrentSkipListSet<>();
	private ReentrantLock locker = new ReentrantLock();

	private ConnectionPool() {
	}

	public static ConnectionPool getInstance() {
		return instance;
	}

	public Connection getConnection() throws DaoException {
		locker.lock();
		PooledConnection connection = null;
		while (connection == null) {
			try {
				if (!freeConnections.isEmpty()) {
					connection = freeConnections.take();
					if (!connection.isValid(checkConnectionTimeout)) {
						try {
							connection.getConnection().close();
						} catch (SQLException e) {
						}
						connection = null;
					}
				} else if (usedConnections.size() < maxSize) {
					connection = createConnection();
				} else {
					logger.error("The limit of number of database connections is exceeded");
					throw new DaoException();
				}
			} catch (InterruptedException | SQLException e) {
				logger.error("It is impossible to connect to a database", e);
				throw new DaoException(e);
			}
		}
		usedConnections.add(connection);
		logger.debug(String.format(
				"Connection was received from pool. Current pool size: %d used connections; %d free connection",
				usedConnections.size(), freeConnections.size()));
		locker.unlock();
		return connection;
	}

	void freeConnection(PooledConnection connection) {
		locker.lock();
		try {
			if (connection.isValid(checkConnectionTimeout)) {
				connection.clearWarnings();
				connection.setAutoCommit(true);
				usedConnections.remove(connection);
				freeConnections.put(connection);
				logger.debug(String.format(
						"Connection was returned into pool. Current pool size: %d used connections; %d free connection",
						usedConnections.size(), freeConnections.size()));
			}
		} catch (SQLException | InterruptedException e1) {
			logger.warn("It is impossible to return database connection into pool", e1);
			try {
				connection.getConnection().close();
			} catch (SQLException e2) {
			}
		}
		locker.unlock();
	}

	public void init(String driverClass, String url, String user, String password, int startSize, int maxSize,
			int checkConnectionTimeout) throws DaoException {
		locker.lock();
		try {
			destroy();
			Class.forName(driverClass);
			this.url = url;
			this.user = user;
			this.password = password;
			this.maxSize = maxSize;
			this.checkConnectionTimeout = checkConnectionTimeout;
			for (int counter = 0; counter < startSize; counter++) {
				freeConnections.put(createConnection());
			}
		} catch (ClassNotFoundException | SQLException | InterruptedException e) {
			logger.fatal("It is impossible to initialize connection pool", e);
			throw new DaoException(e);
		}
		locker.unlock();
	}

	private PooledConnection createConnection() throws SQLException {
		return new PooledConnection(DriverManager.getConnection(url, user, password));
	}

	public void destroy() {
		locker.lock();
		usedConnections.addAll(freeConnections);
		freeConnections.clear();
		for (PooledConnection connection : usedConnections) {
			try {
				connection.getConnection().close();
			} catch (SQLException e) {
			}
		}
		usedConnections.clear();
		locker.unlock();
	}

	@Override
	protected void finalize() throws Throwable {
		destroy();
	}
}