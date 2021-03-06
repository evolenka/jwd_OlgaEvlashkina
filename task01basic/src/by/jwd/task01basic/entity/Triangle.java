package by.jwd.task01basic.entity;

public class Triangle {

	private double side1;
	private double side2;
	private double side3;

	public Triangle() {
	}

	public Triangle(double side1, double side2, double side3) {

		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}

	public double getSide1() {
		return side1;
	}

	public void setSide1(double side1) {
		this.side1 = side1;
	}

	public double getSide2() {
		return side2;
	}

	public void setSide2(double side2) {
		this.side2 = side2;
	}

	public double getSide3() {
		return side3;
	}

	public void setSide3(double side3) {
		this.side3 = side3;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (side1);
		result = prime * result + (int) (side2);
		result = prime * result + (int) (side3);
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
		Triangle other = (Triangle) obj;
		if (side1 != other.side1)
			return false;
		if (side1 != other.side2)
			return false;
		if (side1 != other.side3)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Triangle first side =" + side1 + ", Triangle second side =" + side2 + ", Triangle third side =" + side3;
	}
}