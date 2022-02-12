package by.jwd.task06infohandling.entity;

import java.util.ArrayList;
import java.util.List;

public class Component implements IComponent {

	private Delimeter type;
	private List<IComponent> components = new ArrayList<>();
	
	public Component() {
	}

	public Component(List<IComponent> components, Delimeter type) {
		this.components = components;
		this.type = type;
	}

	public Component(Delimeter type) {
		this.type = type;
	}

	public Delimeter getType() {
		return type;
	}

	public void setType(Delimeter type) {
		this.type = type;
	}

	@Override
	public List<IComponent> getComponents() {
		return new ArrayList<>(components);
	}

	@Override
	public int getSize() {
		return components.size();
	}

	@Override
	public String collect() {
		StringBuilder text = new StringBuilder();

		switch (type) {
		case TEXT:
			for (IComponent component : components) {
				text.append(component.collect());
				text.append("\r\n");
			}
			break;
		case PARAGRAPH:
			for (IComponent component : components) {
				text.append(component.collect());
				text.append("");
			}
			break;
		case SENTENCE:
			for (IComponent component : components) {
				text.append(component.collect());
				text.append(" ");
			}
			break;
		default:
			for (IComponent component : components) {
				text.append(component.collect());
				text.append("");
			}
		}
		return text.toString();
	}

	@Override
	public void add(IComponent component) {
		components.add(component);
	}

	@Override
	public void remove(IComponent component) {
		components.remove(component);
	}

	@Override
	public IComponent getChild(int index) {
		return components.get(index);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((components == null) ? 0 : components.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Component other = (Component) obj;
		if (components == null) {
			if (other.components != null)
				return false;
		} else if (!components.equals(other.components))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder text = new StringBuilder();

		switch (type) {
		case TEXT:
			for (IComponent component : components) {
				text.append(component.collect());
				text.append("\r\n");
			}
			break;
		case PARAGRAPH:
			for (IComponent component : components) {
				text.append(component.collect());
				text.append("");
			}
			break;
		case SENTENCE:
			for (IComponent component : components) {
				text.append(component.collect());
				text.append(" ");
			}
			break;
		default:
			for (IComponent component : components) {
				text.append(component.collect());
				text.append("");
			}
		}
		return text.toString();
	}
}