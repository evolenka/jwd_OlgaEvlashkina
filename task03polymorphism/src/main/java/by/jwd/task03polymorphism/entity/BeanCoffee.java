package by.jwd.task03polymorphism.entity;

public class BeanCoffee extends Coffee {

	public BeanCoffee(String sort, String trademark, String roastDegree, double pricePerKg, int netWeight) {
		super(sort, trademark, roastDegree, pricePerKg, netWeight);
		super.setTitle(Title.BEAN);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "title: " + getTitle() + ", sort: " + getSort() + ", trademark: " + getTrademark() + ", roastDegree: "
				+ getRoastDegree() + ", pricePerKg: " + getPricePerKg() + ", netWeight: " + getNetWeight();
	}
}
