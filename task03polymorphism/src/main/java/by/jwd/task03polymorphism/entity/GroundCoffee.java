package by.jwd.task03polymorphism.entity;

public class GroundCoffee extends CoffeeBean {

	private String title = "молотый";
	private String grindingDegree;

	public GroundCoffee(String sort, String trademark, String roastDegree, double pricePerKg, int netWeight, String grindingDegree) {

		super(sort, trademark, roastDegree, pricePerKg, netWeight);
		this.grindingDegree = grindingDegree;
	}

	public String getTitle() {
		return title;
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
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GroundCoffee [title=" + title + "sort=" + getSort() + ", trademark=" + getTrademark() + ", roastDegree=" + getRoastDegree()
				+ ", pricePerKg=" + getPricePerKg() + ", netWeight=" + getNetWeight() + ", grindingDegree="
				+ grindingDegree + "]";
	}

}
