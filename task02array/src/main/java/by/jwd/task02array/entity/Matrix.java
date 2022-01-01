package by.jwd.task02array.entity;

import java.util.Arrays;

public class Matrix<T> {

	private T[][] a;

	public Matrix(T[][] a) {
		this.a = a;
	}

	public int getRowQuantity() {
		return a.length;
	}

	public int getColumnQuantity() {
		return a[0].length;
	}

	public T getElement(int i, int j) throws MatrixException {
		if (checkRange(i, j)) {
			return a[i][j];
		} else {
			throw new MatrixException();
		}
	}

	public void setElement(int i, int j, T value) throws MatrixException {
		if (checkRange(i, j)) {
			a[i][j] = value;
		} else {
			throw new MatrixException();
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(a);
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
		Matrix<?> other = (Matrix<?>) obj;
		if (!Arrays.deepEquals(a, other.a))
			return false;
		return true;
	}

	@Override
	public String toString() {
		final String BLANK = " ";
		StringBuilder s = new StringBuilder("\n" + a.length + "x" + a[0].length + "\n");
		for (T[] row : a) {
			for (T value : row) {
				s.append(value).append(BLANK);
			}
			s.append("\n");
		}

		return s.toString();
	}

	private boolean checkRange(int i, int j) {
		return (i < 0 || i > a.length - 1 || j < 0 || j > a[0].length - 1) ? false : true;
	}

}
