package by.jwd.task03innerclass.entity;

import java.util.List;

public class Shop {

	private List<Department> listOfDepartment;

	public Shop() {
	}

	public Shop(List<Department> listOfDepartment) {
		this.listOfDepartment = listOfDepartment;
	}

	public void addDepartment(Department department) {
		listOfDepartment.add(department);
	}

	public Department getDepartment(int index) {
		return listOfDepartment.get(index);
	}

	public void deleteDepartment(Department department) {
		listOfDepartment.remove(department);
	}

	public int getDepartmentQuantity() {
		return listOfDepartment.size();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((listOfDepartment == null) ? 0 : listOfDepartment.hashCode());
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
		Shop other = (Shop) obj;
		if (listOfDepartment == null) {
			if (other.listOfDepartment != null)
				return false;
		} else if (!listOfDepartment.equals(other.listOfDepartment))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "list of shop departments:" + listOfDepartment;
	}

	public class Department {

		private String name;
		private List<Good> assortment;

		public Department() {
		}

		public Department(String name, List<Good> assortment) {
			super();
			this.name = name;
			this.assortment = assortment;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public void addGood(Good good) {
			assortment.add(good);
		}

		public Good getGood(int index) {
			return assortment.get(index);
		}

		public void deleteGood(Good good) {
			assortment.remove(good);
		}

		public int getAssortmentQuantity() {
			return assortment.size();
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((assortment == null) ? 0 : assortment.hashCode());
			result = prime * result + ((name == null) ? 0 : name.hashCode());
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
			Department other = (Department) obj;
			if (assortment == null) {
				if (other.assortment != null)
					return false;
			} else if (!assortment.equals(other.assortment))
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "\ndepartment name: " + name + ", assortment: " + assortment;
		}
	}
}