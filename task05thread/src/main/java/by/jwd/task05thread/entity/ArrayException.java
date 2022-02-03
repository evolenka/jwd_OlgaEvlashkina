package by.jwd.task05thread.entity;

public class ArrayException extends Exception {

	private static final long serialVersionUID = 1L;

	public ArrayException() {
	}

	public ArrayException(final String message) {
		super(message);
	}

	public ArrayException(final Throwable cause) {
		super(cause);

	}

	public ArrayException(final String message, final Throwable cause) {
		super(message, cause);
	}
}