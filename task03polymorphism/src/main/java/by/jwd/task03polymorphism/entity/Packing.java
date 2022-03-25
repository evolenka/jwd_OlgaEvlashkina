package by.jwd.task03polymorphism.entity;

public class Packing {

	private String type;
	private double price;
	private double volume;
	private int weight;

	public Packing(String type, double price, double volume, int weight) {

		this.type = type;
		this.price = price;
		this.volume = volume;
		this.weight = weight;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * (int) price;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * (int) volume;
		result = prime * result + weight;
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
		Packing other = (Packing) obj;
		if (price != (other.price))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (volume != other.volume)
			return false;
		if (weight != other.weight)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return " type: " + type + ", price: " + price + ", volume:" + volume + ", weight:" + weight;
	}
}