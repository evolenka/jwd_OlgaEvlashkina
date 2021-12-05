package by.jwd.task01basic.service;

public interface PasswordService {
	
	/**
	 * Compare user password to the list of passwords from PasswordBase and retutn information about access to
	 * the bases
	 * 
	 * @param String password (inputed by user)
	 * @return String result
	 */

	public String getInfo(String password);
}