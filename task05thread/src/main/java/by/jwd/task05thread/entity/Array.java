package by.jwd.task05thread.entity;

import java.util.Arrays;

public class Array<T> {

	private T[] a;

	public Array(T[] a) {
		this.a = a;
	}

	public int getLength() {
		return a.length;
	}

	public T getElement(int i) throws ArrayException {
		if (checkRange(i)) {
			throw new ArrayException();
		}
		return a[i];
	}

	public void setElement(int i, T value) throws ArrayException {
		if (checkRange(i)) {
			throw new ArrayException();
		}
		a[i] = value;
	}

	@Override
	public int hashCode() {
		return Arrays.deepHashCode(a);
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
		if (!Arrays.deepEquals(a, other.a))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder(": ");
		for (T value : a) {
			s.append(value + " ");
		}
		return s.toString();
	}

	private boolean checkRange(int i) {
		return (i < 0 || i > a.length - 1);
	}
}