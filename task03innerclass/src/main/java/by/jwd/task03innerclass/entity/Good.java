package by.jwd.task03innerclass.entity;

public class Good {

	private String title;
	private String trademark;
	private double price;
	private int quantity;

	public Good() {
	}

	public Good(String title, String trademark, double price, int quantity) {
		super();
		this.title = title;
		this.trademark = trademark;
		this.price = price;
		this.quantity = quantity;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTrademark() {
		return trademark;
	}

	public void setTrademark(String trademark) {
		this.trademark = trademark;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + quantity;
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
		Good other = (Good) obj;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (quantity != other.quantity)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
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
		return "\ntitle: " + title + ", trademark: " + trademark + ", price: " + price + ", quantity: " + quantity;
	}
}