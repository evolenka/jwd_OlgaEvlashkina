package by.jwd.task06infohandling.entity;

public class Symbol implements Component {

	private char character;

	public Symbol(char character) {
		this.character = character;

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + character;
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
		Symbol other = (Symbol) obj;
		if (character != other.character)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.valueOf(character);
	}
}