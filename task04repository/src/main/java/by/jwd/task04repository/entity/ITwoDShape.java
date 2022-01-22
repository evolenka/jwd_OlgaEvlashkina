package by.jwd.task04repository.entity;

/**
 * Provides common methods for entities being twoDShape figures
 * 
 * @author Evlashkina
 * 
 */

public abstract interface ITwoDShape {

	public Long getId();

	public void setId(Long id);

	public FigureType getName();

	public void setName(FigureType name);
}
