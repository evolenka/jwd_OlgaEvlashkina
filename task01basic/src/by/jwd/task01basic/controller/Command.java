package by.jwd.task01basic.controller;

public interface Command {
	
	/**
	 * Get data from user and return responce
	 * 
	 * @author evlashkina
	 * @version 1
	 * @param params (String data from user)
	 * @return String responce
	 */

	public String execute(String[] params);
}