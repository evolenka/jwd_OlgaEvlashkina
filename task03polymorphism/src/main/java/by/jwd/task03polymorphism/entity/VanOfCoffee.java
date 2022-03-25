package by.jwd.task03polymorphism.entity;

import java.util.ArrayList;
import java.util.List;

public class VanOfCoffee {

	private int capacity;
	private List<ItemOfCoffee> assortment = new ArrayList<>();

	public VanOfCoffee() {
	}

	public VanOfCoffee(List<ItemOfCoffee> assortment) {
		this.assortment = assortment;
	}

	public VanOfCoffee(int capacity, List<ItemOfCoffee> assortment) {

		this.capacity = capacity;
		this.assortment = assortment;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public List<ItemOfCoffee> getAssortment() {
		return new ArrayList<>(assortment);
	}

	public ItemOfCoffee getItemOfCoffee(int index) {
		return assortment.get(index);
	}

	public void addItemOfCofee(ItemOfCoffee item) {
		assortment.add(item);
	}

	public void deleteItemOfCofee(ItemOfCoffee item) {
		assortment.remove(item);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((assortment == null) ? 0 : assortment.hashCode());
		result = prime * result + capacity;
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
		VanOfCoffee other = (VanOfCoffee) obj;
		if (assortment == null) {
			if (other.assortment != null)
				return false;
		} else if (!assortment.equals(other.assortment))
			return false;
		if (capacity != other.capacity)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "\n capacity: " + capacity + "\n" + assortment;
	}
}