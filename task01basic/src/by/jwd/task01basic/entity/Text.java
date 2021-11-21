package by.jwd.task01basic.entity;

import java.util.Arrays;

public class Text {
	private String[] sequence;

	public Text() {
	}

	public Text(String[] sequence) {
		this.sequence = sequence;
	}

	public String[] getSequence() {
		return sequence;
	}

	public void setSequence(String[] sequence) {
		this.sequence = sequence;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(sequence);
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
		Text other = (Text) obj;
		if (!Arrays.equals(sequence, other.sequence))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Text [sequence=" + Arrays.toString(sequence) + "]";
	}
}
