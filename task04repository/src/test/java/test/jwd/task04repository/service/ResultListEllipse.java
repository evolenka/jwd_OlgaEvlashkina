package test.jwd.task04repository.service;

import java.util.ArrayList;
import java.util.List;

import by.jwd.task04repository.entity.EllipseRegistrator;
import by.jwd.task04repository.entity.EllipseToObserve;
import by.jwd.task04repository.entity.IEllipse;
import by.jwd.task04repository.entity.Point;
import by.jwd.task04repository.service.ServiceException;
import by.jwd.task04repository.service.factory.EllipseCreator;
import by.jwd.task04repository.service.factory.EllipseRegistratorCreator;


public class ResultListEllipse {

	public static List<IEllipse> listOfEllipse = createListOfEllipse();

	public static List<IEllipse> createListOfEllipse() {
		
		EllipseCreator creator = new EllipseCreator();
		List<IEllipse> ellip = new ArrayList<>();
		
		try {
			IEllipse ellipse1 = new EllipseToObserve(creator.createEllipse(new Point(1.0, 2.0), new Point(-8.0, 5.0)));
			ellipse1.setId(1L);
			EllipseRegistrator registrator1 = new EllipseRegistratorCreator().create(ellipse1);
			((EllipseToObserve) ellipse1).registerObserver(registrator1);
			ellip.add(ellipse1);

			IEllipse ellipse2 = new EllipseToObserve(creator.createEllipse(new Point(0.0, 2.0), new Point(1.0, 0.0)));
			ellipse2.setId(2L);
			EllipseRegistrator registrator2 = new EllipseRegistratorCreator().create(ellipse2);
			((EllipseToObserve) ellipse2).registerObserver(registrator2);
			ellip.add(ellipse2);

			IEllipse ellipse3 = new EllipseToObserve(creator.createEllipse(new Point(0.0, 3.0), new Point(3.0, 0.0)));
			ellipse3.setId(3L);
			EllipseRegistrator registrator3 = new EllipseRegistratorCreator().create(ellipse3);
			((EllipseToObserve) ellipse3).registerObserver(registrator3);
			ellip.add(ellipse3);

			IEllipse ellipse4 = new EllipseToObserve(creator.createEllipse(new Point(0.0, 1.0), new Point(4.0, 0.0)));
			ellipse4.setId(4L);
			EllipseRegistrator registrator4 = new EllipseRegistratorCreator().create(ellipse4);
			((EllipseToObserve) ellipse4).registerObserver(registrator4);
			ellip.add(ellipse4);

			IEllipse ellipse5 = new EllipseToObserve(creator.createEllipse(new Point(4.0, 3.0), new Point(4.5, 1.5)));
			ellipse5.setId(5L);
			EllipseRegistrator registrator5 = new EllipseRegistratorCreator().create(ellipse5);
			((EllipseToObserve) ellipse5).registerObserver(registrator5);
			ellip.add(ellipse5);

			IEllipse ellipse6 = new EllipseToObserve(creator.createEllipse(new Point(5.0, 5.0), new Point(8.0, 4.0)));
			ellipse6.setId(6L);
			EllipseRegistrator registrator6 = new EllipseRegistratorCreator().create(ellipse6);
			((EllipseToObserve) ellipse6).registerObserver(registrator6);
			ellip.add(ellipse6);

			IEllipse ellipse7 = new EllipseToObserve(creator.createEllipse(new Point(1.0, 3.0), new Point(-2.0, 4.0)));
			ellipse7.setId(7L);
			EllipseRegistrator registrator7 = new EllipseRegistratorCreator().create(ellipse7);
			((EllipseToObserve) ellipse7).registerObserver(registrator7);
			ellip.add(ellipse7);

			IEllipse ellipse8 = new EllipseToObserve(creator.createEllipse(new Point(3.0, 0.5), new Point(-0.5, 4.0)));
			ellipse8.setId(8L);
			EllipseRegistrator registrator8 = new EllipseRegistratorCreator().create(ellipse8);
			((EllipseToObserve) ellipse8).registerObserver(registrator8);
			ellip.add(ellipse8);

			IEllipse ellipse9 = new EllipseToObserve(creator.createEllipse(new Point(4.0, 6.0), new Point(5.0, 5.0)));
			ellipse9.setId(9L);
			EllipseRegistrator registrator9 = new EllipseRegistratorCreator().create(ellipse9);
			((EllipseToObserve) ellipse9).registerObserver(registrator9);
			ellip.add(ellipse9);

			IEllipse ellipse10 = new EllipseToObserve(
					creator.createEllipse(new Point(-3.0, 2.0), new Point(-2.5, 0.0)));
			ellipse10.setId(10L);
			EllipseRegistrator registrator10 = new EllipseRegistratorCreator().create(ellipse10);
			((EllipseToObserve) ellipse10).registerObserver(registrator10);
			ellip.add(ellipse10);

		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return ellip;
	}
}