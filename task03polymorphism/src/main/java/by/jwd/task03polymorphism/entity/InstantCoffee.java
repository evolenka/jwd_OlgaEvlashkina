package by.jwd.task03polymorphism.entity;

public class InstantCoffee extends CoffeeBean {

	private String shape;

	public InstantCoffee(String sort, String trademark, String roastDegree, double pricePerKg, int netWeight,
			String shape) {

		super(sort, trademark, roastDegree, pricePerKg, netWeight);
		super.setTitle("растворимый");
		this.shape = shape;

	}

	public String getShape() {
		return shape;
	}

	public void setShape(String shape) {
		this.shape = shape;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((shape == null) ? 0 : shape.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		InstantCoffee other = (InstantCoffee) obj;
		if (shape == null) {
			if (other.shape != null)
				return false;
		} else if (!shape.equals(other.shape))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "title: " + getTitle() + ", sort: " + getSort() + ", trademark: " + getTrademark() + ", roastDegree: "
				+ getRoastDegree() + ", pricePerKg: " + getPricePerKg() + ", netWeight: " + getNetWeight() + ", shape: "
				+ shape;
	}
}
