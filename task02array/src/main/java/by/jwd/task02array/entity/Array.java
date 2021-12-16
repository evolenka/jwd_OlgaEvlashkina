package by.jwd.task02array.entity;

import java.util.Arrays;

public class Array<T> {

	private T[] a;

	public Array(T[] a) {
		this.a = a;
	}

	public Array(int length) throws ArrayException {
		if (length < 1) {
			throw new ArrayException();
		}
		a = (T[]) new Object[length];
	}

	public int getLength() {
		return a.length;
	}

	public T getElement(int i) throws ArrayException {
		if (i < 0 || i > a.length - 1) {
			throw new ArrayException();
		}
		return a[i];
	}

	public void setElement(int i, T value) throws ArrayException {
		if (i < 0 || i > a.length - 1) {
			throw new ArrayException();
		}
		a[i] = value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(a);
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
		Array<?> other = (Array<?>) obj;
		if (!Arrays.equals(a, other.a))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder("\nArray: ");
		for (T value : a) {
			s.append(value + ", ");
		}
		return s.toString();
	}
}