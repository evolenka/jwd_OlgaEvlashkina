package by.jwd.task06infohandling.entity;

import java.util.List;

public class Symbol implements IComponent {

	char character;

	public Symbol() {

	}

	public Symbol(char character) {
		super();
		this.character = character;
	}

	@Override
	public String collect() {
		return toString();
	}

	@Override
	public int getSize() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void add(IComponent component) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void remove(IComponent component) {
		throw new UnsupportedOperationException();
	}

	@Override
	public IComponent getChild(int index) {
		throw new UnsupportedOperationException();
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

	@Override
	public Delimeter getType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IComponent> getComponents() {
		// TODO Auto-generated method stub
		return null;
	}
}