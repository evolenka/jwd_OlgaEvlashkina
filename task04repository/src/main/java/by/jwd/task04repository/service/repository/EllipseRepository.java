package by.jwd.task04repository.service.repository;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task04repository.entity.EllipseRegistrator;
import by.jwd.task04repository.entity.EllipseToObserve;
import by.jwd.task04repository.entity.IEllipse;
import by.jwd.task04repository.service.EllipseValidation;
import by.jwd.task04repository.service.ServiceException;
import by.jwd.task04repository.service.factory.EllipseRegistratorCreator;
import by.jwd.task04repository.service.specification.FindSpecification;
import by.jwd.task04repository.service.specification.SortSpecification;
import by.jwd.task04repository.service.specification.impl.FindEllipseByIdSpecificationImpl;
import by.jwd.task04repository.service.specification.impl.FindRegistratorByIdSpecificationImpl;

/**
 * Class EllipseRepository keeps list of enitites <T extends IEllipse>, and
 * implements methods of interface BasicRepository<T> to make basic operations
 * over them. It also contains the repository with the perimeters and the
 * squares of the respective ellipses by theirs id
 * 
 * @author Evlashkina
 */

public class EllipseRepository<T extends IEllipse> implements BasicRepository<T> {

	static Logger logger = LogManager.getLogger(EllipseRepository.class);

	private static final EllipseRepository<IEllipse> instance = new EllipseRepository<>();

	private List<T> ellipsepseStorage = new ArrayList<>();

	private List<EllipseRegistrator> registratorStorage = new ArrayList<>();

	private long id = 1L;

	private EllipseRepository() {
	}

	public static EllipseRepository<IEllipse> getInstance() {
		return instance;
	}

	public Long generateId() {
		return id++;
	}

	@Override
	public boolean save(T ellipse) throws ServiceException {

		if (ellipse.getId() == null) {

			EllipseValidation validation = new EllipseValidation();

			if (validation.isValid(ellipse.getFirstPoint(), ellipse.getSecondPoint())) {

				logger.debug("start saving new ellipse to the repository");

				ellipse.setId(generateId());
				EllipseRegistrator registrator = new EllipseRegistratorCreator().create(ellipse);
				((EllipseToObserve) ellipse).registerObserver(registrator);

				ellipsepseStorage.add(ellipse);
				logger.debug("new ellipse added to the ellipse repository");

				registratorStorage.add(registrator);
				logger.debug("new ellipse registrator added to the registrator storage");

			} else {
				logger.error("ellipse is invalid");
				throw new ServiceException();
			}

		} else {

			logger.debug("start updating of the existing ellipse");

			IEllipse existingEllipse = instance.readById(ellipse.getId());
			existingEllipse.setFirstPoint(ellipse.getFirstPoint());
			existingEllipse.setSecondPoint(ellipse.getSecondPoint());
			existingEllipse.setName(ellipse.getName());

			logger.debug("end updating of the existing ellipse");
		}

		return true;
	}

	@Override
	public boolean remove(T ellipse) {

		ellipsepseStorage.remove(instance.readById(ellipse.getId()));
		logger.debug("ellipse is removed");
		return true;
	}

	@Override
	public List<T> readAll() {
		return new ArrayList<>(ellipsepseStorage);
	}

	@Override
	public T readById(Long id) {
		T selected = null;
		for (T ellipse : ellipsepseStorage) {
			if (new FindEllipseByIdSpecificationImpl<>(id).isSpecified(ellipse)) {
				selected = ellipse;
			}
		}
		return selected;
	}

	@Override
	public List<T> findQuery(FindSpecification<T> specification) throws ServiceException {
		List<T> selected = new ArrayList<>();
		for (T ellipse : ellipsepseStorage) {

			if (specification.isSpecified(ellipse)) {
				selected.add(ellipse);
				logger.debug("ellipse is added to selection");
			}
		}
		logger.debug("all matching ellipses are found");
		return selected;
	}

	@Override
	public List<T> sortQuery(SortSpecification<T> specification) {
		List<T> sorted = this.readAll();
		Collections.sort(sorted, specification.findComparator());
		logger.debug("sorting is completed");
		return sorted;
	}

	public EllipseRegistrator readRegistratorById(Long id) {
		EllipseRegistrator registrator = null;
		for (EllipseRegistrator r : registratorStorage) {
			if (new FindRegistratorByIdSpecificationImpl<>(id).isSpecified(r)) {
				registrator = r;
			}
		}
		return registrator;
	}
}