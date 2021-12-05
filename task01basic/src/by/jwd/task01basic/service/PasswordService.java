package by.jwd.task01basic.service;

public interface PasswordService {
	
	/**
	 * Compare user password to the list of passwords from PasswordBase and retutn information about access to
	 * the bases
	 * 
	 * @author evlashkina
	 * @version 1
	 * @param password (inputed by user)
	 * @return String result (information about access to bases)
	 */

	public String getInfo(String password);
}