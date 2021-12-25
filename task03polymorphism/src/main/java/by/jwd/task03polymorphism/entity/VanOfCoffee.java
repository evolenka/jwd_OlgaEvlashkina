package by.jwd.task03polymorphism.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class VanOfCoffee implements Serializable {

	private static final long serialVersionUID = 1L;

	private int capacity;
	private List<ItemOfCoffee> assortment = new ArrayList<>();

	public VanOfCoffee() {
	}
	
	public VanOfCoffee(List<ItemOfCoffee> assortment) {
		this.assortment = assortment;
	}

	public VanOfCoffee(int capacity, List<ItemOfCoffee> assortment) throws VanException {

		if (checkVolume(capacity, assortment)) {
			this.capacity = capacity;
			this.assortment = assortment;
		} else
			throw new VanException();
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

	public boolean checkVolume(int capacity, List<ItemOfCoffee> assortment) {
		double assortmentVolume = 0;
		for (int i = 0; i < assortment.size(); i++) {
			assortmentVolume = assortment.get(i).getPacking().getVolume();
		}
		return (capacity > assortmentVolume);
	}
}