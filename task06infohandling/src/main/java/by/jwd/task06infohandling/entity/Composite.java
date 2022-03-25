package by.jwd.task06infohandling.entity;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task06infohandling.service.CollectService;

public class Composite implements Component {

	static Logger logger = LogManager.getLogger(Composite.class);

	private DelimeterType type;
	private List<Component> components = new ArrayList<>();

	public Composite(List<Component> components, DelimeterType type) {
		this.components = components;
		this.type = type;
	}

	public Composite(DelimeterType type) {
		this.type = type;
	}

	@Override
	public DelimeterType getType() {
		return type;
	}

	@Override
	public List<Component> getComponents() {
		return new ArrayList<>(components);
	}

	@Override
	public int getSize() {
		return components.size();
	}

	@Override
	public void add(Component component) {
		components.add(component);
	}

	@Override
	public void remove(Component component) {
		components.remove(component);
	}

	@Override
	public Component getChild(int index) {
		return components.get(index);
	}

	@Override
	public String collect() {
		return CollectService.getInstance().collectComponent(this);
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
		Composite other = (Composite) obj;
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
		return this.collect();
	}
}