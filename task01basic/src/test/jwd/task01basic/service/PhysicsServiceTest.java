package test.jwd.task01basic.service;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import by.jwd.task01basic.entity.PhysicsData;
import by.jwd.task01basic.service.PhysicsService;
import by.jwd.task01basic.service.impl.PhysicsServiceImpl;

public class PhysicsServiceTest {
	PhysicsService physics;
	PhysicsData physicsData;

	@BeforeClass
	public void setUp() {
		physics = new PhysicsServiceImpl();
		physicsData = new PhysicsData();
	}

	/*
	 * data should be >= 0, see validation in
	 * by.jwd.task01basic.controller.impl.PhysicsControllerImpl
	 */

	@DataProvider(name = "DataForPhysics")
	public Object[][] createDataForDistance() {
		return new Object[][] {
			{ new int[] { 0, 0, 0, 0 }, 0 },
			{ new int[] { 1, 1, 1, 1 }, 2 },
			{ new int[] { 5, 2, 3, 2 }, 23 },
			{ new int[] { 2, 0, 0, 1 }, 0 },
			{ new int[] { 5, 1, 2, 5 }, 10 },
			{ new int[] {Integer.MAX_VALUE, 1, 0, 0}, Integer.MAX_VALUE},
			{ new int[] {Integer.MAX_VALUE, 1, 1, Integer.MAX_VALUE}, -2}};
	}
	
	@Test(dataProvider = "DataForPhysics")
	public void testDistance(int[] ab, int c) {
		physicsData.setBoatSpeed(ab[0]);
		physicsData.setTimeWithStream(ab[1]);
		physicsData.setTimeAgainstStream(ab[2]);
		physicsData.setRiverSpeed(ab[3]);
		
		int actual = physics.doCalculation(physicsData);
		int expected = c;
		assertEquals(actual, expected);
	}
	
	@AfterClass
	public void tierDown() {
		physics = null;
		physicsData = null;
	}
}