package by.jwd.task07xmlparser.entity;

import java.util.Date;
import java.util.Objects;

public class Membership {

	private long id;
	private Client client;
	private String name;
	private Date startDate;
	private Date endDate;
	private int balanceClassQuantity;
	private int maxClassQuantity;
	private double price;

	public Membership() {
	}

	public Membership(long id, Client client, String name, Date startDate, Date endDate, int balanceClassQuantity,
			int maxClassQuantity, double price) {
		super();
		this.id = id;
		this.client = client;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.balanceClassQuantity = balanceClassQuantity;
		this.maxClassQuantity = maxClassQuantity;
		this.price = price;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getBalanceClassQuantity() {
		return balanceClassQuantity;
	}

	public void setBalanceClassQuantity(int balanceClassQuantity) {
		this.balanceClassQuantity = balanceClassQuantity;
	}

	public int getMaxClassQuantity() {
		return maxClassQuantity;
	}

	public void setMaxClassQuantity(int maxClassQuantity) {
		this.maxClassQuantity = maxClassQuantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(balanceClassQuantity, client, endDate, id, maxClassQuantity, name, price, startDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Membership other = (Membership) obj;
		return balanceClassQuantity == other.balanceClassQuantity && Objects.equals(client, other.client)
				&& Objects.equals(endDate, other.endDate) && id == other.id
				&& maxClassQuantity == other.maxClassQuantity && Objects.equals(name, other.name)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Objects.equals(startDate, other.startDate);
	}

	@Override
	public String toString() {
		return "Membership [id=" + id + ", client=" + client + ", name=" + name + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", balanceClassQuantity=" + balanceClassQuantity + ", maxClassQuantity="
				+ maxClassQuantity + ", price=" + price + "]";
	};

}