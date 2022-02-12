package by.jwd.task06infohandling.entity;

import java.util.List;

public interface IComponent {
	
	public int getSize();
	
	public String collect();

	public void add(IComponent component);

	public void remove(IComponent component);

	public IComponent getChild(int index);

	public Delimeter getType();
	
	public List <IComponent> getComponents();

}
