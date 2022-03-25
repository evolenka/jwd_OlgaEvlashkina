package by.jwd.task04repository.entity;

/**
 * Entity class Ellipse with two fields being points of circumscribed
 * rectangle; extends abstract class TwoDShape,
 * implements interface IEllipse
 * 
 * @author Evlashkina
 * 
 */

public class Ellipse extends TwoDShape implements IEllipse {

	private Point firstPoint;
	private Point secondPoint;

	public Ellipse() {
	}

	public Ellipse(Point firstPoint, Point secondPoint) {
		super();
		this.firstPoint = firstPoint;
		this.secondPoint = secondPoint;
		super.setName(FigureType.ELLIPSE);
	}

	@Override
	public Point getFirstPoint() {
		return firstPoint;
	}

	@Override
	public void setFirstPoint(Point firstPoint) {
		this.firstPoint = firstPoint;
	}

	@Override
	public Point getSecondPoint() {
		return secondPoint;
	}

	@Override
	public void setSecondPoint(Point secondPoint) {
		this.secondPoint = secondPoint;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstPoint == null) ? 0 : firstPoint.hashCode());
		result = prime * result + ((secondPoint == null) ? 0 : secondPoint.hashCode());
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
		Ellipse other = (Ellipse) obj;
		if (firstPoint == null) {
			if (other.firstPoint != null)
				return false;
		} else if (!firstPoint.equals(other.firstPoint))
			return false;
		if (secondPoint == null) {
			if (other.secondPoint != null)
				return false;
		} else if (!secondPoint.equals(other.secondPoint))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "id= " + getId() + ", name " + getName() + ", firstPoint= " + firstPoint + ", secondPoint= " + secondPoint;
	}
}