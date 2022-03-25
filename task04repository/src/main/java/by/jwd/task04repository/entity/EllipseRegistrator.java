package by.jwd.task04repository.entity;

import by.jwd.task04repository.service.ServiceException;
import by.jwd.task04repository.service.impl.EllipsePerimeterCalculationImpl;
import by.jwd.task04repository.service.impl.EllipseSquareCalculationImpl;

/**
 * Entity class EllipseRegistrator keeps value of the perimeter and the square
 * of the ellipse; acts as a observer for the entity EllipseToObserve,
 * implements interface Observer providing recalculation of the perimeter and
 * the square on the field Point of EllipseToObserve changes
 * 
 * @author Evlashkina
 * 
 */

public class EllipseRegistrator implements Observer {

	private Long id;
	private double perimeter;
	private double square;

	public EllipseRegistrator() {
	}

	public EllipseRegistrator(Long id, double perimeter, double square) {
		this.perimeter = perimeter;
		this.square = square;
		this.id = id;
	}

	public double getPerimeter() {
		return perimeter;
	}

	public void setPerimeter(double perimeter) {
		this.perimeter = perimeter;
	}

	public double getSquare() {
		return square;
	}

	public void setSquare(double square) {
		this.square = square;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/* recalculate the value of perimeter and the square of ellipse */
	@Override
	public void update(IEllipse ellipse) throws ServiceException {
		setPerimeter(new EllipsePerimeterCalculationImpl<>().calculate(ellipse));
		setSquare(new EllipseSquareCalculationImpl<>().calculate(ellipse));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (int) (perimeter);
		result = prime * result + (int) (square);
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
		EllipseRegistrator other = (EllipseRegistrator) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (perimeter != other.perimeter)
			return false;
		if (square != other.square)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ellipse registrator: id= " + id + ", perimeter=" + perimeter + ", square=" + square;
	}
}