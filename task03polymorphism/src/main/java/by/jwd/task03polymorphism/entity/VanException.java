package by.jwd.task03polymorphism.entity;

public class VanException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public VanException () {
	}

	public VanException (final String message) {
		super(message);
	}

	public VanException (final Throwable cause) {
		super(cause);

	}

	public VanException (final String message, final Throwable cause) {
		super(message, cause);
	}

}