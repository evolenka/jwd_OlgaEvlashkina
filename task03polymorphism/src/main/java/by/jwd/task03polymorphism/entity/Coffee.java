package by.jwd.task03polymorphism.entity;

public abstract class Coffee {

	private Title title;
	private String sort;
	private String trademark;
	private String roastDegree;
	private double pricePerKg;
	private int netWeight;
	
	protected Coffee(String sort, String trademark, String roastDegree, double pricePerKg, int netWeight) {
		
		this.sort = sort;
		this.trademark = trademark;
		this.roastDegree = roastDegree;
		this.pricePerKg = pricePerKg;
		this.netWeight = netWeight;
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getTrademark() {
		return trademark;
	}

	public void setTrademark(String trademark) {
		this.trademark = trademark;
	}

	public String getRoastDegree() {
		return roastDegree;
	}

	public void setRoastDegree(String roastDegree) {
		this.roastDegree = roastDegree;
	}

	public double getPricePerKg() {
		return pricePerKg;
	}

	public void setPricePerKg(double pricePerKg) {
		this.pricePerKg = pricePerKg;
	}

	public int getNetWeight() {
		return netWeight;
	}

	public void setNetWeight(int netWeight) {
		this.netWeight = netWeight;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + netWeight;
		result = prime * result + (int) pricePerKg;
		result = prime * result + ((sort == null) ? 0 : sort.hashCode());
		result = prime * result + ((roastDegree == null) ? 0 : roastDegree.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((trademark == null) ? 0 : trademark.hashCode());
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
		Coffee other = (Coffee) obj;
		if (netWeight != other.netWeight)
			return false;
		if (pricePerKg != other.pricePerKg)
			return false;
		if (roastDegree == null) {
			if (other.roastDegree != null)
				return false;
		} else if (!roastDegree.equals(other.roastDegree))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (sort == null) {
			if (other.sort != null)
				return false;
		} else if (!sort.equals(other.sort))
			return false;
		if (trademark == null) {
			if (other.trademark != null)
				return false;
		} else if (!trademark.equals(other.trademark))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "title: " + title + ", sort: " + sort + ", trademark: " + trademark + ", roastDegree: " + roastDegree
				+ ", pricePerKg: " + pricePerKg + ", netWeight: " + netWeight;
	}
}