package by.jwd.task01basic.controller;

public class ControllerException extends Exception {

	private static final long serialVersionUID = 1L;

	public ControllerException() {
		super();
	}

	public ControllerException(String message) {
		super(message);
	}

	public ControllerException(NumberFormatException e) {
		super(e);

	}

	public ControllerException(String message, NumberFormatException e) {
		super(message, e);
	}
}