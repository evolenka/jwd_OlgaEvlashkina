package by.jwd.task03polymorphism.entity;

import java.io.Serializable;

public class ItemOfCoffee implements Serializable {

	private static final long serialVersionUID = 1L;

	private Coffee coffee;
	private Packing packing;
	double totalPrice;
	int grossWeight;

	public ItemOfCoffee(Coffee coffee, Packing packing, double totalPrice, int grossWeight) {

		this.coffee = coffee;
		this.packing = packing;
		this.totalPrice = totalPrice;
		this.grossWeight = grossWeight;
	}

	public Coffee getCoffee() {
		return coffee;
	}

	public void setCoffee(Coffee coffee) {
		this.coffee = coffee;
	}

	public Packing getPacking() {
		return packing;
	}

	public void setPacking(Packing packing) {
		this.packing = packing;
	}

	public double getPrice() {
		return totalPrice;
	}

	public int getGrossWeight() {
		return grossWeight;
	}
	
	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public void setGrossWeight(int grossWeight) {
		this.grossWeight = grossWeight;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coffee == null) ? 0 : coffee.hashCode());
		result = prime * result + grossWeight;
		result = prime * result + ((packing == null) ? 0 : packing.hashCode());
		result = prime * result + (int) totalPrice;
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
		ItemOfCoffee other = (ItemOfCoffee) obj;
		if (coffee == null) {
			if (other.coffee != null)
				return false;
		} else if (!coffee.equals(other.coffee))
			return false;
		if (grossWeight != other.grossWeight)
			return false;
		if (packing == null) {
			if (other.packing != null)
				return false;
		} else if (!packing.equals(other.packing))
			return false;
		if (totalPrice != other.totalPrice)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "\n" + coffee + ", total price:" + totalPrice + ", grossweight:" + grossWeight + ", Packing:" + packing;
	}
}