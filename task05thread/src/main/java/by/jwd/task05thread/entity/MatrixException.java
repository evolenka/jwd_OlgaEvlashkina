package by.jwd.task05thread.entity;

public class MatrixException extends Exception {

	private static final long serialVersionUID = 1L;

	public MatrixException() {
	}

	public MatrixException(final String message) {
		super(message);
	}

	public MatrixException(final Throwable cause) {
		super(cause);

	}

	public MatrixException(final String message, final Throwable cause) {
		super(message, cause);
	}
}