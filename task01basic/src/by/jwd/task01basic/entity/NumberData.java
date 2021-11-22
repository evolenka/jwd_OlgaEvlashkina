package by.jwd.task01basic.entity;

import java.util.ArrayList;
import java.util.List;

public class NumberData {

	private List<Double> data;

	public NumberData() {
		data = new ArrayList<>();
	}

	public void addNumberData(double number) {
		//comment
		data.add(number);
	}

	public List<Double> getNumberData() {
		return data;
	}

	public void setNumberData(List<Double> data) {
		this.data = data;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
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
		NumberData other = (NumberData) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "NumberData [data=" + data + "]";
	}
}