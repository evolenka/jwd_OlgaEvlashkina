package by.jwd.finaltaskweb.dao;


public interface Transaction {

	public DaoFactory createDaoFactory();

	public void commit() throws DaoException;

	public void rollback() throws DaoException;
	
	public void close() throws DaoException;
}