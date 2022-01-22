
package by.jwd.task04repository.entity;

import by.jwd.task04repository.service.ServiceException;

/**
 * Entity class EllipseToObserve acts as a wrapper for entity class Ellipse in
 * order to act as a subject for observing (see Pattern 'Observer'); implements
 * methods of interface SubjectToObserve to add, remove and notify observer (EllipseRegistrator) *
 * 
 * @author Evlashkina
 * 
 */

public class EllipseToObserve extends TwoDShape implements SubjectToObserve, IEllipse {

	private IEllipse ellipse;
	private Observer observer;

	public EllipseToObserve(IEllipse ellipse) {
		super();
		this.ellipse = ellipse;
		this.setName(ellipse.getName());
	}

	@Override
	public Point getFirstPoint() {
		return ellipse.getFirstPoint();
	}

	/* invokes method notifyObservers() each time firstPoint changes */
	@Override
	public void setFirstPoint(Point secondPoint) throws ServiceException {
		ellipse.setFirstPoint(secondPoint);
		notifyObservers();
	}

	/* invokes method notifyObservers() each time secondPoint changes */
	@Override
	public Point getSecondPoint() {
		return ellipse.getSecondPoint();
	}

	@Override
	public void setSecondPoint(Point secondPoint) throws ServiceException {
		ellipse.setSecondPoint(secondPoint);
		notifyObservers();
	}

	public void registerObserver(Observer observer) {
		this.observer = observer;
	}

	public void removeObserver(Observer observer) {
		this.observer = null;
	}

	/* invokes method update for each observer */
	public void notifyObservers() throws ServiceException {
		observer.update(ellipse);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ellipse == null) ? 0 : ellipse.hashCode());
		result = prime * result + ((observer == null) ? 0 : observer.hashCode());
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
		EllipseToObserve other = (EllipseToObserve) obj;
		if (ellipse == null) {
			if (other.ellipse != null)
				return false;
		} else if (!ellipse.equals(other.ellipse))
			return false;
		if (observer == null) {
			if (other.observer != null)
				return false;
		} else if (!observer.equals(other.observer))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "\nid= " + getId() + ", name= " + getName() + ", firstPoint= " + getFirstPoint() + ", secondPoint="
				+ getSecondPoint() + "; " + observer;
	}
}