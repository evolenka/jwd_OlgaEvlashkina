package by.jwd.task03polymorphism.entity;

public class ItemOfCoffee {

	private CoffeeBean coffee;
	private Packing packing;
	double totalPrice;
	int grossWeight;

	public ItemOfCoffee(CoffeeBean coffee, Packing packing) {

		this.coffee = coffee;
		this.packing = packing;
		this.totalPrice = new Price().calculatePrice();
		this.grossWeight = new GrossWeight().calculateGrossWeight();
	}

	public CoffeeBean getCoffee() {
		return coffee;
	}

	public void setCoffee(CoffeeBean coffee) {
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

	@Override
	public String toString() {
		return "ItemOfCoffee [\ncoffee=" + coffee + ", packing=" + packing + ", price=" + totalPrice + ", grossweight="
				+ grossWeight + "]";
	}

	class Price {
		double calculatePrice() {
			return coffee.getPricePerKg() * coffee.getNetWeight() / 1000;
		}
	}

	class GrossWeight {
		int calculateGrossWeight() {
			return coffee.getNetWeight() + packing.getWeight();
		}

	}
}