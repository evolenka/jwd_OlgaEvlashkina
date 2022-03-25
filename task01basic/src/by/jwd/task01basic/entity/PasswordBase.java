package by.jwd.task01basic.entity;

import java.util.ArrayList;
import java.util.List;

public class PasswordBase {

	private List<String> passwordBase;

	public PasswordBase() {

		passwordBase = new ArrayList<>();
		passwordBase.add("9583");
		passwordBase.add("1748");
		passwordBase.add("3331");
		passwordBase.add("7922");
		passwordBase.add("9455");
		passwordBase.add("8997");
	}

	public List<String> getPasswordBase() {
		return passwordBase;
	}

	public void setPasswordBase(List<String> passwordBase) {
		this.passwordBase = passwordBase;
	}

	public void addPassword(String password) {
		passwordBase.add(password);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((passwordBase == null) ? 0 : passwordBase.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PasswordBase other = (PasswordBase) obj;
		if (passwordBase == null) {
			if (other.passwordBase != null)
				return false;
		} else if (!passwordBase.equals(other.passwordBase))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "password base: " + passwordBase;
	}
}