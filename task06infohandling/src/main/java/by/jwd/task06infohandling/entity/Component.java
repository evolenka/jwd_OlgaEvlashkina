package by.jwd.task06infohandling.entity;

import java.util.List;

public interface Component {

	public default int getSize() {
		throw new UnsupportedOperationException();
	}

	public default void add(Component component) {
		throw new UnsupportedOperationException();
	}

	public default void remove(Component component) {
		throw new UnsupportedOperationException();
	}

	public default Component getChild(int index) {
		throw new UnsupportedOperationException();
	}

	public default List<Component> getComponents() {
		throw new UnsupportedOperationException();
	}

	public default DelimeterType getType() {
		throw new UnsupportedOperationException();
	}

	public default String collect() {
		throw new UnsupportedOperationException();
	}

	public String toString();
}
