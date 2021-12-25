package by.jwd.task03polymorphism.entity;

public class InstantCoffee extends CoffeeBean {

	private String title = "растворимый";
	private String shape;

	public InstantCoffee(String sort, String trademark, String roastDegree, double pricePerKg, int netWeight,
			String shape) {

		super(sort, trademark, roastDegree, pricePerKg, netWeight);
		this.shape = shape;
	}

	
	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
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
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (shape == null) {
			if (other.shape != null)
				return false;
		} else if (!shape.equals(other.shape))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "InstantCoffee  [title=" + title + "sort=" + getSort() + ", trademark=" + getTrademark()
				+ ", roastDegree=" + getRoastDegree() + ", pricePerKg=" + getPricePerKg() + ", netWeight="
				+ getNetWeight() + ", type=" + shape + "]";
	}

}
