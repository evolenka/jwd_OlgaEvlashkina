package by.jwd.task03polymorphism.entity;

public class GroundCoffee extends CoffeeBean {

	private String grindingDegree;

	public GroundCoffee(String sort, String trademark, String roastDegree, double pricePerKg, int netWeight,
			String grindingDegree) {

		super(sort, trademark, roastDegree, pricePerKg, netWeight);
		super.setTitle("молотый");
		this.grindingDegree = grindingDegree;
	}

	public String getGrindingDegree() {
		return grindingDegree;
	}

	public void setGrindingDegree(String grindingDegree) {
		this.grindingDegree = grindingDegree;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((grindingDegree == null) ? 0 : grindingDegree.hashCode());
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
		GroundCoffee other = (GroundCoffee) obj;
		if (grindingDegree == null) {
			if (other.grindingDegree != null)
				return false;
		} else if (!grindingDegree.equals(other.grindingDegree))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "title: " + getTitle() + ", sort: " + getSort() + ", trademark: " + getTrademark() + ", roastDegree: "
				+ getRoastDegree() + ", pricePerKg: " + getPricePerKg() + ", netWeight: " + getNetWeight()
				+ ", grindingDegree: " + grindingDegree;
	}
}
