package by.jwd.task03innerclass.service;

public class ServiceException extends Exception {

	private static final long serialVersionUID = 1L;

	public ServiceException() {
	}

	public ServiceException(final String message) {
		super(message);
	}

	public ServiceException(final Throwable cause) {
		super(cause);

	}

	public ServiceException(final String message, final Throwable cause) {
		super(message, cause);
	}
}
