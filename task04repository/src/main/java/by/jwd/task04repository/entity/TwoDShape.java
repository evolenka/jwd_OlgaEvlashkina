package by.jwd.task04repository.entity;

/**
 * Abstract class for two-dimensional figures, implements interface ITwoDShape
 * 
 * @author Evlashkina
 * 
 */

public abstract class TwoDShape implements ITwoDShape {

	private Long id;
	private FigureType name;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public FigureType getName() {
		return name;
	}

	@Override
	public void setName(FigureType name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		TwoDShape other = (TwoDShape) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name != other.name)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TwoDShape [id=" + id + ", name=" + name + "]";
	}
}