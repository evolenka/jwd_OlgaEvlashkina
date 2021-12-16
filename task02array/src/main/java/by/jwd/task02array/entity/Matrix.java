package by.jwd.task02array.entity;

public class Matrix<T> {

	private T[][] a;

	public Matrix(T[][] a) {
		this.a = a;
	}

	public Matrix(int rowQuantity, int columnQuantity) throws MatrixException {
		if (rowQuantity < 1 || columnQuantity < 1) {
			throw new MatrixException();
		}
		a = (T[][]) new Object[rowQuantity][columnQuantity];
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
	public String toString() {
		final String BLANK = " ";
		StringBuilder s = new StringBuilder("\nMatrix : " + a.length + "x" + a[0].length + "\n");
		for (T[] row : a) {
			for (T value : row) {
				s.append(value).append(BLANK);
			}
			s.append("\n");
		}

		return s.toString();
	}

	private boolean checkRange(int i, int j) {
		if (i < 0 || i > a.length - 1 || j < 0 || j > a[0].length - 1) {
			return false;
		} else {
			return true;
		}
	}

}
