package by.jwd.task01basic.service.impl;

import by.jwd.task01basic.entity.PasswordBase;
import by.jwd.task01basic.service.PasswordService;

/*33 loops task: Only six users have acess to the base by the password. They have the passwords as follows: 9583 and 1748 for acess to the bases A,B,C; 3331 and 7922 - to bases B,C; 9455 and 8997 - to the base C. 
Input the password and find out your access to the secret base.*/

public class AccessByPasswordServiceImpl implements PasswordService {

	/**
	 * Compare user password to the list of passwords from PasswordBase and retutn
	 * the information about user`s access to the bases
	 * 
	 * @author evlashkina
	 * @version 1
	 * @param password (inputed by user)
	 * @return String result (information about user`s access to the bases)
	 */

	@Override
	public String getInfo(String password) {

		String result;

		PasswordBase passwordbase = new PasswordBase();
		String password1 = passwordbase.getPasswordBase().get(0);
		String password2 = passwordbase.getPasswordBase().get(1);
		String password3 = passwordbase.getPasswordBase().get(2);
		String password4 = passwordbase.getPasswordBase().get(3);
		String password5 = passwordbase.getPasswordBase().get(4);
		String password6 = passwordbase.getPasswordBase().get(5);

		if (password.equals(password1) || password.equals(password2)) {
			result = "Your acess level: bases A,B,C";
		} else if (password.equals(password3) || password.equals(password4)) {
			result = "Your acess level: bases B,C";
		} else if (password.equals(password5) || password.equals(password6)) {
			result = "Your acess level: base C";
		} else {
			result = "Invalid password";
		}
		return result;
	}
}