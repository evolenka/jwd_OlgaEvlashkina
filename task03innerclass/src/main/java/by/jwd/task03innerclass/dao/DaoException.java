package by.jwd.task03innerclass.dao;

public class DaoException extends Exception {

	private static final long serialVersionUID = 1L;

	public DaoException() {
	}

	public DaoException(final String message) {
		super(message);
	}

	public DaoException(final Throwable cause) {
		super(cause);

	}

	public DaoException(final String message, final Throwable cause) {
		super(message, cause);
	}
}