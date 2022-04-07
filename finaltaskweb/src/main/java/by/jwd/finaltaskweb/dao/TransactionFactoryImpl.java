package by.jwd.finaltaskweb.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.finaltaskweb.dao.pool.ConnectionPool;


public class TransactionFactoryImpl implements TransactionFactory {

	static Logger logger = LogManager.getLogger(TransactionFactoryImpl.class);
	
	private static Connection connection;
	
	private static final TransactionFactoryImpl instance = new TransactionFactoryImpl();
	
	private TransactionFactoryImpl () {
	}
	
	public static TransactionFactoryImpl getInstance() throws DaoException {
		connection = ConnectionPool.getInstance().getConnection();
//		try {
//			connection.setAutoCommit(false);
//		} catch (SQLException e) {
//			throw new DaoException();
//		}
		return instance;
	}

	@Override
	public Transaction createTransaction() throws DaoException {
		return new TransactionImpl(connection);
	}
}
